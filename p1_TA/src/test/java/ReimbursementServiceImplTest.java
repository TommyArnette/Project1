import dao.ReimbursementDao;
import model.Reimbursement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReimbursementServiceImplTest {
    ReimbursementServiceImpl reimbursementServiceImpl;

    //Mock object
    ReimbursementDao reimbursementDao = Mockito.mock(ReimbursementDao.class);

    @BeforeEach
    void setUp(){
        reimbursementServiceImpl = new ReimbursementServiceImpl(reimbursementDao);
    }

    @Test
    void viewReimbWithFilter(){
        //Assign
        String reimbStatus = "Pending";
        List<Reimbursement> expectedResults = reimbursementServiceImpl.viewReimbWithFilter(reimbStatus);

        //Actual
        List<Reimbursement> actualResults = expectedResults;

        //Assert
        assertEquals(expectedResults, actualResults);

        Mockito.verify(reimbursementDao, Mockito.times(1)).viewReimbWithFilter(reimbStatus);

        for(Reimbursement reimbursement: actualResults){
            System.out.println(reimbursement);
        }
    }

    @Test
    void getEmployeeReimbursement(){
        //Assign
        Integer userId = 1;
        List<Reimbursement> expectedResults = reimbursementServiceImpl.getEmployeeReimbursement(userId);

        //Actual
        List<Reimbursement> actualResults = expectedResults;

        //Assert
        assertEquals(expectedResults, actualResults);

        Mockito.verify(reimbursementDao, Mockito.times(1)).getEmployeeReimbursement(userId);

        for(Reimbursement reimbursement: actualResults){
            System.out.println(reimbursement);
        }
    }
}
