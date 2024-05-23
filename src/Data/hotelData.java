/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;


/**
 *
 * @author Do Dat
 */
public class hotelData implements Serializable, Comparable<hotelData>{
    private String Hotel_id;
    private String Hotel_name;
    private int Hotel_Room_Available;
    private String Hotel_Address;
    private String Hotel_Phone;
    private int Hotel_Rating;

    public hotelData() {
    }

    public hotelData(String Hotel_id, String Hotel_name, int Hotel_Room_Available, String Hotel_Address, String Hotel_Phone, int Hotel_Rating) {
        this.Hotel_id = Hotel_id;
        this.Hotel_name = Hotel_name;
        this.Hotel_Room_Available = Hotel_Room_Available;
        this.Hotel_Address = Hotel_Address;
        this.Hotel_Phone = Hotel_Phone;
        this.Hotel_Rating = Hotel_Rating;
    }

    public String getHotel_id() {
        return Hotel_id;
    }

    public void setHotel_id(String Hotel_id) {
        this.Hotel_id = Hotel_id;
    }

    public String getHotel_name() {
        return Hotel_name;
    }

    public void setHotel_name(String Hotel_name) {
        this.Hotel_name = Hotel_name;
    }

    public int getHotel_Room_Available() {
        return Hotel_Room_Available;
    }

    public void setHotel_Room_Available(int Hotel_Room_Available) {
        this.Hotel_Room_Available = Hotel_Room_Available;
    }

    public String getHotel_Address() {
        return Hotel_Address;
    }

    public void setHotel_Address(String Hotel_Address) {
        this.Hotel_Address = Hotel_Address;
    }

    public String getHotel_Phone() {
        return Hotel_Phone;
    }

    public void setHotel_Phone(String Hotel_Phone) {
        this.Hotel_Phone = Hotel_Phone;
    }

    public int getHotel_Rating() {
        return Hotel_Rating;
    }

    public void setHotel_Rating(int Hotel_Rating) {
        this.Hotel_Rating = Hotel_Rating;
    }

    @Override
    public String toString() {       
        return String.format("|%9s|%17s|%20s|%35s|%11s|%7d star|", Hotel_id,Hotel_name,Hotel_Room_Available,Hotel_Address,Hotel_Phone,Hotel_Rating);       
    }

    @Override
    public int compareTo(hotelData o) {
        return o.getHotel_name().compareTo(this.getHotel_name());
    }   
}
