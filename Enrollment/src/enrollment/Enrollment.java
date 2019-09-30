/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author gravadorre_sd2023
 */
public class Enrollment {

    /**
     * @param args the command line arguments
     */
    public static List<Account> account = new ArrayList<Account>();
    public static List<PersonalInfo> perInfo = new ArrayList<PersonalInfo>();
    public static List<Course> course = new ArrayList<Course>();

    public static String folder = "C:\\Users\\gravadorre_sd2023\\Documents\\NetBeansProjects\\Enrollment\\Files\\";
    public static Scanner user = new Scanner(System.in);
    public static AskforInfos askinfo = new AskforInfos();

    public static void main(String[] args) {
        Retrieve.lunch();
        String username, password, firstname, lastname, age, title, unit, sched;
        boolean idn = true;
        while (idn) {
            Ask ask = new Ask();
            System.out.print("1. Register\n2. Get Info\n3. Delete Info\n4. Update Info\n5. exit\nInput: ");
            String option = user.next();
            if (option.equals("1")) {
                String[] accInfo = askinfo.accountInfo().split(" ");
                username = accInfo[0];
                password = accInfo[1];
                int accId = CRUD.generateAccId();
                account.add(new Account(Integer.toString(accId), username, password));
                CRUD.updateAccFile();
                System.out.println("New Account is added");
                System.out.print("1. Add Personal Information\n2. Leave\ninput: ");
                String askper = user.next();
                switch (askper) {
                    case "1":
                        String[] personalinfo = askinfo.personalinfo().split(" ");
                        firstname = personalinfo[0];
                        lastname = personalinfo[1];
                        age = personalinfo[2];
                        perInfo.add(new PersonalInfo(Integer.toString(CRUD.generateCourseId()), Integer.toString(accId), firstname, lastname, age));
                        CRUD.updatePerInfoFile();
                        System.out.println("Added personal infomation");
                        break;
                    case "2":
                        System.out.println("You leave personal infomation as blank");
                        break;
                    default:
                        System.out.println("invalid key");
                        break;
                }
                //course
                System.out.print("1. Add Subject \n2. Leave\ninput: ");
                String askcourse = user.next();
                switch (askcourse) {
                    case "1":
                        String[] courseinfo = askinfo.courseinfo().split(" ");
                        title = courseinfo[0];
                        unit = courseinfo[1];
                        sched = courseinfo[2];
                        course.add(new Course(Integer.toString(CRUD.generateCourseId()), Integer.toString(accId), title, unit, sched));
                        CRUD.updateCourseFile();
                        System.out.println("New Subject is added!!!");
                        break;
                    case "2":
                        System.out.println("You did not provide course");
                }
            } else if (option.equals("2")) {
                String get = ask.require("1. Account\n2. Personal Info\n3. Course\ninput");
                if (get.equals("1")) {
                    CRUD.getAccount();
                } else if ("2".equals(get)) {
                    CRUD.getPersonalInfo();
                } else if ("3".equals(get)) {
                    CRUD.getCourse();
                } else {
                    System.out.println("Invalid Input");
                }
            } else if (option.equals("3")) {
                String delete = ask.require("1.Delete Account\n2.Delete Personal Info\n3.Delete Course\ninput");
                if ("1".equals(delete)) {
                    CRUD.deleteAccount();
                    CRUD.updateAccFile();
                } else if ("2".equals(delete)) {
                    CRUD.deletePersonalInfo();
                    CRUD.updatePerInfoFile();
                } else if ("3".equals(delete)) {
                    CRUD.deleteCourse();
                    CRUD.updateCourseFile();
                } else {
                    System.out.println("Invalid Input");
                }
            } else if (option.equals("4")) {
                String update = Ask.require("1. Update personal info\n2. Update course\ninput");
                if (update.equals("1")) {
                    CRUD.updatePerInfo();
                    CRUD.updatePerInfoFile();
                } else if (update.equals("2")) {
                    CRUD.updateCourse();
                    CRUD.updateCourseFile();
                } else {
                    System.out.println("Invalid input");
                }
            } else if (option.equals("5")) {
                idn = false;
                System.out.println("Thank You");
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

}