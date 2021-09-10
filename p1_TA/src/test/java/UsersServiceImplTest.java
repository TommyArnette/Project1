import dao.UsersDao;
import dao.UsersDaoImpl;
import model.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.UsersService;
import service.UsersServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class UsersServiceImplTest {

    UsersServiceImpl usersServiceImpl;

    //Mock object
    UsersDao usersDao = Mockito.mock(UsersDaoImpl.class);

    @BeforeEach
    void setUp(){ usersServiceImpl = new UsersServiceImpl(usersDao); }

    @Test
    void checkLoginCredentialsCorrect(){
        //Assign
        Users users = new Users();

        users.setUserName("employee1");
        users.setUserPassword("password");

        Users currentUser = new Users(1, "employee1", "password", "Bobby", "Smiggins", "bobbysmiggins@fake.com", 1);

        Users expectedResult = currentUser;

        Mockito.when(usersDao.getUser(users)).thenReturn(currentUser);

        //Actual
        Users actualResult = usersServiceImpl.login(users);

        //Assert
        assertEquals(expectedResult, actualResult);

        Mockito.verify(usersDao, Mockito.times(1)).getUser(users);
    }
}
