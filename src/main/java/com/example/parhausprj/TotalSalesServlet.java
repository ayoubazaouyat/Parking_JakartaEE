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



        response.setContentType("text/html");
        out.println("<html><body>");
        out.println("<style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color:#FFEBB3;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        table {\n" +
                "            border-collapse: collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        th, td {\n" +
                "            text-align: left;\n" +
                "            padding: 8px;\n" +
                "            border-bottom: 1px solid #ddd;\n" +
                "        }\n" +
                "    </style>");
        out.println("<div style=\"text-align:center;\">");

        response.getWriter().println("<h1><center><B>Ticket-information</B></center></h1>");
        out.println("<button onclick=\"window.location.href='?sort=true'\">Sortieren</button>");
        out.println("<button onclick=\"window.location.href='?sort=false'\">Reset</button>");
        out.println("<table>");
        out.println("<tr><th>Ticket Number</th><th>Eintrittzeit</th><th>Austrittzeit</th><th>Verloren ?</th><th>Amount Charged</th></tr>");

        // Check if the 'sort' parameter is present in the URL and set to 'true'
        boolean sortTable = Boolean.parseBoolean(request.getParameter("sort"));

        List<Ticket> tickets = Ticket.getAllTickets();
        List<Ticket> sortedTickets = sortTable ? Ticket.getSortedTicketsByPriceDescending() : tickets;
        double totalTicketPrice = sortedTickets.stream()
                .mapToDouble(Ticket::getPrice)
                .sum();
        List<Ticket> lostTickets = Ticket.getTicketsByState();
        sortedTickets.forEach(ticket -> {
            out.println("<tr>");
            out.println("<td>" + ticket.getTicketNummer() + "</td>");
            out.println("<td>" + ticket.getEintrittszeit() + "</td>");
            out.println("<td>" + ticket.getBezahlzeit() + "</td>");
            boolean isLost = lostTickets.contains(ticket);
            out.println("<td>" + isLost + "</td>");
            out.println("<td>" + ticket.getPrice() + "<span>&#8364;</span></td>");
            out.println("</tr>");
        });
        out.println("</table>");
        double paidAvg = TicketResponse.tickets.stream().filter(x -> x.getState() instanceof com.example.parhausprj.TicketBezahlt).map(x -> x.getPrice()).reduce(0.0,(x,y) -> y + x )
                        / TicketResponse.tickets.stream().filter(x -> x.getState() instanceof com.example.parhausprj.TicketBezahlt).count();
        double paidPer = ((double) TicketResponse.tickets.stream().filter(x -> x.getState() instanceof com.example.parhausprj.TicketBezahlt).count()
                / (double) TicketResponse.tickets.stream().count()) * 100. ;
        
        out.println("<p>Average Price : " + paidAvg + "<span>&#8364;</span> </p>");
        out.println("<p>Percentage Paid : " + paidPer + "% </p>");
        response.getWriter().println("<h1><center><B> Total Sales: " + totalTicketPrice+ "euro</B></center></h1>");
        out.println("<button onclick=\"window.location.href='index.jsp'\">Back to Home</button>");
        out.println("</div>");
        out.println("</body></html>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
