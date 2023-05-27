package com.example.parhausprj;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TicketServlet", value = "/ticket-servlet")
public class TicketServlet extends HttpServlet {
    private String message = "Get a Ticket";
    public double price = 10.0;


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
        out.println("<h1>" + message + "</h1>");
        out.println("<form action=\"ticket-response \"method=\"post\">" +
                "<label for=\"matrikulNummer\">Car registration number:</label>" +
                "<input type=\"text\" pattern=\"[A-Za-z]{2}-[A-Za-z]{2}-[0-9]{4}\" " +
                "id=\"matrikulNummer\" title=\"i.e BB-BB-0000\" name=\"matrikulNummer\"\" required><br><br>"+
                "<input type=\"submit\"value=\"Submit\"> " +
                "</form>" +
                "<a href=\"index.jsp\"><button type=\"Go Back\">Back to Home</button></a>");
        out.println("</div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
