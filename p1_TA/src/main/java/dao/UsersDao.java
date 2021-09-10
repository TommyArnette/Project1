package dao;

import model.Users;

import java.util.List;

public interface UsersDao {

    List<Users> getAllUsers();

    Users getUser(Users users);
}
