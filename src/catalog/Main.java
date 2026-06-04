package catalog;

public class Main {
    public static void main(String[] args) {
        // --- ETAPA 1 (Memorie & Audit) ---
        System.out.println("=== RULARE ETAPA 1 ===");
        CatalogService service = new CatalogService();

        Adresa adresa1 = new Adresa("Bucuresti", "Str. Primaverii");
        Adresa adresa2 = new Adresa("Cluj", "Str. Toamnei");
        Departament info = new Departament("Informatica");
        Departament mate = new Departament("Matematica");
        Grupa g331 = new Grupa("331");

        Student s1 = new Student("Popescu", "Ion", adresa1, "123AB", g331);
        Student s2 = new Student("Ionescu", "Andrei", adresa2, "124AB", g331);
        Student s3 = new Student("Avram", "Mihai", adresa1, "125AB", g331);

        Profesor p1 = new Profesor("Gheorghe", "Vasile", adresa1, info);
        Profesor p2 = new Profesor("Marin", "Ana", adresa2, mate);

        service.adaugaStudent(s1);
        service.adaugaStudent(s2);
        service.adaugaStudent(s3);
        service.adaugaProfesor(p1);
        service.adaugaProfesor(p2);

        Materie m1 = new Materie("Programare Orientata pe Obiecte", p1);
        service.adaugaMaterie(m1);

        service.acordaNota(s1, m1, 10);
        service.afiseazaStudenti();
        System.out.println("Media: " + service.calculeazaMedieStudent("123AB"));


        // --- ETAPA 2 (Baza de Date JDBC) ---
        System.out.println("\n=== RULARE ETAPA 2 (JDBC) ===");

        // Testam CRUD pentru Departament
        DepartamentDbService depDb = DepartamentDbService.getInstanta();

        // CREATE
        Departament dNou = new Departament("Cibernetica DB");
        depDb.create(dNou);
        System.out.println("1. [CREATE] Am adaugat departamentul in SQLite.");

        // READ (Citim primul ID adaugat)
        Departament citit = depDb.read(1);
        if (citit != null) {
            System.out.println("2. [READ] Am citit din DB: " + citit.getNume());

            // UPDATE
            citit.setNume("Cibernetica Modificat DB");
            depDb.update(citit);
            System.out.println("3. [UPDATE] Nume modificat in baza de date.");

            // DELETE
            // depDb.delete(1); // Decomenteaza daca vrei sa il si stergi la final
        }

        System.out.println("\nUita-te in stanga in IntelliJ! S-au creat fisierele 'catalog_db.sqlite' si 'audit.csv'!");
    }
}