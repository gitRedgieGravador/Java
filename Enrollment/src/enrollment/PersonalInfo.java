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
public class PersonalInfo {
    private String per_inof_id;
    private String acc_Id;
    private String firstname;
    private String lastname;
    private String age;

    public PersonalInfo(String per_inof_id, String acc_id, String firstname, String lastname, String age) {
        this.per_inof_id = per_inof_id;
        this.acc_Id = acc_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getPer_inof_id() {
        return per_inof_id;
    }

    public void setPer_inof_id(String per_inof_id) {
        this.per_inof_id = per_inof_id;
    }

    public String getAccId() {
        return acc_Id;
    }

    public void setAccId(String accId) {
        this.acc_Id = acc_Id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    public String toString() {
        return String.format("---------------------\n"
                + "Personal Info:\n"
                + "Per_inof_id: %s\n"
                + "Acc_id: %s\n"
                + "Firstname: %s\n"
                + "Lastname: %s\n"
                + "Age: %s\n"
                + "---------------------",
                per_inof_id,
                acc_Id,
                firstname,
                lastname,
                age);
    }
    
    
}
