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
public class Account {

    private String acc_Id;
    private String username;
    private String password;

    public Account(String acc_Id, String username, String password) {
        this.acc_Id = acc_Id;
        this.username = username;
        this.password = password;
    }

    public String getAccId() {
        return acc_Id;
    }

    public void setAccId(String accId) {
        this.acc_Id = acc_Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("---------------------\n"
                + "Account Info:\n"
                + "Acc_id: %s\n"
                + "Username: %s\n"
                + "Password: %s\n"
                + "---------------------",
                 acc_Id, username, password);
    }

}
