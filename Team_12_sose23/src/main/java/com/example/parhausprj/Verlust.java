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
        out.println("<h1>" + message + "</h1>");
        out.println("<form action=\"verlust-servlet\" method=\"post\">");
        out.println("<label for=\"autonummer\">Autonummer:</label>");
        out.println("<input type=\"text\" id=\"autonummer\" name=\"autonummer\" required>");
        out.println("<label for=\"creditCardNumber\">Credit Card Number:</label>");
        out.println("<input type=\"text\" id=\"creditCardNumber\" name=\"creditCardNumber\"><br><br>");
        out.println("<input type=\"submit\" value=\"Pay My Ticket\">");
        out.println("</form>");
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
                out.println("<p>Amount Charged: $" + price + "</p>");

                out.println("</body></html>");
            }
        }
        if(ticketnummer==0){

            out.println("Go get a ticket first");
        }
        out.println("<button onclick=\"window.location.href='http://localhost:8080/Parhausprj_war_exploded/'\">Back to Home</button>");
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
