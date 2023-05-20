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

    private Parkplatz parkplatz;
   // private String message = "Reserve a Space";

    @Override
    public void init() throws ServletException {
        super.init();
        parkplatz = new Parkplatz(200);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display a form where the user can enter the number of the parking space they want to reserve
        //request.getRequestDispatcher("/index.jsp").forward(request, response);

        response.setContentType("text/html");
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
                "        }\n" +  "div {\n" +
                "  position: absolute;\n" +
                "  top: 50%;\n" +
                "  left: 50%;\n" +
                "  transform: translate(-50%, -50%);\n" +
                "}\n"+
                "\n" +
                "\n" +
                "    </style>");
        out.println("<div style=\"text-align:center;\">");
        out.println("<h1>Reserve a Parking Space</h1>");
        out.println("<form action=\"platz-servlet\" method=\"post\">");
        out.println("<label for=\"spaceNumber\">Enter the number of the parking space you want to reserve:</label>");
        out.println("<input type=\"text\" id=\"spaceNumber\" name=\"spaceNumber\">");
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
        Parkplatz.ParkingSpace parkingSpace = parkplatz.reserveParkingSpace(spaceNumber);
        // Display the result to the user
        if (parkingSpace != null) {
            response.setContentType("text/html");
            response.getWriter().println("Parking space number" +" " + parkingSpace.getNumber()+ " " +"is reserved " );
            response.getWriter().println("<br>");
            response.getWriter().println("<a href=\"index.jsp\"><button type=\"button\">Back to Home</button></a>");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("This parking space is already reserved");
            response.getWriter().println("<br>");
            response.getWriter().println("<a href=\"index.jsp\"><button type=\"button\">Back to Home</button></a>");
        }

    }

}
