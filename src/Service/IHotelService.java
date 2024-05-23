/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Do Dat
 */
public interface IHotelService {
    public void addHotel();
    public void checkExistHotel();
    public void updateHotelInfo();
    public void deleteHotel();
    public void searchHotel();
    public void displayHotelList();
    public void displayHotelByRoomAndRating();
}
