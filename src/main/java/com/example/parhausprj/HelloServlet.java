import com.example.parhausprj.Ticket;
import com.example.parhausprj.TicketResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message = "Pay your ticket";
    private double price = 10.0;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<form action=\"hello-servlet\" method=\"post\">");
        out.println("<label for=\"autonummer\">Autonummer:</label>");
        out.println("<input type=\"text\" id=\"autonummer\" name=\"autonummer\" required>");
        out.println("<br><br>");
        out.println("<label for=\"ticketNumber\">Ticket Number:</label>");
        out.println("<input type=\"text\" id=\"ticketNumber\" name=\"ticketNumber\"required>");
        out.println("<br><br>");
        out.println("<label for=\"creditCardNumber\">Credit Card Number:</label>");
        out.println("<input type=\"text\" id=\"creditCardNumber\" name=\"creditCardNumber\">");
        out.println("<br><br>");
        out.println("<input type=\"submit\" value=\"Pay My Ticket\">");
        out.println("</form>");
        out.println("</body></html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");

        String ticketNumber = request.getParameter("ticketNumber");
        String creditCardNumber = request.getParameter("creditCardNumber");

        Ticket ticket = null;
        if (TicketResponse.tickets.size() >= Integer.parseInt(ticketNumber)) {
            ticket = TicketResponse.tickets.get(Integer.parseInt(ticketNumber) - 1);
        }

        if (ticket == null) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Error</h1>");
            out.println("<p>There is no ticket with number " + ticketNumber + "</p>");
            out.println("<button onclick=\"window.location.href='http://localhost:8080/Parhausprj_war_exploded/'\">Back to Home</button>");
            out.println("</body></html>");
            return;
        }

        double price = ticket.bezahlen();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Payment Successful</h1>");
        out.println("<p>Ticket Number: " + ticketNumber + "</p>");
        out.println("<p>Eintrittzeit: " + ticket.eintrittszeit + "</p>");
        out.println("<p>Austrittzeit: " + ticket.austrittszeit + "</p>");
        out.println("<p>Amount Charged: $" + price + "</p>");
        out.println("<button onclick=\"window.location.href='http://localhost:8080/Parhausprj_war_exploded/'\">Back to Home</button>");
        out.println("</body></html>");
    }


    public void destroy() {
        }
    }


