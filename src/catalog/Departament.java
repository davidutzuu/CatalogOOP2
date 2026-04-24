package catalog;

public class Departament {
    private String nume;

    public Departament(String nume) { this.nume = nume; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    @Override
    public String toString() { return nume; }
}