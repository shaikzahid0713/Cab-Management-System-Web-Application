package com.cms.Service;

import com.cms.DAO.assignCabDao;
import com.cms.DAO.assignCabDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class assign extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession s = request.getSession(false);
        String email = (String) s.getAttribute("email");
        String pass = (String) s.getAttribute("pass");
        List requestId = (ArrayList) s.getAttribute("requestId");
        List<Integer> abc = new ArrayList<Integer>();
        for (Iterator iterator = requestId.iterator(); iterator.hasNext(); ) {
            abc.add((Integer) iterator.next());
        }
        int val = Integer.parseInt(request.getParameter("acceptBtn"));


        assignCabDao ac = new assignCabDaoImpl();
        ac.assign(abc.get(val));

        RequestDispatcher rd = request.getRequestDispatcher("AssignCab");
        rd.include(request, response);
    }
}
