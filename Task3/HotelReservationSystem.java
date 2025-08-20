import java.util.*;

class Room {
    int roomNumber;
    String type;
    boolean booked;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.booked = false;
    }
}

class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();

    Hotel() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(201, "Suite"));
    }

    void showAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        for (Room r : rooms) {
            if (!r.booked) {
                System.out.println("Room " + r.roomNumber + " (" + r.type + ")");
            }
        }
    }

    void bookRoom(int roomNumber) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber && !r.booked) {
                r.booked = true;
                System.out.println("Room " + r.roomNumber + " booked successfully!");
                return;
            }
        }
        System.out.println("Room not available!");
    }

    void cancelBooking(int roomNumber) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber && r.booked) {
                r.booked = false;
                System.out.println("Booking for room " + r.roomNumber + " cancelled.");
                return;
            }
        }
        System.out.println("Room not found or not booked!");
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n1. Show Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> hotel.showAvailableRooms();
                case 2 -> {
                    System.out.print("Enter room number: ");
                    int rn = sc.nextInt();
                    hotel.bookRoom(rn);
                }
                case 3 -> {
                    System.out.print("Enter room number: ");
                    int rn = sc.nextInt();
                    hotel.cancelBooking(rn);
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
