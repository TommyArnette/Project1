package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Reimbursement;
import model.Response;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;
import service.UsersServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class ReimbursementController {
    private static ReimbursementController reimbursementController;
    ReimbursementService reimbursementService;

    private ReimbursementController(){
        reimbursementService = new ReimbursementServiceImpl();
    }

    public static ReimbursementController getInstance(){
        if(reimbursementController == null)
            reimbursementController = new ReimbursementController();

        return reimbursementController;
    }

    //Financial Manager
    public void getReimbBasedOnFilter(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String reimbStatus = req.getParameter("status");
        List<Reimbursement> reimbursementList;

        if(reimbStatus.equals("Pending")){
            reimbursementList = reimbursementService.viewReimbWithFilter(reimbStatus);
            out.println(new ObjectMapper().writeValueAsString(new Response("Pending reimbursements retrieved", true, reimbursementList)));
        }
        else if(reimbStatus.equals("Approved")){
            reimbursementList = reimbursementService.viewReimbWithFilter(reimbStatus);
            out.println(new ObjectMapper().writeValueAsString(new Response("Approved reimbursements retrieved", true, reimbursementList)));
        }
        else if(reimbStatus.equals("Denied")){
            reimbursementList = reimbursementService.viewReimbWithFilter(reimbStatus);
            out.println(new ObjectMapper().writeValueAsString(new Response("Denied reimbursements retrieved", true, reimbursementList)));
        }
        else{
            reimbursementList = reimbursementService.getAllReimbursements();
            out.println(new ObjectMapper().writeValueAsString(new Response("All reimbursements retrieved", true, reimbursementList)));
        }

        for(Reimbursement reimbursement: reimbursementList){
            System.out.println(reimbursement);
        }
    }

    //Financial Manager
    public void resolveReimbursement(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Reimbursement reimbursement = new ObjectMapper().readValue(requestBody, Reimbursement.class);

        reimbursementService.resolveReimbursement(reimbursement);

        out.println(new ObjectMapper().writeValueAsString(new Response("Reimbursements status updated", true, null)));
    }

    //Employee
    public void getEmployeeReimb(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Integer usersId = Integer.parseInt(req.getParameter("usersId"));

        out.println(new ObjectMapper().writeValueAsString(new Response("Reimbursements retrieved", true, reimbursementService.getEmployeeReimbursement(usersId))));

        for (Reimbursement reimbursement: reimbursementService.getEmployeeReimbursement(usersId)){
            System.out.println(reimbursement);
        }
    }

    public void createReimbursement(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Reimbursement reimbursement = new ObjectMapper().readValue(requestBody, Reimbursement.class);

        reimbursementService.submitNewEmployeeReimbursement(reimbursement);
        System.out.println(reimbursement);

        out.println(new ObjectMapper().writeValueAsString(new Response("Reimbursement created",true,null)));
        out.println(reimbursement);
    }
}
