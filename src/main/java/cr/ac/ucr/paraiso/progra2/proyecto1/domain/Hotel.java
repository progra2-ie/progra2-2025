package cr.ac.ucr.paraiso.progra2.proyecto1.domain;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int hotelId;
    private String name;
    private String address;
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<Room>();
    }

    public Hotel(int hotelId, String name, String address) {
        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
    }

    public Hotel(int hotelId, String name, String address, List<Room> rooms) {
        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.rooms = rooms;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
