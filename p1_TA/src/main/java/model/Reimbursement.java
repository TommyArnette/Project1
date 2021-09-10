package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.*;

public class Reimbursement {
    private int reimbId;
    private int reimbAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a")
    private Date reimbSubmitted;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a")
    private Date reimbResolved;
    private String reimbDescription;
    private byte[] reimbReceipt;
    private int reimbAuthor;
    private int reimbResolver;
    private int reimbStatusId;
    private int reimbTypeId;
    String reimbStatus;
    String reimbType;

    public Reimbursement() {
    }

    public Reimbursement(int reimbId, int reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescription, byte[] reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatusId, int reimbTypeId) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbReceipt = reimbReceipt;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusId = reimbStatusId;
        this.reimbTypeId = reimbTypeId;
    }

    public Reimbursement(int reimbId, int reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescription, byte[] reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatusId, int reimbTypeId, String reimbStatus, String reimbType) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbReceipt = reimbReceipt;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusId = reimbStatusId;
        this.reimbTypeId = reimbTypeId;
        this.reimbStatus = reimbStatus;
        this.reimbType = reimbType;
    }

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public int getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(int reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public Date getReimbSubmitted() {
        return reimbSubmitted;
    }

    public void setReimbSubmitted(Date reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public Date getReimbResolved() {
        return reimbResolved;
    }

    public void setReimbResolved(Date reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public String getReimbDescription() {
        return reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public byte[] getReimbReceipt() {
        return reimbReceipt;
    }

    public void setReimbReceipt(byte[] reimbReceipt) {
        this.reimbReceipt = reimbReceipt;
    }

    public int getReimbAuthor() {
        return reimbAuthor;
    }

    public void setReimbAuthor(int reimbAuthor) {
        this.reimbAuthor = reimbAuthor;
    }

    public int getReimbResolver() {
        return reimbResolver;
    }

    public void setReimbResolver(int reimbResolver) {
        this.reimbResolver = reimbResolver;
    }

    public int getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(int reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public int getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(int reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }

    public String getReimbStatus() {
        return reimbStatus;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    public String getReimbType() {
        return reimbType;
    }

    public void setReimbType(String reimbType) {
        this.reimbType = reimbType;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "Reimbursement Id = " + reimbId +
                ", Reimbursement Amount = " + reimbAmount +
                ", Reimbursement Submitted = " + reimbSubmitted +
                ", Reimbursement Resolved = " + reimbResolved +
                ", Reimbursement Description = '" + reimbDescription + '\'' +
                ", Reimbursement Receipt = " + Arrays.toString(reimbReceipt) +
                ", Reimbursement Author = " + reimbAuthor +
                ", Reimbursement Resolver = " + reimbResolver +
                ", Reimbursement Status Id = " + reimbStatusId +
                ", Reimbursement Type Id = " + reimbTypeId +
                ", Reimbursement Status = '" + reimbStatus + '\'' +
                ", Reimbursement Type = '" + reimbType + '\'' +
                '}';
    }
}
