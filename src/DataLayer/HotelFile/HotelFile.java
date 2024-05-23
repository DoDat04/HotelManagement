/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer.HotelFile;

import Data.hotelData;
import DataLayer.FileManager;
import java.util.List;

/**
 *
 * @author Do Dat
 */
public class HotelFile {
    private final FileManager fm;
    
    public HotelFile() {
        fm = new FileManager();
    }
    
    public boolean loadDataFromFile(List<hotelData> hotel ,String fName) {
        return fm.loadDataFromFile(hotel, fName);
    }
    
    public boolean saveDataFromFile(List<hotelData> hotel,String fName){
        return fm.saveDataToFile(hotel, fName, "Hotels saved to file successfully!!!");
    }
}
