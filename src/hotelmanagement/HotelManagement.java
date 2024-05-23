/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import Service.HotelService;
import java.io.EOFException;


/**
 *
 * @author Do Dat
 */
public class HotelManagement {

    /**
     * @param args the command line arguments
     * @throws java.io.EOFException
     */
    public static void main(String[] args) throws EOFException {
        String[] options = {
            "Adding new Hotel",
            "Checking exists Hotel",
            "Updating Hotel information",
            "Deleting Hotel",
            "Searching Hotel",
            "Displaying a hotel list",
            "Display hotel by room and rating",
            "Exit"
        };
        
        int choice;
        HotelService hs = new HotelService();
        do { 
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("-                            HOTEL MANAGEMENT                           -");
            System.out.println("-------------------------------------------------------------------------");          
            choice = Menu.getChoice(options);            
            switch(choice) {
                case 1:
                    hs.addHotel();
                    break;
                case 2:
                    hs.checkExistHotel();
                    break;
                case 3:
                    hs.updateHotelInfo();
                    break;
                case 4:
                    hs.deleteHotel();
                    break;
                case 5:
                    hs.searchHotel();
                    break;
                case 6:
                    hs.displayHotelList();
                    break;
                case 7:
                    hs.displayHotelByRoomAndRating();
                    break;
                case 8:
                    System.out.println("GOOD BYE!!!");
                    break;
                default:
                    System.out.println("Invalid choice!!! Please choose again!!!");
            }
        } while (choice != 8);
        
        
        
    }
    
}
