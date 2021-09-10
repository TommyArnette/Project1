package service;

import dao.ReimbursementDao;
import dao.UsersDao;
import dao.UsersDaoImpl;
import model.Users;

public class UsersServiceImpl implements UsersService{
    UsersDao usersDao;

    public UsersServiceImpl(){
        usersDao = UsersDaoImpl.getInstance();
    }

    public UsersServiceImpl(UsersDao usersDao) {
    }

    @Override
    public Users login(Users users) {
        //Check username exists in system
        Users currentUser = usersDao.getUser(users);

        if(currentUser.getUserName() == null)
            return null;

        //check if password is incorrect
        if(!currentUser.getUserPassword().equals(users.getUserPassword()))
            return null;

        return currentUser;
    }
}
