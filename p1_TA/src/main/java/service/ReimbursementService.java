package service;

import model.Reimbursement;

import java.util.List;

public interface ReimbursementService {
    //Financial Manager
    List<Reimbursement> getAllReimbursements();
    List<Reimbursement> viewReimbWithFilter(String reimbStatus);
    void resolveReimbursement(Reimbursement reimbursement);

    //Employee
    List<Reimbursement> getEmployeeReimbursement(Integer usersId);
    void submitNewEmployeeReimbursement(Reimbursement reimbursement);
}
