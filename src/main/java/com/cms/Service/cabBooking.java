package com.cms.Service;

import com.cms.DAO.bookingDao;
import com.cms.DAO.bookingDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class cabBooking extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //out.print("<form> </form>");
        HttpSession s=request.getSession(false);
        String id = (String)(s.getAttribute("id"));
        bookingDao b = new bookingDaoImpl();
        boolean confirm = b.requestCab();
        if(confirm) {
            out.println("<!DOCTYPE html>\r\n"
                    + "<html>\r\n"
                    + "\r\n"
                    + "<head>\r\n"
                    + "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
                    + "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
                    + "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
                    + "    <link rel=\"stylesheet\" href=\"logout.css\">\r\n"
                    + "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
                    + "</head>\r\n"
                    + "\r\n"
                    + "<body>\r\n"
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
            out.println("<form method=\"post\" action=\"Employee\" >\r\n"
                    + "<button type=\"submit\" id=\"login-button\" >Return to home</button>\r\n"
                    + "</form>");
            out.println("Welcome to Cab booking <br>");
            out.println("Cab Requested successfully");
            out.println("    </div>\r\n"
                    + "\r\n"
                    + "\r\n"
                    + "    <div class=\"copyright-container\">\r\n"
                    + "        <div class=\" d-flex flex-row justify-content-center\">\r\n"
                    + "            <i class=\"fa fa-copyright icon\" aria-hidden=\"true\"></i>\r\n"
                    + "            <p class=\"content ml-2\">Made with <b style=\"color: red;\">&#x2764;&#xfe0f;</b> by Sagnik.</p>\r\n"
                    + "        </div>\r\n"
                    + "    </div>\r\n"
                    + "\r\n"
                    + "</body>\r\n"
                    + "\r\n"
                    + "</html>\r\n"
                    + "");

        }
        else {
            out.println("<!DOCTYPE html>\r\n"
                    + "<html>\r\n"
                    + "\r\n"
                    + "<head>\r\n"
                    + "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
                    + "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
                    + "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
                    + "    <link rel=\"stylesheet\" href=\"logout.css\">\r\n"
                    + "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
                    + "</head>\r\n"
                    + "\r\n"
                    + "<body>\r\n"
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
            out.println("<form method=\"post\" action=\"Employee\" >\r\n"
                    + "<button type=\"submit\" id=\"login-button\" >Return to home</button>\r\n"
                    + "</form>");
            out.println("Welcome to Cab booking <br>");
            out.println("Couldn't Request your Cab</br>Your previous request is still pending. <br>Contact your Manager");
            out.println("    </div>\r\n"
                    + "\r\n"
                    + "\r\n"
                    + "    <div class=\"copyright-container\">\r\n"
                    + "        <div class=\" d-flex flex-row justify-content-center\">\r\n"
                    + "            <i class=\"fa fa-copyright icon\" aria-hidden=\"true\"></i>\r\n"
                    + "            <p class=\"content ml-2\">Made with <b style=\"color: red;\">&#x2764;&#xfe0f;</b> by Sagnik.</p>\r\n"
                    + "        </div>\r\n"
                    + "    </div>\r\n"
                    + "\r\n"
                    + "</body>\r\n"
                    + "\r\n"
                    + "</html>\r\n"
                    + "");
        }
    }
}
