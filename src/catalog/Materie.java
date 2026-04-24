package catalog;

public class Materie {
    private String nume;
    private Profesor titular;

    public Materie(String nume, Profesor titular) {
        this.nume = nume;
        this.titular = titular;
    }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public Profesor getTitular() { return titular; }
    public void setTitular(Profesor titular) { this.titular = titular; }

    @Override
    public String toString() { return nume + " (Prof. " + titular.getNume() + ")"; }
}