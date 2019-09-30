/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import static enrollment.Enrollment.course;
import static enrollment.CRUD.generateCourseId;
import static enrollment.InfoNotValidException.*;
import static enrollment.CRUD.updateCourseFile;


/**
 *
 * @author 2ndyrGroupC
 */
public class AskforInfos {

    private String firstname, lastname, age, username, password, title, unit, timein, timeout,time, sched;

    public String personalinfo() {
        while (true) {
            try {
                firstname = Ask.require("firstname");
                isWithNoNumber(firstname);
                break;
            } catch (InfoNotValidException e) {
                System.out.println(e);
            }
        }

        while (true) {
            try {
                lastname = Ask.require("lastname");
                isWithNoNumber(lastname);
                break;
            } catch (InfoNotValidException e) {
                System.out.println(e);
            }
        }

        while (true) {
            try {
                age = Ask.require("age");
                isNumber(age);
                if (Integer.parseInt(age) <= 0) {
                    throw new InfoNotValidException("Invalid!!!");
                }
                break;
            } catch (InfoNotValidException e) {
                System.out.println(e);
            }
        }
        return firstname + " " + lastname + " " + age;
    }

    public String accountInfo() {
        while (true) {
            try {
                username = Ask.require("username");
                isWithNoNumber(username);
                break;

            } catch (InfoNotValidException e) {
                System.out.println(e);
            }
        }
        while (true) {
            try {
                password = Ask.require("password");
                validatePassword(password);
                break;
            } catch (InfoNotValidException e) {
                System.out.println(e);
            }
        }
        return username + " " + password;
    }

    public String courseinfo() {
        while (true) {
            title = Ask.require("title");
            while (true) {
                try {
                    //unit
                    unit = Ask.require("unit");
                    isNumber(unit);
                    break;

                } catch (InfoNotValidException e) {
                    System.out.println(e);
                }
            }
            //time in
            timein = Ask.require("timeIn");
            //time out
            timeout = Ask.require("timeOut");
            time = Ask.isPM();
            sched = timein + "-" + timeout + "--" + time;
            break;
        }
        return title + " " + unit + " " + sched;
    }
}
