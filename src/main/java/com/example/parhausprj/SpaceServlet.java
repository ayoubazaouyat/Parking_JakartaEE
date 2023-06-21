package com.example.parhausprj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "platzServlet", value = "/platz-servlet")
public class SpaceServlet extends HttpServlet {

    public static Parkplatz parkplatz= new Parkplatz(200);
   // private String message = "Reserve a Space";

    @Override
    public void init() throws ServletException {
        super.init();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display a form where the user can enter the number of the parking space they want to reserve
        //request.getRequestDispatcher("/index.jsp").forward(request, response);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(HelloServlet.style);
        out.println("<div style=\"text-align:center;\">");
        out.println("<h1>Reserve a Parking Space</h1>");
        out.println("<form action=\"platz-servlet\" method=\"post\">");
        out.println("<label for=\"spaceNumber\">Enter the number of the parking space you want to reserve:</label>");
        out.println("<input type=\"text\" id=\"spaceNumber\" name=\"spaceNumber\" required>");
        out.println("<br><br>");
        out.println("<label for=\"autonummer\">Enter your license plate number\n</label>");
        out.println("<input type=\"text\" pattern=\"[A-Za-z]{2}-[A-Za-z]{2}-[0-9]{4}\" " +
                "title=\"i.e BB-BB-0000\" id=\"autonummer\" name=\"autonummer\" required>");
        out.println("<br><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</div>");
        out.println("</body></html>");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String spaceNumberStr = request.getParameter("spaceNumber");
        int spaceNumber = Integer.parseInt(spaceNumberStr);
        // Attempt to reserve the parking space
        Parkplatz.ParkingSpace parkingSpace = parkplatz.reserveParkingSpace(spaceNumber+1,request.getParameter("autonummer"));
        // Display the result to the user
        if (parkingSpace != null) {
            response.setContentType("text/html");
            response.getWriter().println("Parking space number" +" " + (parkingSpace.getNumber()-1)+ " " +"is reserved for you" );
            response.getWriter().println("<br><br><br>");
            response.getWriter().println("<a href=\"index.jsp\"><button type=\"button\">Back to Home</button></a>");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("This parking space is already reserved");
            response.getWriter().println("<br>");
            response.getWriter().println("<a href=\"index.jsp\"><button type=\"button\">Back to Home</button></a>");
        }

    }

}
