package model;
public class Booking {
    private int roomId;      
    private String guestName; 
    private String checkIn;   
    private String checkOut;  

    // Constructor
    public Booking(int roomId, String guestName, String checkIn, String checkOut) {
        this.roomId = roomId;
        this.guestName = guestName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Getters
    public int getRoomId() { return roomId; }
    public String getGuestName() { return guestName; }
    public String getCheckIn() { return checkIn; }
    public String getCheckOut() { return checkOut; }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}