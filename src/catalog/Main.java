package catalog;

public class Main {
    public static void main(String[] args) {
        CatalogService service = new CatalogService();

        // Cream cateva instante necesare
        Adresa adresa1 = new Adresa("Bucuresti", "Str. Primaverii");
        Adresa adresa2 = new Adresa("Cluj", "Str. Toamnei");
        Departament info = new Departament("Informatica");
        Departament mate = new Departament("Matematica");
        Grupa g331 = new Grupa("331");

        // Actiunea 1 & 2: Instantiem si adaugam persoane
        Student s1 = new Student("Popescu", "Ion", adresa1, "123AB", g331);
        Student s2 = new Student("Ionescu", "Andrei", adresa2, "124AB", g331);
        Student s3 = new Student("Avram", "Mihai", adresa1, "125AB", g331);

        Profesor p1 = new Profesor("Gheorghe", "Vasile", adresa1, info);
        Profesor p2 = new Profesor("Marin", "Ana", adresa2, mate);

        service.adaugaStudent(s1);
        service.adaugaStudent(s2);
        service.adaugaStudent(s3); // Adaugat cu "A" pt a testa sortarea
        service.adaugaProfesor(p1);
        service.adaugaProfesor(p2);

        // Actiunea 3: Materii
        Materie m1 = new Materie("Programare Orientata pe Obiecte", p1);
        Materie m2 = new Materie("Algebra", p2);
        service.adaugaMaterie(m1);
        service.adaugaMaterie(m2);

        // Actiunea 4: Acordare note
        service.acordaNota(s1, m1, 10);
        service.acordaNota(s1, m2, 8);
        service.acordaNota(s2, m1, 9);

        // Testare interogari
        System.out.println("\n");
        // Actiunea 5
        service.afiseazaStudenti(); // Vor aparea in ordine: Avram, Ionescu, Popescu (datorita TreeSet)

        System.out.println("\n");
        // Actiunea 6
        service.afiseazaProfesori();

        System.out.println("\n");
        // Actiunea 7
        service.afiseazaNoteStudent("123AB");

        System.out.println("\n");
        // Actiunea 8
        System.out.println("Media studentului Popescu Ion: " + service.calculeazaMedieStudent("123AB"));

        System.out.println("\n");
        // Actiunea 9
        service.afiseazaMateriiProfesor("Gheorghe");

        System.out.println("\n");
        // Actiunea 10
        service.stergeStudent("124AB");
        service.afiseazaStudenti(); // Verificam daca a fost sters
    }
}