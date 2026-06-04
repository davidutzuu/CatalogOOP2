package catalog;
import java.sql.*;

public class AdresaDbService implements GenericCrudService<Adresa> {
    private static AdresaDbService instanta;
    private Connection connection = DatabaseConnection.getConexiune();

    private AdresaDbService() {}

    public static AdresaDbService getInstanta() {
        if (instanta == null) instanta = new AdresaDbService();
        return instanta;
    }

    @Override
    public void create(Adresa adresa) {
        String sql = "INSERT INTO adresa (oras, strada) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, adresa.getOras());
            pstmt.setString(2, adresa.getStrada());
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_create_adresa");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public Adresa read(int id) {
        String sql = "SELECT * FROM adresa WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            AuditService.getInstanta().logActiune("db_read_adresa");
            if (rs.next()) {
                Adresa a = new Adresa(rs.getString("oras"), rs.getString("strada"));
                a.setId(id);
                return a;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public void update(Adresa adresa) {
        String sql = "UPDATE adresa SET oras = ?, strada = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, adresa.getOras());
            pstmt.setString(2, adresa.getStrada());
            pstmt.setInt(3, adresa.getId());
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_update_adresa");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM adresa WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_delete_adresa");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}