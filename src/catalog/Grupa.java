package catalog;

public class Grupa {
    private int id; // Adaugat pentru DB
    private String codGrupa;

    public Grupa(String codGrupa) { this.codGrupa = codGrupa; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCodGrupa() { return codGrupa; }
    public void setCodGrupa(String codGrupa) { this.codGrupa = codGrupa; }

    @Override
    public String toString() { return codGrupa; }
}