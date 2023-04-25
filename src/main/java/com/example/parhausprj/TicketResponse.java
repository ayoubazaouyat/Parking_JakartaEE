package com.example.parhausprj;

import com.example.parhausprj.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TicketResponse", value = "/ticket-response")
public class TicketResponse extends HttpServlet{
    public int ticketNumber = 0;
    public static List<Ticket> tickets = new ArrayList<>();
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        tickets.add(new Ticket(++ticketNumber,request.getParameter("matrikulNummer"),PriceServlet.ticketPrice));
        //tickets.add(new Ticket(++ticketNumber,request.getParameter("matrikulNummer"),2.5));
        Date date = tickets.get(ticketNumber-1).ticketZiehen();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Thank you!" + "</h1>");
        out.println("<p> Ticket with Number " + tickets.get(ticketNumber - 1).getTicketNummer() + "has beem succesfully submitted at "+ date+ "with Registration number "+ tickets.get(ticketNumber-1).getAutoNummer()+ "</p>");
        out.println("</body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException , IOException {

        doGet(request, response);
        PrintWriter out = response.getWriter();
        out.println("<button onclick=\"window.location.href='http://localhost:8080/Parhausprj_war_exploded/'\">Back to Home</button>");
    }

    public void destroy() {
    }
}