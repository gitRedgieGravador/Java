/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javadb.Sqlcrud.DB_URL;
import static javadb.Sqlcrud.JDBC_DRIVER;
import static javadb.Sqlcrud.PASS;
import static javadb.Sqlcrud.USER;

/**
 *
 * @author gravadorre_sd2023
 */
public class Sqlcrudaccount {
    public static int insertAccount() {
        Connection conn = null;
        Statement stmt = null;
        String username = null, password;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Register Account ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            username = Menu.ask("Username");
            password = Menu.ask("Password");
            String accountUpdate = "INSERT INTO `tblaccounts`(`Usernames`, `Passwords`) VALUES ('" + username + "','" + username + "')";
            stmt.executeUpdate(accountUpdate);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try
        
        System.out.println("=================== done! ===================");
        return getAccId(username);
    }

    public static void getAccountByID(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Retrive AccountByID ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountQuery = "SELECT * FROM `tblaccounts` WHERE idaccount = " + id;

            ResultSet rs = stmt.executeQuery(accountQuery);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int retrieve_id = rs.getInt("IDAccount");
                String retrieve_username = rs.getString("Usernames");
                String retrieve_password = rs.getString("Passwords");

                //Display values
                System.out.print("ID: " + retrieve_id);
                System.out.print(", Username: " + retrieve_username);
                System.out.println(", Password: " + retrieve_password);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try
        System.out.println("=================== done! ===================");
    }

    public static void updateAccountByID(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Update AccountByID ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String nusername = Menu.ask("New Username");
            String npassword = Menu.ask("New Password");
            String accountUpdate = "UPDATE `tblaccounts` SET `Usernames`='" + nusername + "',`Passwords`= '" + npassword + "' WHERE `IDAccount`= " + id;
            stmt.executeUpdate(accountUpdate);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try
        System.out.println("=================== Account Updated! ===================");
    }

    public static void deleteAccountByID(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Delete AccountByID ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountUpdate = "DELETE FROM `tblaccounts` WHERE IDAccount = " + id;
            stmt.executeUpdate(accountUpdate);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try
        System.out.println("=================== Account Deleted! ===================");
    }

    public static void getAccountAll() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Retrive AccountByID ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountQuery = "SELECT * FROM `tblaccounts` WHERE 1";

            ResultSet rs = stmt.executeQuery(accountQuery);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int retrieve_id = rs.getInt("IDAccount");
                String retrieve_username = rs.getString("Usernames");
                String retrieve_password = rs.getString("Passwords");

                //Display values
                System.out.print("IDAccount: " + retrieve_id);
                System.out.print(", Username: " + retrieve_username);
                System.out.println(", Password: " + retrieve_password);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try
        System.out.println("=================== done! ===================");
    }

    public static int getAccId(String username) {
        Connection conn = null;
        Statement stmt = null;
        int retrieve_id = 1;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountQuery = "SELECT idaccount FROM tblaccounts WHERE usernames = '"+ username +"'";

            ResultSet rs = stmt.executeQuery(accountQuery);
            //System.out.println("this" + rs.getInt("IDAccount"));

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                retrieve_id = rs.getInt("IDAccount");
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try
        
        return retrieve_id;
    }
}
