# Hotel Booking System

A Java-based hotel booking management system with SQLite database integration.

## 📁 Project Structure

```
HOTEL BOOKING/
├── database/
│   └── init_hotel_db.sql          # Database initialization script
├── lib/
│   ├── README.md                   # SQLite JDBC driver instructions
│   └── sqlite-jdbc-3.44.1.0.jar   # SQLite JDBC driver (download required)
├── SRC/
│   ├── dao/
│   │   ├── BookingDAO.java         # Data Access Object for bookings
│   │   └── RoomDAO.java           # Data Access Object for rooms
│   ├── MODEL/
│   │   ├── Booking.java           # Booking entity class
│   │   ├── Room.java              # Room entity class
│   │   └── ui/
│   │       └── MainMenu.java      # Main user interface
└── README.md                      # This file
```

## 🚀 Features

- **View Available Rooms**: Display all available rooms with details
- **Book a Room**: Create new bookings with guest information
- **Database Integration**: SQLite database for persistent storage
- **Room Management**: Track room availability and pricing

## 🛠️ Prerequisites

- Java JDK 8 or higher
- SQLite3 JDBC Driver (instructions in `lib/README.md`)

## 📦 Installation

### 1. Download SQLite JDBC Driver

Navigate to the `lib` folder and follow the instructions in `lib/README.md` to download the SQLite JDBC driver.

### 2. Initialize Database

Run the database initialization script:

```bash
sqlite3 database/hotel.db < database/init_hotel_db.sql
```

## 🔧 Compilation

Compile all Java files with the SQLite JDBC driver in the classpath:

```bash
javac -cp "lib/*" SRC/dao/*.java SRC/MODEL/*.java SRC/MODEL/ui/*.java
```

## 🏃‍♂️ Running the Application

Run the main application:

```bash
java -cp "lib/*;." ui.MainMenu
```

## 📋 Usage

1. **View Available Rooms**: Select option 1 to see all available rooms
2. **Book a Room**: Select option 2 to create a new booking
   - Enter Room ID
   - Enter Guest Name
   - Enter Check-in Date (YYYY-MM-DD format)
   - Enter Check-out Date (YYYY-MM-DD format)
3. **Exit**: Select option 3 to exit the application

## 🗄️ Database Schema

### Rooms Table
- `id` (INTEGER PRIMARY KEY): Room identifier
- `type` (TEXT): Room type (e.g., "Deluxe", "Suite")
- `price_per_night` (REAL): Price per night
- `is_available` (BOOLEAN): Room availability status

### Bookings Table
- `id` (INTEGER PRIMARY KEY): Booking identifier
- `room_id` (INTEGER): Reference to room
- `guest_name` (TEXT): Guest name
- `check_in` (TEXT): Check-in date
- `check_out` (TEXT): Check-out date

## 🏗️ Architecture

### Model Classes
- **Room**: Represents a hotel room with properties like id, type, price, and availability
- **Booking**: Represents a booking with room, guest, and date information

### DAO Classes
- **RoomDAO**: Handles database operations for rooms (CRUD operations)
- **BookingDAO**: Handles database operations for bookings

### UI Classes
- **MainMenu**: Main user interface with menu-driven interaction

## 🔍 Key Methods

### RoomDAO
- `getAvailableRooms()`: Retrieves all available rooms
- `updateRoomAvailability(int roomId, boolean isAvailable)`: Updates room availability

### BookingDAO
- `saveBooking(int roomId, String guestName, String checkIn, String checkOut)`: Creates new booking

## 🐛 Troubleshooting

### Common Issues

1. **"Room cannot be resolved to a type"**
   - Ensure all files are compiled together
   - Check that the SQLite JDBC driver is in the classpath

2. **"The import model cannot be resolved"**
   - Compile from the correct directory
   - Use the proper classpath with `-cp "lib/*"`

3. **Database connection errors**
   - Ensure the database file exists
   - Check that the SQLite JDBC driver is downloaded

## 📝 Development Notes

- The project uses uppercase directory names (`SRC`, `MODEL`) which may cause compilation issues
- Consider renaming directories to lowercase for better Java package conventions
- The system uses SQLite for simplicity; can be extended to other databases

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request



**Note**: Make sure to download the SQLite JDBC driver before running the application. See `lib/README.md` for detailed instructions.
