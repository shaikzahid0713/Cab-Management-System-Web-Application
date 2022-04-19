package com.cms.Service;

import com.cms.DAO.rejectRequestDao;
import com.cms.DAO.rejectRequestDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class reject extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession s=request.getSession(false);
        String email = (String) s.getAttribute("email");
        String pass = (String) s.getAttribute("pass");
        Integer requestId = (Integer) s.getAttribute("requestId");

        rejectRequestDao rq = new rejectRequestDaoImpl();
        boolean confirm = rq.reject(requestId);

        RequestDispatcher rd=request.getRequestDispatcher("PendingRequest");
        rd.include(request, response);
    }
}
