package catalog;

public class Departament {
    private int id; // Adaugat pentru DB
    private String nume;

    public Departament(String nume) { this.nume = nume; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    @Override
    public String toString() { return nume; }
}