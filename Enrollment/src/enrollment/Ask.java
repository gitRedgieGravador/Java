/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import static enrollment.Enrollment.user;

/**
 *
 * @author 2ndyrGroupC
 */
public  class Ask {

    public Ask() {
    }

    public static String require(String label) {
        System.out.print(label + ": ");
        return user.next();
    }

    public static String optional(String label) {
        System.out.print("This field is optional\nType NA for Not available\n" + label + ": ");
        String input = user.next();
        if (input.equalsIgnoreCase("NA")) {
            return "NA";
        } else {
            return user.nextLine();
        }
    }

    public static String isPM() {
        System.out.print("1 >> AM\nany key >> PM\nInput: ");
        if (user.next() == "1") {
            return "AM";
        } else {
            return "PM";
        }

    }
}
