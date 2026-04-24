package catalog;

import java.util.*;

public class CatalogService {
    private Set<Student> studenti = new TreeSet<>();
    private List<Profesor> profesori = new ArrayList<>();
    private List<Materie> materii = new ArrayList<>();
    private List<Nota> note = new ArrayList<>();

    // 1. Adaugare student
    public void adaugaStudent(Student student) {
        studenti.add(student);
    }

    // 2. Adaugare profesor
    public void adaugaProfesor(Profesor profesor) {
        profesori.add(profesor);
    }

    // 3. Adaugare materie
    public void adaugaMaterie(Materie materie) {
        materii.add(materie);
    }

    // 4. Adaugare nota
    public void acordaNota(Student student, Materie materie, int valoare) {
        Nota nota = new Nota(valoare, materie, student);
        note.add(nota);
    }

    // 5. Afisare studenti sortati
    public void afiseazaStudenti() {
        System.out.println("--- Lista Studenti (Sortata alfabetic) ---");
        for (Student s : studenti) {
            System.out.println(s);
        }
    }

    // 6. Afisare profesori
    public void afiseazaProfesori() {
        System.out.println("--- Lista Profesori ---");
        for (Profesor p : profesori) {
            System.out.println(p);
        }
    }

    // 7. Afisare note student
    public void afiseazaNoteStudent(String nrMatricol) {
        System.out.println("--- Note pentru studentul cu matricol: " + nrMatricol + " ---");
        for (Nota n : note) {
            if (n.getStudent().getNrMatricol().equals(nrMatricol)) {
                System.out.println(n);
            }
        }
    }

    // 8. Calcul medie student
    public double calculeazaMedieStudent(String nrMatricol) {
        int suma = 0;
        int count = 0;
        for (Nota n : note) {
            if (n.getStudent().getNrMatricol().equals(nrMatricol)) {
                suma += n.getValoare();
                count++;
            }
        }
        return count == 0 ? 0 : (double) suma / count;
    }

    // 9. Afisare materii predate de un prof
    public void afiseazaMateriiProfesor(String numeProfesor) {
        System.out.println("--- Materii predate de Prof. " + numeProfesor + " ---");
        for (Materie m : materii) {
            if (m.getTitular().getNume().equals(numeProfesor)) {
                System.out.println(m.getNume());
            }
        }
    }

    // 10. Stergere student
    public void stergeStudent(String nrMatricol) {
        studenti.removeIf(s -> s.getNrMatricol().equals(nrMatricol));
        System.out.println("Studentul cu matricolul " + nrMatricol + " a fost sters.");
    }
}