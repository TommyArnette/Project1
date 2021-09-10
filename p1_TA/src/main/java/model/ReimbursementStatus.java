package model;

public class ReimbursementStatus {
    private int reimbStatusId;
    private String reimbStatus;

    public ReimbursementStatus() {
    }

    public ReimbursementStatus(int reimbStatusId, String reimbStatus) {
        this.reimbStatusId = reimbStatusId;
        this.reimbStatus = reimbStatus;
    }

    public int getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(int reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public String getReimbStatus() {
        return reimbStatus;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "Reimbursement Status Id = " + reimbStatusId +
                ", Reimbursement Status = '" + reimbStatus + '\'' +
                '}';
    }
}
