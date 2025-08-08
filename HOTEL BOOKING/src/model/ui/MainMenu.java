package ui;  
import dao.BookingDAO;
import dao.RoomDAO;
import model.Room;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomDAO roomDAO = new RoomDAO();
        BookingDAO bookingDAO = new BookingDAO();

        while (true) {
            System.out.println("\n=== Hotel Booking System ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    viewAvailableRooms(roomDAO);
                    break;
                case 2:
                    bookRoom(scanner, roomDAO, bookingDAO);
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void viewAvailableRooms(RoomDAO roomDAO) {
        List<Room> rooms = roomDAO.getAvailableRooms();
        if (rooms.isEmpty()) {
            System.out.println("\nNo rooms available currently.");
        } else {
            System.out.println("\nAvailable Rooms:");
            System.out.println("ID\tType\t\tPrice/Night");
            System.out.println("--------------------------------");
            for (Room room : rooms) {
                System.out.printf("%d\t%-10s\t$%.2f%n",
                    room.getId(),
                    room.getType(),
                    room.getPrice());
            }
        }
    }

    private static void bookRoom(Scanner scanner, RoomDAO roomDAO, BookingDAO bookingDAO) {
       
        viewAvailableRooms(roomDAO);

        System.out.print("\nEnter Room ID to book: ");
        int roomId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Your Name: ");
        String guestName = scanner.nextLine();

        System.out.print("Check-In Date (YYYY-MM-DD): ");
        String checkIn = scanner.nextLine();

        System.out.print("Check-Out Date (YYYY-MM-DD): ");
        String checkOut = scanner.nextLine();

       
        bookingDAO.saveBooking(roomId, guestName, checkIn, checkOut);
        System.out.println("Booking confirmed!");

        
        roomDAO.updateRoomAvailability(roomId, false);
    }
}