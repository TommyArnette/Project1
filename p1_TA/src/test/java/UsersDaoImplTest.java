import dao.UsersDao;
import dao.UsersDaoImpl;
import model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsersDaoImplTest {

    UsersDao usersDao;

    @BeforeEach
    void setUp(){
        //usersDao = new UsersDaoImpl();
    }

    @Test
    void getUser(){
        //Assign
        Users users = new Users();

        users.setUserName("finance1");
        users.setUserPassword("password");

        Users expectedResult = users;

        //Act
        Users actualResult = usersDao.getUser(users);

        //Assert
        assertEquals(expectedResult.getUserName(), actualResult.getUserName());
        System.out.println(actualResult);
    }
}
