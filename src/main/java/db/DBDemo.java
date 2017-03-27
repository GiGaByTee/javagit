package db;

import java.sql.*;

/**
 * Created by GiGaByTe on 28.03.2017.
 */
public class DBDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/user";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "nazarko";

    public static void main(String[] args) {
        //testDBStatementExample();
        //testDBCallableStatementExample();
        testDBPreparedStatementExample();
    }

    public static void testDBStatementExample() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.println(", Email: " + email);
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void testDBCallableStatementExample() {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            String sql = "{call getUserName (?, ?)}";
            stmt = conn.prepareCall(sql);

            //Bind IN parameter first, then bind OUT parameter
            int userID = 1;
            stmt.setInt(1, userID); // This would set ID as 1
            // Because second parameter is OUT so register it
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

            //Use execute method to run stored procedure.
            System.out.println("Executing stored procedure...");
            stmt.execute();

            //Retrieve employee name with getXXX method
            String userName = stmt.getString(2);
            System.out.println("User Name with ID:" +
                    userID + " is " + userName);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void testDBPreparedStatementExample() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            String sql = "Insert into user values (?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "lalal");
            preparedStatement.setString(3, "neww");
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
