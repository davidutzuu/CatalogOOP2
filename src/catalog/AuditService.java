package catalog;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private static AuditService instanta;
    private final String fisierLog = "audit.csv";

    private AuditService() {}

    public static AuditService getInstanta() {
        if (instanta == null) instanta = new AuditService();
        return instanta;
    }

    public void logActiune(String numeActiune) {
        try (FileWriter writer = new FileWriter(fisierLog, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.append(numeActiune).append(",").append(timestamp).append("\n");
        } catch (IOException e) {
            System.out.println("Eroare scriere audit: " + e.getMessage());
        }
    }
}