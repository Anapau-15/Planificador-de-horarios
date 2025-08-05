package mx.edu.utez.integradora.Proyecto.models;

import mx.edu.utez.integradora.Proyecto.utils.OracleDatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario {
    private int id;
    private String email;
    private String contra;

    // Getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }

    public boolean login() {
        String sql = "SELECT ID, EMAIL FROM Usuario WHERE LOWER(EMAIL) = LOWER(?) AND CONTRASEÑA = ?";
        try (Connection conn = OracleDatabaseConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String emailTrim = this.email.trim();
            String contraTrim = this.contra.trim();

            System.out.println("Intentando login con: '" + emailTrim + "' / '" + contraTrim + "'");

            stmt.setString(1, emailTrim);
            stmt.setString(2, contraTrim);  // No uses LOWER(?) aquí, ya que Oracle no lo permite

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.id = rs.getInt("ID");
                this.email = rs.getString("EMAIL");
                System.out.println("Usuario autenticado. ID: " + this.id);
                return true;
            } else {
                System.out.println("No se encontró usuario con esas credenciales.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error en login(): " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
