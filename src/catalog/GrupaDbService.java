package catalog;
import java.sql.*;

public class GrupaDbService implements GenericCrudService<Grupa> {
    private static GrupaDbService instanta;
    private Connection connection = DatabaseConnection.getConexiune();

    private GrupaDbService() {}

    public static GrupaDbService getInstanta() {
        if (instanta == null) instanta = new GrupaDbService();
        return instanta;
    }

    @Override
    public void create(Grupa grupa) {
        String sql = "INSERT INTO grupa (cod_grupa) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, grupa.getCodGrupa());
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_create_grupa");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public Grupa read(int id) {
        String sql = "SELECT * FROM grupa WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            AuditService.getInstanta().logActiune("db_read_grupa");
            if (rs.next()) {
                Grupa g = new Grupa(rs.getString("cod_grupa"));
                g.setId(id);
                return g;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public void update(Grupa grupa) {
        String sql = "UPDATE grupa SET cod_grupa = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, grupa.getCodGrupa());
            pstmt.setInt(2, grupa.getId());
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_update_grupa");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM grupa WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_delete_grupa");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}