package model;

public class Room {
    private int id;             
    private String type;        
    private double price;       
    private boolean isAvailable; 

    
    public Room(String type, double price) {
        this.type = type;
        this.price = price;
        this.isAvailable = true; 
    }

    
    public int getId() { return id; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }

    
    public void setId(int id) {
        this.id = id;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    

}