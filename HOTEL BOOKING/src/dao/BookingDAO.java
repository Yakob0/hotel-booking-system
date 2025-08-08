package dao;


import java.sql.*;

public class BookingDAO {
    private static final String DB_URL = "jdbc:sqlite:database/hotel.db";

    public void saveBooking(int roomId, String guestName, String checkIn, String checkOut) {
        String sql = "INSERT INTO bookings (room_id, guest_name, check_in, check_out) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, roomId);
            pstmt.setString(2, guestName);
            pstmt.setString(3, checkIn);
            pstmt.setString(4, checkOut);
            pstmt.executeUpdate();

            System.out.println("Booking saved!");
        } catch (SQLException e) {
            System.err.println("Error saving booking: " + e.getMessage());
        }
    }
}