/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

/**
 *
 * @author gravadorre_sd2023
 */
public class JavaDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean on = true;
        String id;
        while (on) {
            String option = Menu.main();
            switch (option) {
                case "1":
                    int accid = Sqlcrudaccount.insertAccount();
                    System.out.println(accid);
                    String perinfo = Menu.ask("1. Add Personal Info\n2. Leave\nInput");
                    switch (perinfo) {
                        case "1":
                            Sqlcrudpersonalinfo.insertPerInfo(accid);
                            break;
                        case "2":
                            Sqlcrudpersonalinfo.insertPerInfonull(accid);
                            System.out.println("Leave the Personal info as blank");
                            break;
                        default:
                            System.out.println("Invalid");
                            break;
                    }

                    String asksub = Menu.ask("1. Add Course\n2. Leave\nInput");
                    switch (asksub) {
                        case "1":
                            Sqlcrudsubject.insertCourse(accid);
                            boolean addmore = true;
                            while (addmore) {
                                String add = Menu.ask("1. Add More\n2. Exit\nInput");
                                switch (add) {
                                    case "1":
                                        Sqlcrudsubject.insertCourse(accid);
                                        break;
                                    case "2":
                                        Sqlcrudsubject.insertCoursenull(accid);
                                        addmore = false;
                                        break;
                                    default:
                                        System.out.println("Invalid");
                                        break;
                                }
                            }
                            break;
                        case "2":
                            Sqlcrudsubject.insertCoursenull(accid);
                            addmore = false;
                            break;
                        default:
                            System.out.println("Invalid");
                            break;
                    }

                    break;

                case "2":
                    boolean unget = true;
                    while (unget) {
                        String get = Menu.ask("1. Retrieve all\n2. Retrieve by id\nInput");
                        switch (get) {
                            case "1":
                                String alltype = Menu.ask("1. Accounts\n2. Personal Info\n3. Course\nInput");
                                switch (alltype) {
                                    case "1":
                                        Sqlcrudaccount.getAccountAll();
                                        unget = false;
                                        break;
                                    case "2":
                                        Sqlcrudpersonalinfo.getPersonalInfoAll();
                                        unget = false;
                                        break;
                                    case "3":
                                        Sqlcrudsubject.getCourseAll();
                                        unget = false;
                                        break;
                                    default:
                                        System.out.println("Invalid");
                                        unget = false;
                                        break;
                                }
                                break;
                            case "2":
                                String idtype = Menu.ask("1. Accounts\n2. Personal Info\n3. Course\nInput");
                                switch (idtype) {
                                    case "1":
                                        id = Menu.askId("IDAccount");
                                        Sqlcrudaccount.getAccountByID(id);
                                        unget = false;
                                        break;
                                    case "2":
                                        id = Menu.askId("IDPersonalInfo");
                                        Sqlcrudpersonalinfo.getPerInfoByID(id);
                                        unget = false;
                                        break;
                                    case "3":
                                        id = Menu.askId("IDCourse");
                                        Sqlcrudsubject.getCourseByID(id);
                                        unget = false;
                                        break;
                                    default:
                                        System.out.println("Invalid");
                                        break;
                                }

                            default:
                                System.out.println("Invalid");
                                break;
                        }
                    }
                    break;

                case "3":
                    String deletetype = Menu.ask("1. Personal Info\n2. Course\nInput");
                    switch (deletetype) {
                        case "1":
                            id = Menu.askId("IDPersonalInfo");
                            Sqlcrudpersonalinfo.deletePersonalInfoByID(id);
                            break;
                        case "2":
                            id = Menu.askId("IDCourse");
                            Sqlcrudsubject.deleteCourseByID(id);
                            break;
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                case "4":
                    String updatetype = Menu.ask("1. Personal Info\n2. Course\nInput");
                    switch (updatetype) {
                        case "1":
                            id = Menu.askId("IDPersonalinfo");
                            Sqlcrudpersonalinfo.getPerInfoByID(id);
                            Sqlcrudpersonalinfo.updatePersonalInfoByID(id);
                            break;
                        case "2":
                            id = Menu.askId("IDCourse");
                            Sqlcrudsubject.getCourseByID(id);
                            Sqlcrudsubject.updateCoursetByID(id);
                            break;
                    }

                    break;
                case "5":
                    System.out.println("Thank You");
                    on = false;
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

}
