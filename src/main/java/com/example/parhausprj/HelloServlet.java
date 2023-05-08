package com.example.parhausprj;
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
        out.println("<style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color:#FFEBB3;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        form {\n" +
                "            margin-bottom: 40px;\n" +
                "        }\n" +
                "        label {\n" +
                "            display: block;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "        input[type=\"text\"] {\n" +
                "            padding: 5px;\n" +
                "            font-size: 16px;\n" +
                "            border: 1px solid #ccc;\n" +
                "            border-radius: 3px;\n" +
                "            width: 100%;\n" +
                "            max-width: 300px;\n" +
                "            box-sizing: border-box;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "        input[type=\"submit\"] {\n" +
                "            background-color: #333;\n" +
                "            color: #fff;\n" +
                "            padding: 5px;\n" +
                "            border: none;\n" +
                "            border-radius: 3px;\n" +
                "            cursor: pointer;\n" +
                "        }\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "\n" +
                "        .row {\n" +
                "            display: flex;\n" +
                "        }\n" +
                "\n" +
                "        .column {\n" +
                "            flex: 50%;\n" +
                "            padding: 10px;\n" +
                "            height: 740px;\n" +
                "\n" +
                "        }\n" + "div {\n" +
                "  position: absolute;\n" +
                "  top: 50%;\n" +
                "  left: 50%;\n" +
                "  transform: translate(-50%, -50%);\n" +
                "}\n"+
                "\n" +
                "\n" +
                "    </style>");
        out.println("<div style=\"text-align:center;\">");
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
        out.println("</div>");
        out.println("</body></html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String ticketNumber = request.getParameter("ticketNumber");
        String creditCardNumber = request.getParameter("creditCardNumber");

        Ticket ticket = TicketResponse.tickets.get(Integer.parseInt(ticketNumber) - 1);



        if (ticket == null) {
            out.println("<html><body>");
            out.println("<h1>Error</h1>");
            out.println("<p>There is no ticket with number " + ticketNumber + "</p>");
            out.println("<button onclick=\"window.location.href='index.jsp'\">Back to Home</button>");
            out.println("</body></html>");
            return;
        }
        try {
            if (request.getParameter("autonummer").equals(ticket.getAutoNummer())) {
                double price = ticket.bezahlen();


                out.println("<html><body>");
                out.println("<h1>Payment Successful</h1>");
                out.println("<p>Ticket Number: " + ticketNumber + "</p>");
                out.println("<p>Eintrittzeit: " + ticket.eintrittszeit + "</p>");
                out.println("<p>Austrittzeit: " + ticket.austrittszeit + "</p>");
                out.println("<button onclick=\"printReceipt()\">Print Receipt</button>");
                out.println("<p>Amount Charged: " + price + "<span>&#8364;</span> </p>");
                out.println("<button onclick=\"window.location.href='index.jsp'\">Back to Home</button>");
                out.println("</body></html>");
                out.println("<script>");
                out.println("function printReceipt() {");
                out.println("  window.print();");
                out.println("}");
                out.println("</script>");
            } else {


                out.println("Registration number is incorrect!");
            }
        }
        catch (IllegalStateException e) {
            out.println("<p> You already paid your Ticket</p>");
        }

    }


    public void destroy() {
        }
    }


