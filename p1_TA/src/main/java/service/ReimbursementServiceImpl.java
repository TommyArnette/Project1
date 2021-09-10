package service;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import model.Reimbursement;

import java.util.List;

public class ReimbursementServiceImpl implements ReimbursementService{
    ReimbursementDao reimbursementDao;

    public ReimbursementServiceImpl(){
        reimbursementDao = ReimbursementDaoImpl.getInstance();
    }

    public ReimbursementServiceImpl(ReimbursementDao reimbursementDao) {
    }

    @Override
    public List<Reimbursement> getAllReimbursements() {
        return reimbursementDao.getAllReimbursements();
    }

    @Override
    public List<Reimbursement> viewReimbWithFilter(String reimbStatus) {
        return reimbursementDao.viewReimbWithFilter(reimbStatus);
    }

    @Override
    public void resolveReimbursement(Reimbursement reimbursement) {
        reimbursementDao.resolveReimbursement(reimbursement);
    }

    @Override
    public List<Reimbursement> getEmployeeReimbursement(Integer usersId) {
        return reimbursementDao.getEmployeeReimbursement(usersId);
    }

    @Override
    public void submitNewEmployeeReimbursement(Reimbursement reimbursement) {
        reimbursementDao.submitNewEmployeeReimbursement(reimbursement);
    }
}
