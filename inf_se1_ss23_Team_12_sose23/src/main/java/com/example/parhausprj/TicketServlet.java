package com.example.parhausprj;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TicketServlet", value = "/ticket-servlet")
public class TicketServlet extends HttpServlet {
    private String message = "Get a Ticket";
    public double price = 10.0;


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<form action=\"ticket-response \"method=\"post\">" +
                "<label for=\"matrikulNummer\">Car registration number:</label>" +
                "<input type=\"text\" id=\"matrikulNummer\" name=\"matrikulNummer\"\" required><br><br>"+
                "<input type=\"submit\"value=\"Submit\"> " +
                "</form>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
