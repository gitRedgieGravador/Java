/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import static enrollment.Enrollment.account;
import static enrollment.Enrollment.course;
import static enrollment.Enrollment.folder;
import static enrollment.Enrollment.perInfo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 2ndyrGroupC
 */
public class Retrieve {

    public static List<String> readFileInList(String fileName) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
        }
        return lines;
    }

    public static void getAccounts() {
        String location = folder + "Account.txt";
        List l = readFileInList(location);
        Iterator<String> itr = l.iterator();
        while (itr.hasNext()) {
            String line = itr.next().toString();
            if (line != null) {
                String[] out = line.split("\t");
                //Account(String acc_Id, String username, String password)
                account.add(new Account(out[0], out[1], out[2]));
            }
        }
    }

    public static void getPersonalInfos() {
        String location = folder + "PersonalInfo.txt";
        List l = readFileInList(location);
        Iterator<String> itr = l.iterator();
        while (itr.hasNext()) {
            String line = itr.next().toString();
            if (line != null) {
                String[] out = line.split("\t");
                //PersonalInfo(String per_inof_id, Account acc_id, String firstname, String lastname, int age)
                perInfo.add(new PersonalInfo(out[0], out[1], out[2], out[3], out[4]));
            }
        }
    }

    public static void getCourses() {
        String location = folder + "Course.txt";
        List l = readFileInList(location);
        Iterator<String> itr = l.iterator();
        while (itr.hasNext()) {
            String line = itr.next().toString();
            if (line != null) {
                String[] out = line.split("\t");
                //Course(String course_id, Account acc_id, String title, String unit, String sched)
                course.add(new Course(out[0], out[1], out[2], out[3], out[4]));
            }
        }
    }
    
    public static void lunch(){
        getAccounts();
        getPersonalInfos();
        getCourses();
    }
}
