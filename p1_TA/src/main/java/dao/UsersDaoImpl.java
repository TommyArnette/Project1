package dao;

import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao{
    String url = "jdbc:postgresql://revaturedatabase.c6cmee0a2ssz.us-east-2.rds.amazonaws.com/project1_db";

    String username = "postgres";
    String password = "p4ssw0rd";

    private static UsersDao usersDao;
    private UsersDaoImpl(){
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static UsersDao getInstance(){
        if (usersDao == null) {
            usersDao = new UsersDaoImpl();
        }
        return usersDao;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();

        try {
            //generating our connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql statement that we will be executing
            String sql = "SELECT * FROM usersTable;";
            PreparedStatement ps = conn.prepareStatement(sql);

            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();

            //loop through all records in the result set
            while (rs.next()) {
                usersList.add(
                        new Users(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6),
                                rs.getInt(7))
                );
            }

            //close the connection
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public Users getUser(Users users) {
        Users user = null;

        try {
            //generating our connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql statement that we will be executing
            String sql = "SELECT * FROM usersTable WHERE ers_username = ? AND ers_password = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, users.getUserName());
            ps.setString(2, users.getUserPassword());

            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();

            //loop through all records in the result set
            while (rs.next()) {
                user =
                        new Users(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6),
                                rs.getInt(7), rs.getString(8));
            }

            //close the connection
            //conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
