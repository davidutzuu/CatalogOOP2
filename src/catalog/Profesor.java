package catalog;

public class Profesor extends Persoana {
    private Departament departament;

    public Profesor(String nume, String prenume, Adresa adresa, Departament departament) {
        super(nume, prenume, adresa);
        this.departament = departament;
    }

    public Departament getDepartament() { return departament; }
    public void setDepartament(Departament departament) { this.departament = departament; }

    @Override
    public String toString() {
        return "Profesor: " + nume + " " + prenume + " - Dept: " + departament;
    }
}