package com.example.parhausprj;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ZeitServlet", value = "/zeit-servlet")
public class Offnungzeitenservlet extends HttpServlet {
    private String message;

    private static final long serialVersionUID = 1L;

    private ParkhausIF parkhaus = new Parkhauss();

    public void init() {
        parkhaus = new Parkhauss();
        //parkhaus.setOpeningHours("Mo-Fr 9-18, Sa-Su 10-16");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        parkhaus.setOpeningHours(request.getParameter("openingHours"));
        String openingHours = parkhaus.getOpeningHours();
        request.setAttribute("openingHours", openingHours);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

        if (openingHours != null && !openingHours.isEmpty()) {
            parkhaus.setOpeningHours(openingHours);
        }
        doGet(request, response);
    }




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        parkhaus.setOpeningHours(request.getParameter("openingHours")); // Setzen Sie die Öffnungszeiten hier

        String openingHours = parkhaus.getOpeningHours();
        request.setAttribute("openingHours", openingHours);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1><center>Herzlich Willkommen in unserem Parkhaus</center></h1>");
        out.println("<h2><center>Öffnungszeiten: " + openingHours + "</center></h2>");

        // Formular-Button hinzufügen
        out.println("<form method=\"post\" action=\"zeit-servlet\">");
        out.println("<input type=\"text\" name=\"openingHours\" placeholder=\"Neue Öffnungszeiten\">");
        out.println("<button type=\"submit\">Öffnungszeiten ändern</button>");
        out.println("</form>");

        out.println("</body></html>");
    }



    public void destroy() {
    }
}