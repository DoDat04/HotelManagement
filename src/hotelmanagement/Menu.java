/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import checkData.Tools;

/**
 *
 * @author Do Dat
 */
public class Menu {
    public static int getChoice(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " - " + options[i]);
            
        }
        System.out.println("-------------------------------------------------------------------------");
        return Tools.inputChoice("Choose 1 -> " + options.length + ": ");
    }
}
