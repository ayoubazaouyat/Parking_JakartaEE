package com.example.parhausprj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.example.parhausprj.TicketResponse.tickets;

@WebServlet(name = "TotalSalesServlet", value = "/TotalSales-servlet")
public class TotalSalesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Ticket> tickets = Ticket.getAllTickets();


        double totalSales = Ticket.getTotalSales();
        ;
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
        response.getWriter().println("<h1><center><B> Total Sales: " + totalSales + "euro</B></center></h1>");


        for (Ticket i : tickets) {
            if(i.getBezahlzeit()!=null) {
                out.println("<html><body>");
                out.println("<p>Ticket Number: " + i.getTicketNummer());
                out.println("<p>Eintrittzeit: " + i.eintrittszeit);
                out.println("<p>Austrittzeit: " + i.bezahlzeit);
                out.println("<p>Amount Charged: " + i.getPrice() + "<span>&#8364;</span> </p>");
                out.println("</body></html>");
            }
        }
        out.println("<button onclick=\"window.location.href='index.jsp'\">Back to Home</button>");
        out.println("</div>");
        out.println("</body></html>");




    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}