package catalog;

public class Nota {
    private int valoare;
    private Materie materie;
    private Student student;

    public Nota(int valoare, Materie materie, Student student) {
        this.valoare = valoare;
        this.materie = materie;
        this.student = student;
    }

    public int getValoare() { return valoare; }
    public void setValoare(int valoare) { this.valoare = valoare; }
    public Materie getMaterie() { return materie; }
    public void setMaterie(Materie materie) { this.materie = materie; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    @Override
    public String toString() {
        return "Nota " + valoare + " la " + materie.getNume();
    }
}