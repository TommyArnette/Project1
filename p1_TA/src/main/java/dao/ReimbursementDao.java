package dao;

import model.Reimbursement;
import model.Users;

import java.util.List;

public interface ReimbursementDao {
    //Financial Manager
    List<Reimbursement> getAllReimbursements();
    Reimbursement resolveReimbursement(Reimbursement reimbursement);
    List<Reimbursement> viewReimbWithFilter(String reimbStatus);

    //Employee
    List<Reimbursement> getEmployeeReimbursement(Integer usersId);
    Reimbursement submitNewEmployeeReimbursement(Reimbursement reimbursement);
}
