package org.example;

import org.example.EmployeeDTO.EmployeeDTO;
import org.example.dao.StockFundamentalsDao;
import org.example.dao.StocksPriceHistoryDao;
import org.example.model.Employee;
import org.example.model.StockPriceHistory;
import org.example.services.ServiceAnlysis;
import org.example.services.StockDetailsService;
import org.example.vo.StocksFundamentals;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import the packages



public class Main {

    static final String DB_URL = "jdbc:postgresql://endeavourtech.ddns.net:50271/CrudDB";
    static final String USER = "evr_sql_app";
    static final String PASS = "5LViU5pLkSjRHECec9NF4wRxxV";
    static final String QUERY = "select employeeId, firstname, lastname, gender, departmentid,department_name   FROM endeavour_test_area.employees_pra\n" +
            "join endeavour_test_area.department_pra on departmentid = department_id";

    public static void main(String[] args) {
//1.
//        StockFundamentalsDao dao = new StockFundamentalsDao();
//        List<StocksFundamentals> list = dao.getAllStockFundamentals();
//
//        list.forEach(System.out::println);
//4.
//        StocksPriceHistoryDao dao = new StocksPriceHistoryDao();
//        List<StockPriceHistory> stocks = dao.getAllStocks();
//
//
//        stocks.sort((s1, s2) -> Double.compare(s1.getClosePrice(), s2.getClosePrice()));
//        System.out.println("Sorted by Close Price:");
//        stocks.forEach(System.out::println);
//
//        stocks.sort((s1, s2) -> Long.compare(s2.getVolume(), s1.getVolume()));
//        System.out.println("\nSorted by Volume (Descending):");
//        stocks.forEach(System.out::println);

        //6th Answer

//        ServiceAnlysis serviceAnlysis = new ServiceAnlysis();
//        serviceAnlysis.displaySectorWiseStockCount();

        //7th Answer
//        StockDetailsService detailsService = new StockDetailsService();
//        detailsService.displayStockDetails("AAPL");
        ; // you can replace with any ticker symbol
//        List<EmployeeDTO> employees = new ArrayList<>();
//        try(Connection connect = DriverManager.getConnection(DB_URL,USER,PASS);
//            Statement smt = connect.createStatement();
//            ResultSet result = smt.executeQuery(QUERY);){
//            while(result.next()){
//                EmployeeDTO emp = new EmployeeDTO();
//                      emp.setEmployeeId(result.getInt("employeeId"));
//                      emp.setFirstName(result.getString("firstname"));
//                      emp.setLastName(result.getString("lastname"));
//                      emp.setGender(result.getString("gender"));
//                      emp.setDepartment(result.getInt("departmentid"));
//                      emp.setDepartment_name(result.getString("department_name"));
//
//                employees.add(emp);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        } finally{
//
//        }
//
//        for (EmployeeDTO emp : employees) {
//            System.out.println(emp);
//        }

//        List<Employee> demon = GetDataSP();
//        for(Employee emp: demon){
//            System.out.println(emp.getId()+" - "+emp.getFullname());
//        }

        List<Employee> demon2 = GetDataSPCallable(6);
        for(Employee emp: demon2){
            System.out.println(emp.getId()+" - "+emp.getFullname()+" "+emp.getDeptid());
        }





//        StockFundamentalsDao dao = new StockFundamentalsDao();
//        List<StocksFundamentals> stocks = dao.getStockFundamentals();

//        for (StocksFundamentals sf : stocks) {
//            System.out.println(sf);
//        }

//        List<EmployeeDTO> employees = new ArrayList<>();
//        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(QUERY);) {
//            // Extract data from result set
//            while (rs.next()) {
                // Retrieve by column name
//                System.out.print("ID: " + rs.getInt("employeeId"));
//                System.out.print(", gender: " + rs.getString("gender"));
//                System.out.print(", First: " + rs.getString("firstname"));
//                System.out.println(", Last: " + rs.getString("lastname"));
//                EmployeeDTO emp = new EmployeeDTO();
//                      emp.setEmployeeId(rs.getInt("employeeId"));
//                      emp.setFirstName(rs.getString("firstname"));
//                      emp.setLastName(rs.getString("lastname"));
//                      emp.setGender(rs.getString("gender"));
//
//                employees.add(emp);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//        for (EmployeeDTO emp : employees) {
//            System.out.println(emp);
//        }
    }

    public static List<Employee> GetDataSPCallable(int deptId){
        List<Employee> listEmployee = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {

//            PreparedStatement preStatement = connection.prepareStatement(selectSql);
            CallableStatement preStatement = connection.prepareCall("{call endeavour_test_area.get_employees_callable(?)}");
            preStatement.setInt(1, deptId);


//            preStatement.setInt(1, employeeId); ==> we're explicitly sending the parameter

            ResultSet resultSet = preStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employeeId"));
                employee.setFullname(resultSet.getString("fullname"));
                employee.setFirstname(resultSet.getString("firstname"));
                employee.setLastname(resultSet.getString("lastname"));
                employee.setDeptid(resultSet.getInt("departmentid"));
                listEmployee.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmployee;
    }

    public static List<Employee> GetDataSP(){
        List<Employee> listEmployee = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {

//            PreparedStatement preStatement = connection.prepareStatement("SELECT * FROM endeavour_test_area.get_employees_callable(?);");
            CallableStatement preStatement = connection.prepareCall("{call endeavour_test_area.get_all_employees()}");

//            preStatement.setInt(1, employeeId); ==> we're explicitly sending the parameter

            ResultSet resultSet = preStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employeeId"));
                employee.setFullname(resultSet.getString("fullname"));
                employee.setFirstname(resultSet.getString("firstname"));
                employee.setLastname(resultSet.getString("lastname"));
                listEmployee.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmployee;
    }

    public static List<Employee> GetData(int employeeId){

        String selectSql = "select employeeId, firstname, lastname, gender FROM endeavour_test_area.employees_pra  where employeeId > ?";
        List<Employee> listEmployee = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {

            PreparedStatement preStatement = connection.prepareStatement(selectSql);

            preStatement.setInt(1, employeeId);//we explicitly sending the parameter

            ResultSet resultSet = preStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employeeId"));
                employee.setFirstname(resultSet.getString("firstname"));
                employee.setLastname(resultSet.getString("lastname"));
                listEmployee.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmployee;
    }

}
