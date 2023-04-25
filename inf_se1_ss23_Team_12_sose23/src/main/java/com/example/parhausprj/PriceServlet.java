package com.example.parhausprj;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "priceServlet", value = "/price-servlet")
public class PriceServlet extends HttpServlet  {
    public static double ticketPrice = 0.99;

    @Override
    public void init()  {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String ticketPriceParam = request.getParameter("ticketPrice");
        if (ticketPriceParam != null) {
            ticketPrice = Double.parseDouble(ticketPriceParam);
        }
        // else {
        //     response.getWriter().println("Bitte geben Sie einen Ticketpreis an.");
        // }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<br><h1 style=\"color:black;\">Der neue Ticketspreis ist :" + " " + ticketPrice + " " +"Euro"+ "</h1>");
        out.println("<button onclick=\"window.location.href='http://localhost:8080/Parhausprj_war_exploded/'\">Back to Home</button>");
        out.println("</body></html>");


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);

    }

    public void destroy() {
    }
}
