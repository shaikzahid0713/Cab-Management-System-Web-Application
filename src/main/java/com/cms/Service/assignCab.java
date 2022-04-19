package com.cms.Service;


import com.cms.Model.Request;
import com.cms.DAO.requestPendingDao;
import com.cms.DAO.requestPendingDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class assignCab extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession s = request.getSession(false);

        requestPendingDao pr = new requestPendingDaoImpl();
        List lst = pr.pendingRequest();

        List gd = new ArrayList();

        out.println("<!DOCTYPE html>\r\n"
                + "<html lang=\"en\">\r\n"
                + "<head>\r\n"
                + "    <meta charset=\"UTF-8\">\r\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + "    <title>Pending Request</title>\r\n"
                + "<script>"
                + " var i=0;"
                + "document.addEventListener('DOMContentLoaded', function() {\r\n"
                + "    var button = document.createElement('button');\r\n"
                + "    button.type = 'submit';\r\n"
                + "    button.innerHTML = 'Assign';\r\n"
                + "    button.className = 'button button1';\r\n"
                + "    button.value = i++;\r\n"
                + "    button.name = \"acceptBtn\";"
                + "    var container = document.getElementById('frm');\r\n"
                + "    container.appendChild(button);\r\n"
                + "}, false);"
                + "</script>"
                + "    <style>\r\n"
                + "        table {\r\n"
                + "          border-collapse: collapse;\r\n"
                + "        }\r\n"
                + "        \r\n"
                + "        th, td {\r\n"
                + "          padding: 8px;\r\n"
                + "          text-align: left;\r\n"
                + "          border-bottom: 1px solid #DDD;\r\n"
                + "        }\r\n"
                + "        tr:nth-child(even) {\r\n"
                + "          background-color: rgba(157, 229, 173, 0.651);\r\n"
                + "        }\r\n"
                + "\r\n"
                + "        th:nth-child(even),td:nth-child(even) {\r\n"
                + "          background-color: rgba(150, 212, 212, 0.4);\r\n"
                + "        }\r\n"
                + "        \r\n"
                + "        tr:hover {background-color: #D6EEEE;}\r\n"
                + ".button {\r\n"
                + "  background-color: #4CAF50; /* Green */\r\n"
                + "  border: none;\r\n"
                + "  font-size: 16px;\r\n"
                + "  margin: 4px 2px;"
                + "  color: white;\r\n"
                + "  text-align: center;\r\n"
                + "  text-decoration: none;\r\n"
                + "  display: inline-block;\r\n"
                + "  transition-duration: 0.4s;\r\n"
                + "  cursor: pointer;\r\n"
                + "}"
                + ".button1 {\r\n"
                + "  background-color: white; \r\n"
                + "  color: black; \r\n"
                + "  border: 2px solid #4CAF50;\r\n"
                + "}\r\n"
                + "\r\n"
                + ".button1:hover {\r\n"
                + "  background-color: #4CAF50;\r\n"
                + "  color: white;\r\n"
                + "}"
                + ".button3 {\r\n"
                + "  background-color: white; \r\n"
                + "  color: black; \r\n"
                + "  border: 2px solid #f44336;\r\n"
                + "}\r\n"
                + "\r\n"
                + ".button3:hover {\r\n"
                + "  background-color: #f44336;\r\n"
                + "  color: white;\r\n"
                + "}"
                + "        </style>\r\n"
                + "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
                + "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
                + "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
                + "    <link rel=\"stylesheet\" href=\"logout.css\">\r\n"
                + "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
                + "</head>\r\n"
                + "<body>"
                + "    <div class=\" d-flex justify-content-between nav-color\">\r\n"
                + "        <h1 class=\"nav-logo \">\r\n"
                + "            S.\r\n"
                + "        </h1>\r\n"
                + "        <form action = \"logout\" method=\"post\">\r\n"
                + "            <button class=\"btns\" type=\"submit\">Logout</button>\r\n"
                + "        </form>\r\n"
                + "\r\n"
                + "    </div>\r\n"
                + "\r\n"
                + "\r\n"
                + "    <div class=\"bg-container\">");
        out.println("<form method=\"post\" action=\"Admin\" >\r\n"
                + "<button type=\"submit\" id=\"login-button\" >Return to home</button>\r\n"
                + "</form>");
        out.println("<center>\r\n"
                + "    <table>\r\n"
                + "        <thead>\r\n"
                + "            <tr>\r\n"
                + "                <th>Request Id</th>\r\n"
                + "                <th>Employee Id</th>\r\n"
                + "                <th>Employee Name</th>\r\n"
                + "                <th>Cab</th>\r\n"
                + "            </tr>\r\n"
                + "        </thead>\r\n"
                + "        <tbody>");
        for (Iterator iterator = lst.iterator(); iterator.hasNext(); ) {
            Request b = (Request) iterator.next();
            out.println("            <tr>");
            out.format("<td>" + b.getRequestId() + "</td>");
            out.format("<td>%s</td>", b.getEmp().getId());
            out.format("<td>%s</td>", b.getEmp().getName());
            gd.add(b.getRequestId());
            out.format("<td>"
                    + "<form method=\"post\" action=\"Assign\" id=\"frm\">\r\n"
                    + "</form>"
                    + "</td>");
            out.println("            <tr>");
        }
        s.setAttribute("requestId", gd);
        out.println("        </tbody>\r\n"
                + "    </table>\r\n"
                + "    </center>");
        out.println("</div>\r\n"
                + "\r\n"
                + "\r\n"
                + "    <div class=\"copyright-container\">\r\n"
                + "        <div class=\" d-flex flex-row justify-content-center\">\r\n"
                + "            <i class=\"fa fa-copyright icon\" aria-hidden=\"true\"></i>\r\n"
                + "            <p class=\"content ml-2\">Made with <b style=\"color: red;\">&#x2764;&#xfe0f;</b> by Sagnik.</p>\r\n"
                + "        </div>\r\n"
                + "    </div>"
                + "</body>\r\n"
                + "</html>");
    }
}
