package com.example.demo.controller;

import com.example.demo.command.Command;
import com.example.demo.command.CommandType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dbServlet", urlPatterns= {"/db-servlet", "*.do"})
public class DBServlet extends HttpServlet {
    public void init() {

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String commandStr = request.getParameter("command");
        Command command   = CommandType.define(commandStr);
        String page  = command.execute(request);
        request.getRequestDispatcher(page).forward(request,response );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
