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
public class Sqlcrudpersonalinfo {
    public static void insertPerInfo(int accid) {
        Connection conn = null;
        Statement stmt = null;
        String firstname, lastname, age;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Register Personal Info ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            firstname = Menu.ask("Firstname");
            lastname = Menu.ask("Lastname");
            age = Menu.ask("Age");
            String accountUpdate = "INSERT INTO `tblpersonalinfo`(`IDAccount`, `Firstname`, `Lastname`, `Age`) VALUES ('"+accid+"','"+firstname+"','"+lastname+"','"+Integer.valueOf(age)+"')";
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
    }
    
    public static void insertPerInfonull(int accid) {
        Connection conn = null;
        Statement stmt = null;
        String firstname, lastname, age;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Register Personal Info ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            firstname = Menu.ask("Firstname");
            lastname = Menu.ask("Lastname");
            age = Menu.ask("Age");
            String accountUpdate = "INSERT INTO `tblpersonalinfo`(`IDAccount`, `Firstname`, `Lastname`, `Age`) VALUES ('"+Integer.valueOf(accid)+"','null','null','null')";
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
    }

    public static void getPerInfoByID(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Retrive Personal info ByID ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountQuery = "SELECT `IDPersonalInfo`, `IDAccount`, `Firstname`, `Lastname`, `Age` FROM `tblpersonalinfo` WHERE IDPersonalInfo = " + id;

            ResultSet rs = stmt.executeQuery(accountQuery);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                //Display values
                System.out.print("IDPersonalInfo: " + rs.getInt("IDPersonalInfo"));
                System.out.print("IDAccount: " + rs.getInt("IDAccount"));
                System.out.print("Firstname: " + rs.getInt("Firstname"));
                System.out.print("Lastname: " + rs.getInt("Lastname"));
                System.out.print("Age: " + rs.getInt("Age"));
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

    public static void updatePersonalInfoByID(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Update Personal info ByID ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String nfname = Menu.ask("New Firstname");
            String nlname= Menu.ask("New Lastname");
            String age = Menu.ask("Age");
            String accountUpdate = "UPDATE `tblpersonalinfo` SET `Firstname`=[value-3],`Lastname`=[value-4],`Age`=[value-5] WHERE `IDPersonalInfo`= " + id;
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

    public static void deletePersonalInfoByID(String id) {
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

    public static void getPersonalInfoAll() {
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
}
