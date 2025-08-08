package dao;

import model.Room;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private static final String URL = "jdbc:sqlite:database/hotel.db";
    
public void updateRoomAvailability(int roomId, boolean isAvailable) {
    String sql = "UPDATE rooms SET is_available = ? WHERE id = ?";
    try (Connection conn = DriverManager.getConnection(URL);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setBoolean(1, isAvailable);
        pstmt.setInt(2, roomId);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error updating room: " + e.getMessage());
    }
}
    public List<Room> getAvailableRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE is_available = TRUE";
    
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Room room = new Room(
                        rs.getString("type"),
                        rs.getDouble("price_per_night")
                );
                room.setId(rs.getInt("id"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching rooms: " + e.getMessage());
        }
        return rooms;
    }
}