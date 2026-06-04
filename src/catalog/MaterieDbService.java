package catalog;
import java.sql.*;

public class MaterieDbService implements GenericCrudService<Materie> {
    private static MaterieDbService instanta;
    private Connection connection = DatabaseConnection.getConexiune();

    private MaterieDbService() {}

    public static MaterieDbService getInstanta() {
        if (instanta == null) instanta = new MaterieDbService();
        return instanta;
    }

    @Override
    public void create(Materie materie) {
        String sql = "INSERT INTO materie (nume) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, materie.getNume());
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_create_materie");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public Materie read(int id) {
        String sql = "SELECT * FROM materie WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            AuditService.getInstanta().logActiune("db_read_materie");
            if (rs.next()) {
                Materie m = new Materie(rs.getString("nume"));
                m.setId(id);
                return m;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public void update(Materie materie) {
        String sql = "UPDATE materie SET nume = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, materie.getNume());
            pstmt.setInt(2, materie.getId());
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_update_materie");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM materie WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_delete_materie");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}