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
import static javadb.Sqlcrud.*;

/**
 *
 * @author 2ndyrGroupC
 */
public class Sqlcrudsubject {
    public static void insertCourse(int accid) {
        Connection conn = null;
        Statement stmt = null;
        String title, unit, sched;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Add Course ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            title = Menu.ask("Title");
            unit = Menu.ask("Unit");
            sched = Menu.ask("Schedule");
            String accountUpdate = "INSERT INTO `tblcourse`(`IDAccount`, `Title`, `Unit`, `Schedule`) VALUES ('"+accid+"','"+title+"','"+unit+"','"+sched+"')";
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
    
    public static void insertCoursenull(int accid) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountUpdate = "INSERT INTO `tblcourse`(`IDAccount`, `Title`, `Unit`, `Schedule`) VALUES ('"+accid+"','null','null','null')";
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
        
    }

    public static void getCourseByID(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Retrive Course ByID ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountQuery = "SELECT `IDCourse`, `IDAccount`, `Title`, `Unit`, `Schedule` FROM `tblcourse` WHERE IDCourse = " + id;

            ResultSet rs = stmt.executeQuery(accountQuery);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Display values
                System.out.println("IDCourse: "+ rs.getInt("IDCourse")+" IDAccount: "+ rs.getInt("IDAccount")+" Title: "+rs.getString("Title")+" Unit: "+rs.getInt("Unit")+" Schedule: "+rs.getString("Schedule") );
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

    public static void updateCoursetByID(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Update Course ByID ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String Title = Menu.ask("New Title");
            String Unit= Menu.ask("New Unit");
            String Schedule = Menu.ask("Schedule");
            String accountUpdate = "UPDATE `tblcourse` SET `Title`='"+Title+"',`Unit`='"+Unit+"',`Schedule`='"+Schedule+"' WHERE IDCourse = " + id;
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
        System.out.println("=================== Course Updated! ===================");
    }

    public static void deleteCourseByID(String id) {
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
            String accountUpdate = "DELETE FROM `tblcourse` WHERE IDCourse = " + id;
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
        System.out.println("=================== Course Deleted! ===================");
    }

    public static void getCourseAll() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Retrive All Courses ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountQuery = "SELECT `IDCourse`, `IDAccount`, `Title`, `Unit`, `Schedule` FROM `tblcourse` WHERE 1";

            ResultSet rs = stmt.executeQuery(accountQuery);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                System.out.println("IDCourse: "+ rs.getInt("IDCourse")+" IDAccount: "+rs.getInt("IDAccount")+" Title: "+ rs.getString("Title")+" Unit: "+rs.getInt("Unit")+" Schedule: "+rs.getString("Schedule"));
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
