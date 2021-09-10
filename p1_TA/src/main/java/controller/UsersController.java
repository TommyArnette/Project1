package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import model.Users;
import service.UsersService;
import service.UsersServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class UsersController {
    private static UsersController usersController;
    UsersService usersService;

    private UsersController(){
        usersService = new UsersServiceImpl();
    }

    public static UsersController getInstance(){
        if(usersController == null)
            usersController = new UsersController();

        return usersController;
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Users users = new ObjectMapper().readValue(requestBody, Users.class);

        Users tempUser = usersService.login(users);
        //out.println(currentUser);

        if(tempUser != null){
            //create session if successful
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("active", tempUser);

            out.println(new ObjectMapper().writeValueAsString(new Response("Login successful", true, tempUser)));
        }
        else{
            out.println(new ObjectMapper().writeValueAsString(new Response("Invalid credentials", false, null)));
        }
    }

    public void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Users currentUser = (Users) req.getSession().getAttribute("active");

        if(currentUser != null){
            out.println(new ObjectMapper().writeValueAsString(new Response("Session found", true, currentUser)));
        }else{
            out.println(new ObjectMapper().writeValueAsString(new Response("No session found", false, null)));
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        HttpSession httpSession = req.getSession();
        req.getSession().setAttribute("active", null);
        httpSession.invalidate();

        out.println(new ObjectMapper().writeValueAsString(new Response("Session terminated",true,null)));
    }
}
