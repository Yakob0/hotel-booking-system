-- Create rooms table
CREATE TABLE IF NOT EXISTS rooms (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    type TEXT NOT NULL,
    price_per_night REAL NOT NULL,
    is_available BOOLEAN NOT NULL DEFAULT 1
);

-- Create bookings table
CREATE TABLE IF NOT EXISTS bookings (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    room_id INTEGER NOT NULL,
    guest_name TEXT NOT NULL,
    check_in TEXT NOT NULL,
    check_out TEXT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);

-- Insert sample rooms
INSERT INTO rooms (type, price_per_night, is_available) VALUES
('Deluxe', 120.0, 1),
('Suite', 200.0, 1),
('Standard', 80.0, 1); 