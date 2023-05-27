package com.example.parhausprj;
import com.example.parhausprj.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VerlustServlet", value = "/verlust-servlet")
public class Verlust extends HttpServlet {
    private String message = "Pay for your lost ticket";


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

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
        out.println("<form action=\"verlust-servlet\" method=\"post\">");
        out.println("<label for=\"autonummer\">Autonummer:</label>");
        out.println("<input type=\"text\" id=\"autonummer\" name=\"autonummer\" required>");
        out.println("<label for=\"creditCardNumber\">Credit Card Number:</label>");
        out.println("<input type=\"text\" id=\"creditCardNumber\" name=\"creditCardNumber\"><br><br>");
        out.println("<input type=\"submit\" value=\"Pay My Ticket\">");
        out.println("</form>");
        out.println("</div>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int ticketnummer=0;
        String autonummer = request.getParameter("autonummer");
        String creditCardNumber = request.getParameter("creditCardNumber");

        // Erstellen Sie eine Instanz der Ticket-Klasse und legen Sie die Werte für das Ticket fest
        //  Ticket ticket = new Ticket(1234, "ABC-123", 10.0);
        for(Ticket i:TicketResponse.tickets){

            if(i.getAutoNummer().equals(autonummer)) {
                ticketnummer=i.getTicketNummer();
                i.verloren();
                double price = i.bezahlen();
                out.println("<html><body>");
                out.println("<h1>Payment Successful</h1>");
                out.println("<p>Ticket Number: " +ticketnummer+ "</p>");
                out.println("<p>Amount Charged: " + price + "<span>&#8364;</span> </p>");

                out.println("</body></html>");
            }
        }
        if(ticketnummer==0){

            out.println("Go get a ticket first");
        }
        out.println("<button onclick=\"window.location.href='index.jsp'\">Back to Home</button>");
        // Validieren Sie das Ticket und berechnen Sie den Preis



        // Prüfen Sie, ob die eingegebene Ticket-Nummer mit der des Tickets übereinstimmt
        //if (ticketNumber.equals(Integer.toString(ticket.getTicketNummer()))) {
        // Fügen Sie hier den Code ein, um die Kreditkarte zu belasten



        /* } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Error: Invalid Ticket Number</h1>");
            out.println("</body></html>");
        }*/
    }


    public void destroy() {
    }

}
