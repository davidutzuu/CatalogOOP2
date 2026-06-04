package catalog;

import java.util.*;

public class CatalogService {
    private Set<Student> studenti = new TreeSet<>();
    private List<Profesor> profesori = new ArrayList<>();
    private List<Materie> materii = new ArrayList<>();
    private List<Nota> note = new ArrayList<>();

    public void adaugaStudent(Student student) {
        studenti.add(student);
        AuditService.getInstanta().logActiune("adauga_student_memorie");
    }

    public void adaugaProfesor(Profesor profesor) {
        profesori.add(profesor);
        AuditService.getInstanta().logActiune("adauga_profesor_memorie");
    }

    public void adaugaMaterie(Materie materie) {
        materii.add(materie);
        AuditService.getInstanta().logActiune("adauga_materie_memorie");
    }

    public void acordaNota(Student student, Materie materie, int valoare) {
        Nota nota = new Nota(valoare, materie, student);
        note.add(nota);
        AuditService.getInstanta().logActiune("acorda_nota");
    }

    public void afiseazaStudenti() {
        System.out.println("--- Lista Studenti (Sortata alfabetic) ---");
        for (Student s : studenti) {
            System.out.println(s);
        }
        AuditService.getInstanta().logActiune("afiseaza_studenti");
    }

    public void afiseazaProfesori() {
        System.out.println("--- Lista Profesori ---");
        for (Profesor p : profesori) {
            System.out.println(p);
        }
        AuditService.getInstanta().logActiune("afiseaza_profesori");
    }

    public void afiseazaNoteStudent(String nrMatricol) {
        System.out.println("--- Note pentru studentul cu matricol: " + nrMatricol + " ---");
        for (Nota n : note) {
            if (n.getStudent().getNrMatricol().equals(nrMatricol)) {
                System.out.println(n);
            }
        }
        AuditService.getInstanta().logActiune("afiseaza_note_student");
    }

    public double calculeazaMedieStudent(String nrMatricol) {
        int suma = 0;
        int count = 0;
        for (Nota n : note) {
            if (n.getStudent().getNrMatricol().equals(nrMatricol)) {
                suma += n.getValoare();
                count++;
            }
        }
        AuditService.getInstanta().logActiune("calculeaza_medie_student");
        return count == 0 ? 0 : (double) suma / count;
    }

    public void afiseazaMateriiProfesor(String numeProfesor) {
        System.out.println("--- Materii predate de Prof. " + numeProfesor + " ---");
        for (Materie m : materii) {
            if (m.getTitular().getNume().equals(numeProfesor)) {
                System.out.println(m.getNume());
            }
        }
        AuditService.getInstanta().logActiune("afiseaza_materii_profesor");
    }

    public void stergeStudent(String nrMatricol) {
        studenti.removeIf(s -> s.getNrMatricol().equals(nrMatricol));
        System.out.println("Studentul cu matricolul " + nrMatricol + " a fost sters.");
        AuditService.getInstanta().logActiune("sterge_student");
    }
}