import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import model.Reimbursement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ReimbursementServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementDaoImplTest {
    ReimbursementDao reimbursementDao;
    ReimbursementDaoImpl reimbursementDaoImpl;

    @BeforeEach
    void setUp(){
        //reimbursementDaoImpl = new ReimbursementDaoImpl();
    }

    @Test
    void getAllReimbursements(){
        //Assign
        List<Reimbursement> expectedResult = new ArrayList<>();

        //Act
        List<Reimbursement> actualResult = reimbursementDao.getAllReimbursements();

        //Assert
        assertEquals(expectedResult, actualResult);
        for(Reimbursement reimbursement: actualResult){
            System.out.println(reimbursement);
        }
    }

    @Test
    void resolveReimbursement(){
        //Assign
        Integer reimbId = 19;
        Integer reimbResolver = 2;
        String reimbStatus = "Approved";

        Reimbursement reimbursement = new Reimbursement();

        reimbursement.setReimbId(reimbId);
        reimbursement.setReimbResolver(reimbResolver);
        reimbursement.setReimbStatus(reimbStatus);

        Reimbursement expectedResult = reimbursement;

        //Act
        Reimbursement actualResult = reimbursementDao.resolveReimbursement(reimbursement);

        //Assert
        assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }

    @Test
    void getEmployeeReimbursement(){
        //Assign
        Integer usersId = 3;
        List<Reimbursement> expectedResult = new ArrayList<>();

        //Act
        List<Reimbursement> actualResult = reimbursementDao.getEmployeeReimbursement(usersId);

        //Assert
        assertEquals(expectedResult, actualResult);
        for (Reimbursement reimbursement: actualResult){
            System.out.println(reimbursement);
        }
    }

    @Test
    void submitNewEmployeeReimbursement(){
        //Assign

        //Act

        //Assert
    }
}
