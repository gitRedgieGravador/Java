/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import static enrollment.Enrollment.account;
import static enrollment.Enrollment.askinfo;
import static enrollment.Enrollment.course;
import static enrollment.Enrollment.folder;
import static enrollment.Enrollment.perInfo;
import static enrollment.Enrollment.user;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 *
 * @author 2ndyrGroupC
 */
public class CRUD {

    public static void getAccount() {
        String inp = Ask.require("Account ID");
        for (int i = 0; i < account.size(); ++i) {
            if (inp.equals(account.get(i).getAccId())) {
                System.out.println(account.get(i));
            }
        }
    }

    public static void getPersonalInfo() {
        String inp = Ask.require("Account ID");
        for (int i = 0; i < perInfo.size(); ++i) {
            if (inp.equals(perInfo.get(i).getAccId())) {
                System.out.println(perInfo.get(i));
            }
        }
    }

    public static void getCourse() {
        String inp = Ask.require("Account ID");
        for (int i = 0; i < course.size(); ++i) {
            if (inp.equals(course.get(i).getAccId())) {
                System.out.println(course.get(i));
            }
        }
    }

    public static void deleteAccount() {
        String id = Ask.require("Account ID");
        for (int i = 0; i < account.size(); ++i) {
            if (id.equals(account.get(i).getAccId())) {
                account.remove(i);
            }
        }
    }

    public static void deletePersonalInfo() {
        String id = Ask.require("Per_info_ID");
        for (int i = 0; i < perInfo.size(); ++i) {
            if (id.equals(perInfo.get(i).getPer_inof_id())) {
                perInfo.remove(i);
            }
        }
    }

    public static void deleteCourse() {
        String id = Ask.require("Course ID");
        for (int i = 0; i < course.size(); ++i) {
            if (id.equals(course.get(i).getCourse_id())) {
                course.remove(i);
            }
        }
    }

    public static void updateAccFile() {
        try {
            Files.write(Paths.get(folder + "Account.txt"), "".getBytes());
        } catch (IOException e) {
        }
        for (int i = 0; i < account.size(); ++i) {
            String text = account.get(i).getAccId() + "\t" + account.get(i).getUsername() + "\t" + account.get(i).getPassword() + "\r\n";
            try {
                Files.write(Paths.get(folder + "Account.txt"), text.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
            }
        }
    }

    public static void updatePerInfoFile() {
        try {
            Files.write(Paths.get(folder + "PersonalInfo.txt"), "".getBytes());
        } catch (IOException e) {
        }
        for (int i = 0; i < perInfo.size(); ++i) {
            String text = perInfo.get(i).getPer_inof_id() + "\t" + perInfo.get(i).getAccId() + "\t" + perInfo.get(i).getFirstname() + "\t" + perInfo.get(i).getLastname() + "\t" + perInfo.get(i).getAge() + "\r\n";
            try {
                Files.write(Paths.get(folder + "PersonalInfo.txt"), text.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
            }
        }
    }

    public static void updateCourseFile() {
        try {
            Files.write(Paths.get(folder + "Course.txt"), "".getBytes());
        } catch (IOException e) {
        }
        for (int i = 0; i < course.size(); ++i) {
            String text = course.get(i).getCourse_id() + "\t" + course.get(i).getAccId() + "\t" + course.get(i).getTitle() + "\t" + course.get(i).getUnit() + "\t" + course.get(i).getSched() + "\r\n";
            try {
                Files.write(Paths.get(folder + "Course.txt"), text.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
            }
        }
    }

    public static void updatePerInfo() {
        String id = Ask.require("Account ID");
        PersonalInfo[] strArr = perInfo.toArray(new PersonalInfo[perInfo.size()]);
        String firstname, lastname, age, remark = "ID not found";
        int idnotfound = perInfo.size();
        for (int j = 0; j < account.size(); ++j) {
            if (id.equals(account.get(j).getAccId())) {
                for (int i = 0; i < perInfo.size(); ++i) {
                    if (id.equals(perInfo.get(i).getAccId())) {
                        remark = "Personal information was updated";
                        String[] personalinfo = askinfo.personalinfo().split(" ");
                        firstname = personalinfo[0];
                        lastname = personalinfo[1];
                        age = personalinfo[2];
                        //PersonalInfo(String per_inof_id, String acc_id, String firstname, String lastname, String age)
                        strArr[i] = new PersonalInfo(perInfo.get(i).getPer_inof_id(), perInfo.get(i).getAccId(), firstname, lastname, age);
                        perInfo = Arrays.asList(strArr);
                        idnotfound = perInfo.size() - 100;
                        break;
                    }
                }
                if (idnotfound == perInfo.size()) {
                    remark = "Personal Information was updated";
                    String[] personalinfo = askinfo.personalinfo().split(" ");
                    firstname = personalinfo[0];
                    lastname = personalinfo[1];
                    age = personalinfo[2];
                    perInfo.add(new PersonalInfo(Integer.toString(generatePerInfoId()), Integer.toString(j), firstname, lastname, age));
                }
            }
        }

        System.out.println(remark);
    }

    public static void updateCourse() {
        String id = Ask.require("Account ID");
        Course[] strArr = course.toArray(new Course[course.size()]);
        String remark = "ID not found";
        String title, unit, sched;
        int idnotfound = course.size();
        for (int j = 0; j < account.size(); ++j) {
            if (id.equals(account.get(j).getAccId())) {
                for (int i = 0; i < course.size(); ++i) {
                    if (id.equals(course.get(i).getAccId())) {
                        remark = "Course updated";
                        System.out.print("1. Add Subject\n2. done\ninput: ");
                        String yes = user.next();
                        if (yes.equalsIgnoreCase("1")) {
                            String[] courseinfo = askinfo.courseinfo().split(" ");
                            title = courseinfo[0];
                            unit = courseinfo[1];
                            sched = courseinfo[2];
                            strArr[i] = new Course(course.get(i).getCourse_id(), course.get(i).getAccId(), title, unit, sched);
                            course = Arrays.asList(strArr);
                            idnotfound = course.size() + 100;
                        } else if (yes.equalsIgnoreCase("2")) {
                            System.out.println("Thank you");
                            break;
                        } else {
                            System.out.println("Invalid Key");
                        }
                    }
                }
                if (idnotfound == course.size()) {
                    remark = "Course updated";
                    System.out.print("1. Add Subject\n2. done\ninput: ");
                    String yes = user.next();
                    if (yes.equalsIgnoreCase("1")) {
                        String[] courseinfo = askinfo.courseinfo().split(" ");
                        title = courseinfo[0];
                        unit = courseinfo[1];
                        sched = courseinfo[2];
                        course.add(new Course(Integer.toString(generatePerInfoId()), Integer.toString(j), title, unit, sched));
                    } else if (yes.equalsIgnoreCase("2")) {
                        System.out.println("Thank you");
                        break;
                    } else {
                        System.out.println("Invalid Key");
                    }
                }
            }
        }

        System.out.println(remark);
    }

    public static int generateAccId() {
        if (account.size() != 1) {
            return Integer.parseInt(account.get(account.size() - 1).getAccId()) + 1;
        } else {
            return 1;
        }

    }

    public static int generatePerInfoId() {
        if (perInfo.size() != 1) {
            return Integer.parseInt(perInfo.get(perInfo.size() - 1).getAccId()) + 1;
        } else {
            return 1;
        }

    }

    public static int generateCourseId() {
        if (course.size() != 1) {
            return Integer.parseInt(course.get(course.size() - 1).getAccId()) + 1;
        } else {
            return 1;
        }
    }
}
