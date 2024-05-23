/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Data.hotelData;
import DataLayer.HotelFile.HotelFile;
import checkData.Tools;
import hotelmanagement.Menu;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author Do Dat
 */
public class HotelService implements IHotelService{
    private ArrayList<hotelData> listHotel = new ArrayList<>();
    private HotelFile hd = new HotelFile();
    String[] options = {
        "Search by Hotel_Id",
        "Search by Hotel_Name",
        "Exit"
    };
    
    /**
     * Khi chạy chương trình sẽ load file dat vô listHotel
     * @throws EOFException 
     */
    public HotelService() throws EOFException{
        try {
            hd.loadDataFromFile(listHotel, "Hotel.dat");
        } catch (Exception e) {
            System.out.println("The list is empty!!!");
        }
    }      
    
    public hotelData searchHotel(String code) {
        code = code.trim().toUpperCase();
        for (hotelData hotel : listHotel) {
            // Find hotel by id in upper and lower
            if (hotel.getHotel_id().equalsIgnoreCase(code)) {
                return hotel;
            }
        }
        // If not found hotel by the id
        return null;    
    }
    
    private boolean isIdDuplicated(String code) {
        return this.searchHotel(code) != null;
    }
    
    public void display(hotelData hotel) {
        String address = hotel.getHotel_Address();
        int n = address.length();
        String parts = address.substring(0, 32);
        
        String remain = address.substring(32, n);
        System.out.println("|-------------------------------------------------------------------------------------------------------------|");
        System.out.printf("|%-9s|%-17s|%-20s|%-35s|%-11s|%7s star|\n",hotel.getHotel_id(),hotel.getHotel_name(),hotel.getHotel_Room_Available(),
                                                                parts, hotel.getHotel_Phone(), hotel.getHotel_Rating());
                      
        System.out.printf("|%9s|%17s|%20s|%-35s|%11s|%12s|\n","","", "",remain, "", "");
        System.out.println("|-------------------------------------------------------------------------------------------------------------|");
    }
    
    @Override
    public void addHotel() {
        boolean choice = true;
        boolean idDuplicated;
        while(choice) {
            String hotelId;
            do {                
                hotelId = Tools.inputHotelId("Enter the id of hotel: ");
                idDuplicated = isIdDuplicated(hotelId);
                if (idDuplicated) {
                    System.out.println("ID already exist. Please enter another one!!!");
                }
            } while (idDuplicated);
          
            String hotelName = Tools.inputHotelName("Enter the name of hotel: ");
            int hotelRoom = Tools.inputHotelRoomAvailable("Enter the room available of hotel: ");
            String hotelAddress = Tools.inputHotelAddress("Enter the address of hotel: ");
            String hotelPhone = Tools.inputHotelPhone("Enter phone number of hotel: ");
            int hotelRating = Tools.inputHotelRating("Enter the star for hotel (1-6): ");
            hotelData newHotel = new hotelData(hotelId, hotelName, hotelRoom, hotelAddress, hotelPhone, hotelRating);
            listHotel.add(newHotel);
            hd.saveDataFromFile(listHotel, "D:\\SEM3\\LAB211\\HotelManagement\\src\\DataLayer\\Hotel.dat");
            choice = Tools.inputYN("Do you want to continue (Y/N): ");
        }           
    }

    @Override
    public void checkExistHotel() {       
        ArrayList<hotelData> checkHotel = new ArrayList<>();
        hd.loadDataFromFile(checkHotel, "Hotel.dat");
        boolean choice;

        hotelData foundHotel = null;

        for (hotelData hotel : checkHotel) {
            foundHotel = searchHotel(hotel.getHotel_id());

            // break out of the loop if a hotel is found
            if (foundHotel != null) {
                break;
            }
        }

        if (foundHotel != null) {
            System.out.println("Exist Hotel!!!");
        } else {
            System.out.println("No Hotel Found!!!");
        }                  
        choice = Tools.inputYN("Do you want to go back to main menu (Y/N): ");    
        if (!choice) {
            checkExistHotel();
        }
    }   

    @Override
    public void updateHotelInfo() {
        if (listHotel.isEmpty()) {
            System.out.println("No Hotel Found!!!");
            return;
        }
        String updateId = Tools.inputHotelId("Enter the id of hotel to update: ");
        hotelData hotel = searchHotel(updateId);
        if (hotel != null) {
            System.out.println("The hotel is found!!!");
            System.out.printf("|%-9s|%-17s|%-20s|%-35s|%-11s|%-10s|\n", "Hotel_ID", "Hotel_Name", "Hotel_Room_Available", "Hotel_Address", "Hotel_Phone", "Hotel_Rating");
            display(hotel);
            String new_hotel_name = Tools.inputHotelName("Enter the new name of hotel: ");
            int new_hotel_room_available = Tools.inputHotelRoomAvailable("Enter the new room available: ");
            String new_hotel_address = Tools.inputHotelAddress("Enter the new address of hotel: ");
            String new_hotel_phone = Tools.inputHotelPhone("Enter new phone number of hotel: ");
            int new_hotel_rating = Tools.inputHotelRating("Enter new rating for hotel (1-6): ");
            //update information of hotel at it's index
            listHotel.set(listHotel.indexOf(hotel), new hotelData(updateId, new_hotel_name, new_hotel_room_available, new_hotel_address, new_hotel_phone, new_hotel_rating));
            System.out.println("Update Successfully!!!");
            hd.saveDataFromFile(listHotel, "Hotel.dat");
        } else {
            System.out.println("Hotel does not exist!!!");
        }
    }

