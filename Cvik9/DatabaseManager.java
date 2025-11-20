package Cvik9;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:students.db";
    
    // Vytvorenie databázovej tabuľky
    public static void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS student (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    meno TEXT NOT NULL,
                    priezvisko TEXT NOT NULL,
                    email TEXT NOT NULL UNIQUE
                )
                """;
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabuľka 'student' bola úspešne vytvorená alebo už existuje.");
        } catch (SQLException e) {
            System.err.println("Chyba pri vytváraní tabuľky: " + e.getMessage());
        }
    }
    
    // Vloženie nového študenta
    public static boolean insertStudent(Student student) {
        String sql = "INSERT INTO student(meno, priezvisko, email) VALUES(?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, student.getMeno());
            pstmt.setString(2, student.getPriezvisko());
            pstmt.setString(3, student.getEmail());
            pstmt.executeUpdate();
            
            System.out.println("Študent bol úspešne pridaný do databázy.");
            return true;
        } catch (SQLException e) {
            System.err.println("Chyba pri vkladaní študenta: " + e.getMessage());
            return false;
        }
    }
    
    // Výpis všetkých študentov
    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, meno, priezvisko, email FROM student";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("id"),
                    rs.getString("meno"),
                    rs.getString("priezvisko"),
                    rs.getString("email")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println("Chyba pri načítavaní študentov: " + e.getMessage());
        }
        
        return students;
    }
    
    // Vyhľadanie študenta podľa ID
    public static Student getStudentById(int id) {
        String sql = "SELECT id, meno, priezvisko, email FROM student WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("meno"),
                    rs.getString("priezvisko"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.err.println("Chyba pri vyhľadávaní študenta: " + e.getMessage());
        }
        
        return null;
    }
    
    // Aktualizácia študenta
    public static boolean updateStudent(Student student) {
        String sql = "UPDATE student SET meno = ?, priezvisko = ?, email = ? WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, student.getMeno());
            pstmt.setString(2, student.getPriezvisko());
            pstmt.setString(3, student.getEmail());
            pstmt.setInt(4, student.getId());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Študent bol úspešne aktualizovaný.");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Chyba pri aktualizácii študenta: " + e.getMessage());
        }
        
        return false;
    }
    
    // Vymazanie študenta
    public static boolean deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Študent bol úspešne vymazaný.");
                return true;
            } else {
                System.out.println("Študent s ID " + id + " nebol najdený.");
            }
        } catch (SQLException e) {
            System.err.println("Chyba pri mazaní študenta: " + e.getMessage());
        }
        
        return false;
    }
}
