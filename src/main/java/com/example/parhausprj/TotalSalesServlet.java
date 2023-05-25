package com.example.parhausprj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TotalSalesServlet", value = "/TotalSales-servlet")
public class TotalSalesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double totalSales = Ticket.getTotalSales();;
        response.setContentType("text/html");
        out.println("<html><body>");
        out.println("<style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color:#FFEBB3;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +

                "    </style>");
        out.println("<div style=\"text-align:center;\">");
        response.getWriter().println("<h1> Total Sales: " + totalSales+ "</h1>");
        out.println("</div>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }




}