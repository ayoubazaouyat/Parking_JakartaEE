package com.example.parhausprj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "TotalSalesServlet", value = "/TotalSales-servlet")
public class TotalSalesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ticket Information</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #FFEBB3;");
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("}");

        out.println("h1 {");
        out.println("    text-align: center;");
        out.println("    margin-top: 30px;");
        out.println("}");

        out.println("table {");
        out.println("    width: 80%;");
        out.println("    margin: 30px auto;");
        out.println("    border-collapse: collapse;");
        out.println("    background-color: #fff;");
        out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
        out.println("}");

        out.println("th, td {");
        out.println("    padding: 12px 15px;");
        out.println("    text-align: left;");
        out.println("    border-bottom: 1px solid #ddd;");
        out.println("}");

        out.println("th {");
        out.println("    background-color: #f9f9f9;");
        out.println("}");

        out.println("td:last-child {");
        out.println("    text-align: center;");
        out.println("}");

        out.println(".center {");
        out.println("    text-align: center;");
        out.println("    margin-top: 20px;");
        out.println("}");

        out.println(".button-container {");
        out.println("    text-align: center;");
        out.println("    margin-bottom: 20px;");
        out.println("}");

        out.println(".button-container button {");
        out.println("    margin: 0 5px;");
        out.println("    padding: 10px 15px;");
        out.println("    font-size: 16px;");
        out.println("    background-color: #4CAF50;");
        out.println("    color: #fff;");
        out.println("    border: none;");
        out.println("    border-radius: 4px;");
        out.println("    cursor: pointer;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Ticket Information</h1>");
        out.println("<div class=\"button-container\">");
        out.println("<button onclick=\"window.location.href='?sort=true'\">Sortieren</button>");
        out.println("<button onclick=\"window.location.href='?paid=true'\">Paid Tickets</button>");
        out.println("<button onclick=\"window.location.href='?unpaid=true'\">Unpaid Tickets</button>");
        out.println("<button onclick=\"window.location.href='?showalltickets=true'\">Show all tickets</button>");
        out.println("</div>");

        out.println("<table>");
        out.println("<tr><th>Ticket Number</th><th>Entry time</th><th>Exit time</th><th>Amount Charged</th><th>Leaved</th><th>Lost</th></tr>");

        // Check if the 'sort' parameter is present in the URL and set to 'true'
        boolean sortTable = Boolean.parseBoolean(request.getParameter("sort"));

        // Check if the 'paid' parameter is present in the URL and set to 'true'
        boolean showPaidTickets = Boolean.parseBoolean(request.getParameter("paid"));

        boolean showunPaidTickets = Boolean.parseBoolean(request.getParameter("unpaid"));

        // Check if the 'reset' parameter is present in the URL and set to 'true'
        boolean showAllTickets = Boolean.parseBoolean(request.getParameter("showalltickets"));

        List<Ticket> tickets = Ticket.getAllTickets();
        List<Ticket> sortedTickets;

        if (showPaidTickets) {
            sortedTickets = sortTable ? Ticket.getSortedTicketsByPriceDescending() : Ticket.getPaidTickets();
        } else if (showunPaidTickets) {
            sortedTickets = sortTable ? Ticket.getSortedTicketsByPriceDescending() : Ticket.getunPaidTickets();
        } else {
            sortedTickets = sortTable ? Ticket.getSortedTicketsByPriceDescending() : tickets;
        }

        if (showAllTickets) {
            sortedTickets = tickets;
        }

        double totalTicketPrice = sortedTickets.stream()
                .mapToDouble(Ticket::getPrice)
                .sum();

        List<Ticket> lostTickets = Ticket.getTicketsByState();

        sortedTickets.forEach(ticket -> {
            out.println("<tr>");
            out.println("<td>" + ticket.getTicketNummer() + "</td>");
            out.println("<td>" + ticket.getEintrittszeit() + "</td>");

            if (ticket.getBezahlzeit() != null && ticket.state instanceof com.example.parhausprj.Ausgefahren) {
                out.println("<td>" + ticket.getBezahlzeit() + "</td>");
                out.println("<td>" + ticket.getPrice() + "<span>&#8364;</span></td>");
                out.println("<td>Yes</td>");
            } else {
                out.println("<td>-</td>");
                out.println("<td>-</td>");
                out.println("<td>Nope</td>");
            }

            boolean isLost = lostTickets.contains(ticket);
            out.println("<td>" + isLost + "</td>");
            out.println("</tr>");
        });

        out.println("</table>");

        out.println("<div class=\"center\">");
        out.println("<h2>Total Sales: " + totalTicketPrice + "<span>&#8364;</span></h2>");

        double paidAvg = Ticket.getPaidTickets().stream().mapToDouble(Ticket::getPrice).average().orElse(0.0);
        double paidPercentage = (double) Ticket.getPaidTickets().size() / tickets.size() * 100.0;

        out.println("<p>Average Price of Paid Tickets: " + String.format("%.2f", paidAvg) + "<span>&#8364;</span></p>");
        out.println("<p>Percentage of Paid Tickets: " + String.format("%.2f", paidPercentage) + "%</p>");

        out.println("<button onclick=\"window.location.href='index.jsp'\">Back to Home</button>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

