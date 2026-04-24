package catalog;

public class Grupa {
    private String codGrupa;

    public Grupa(String codGrupa) { this.codGrupa = codGrupa; }

    public String getCodGrupa() { return codGrupa; }
    public void setCodGrupa(String codGrupa) { this.codGrupa = codGrupa; }

    @Override
    public String toString() { return codGrupa; }
}