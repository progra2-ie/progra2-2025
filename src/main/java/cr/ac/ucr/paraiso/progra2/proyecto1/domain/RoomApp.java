package cr.ac.ucr.paraiso.progra2.proyecto1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoomApp {
    public static void main(String[] args) {
     //Crear una instancia del room con todos sus datos
     Room room1 = new Room();
     room1.setRoomNumber("e99p100h100");
     room1.setHotel(new Hotel(100, "Dominical Experience", "Dominical, Puntarenas"));
     room1.setRoomCondition(RoomCondition.EN_MANTENIMIENTO);
     room1.setRoomType(RoomType.DELUXE);

    Room room2 = new Room();
    room2.setRoomNumber("e99p100h101");
    room2.setHotel(new Hotel(100, "Dominical Experience", "Dominical, Puntarenas"));
    room2.setRoomCondition(RoomCondition.DISPONIBLE);
    room2.setRoomType(RoomType.ESTANDAR);

    Room room3 = new Room();
    room3.setRoomNumber("e99p100h105");
    room3.setHotel(new Hotel(100, "Dominical Experience", "Dominical, Puntarenas"));
    room3.setRoomCondition(RoomCondition.DISPONIBLE);
    room3.setRoomType(RoomType.DELUXE);
     // TODO Crear una instancia del hotel con todos sus datos
    Hotel hotel = new Hotel();
    hotel.setHotelId(100);
    hotel.setName("Dominical experience");
    List<Room> rooms = new ArrayList<Room>();
    rooms.add(room1);
    rooms.add(room2);
    rooms.add(room3);
    hotel.setRooms(rooms);

    System.out.println("--- Rooms Grouped by Type for " + hotel.getName() + " ---");

    // Grouping rooms by RoomType using Java Streams
    Map<RoomType, List<Room>> roomsGroupedByType = hotel.getRooms().stream()
            .collect(Collectors.groupingBy(Room::getRoomType));

    // Printing the grouped rooms
    for (Map.Entry<RoomType, List<Room>> entry : roomsGroupedByType.entrySet()) {
        RoomType type = entry.getKey();
        List<Room> roomsOfType = entry.getValue();
        System.out.println("\nRooms of Type: " + type);
        for (Room room : roomsOfType) {
            System.out.println("  - " + room); // Assuming Room's toString() is well-defined
        }
    }

    }
}
