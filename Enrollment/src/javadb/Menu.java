/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

import java.util.Scanner;
import static javadb.InfoNotValidException.*;

/**
 *
 * @author gravadorre_sd2023
 */
public class Menu {
    
    public static String main(){
        boolean undone = true;
        String data = null;
        while (undone){
            try{
                data = ask("1. Register\n2. Get Info\n3. Delete Info\n4. Update Info\n5. exit\nInput");
                isNumber(data);
                undone = false;
            }catch(InfoNotValidException ex){
                System.out.println(ex);
            }
        }
        return data;
    }
    
    public static String askId(String field){
        boolean undone = true;
        String data = null;
        while (undone){
            try{
                data = ask(field);
                isNumber(data);
                undone = false;
            }catch(InfoNotValidException ex){
                System.out.println(ex);
            }
        }
        return data;
    }
    
    public static String ask(String label) {
        System.out.print(label + ": ");
        return input.next();
    }
}
