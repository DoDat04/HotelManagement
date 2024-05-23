/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkData;

import java.util.Scanner;

/**
 *
 * @author Do Dat
 */
public class Tools {
    public static String inputStr(String msg) {
        String result;
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        result = sc.nextLine();
        return result;
    }
    
    public static String inputHotelId(String msg) {  
        String data = "";
        boolean lapNua = true;
        while (lapNua) {            
            try {
                data = inputStr(msg).toUpperCase().trim();
                if (data.isEmpty()) {
                    throw new Exception();
                }
                lapNua = false;
            } catch (Exception e) {
                System.out.println("Invalid input!!! Please enter as Hxx (x is number)!!!");
                lapNua = true;
            }
        }
        return data;
    }
    
    public static String inputHotelName(String msg) {
        String pattern = ".*\\d.*";
        String data = "";
        boolean lapNua = true;
        while (lapNua) {            
            try {
                data = inputStr(msg).trim();
                if (data.isEmpty() || data.matches(pattern)) {
                    throw new Exception();
                }
                lapNua = false;
            } catch (Exception e) {
                System.out.println("Invalid input!!! Name must not be empty and contain numbers!!!");
                lapNua = true;
            }
        }
        return data;
    }
    
    public static int inputHotelRoomAvailable(String msg) {
        String pattern = "[a-zA-Z]";
        String data;
        int number = 0;
        boolean lapNua = true;
        while (lapNua) {            
            try {
                data = inputStr(msg).trim();
                number = Integer.parseInt(data);
                if (number < 0 || data.matches(pattern)) {
                    throw new Exception();
                }
                lapNua = false;
            } catch (Exception e) {
                System.out.println("Invalid input!!! Room hotel must be a number (greater than 0)!!!");
                lapNua = true;
            }
        }
        return number;
    }
    
    public static String inputHotelAddress(String msg) {
        String data = "";
        boolean lapNua = true;
        while (lapNua) {            
            try {
                data = inputStr(msg).trim();
                if (data.isEmpty()) {
                    throw new Exception();
                }
                lapNua = false;
            } catch (Exception e) {
                System.out.println("Invalid input!!! Must not be empty!!!");
                lapNua = true;
            }
        }
        return data;
    }
    
    public static String inputHotelPhone(String msg) {
        String pattern = "0\\d{9}";
        String data = "";
        boolean lapNua = true;
        while (lapNua) {            
            try {
                data = inputStr(msg).trim();
                if (!data.matches(pattern)) {
                    throw new Exception();
                }
                lapNua = false;
            } catch (Exception e) {
                System.out.println("Invalid input!!! Phone must start with 0 and have 10 numbers!!!");
                lapNua = true;
            }
        }
        return data;
    }
    
    public static int inputHotelRating(String msg) {
        String pattern = "[1-6]";
        String data;
        int rating = 0;
        boolean lapNua = true;
        while (lapNua) {            
            try {
                data = inputStr(msg).trim();
                rating = Integer.parseInt(data);
                if (!data.matches(pattern)) {
                    throw new Exception();
                }
                lapNua = false;
            } catch (Exception e) {
                System.out.println("Invalid input!!! Please enter a number in range!!!");
                lapNua = true;
            }
        }
        return rating;
    }
    
    public static boolean inputYN(String msg) {
        String data;
        boolean lapNua = true;
        while (lapNua) {            
            try {
                data = inputStr(msg);
                if (data.equalsIgnoreCase("Y")) {
                    return true;
                } else if (data.equalsIgnoreCase("N")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Must be Y or N!!!");
                lapNua = true;
            }
        }
        return false;
    }
    
    public static int inputChoice(String msg) {
        int choice = 0;
        String pattern = "[a-zA-z]";
        String data;
        boolean lapNua = true;
        while (lapNua) {            
            try {
                data = inputStr(msg);
                choice = Integer.parseInt(data);
                if (data.matches(pattern))
                    throw new Exception();
                lapNua = false;
            } catch (Exception e) {
                System.out.println("Invalid input!!! Choice must be a number!!!");
                lapNua = true;
            }
        }
        return choice;
    }
}
