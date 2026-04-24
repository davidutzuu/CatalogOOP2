package catalog;

// Implementeaza Comparable pentru a putea fi sortat automat intr-un TreeSet
public class Student extends Persoana implements Comparable<Student> {
    private String nrMatricol;
    private Grupa grupa;

    public Student(String nume, String prenume, Adresa adresa, String nrMatricol, Grupa grupa) {
        super(nume, prenume, adresa);
        this.nrMatricol = nrMatricol;
        this.grupa = grupa;
    }

    public String getNrMatricol() { return nrMatricol; }
    public void setNrMatricol(String nrMatricol) { this.nrMatricol = nrMatricol; }
    public Grupa getGrupa() { return grupa; }
    public void setGrupa(Grupa grupa) { this.grupa = grupa; }

    @Override
    public int compareTo(Student o) {
        int numeCompare = this.nume.compareTo(o.nume);
        if (numeCompare != 0) return numeCompare;
        return this.prenume.compareTo(o.prenume);
    }

    @Override
    public String toString() {
        return "Student: " + nume + " " + prenume + " (" + nrMatricol + "), Grupa: " + grupa;
    }
}