package com.cms.Service;

import com.cms.DAO.acceptRequestDao;
import com.cms.DAO.acceptRequestDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class accept extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession s = request.getSession(false);
        String email = (String) s.getAttribute("email");
        String pass = (String) s.getAttribute("pass");
        Integer requestId = (Integer) s.getAttribute("requestId");

        acceptRequestDao ar = new acceptRequestDaoImpl();
        boolean confirm = ar.accept(requestId);

        RequestDispatcher rd = request.getRequestDispatcher("PendingRequest");
        rd.include(request, response);
    }
}
