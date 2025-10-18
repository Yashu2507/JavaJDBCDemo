package org.example;

import java.sql.*;

public class JDBC {

    static final String DB_URL = "jdbc:postgresql://endeavourtech.ddns.net:50271/CrudDB";
    static final String USER = "endeavour_test_area";
    static final String PASS = "Endeavour01";
    public static  void main(String[] args) {

        String query="call endeavour_test_area.yaswanthn_procedure(?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             CallableStatement callStmt = conn.prepareCall(query)) {

            // Set IN parameters
            callStmt.setInt(1, 2);
            callStmt.setString(2, "Maro Manishi");
            callStmt.setInt(3, 852);
            callStmt.setString(4, "O");


            callStmt.registerOutParameter(5,Types.VARCHAR);

            // Execute the procedure
            callStmt.execute();
            String resultMsg = callStmt.getString(5);

            System.out.println(" Procedure executed successfully — record inserted: "+resultMsg);

        } catch (Exception e) {
            System.out.println(" An error occurred during procedure execution.");
            e.printStackTrace();
        }


//
//        String query = "insert into endeavour_test_area.employees_nalamasat (id, name, salary, gender,department)\n" +
//                "  values(?,?,?,?,?);";
//
//
//
//        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//             PreparedStatement ps = conn.prepareStatement(query)) {
//
//            // Set values for placeholders
//            ps.setInt(1, 421);
//            ps.setString(2, "Sana");
//            ps.setInt(3, 10);
//            ps.setString(4, "F");
//            ps.setString(5, "Medico");
//
//
//
//            // Execute insert
//            int rowsInserted = ps.executeUpdate();//How many Records that i have passed or updated to the table
//            System.out.println(rowsInserted);
//
//            if (rowsInserted > 0) {
//                System.out.println("A new employee was inserted successfully!");
//            }
//
//
//
//
//            System.out.println(" Procedure executed successfully — record inserted.");
//
//        } catch (Exception e) {
//            System.out.println(" An error occurred during procedure execution.");
//            e.printStackTrace();
//        }
//        }

        // Set IN parameters
//            callStmt.setInt(1, 2);
//            callStmt.setString(2, "Maro Manishi");
//            callStmt.setInt(3, 852);
//            callStmt.setString(4, "O");
//            callStmt.setString(5, "IT");

        // Execute the procedure
//            callStmt.execute();


    }

}
