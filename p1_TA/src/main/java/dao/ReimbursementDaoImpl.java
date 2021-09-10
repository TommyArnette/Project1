package dao;

import model.Reimbursement;
import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ReimbursementDaoImpl implements ReimbursementDao{
    String url = "jdbc:postgresql://revaturedatabase.c6cmee0a2ssz.us-east-2.rds.amazonaws.com/project1_db";

    String username = "postgres";
    String password = "p4ssw0rd";

    private static ReimbursementDao reimbursementDao;
    private ReimbursementDaoImpl(){
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static ReimbursementDao getInstance(){
        if (reimbursementDao == null) {
            reimbursementDao = new ReimbursementDaoImpl();
        }
        return reimbursementDao;
    }

    //Financial Manager
    @Override
    public List<Reimbursement> getAllReimbursements() {
        List<Reimbursement> reimbursementList = new ArrayList<>();

        try {
            //generating our connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql statement that we will be executing
            String sql = "SELECT * FROM reimbTable ORDER BY reimb_id ASC;";
            PreparedStatement ps = conn.prepareStatement(sql);

            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();

            //loop through all records in the result set
            while (rs.next()) {
                reimbursementList.add(
                        new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3),
                                rs.getTimestamp(4), rs.getString(5), rs.getBytes(6), rs.getInt(7),
                                rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12))
                );
            }

            //close the connection
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return reimbursementList;
    }

    //Financial Manager
    @Override
    public Reimbursement resolveReimbursement(Reimbursement reimbursement) {
        try {
            //generating our connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql statement that we will be executing
            String sql = "UPDATE ers_reimbursement SET reimb_resolved = current_timestamp, reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimbursement.getReimbResolver());
            ps.setInt(2, reimbursement.getReimbStatusId());
            ps.setInt(3, reimbursement.getReimbId());

            //execute the sql statement
            ps.executeUpdate(); //should be executeUpdate(), was executeQuery() and throwing an exception;

            //close the connection
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return reimbursement;
    }

    //Financial Manager
    @Override
    public List<Reimbursement> viewReimbWithFilter(String reimbStatus) {
        List<Reimbursement> reimbursementList = new ArrayList<>();

        try {
            //generating our connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql statement that we will be executing
            String sql = "SELECT * FROM reimbTable WHERE reimb_status = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, reimbStatus);

            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();

            //loop through all records in the result set
            while (rs.next()) {
                reimbursementList.add(
                        new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3),
                                rs.getTimestamp(4), rs.getString(5), rs.getBytes(6), rs.getInt(7),
                                rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12))
                );
            }

            //close the connection
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return reimbursementList;
    }

    //Employee
    @Override
    public List<Reimbursement> getEmployeeReimbursement(Integer usersId) {
        List<Reimbursement> employeeReimbList = new ArrayList<>();

        try {
            //generating our connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql statement that we will be executing
            String sql = "SELECT * FROM reimbTable WHERE reimb_author = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, usersId);

            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();

            //loop through all records in the result set
            while (rs.next()) {
                employeeReimbList.add(
                        new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3),
                                rs.getTimestamp(4), rs.getString(5), rs.getBytes(6), rs.getInt(7),
                                rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12)
                ));
            }

            //close the connection
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return employeeReimbList;
    }

    //Employee
    @Override
    public Reimbursement submitNewEmployeeReimbursement(Reimbursement reimbursement) {

        try {
            //generating our connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql statement that we will be executing
            String sql = "INSERT INTO ers_reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt," +
                    "reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)" +
                    " VALUES (DEFAULT, ?, current_timestamp, NULL, ?, NULL, ?, NULL, 1, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimbursement.getReimbAmount());
            ps.setString(2, reimbursement.getReimbDescription());
            ps.setInt(3, reimbursement.getReimbAuthor());
            ps.setInt(4, reimbursement.getReimbTypeId());

            //execute the sql statement
            ps.executeUpdate(); //should be executeUpdate(), was executeQuery() and throwing an exception;

            //close the connection
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return reimbursement;
    }
}
