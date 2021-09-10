package frontcontroller;

import controller.ReimbursementController;
import controller.UsersController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/api/*")
public class Dispatcher extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI();
        System.out.println(URI);

        switch(URI){
            case "/project1_TA/api/login":
                if(req.getMethod().equals("POST"))
                    UsersController.getInstance().login(req, resp);
                break;
            case "/project1_TA/api/employee-reimbursements":
                switch(req.getMethod()){
                    case "GET":
                        ReimbursementController.getInstance().getEmployeeReimb(req, resp);
                        break;
                    case "POST":
                        ReimbursementController.getInstance().createReimbursement(req, resp);
                        break;
                }
                break;
            case "/project1_TA/api/manager-reimbursements":
                switch(req.getMethod()){
                    case "GET":
                        ReimbursementController.getInstance().getReimbBasedOnFilter(req, resp);
                        break;
                    case "PATCH":
                        ReimbursementController.getInstance().resolveReimbursement(req, resp);
                        break;
                }
                break;
            case "/project1_TA/api/check-session":
                if(req.getMethod().equals("GET"))
                    UsersController.getInstance().checkSession(req, resp);
                break;
            case "/project1_TA/api/logout":
                if(req.getMethod().equals("GET"))
                    UsersController.getInstance().logout(req, resp);
                break;
        }
    }
}