    @Override
    public void deleteHotel() {
        if (listHotel.isEmpty()) {
            System.out.println("No Hotel Found!!!");
            return;
        }
        String deleteId = Tools.inputHotelId("Enter the id of hotel to delete: ");
        hotelData hotel = searchHotel(deleteId);
        boolean choice;
        if (hotel != null) {
            System.out.println("The hotel is found!!!");
            System.out.printf("|%-9s|%-17s|%-20s|%-35s|%-11s|%-10s|\n", "Hotel_ID", "Hotel_Name", "Hotel_Room_Available", "Hotel_Address", "Hotel_Phone", "Hotel_Rating");
            display(hotel);
            choice = Tools.inputYN("Do you really want to delete (Y/N): ");
            if (choice) {
                listHotel.remove(hotel);
                System.out.println("Delete successfully!!!");
                hd.saveDataFromFile(listHotel, "Hotel.dat");
            }
        } else {
            System.out.println("Hotel does not exist!!!");
        }     
    }
    
    private void searchHotelById() {
        String searchHotelId = Tools.inputHotelId("Enter id of hotel to search: ");
        boolean check = false;
        
        System.out.printf("|%-9s|%-17s|%-20s|%-35s|%-11s|%-10s|\n", "Hotel_ID", "Hotel_Name", "Hotel_Room_Available", "Hotel_Address", "Hotel_Phone", "Hotel_Rating");
        for (hotelData hotel : listHotel) {
            if (hotel.getHotel_id().contains(searchHotelId)) {               
                display(hotel);
                check = true;
            }
        }

        if (!check) {
            System.out.println("Hotel does not exist!!!");
        } else {
            //descending by id
            Collections.sort(listHotel, (a1, a2) -> a2.getHotel_id().compareTo(a1.getHotel_id()));
            System.out.println("List of hotels after sorting descendingly by id!!!");
            System.out.printf("|%-9s|%-17s|%-20s|%-35s|%-11s|%-10s|\n", "Hotel_ID", "Hotel_Name", "Hotel_Room_Available", "Hotel_Address", "Hotel_Phone", "Hotel_Rating");
            for (hotelData hotelSortedId : listHotel) {          
                display(hotelSortedId);
            }  
        }       
    }
    
    private void searchHotelByName() {
        String searchHotelName = Tools.inputHotelName("Enter name of hotel to search: ").toLowerCase();
        boolean check = false;
        
        System.out.printf("|%-9s|%-17s|%-20s|%-35s|%-11s|%-10s|\n", "Hotel_ID", "Hotel_Name", "Hotel_Room_Available", "Hotel_Address", "Hotel_Phone", "Hotel_Rating");
        for (hotelData hotel : listHotel) {
            if (hotel.getHotel_name().toLowerCase().contains(searchHotelName)) {               
                display(hotel);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Hotel does not exist!!!");
        } 
    }

    @Override
    public void searchHotel() {
        if (listHotel.isEmpty()) {
            System.out.println("No Hotel Found!!!");
            return;
        }
        int choice;
        do {           
            choice = Menu.getChoice(options);
            switch(choice) {
                case 1:
                    searchHotelById();
                    break;
                case 2:
                    searchHotelByName();
                    break;
                case 3:
                    System.out.println("Thank you for choosing search hotel!!!");
                    break;
                default:
                    System.out.println("Invalid choice!!! Please enter again!!!");
            }
        } while (choice != 3);
    }

    @Override
    public void displayHotelList() {
        if (listHotel.isEmpty()) {
            System.out.println("No Hotel Found!!!");
            return;
        }
        System.out.printf("|%-9s|%-17s|%-20s|%-35s|%-11s|%-10s|\n", "Hotel_ID", "Hotel_Name", "Hotel_Room_Available", "Hotel_Address", "Hotel_Phone", "Hotel_Rating");
        Collections.sort(listHotel, Collections.reverseOrder());
//        String pattern = "0(?:911|918|988)\\d{6}";
        for (hotelData i : listHotel) {
            display(i);           
                               
        }
    }   

    @Override
    public void displayHotelByRoomAndRating() {
        if (listHotel.isEmpty()) {
            System.out.println("No Hotel Found!!!");
            return;
        }
        boolean check = false;
        int bookRoom = Tools.inputHotelRoomAvailable("Enter the number of rooms you want to book: ");
        int rating = Tools.inputHotelRating("Enter the star of hotel you want to book: ");
        for (hotelData hotel : listHotel) {
            if ((hotel.getHotel_Room_Available() >= bookRoom) && hotel.getHotel_Rating() == rating) {
                display(hotel);
                check = true;
            }               
        }
        
        if (!check) {
            System.out.println("No hotels apply your choice!!!");
        }
    }
    
}
