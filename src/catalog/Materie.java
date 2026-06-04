package catalog;

public class Materie {
    private int id; // Adaugat pentru DB
    private String nume;
    private Profesor titular;

    public Materie(String nume, Profesor titular) {
        this.nume = nume;
        this.titular = titular;
    }

    // Constructor secundar simplificat pentru citirea din DB
    public Materie(String nume) {
        this.nume = nume;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public Profesor getTitular() { return titular; }
    public void setTitular(Profesor titular) { this.titular = titular; }

    @Override
    public String toString() {
        if (titular != null) return nume + " (Prof. " + titular.getNume() + ")";
        return nume;
    }
}