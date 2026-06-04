package catalog;
import java.sql.*;

public class DepartamentDbService implements GenericCrudService<Departament> {
    private static DepartamentDbService instanta;
    private Connection connection = DatabaseConnection.getConexiune();

    private DepartamentDbService() {}

    public static DepartamentDbService getInstanta() {
        if (instanta == null) instanta = new DepartamentDbService();
        return instanta;
    }

    @Override
    public void create(Departament dep) {
        String sql = "INSERT INTO departament (nume) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, dep.getNume());
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_create_departament");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public Departament read(int id) {
        String sql = "SELECT * FROM departament WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            AuditService.getInstanta().logActiune("db_read_departament");
            if (rs.next()) {
                Departament d = new Departament(rs.getString("nume"));
                d.setId(id);
                return d;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public void update(Departament dep) {
        String sql = "UPDATE departament SET nume = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, dep.getNume());
            pstmt.setInt(2, dep.getId());
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_update_departament");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM departament WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            AuditService.getInstanta().logActiune("db_delete_departament");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}