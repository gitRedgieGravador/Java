/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

/**
 *
 * @author gravadorre_sd2023
 */
public class Course {

    private String course_id;
    private String acc_Id;
    private String title;
    private String unit;
    private String sched;

    public Course(String course_id, String acc_id, String title, String unit, String sched) {
        this.course_id = course_id;
        this.acc_Id = acc_id;
        this.title = title;
        this.unit = unit;
        this.sched = sched;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getAccId() {
        return acc_Id;
    }

    public void setAccId(String accId) {
        this.acc_Id = acc_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSched() {
        return sched;
    }

    public void setSched(String sched) {
        this.sched = sched;
    }

    public String toString() {
        return String.format("---------------------\n"
                + "Course Info:\n"
                + "Course_id: %s\n"
                + "Acc_id: %s\n"
                + "Title: %s\n"
                + "Unit: %s\n"
                + "Schedule: %s\n"
                + "---------------------",
                this.course_id,
                this.acc_Id,
                this.title,
                this.unit,
                this.sched);
    }

}
