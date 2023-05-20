package com.example.parhausprj;
import com.example.parhausprj.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
        PrintWriter out = response.getWriter();

        tickets.add(new Ticket(++ticketNumber,request.getParameter("matrikulNummer"),PriceServlet.ticketPrice));
        Date date = tickets.get(ticketNumber-1).ticketZiehen();
        int place = chooseLot();
        Parkhauss.lots[place] = tickets.get(ticketNumber - 1).getAutoNummer();
        tickets.get(ticketNumber-1).setPlace(place);

        out.println("<html><body>");
        out.println("<h1>" + "Thank you!" + "</h1>");
        out.println("<p> Ticket with Number " + tickets.get(ticketNumber - 1).getTicketNummer() +
                " has beem succesfully submitted at "+ date+ " with Registration number "+ tickets.get(ticketNumber-1).getAutoNummer()+
                "lot number : "+ place +"</p>");
        out.println("</body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException , IOException {
        PrintWriter out = response.getWriter();
        try {
            doGet(request, response);

            out.println("<button onclick=\"window.location.href='index.jsp'\">Back to Home</button>");
        } catch (IllegalStateException e ) {
            out.println("<p> The Parking House is Full come back soon! </p>");
        }
    }

    public void destroy() {
    }
    public static int chooseLot() {
        boolean done = false ;
        Random rand = new Random();
        int lot =0;
        while (done == false) {
            lot = rand.nextInt(200);
            if (Parkhauss.lots[lot] != null) {
                continue;
            }
            done = true;
        }
        return lot ;
    }
}