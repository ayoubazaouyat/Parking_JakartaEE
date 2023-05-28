package com.example.parhausprj;
import java.io.IOException;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Duration;
import  java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ZeitHandlingServlet", value = "/zeithandling")
    public class ZeitHandlingServlet extends HttpServlet {
        public static LocalDateTime currentTime = LocalDateTime.now();
        private int additionalMinutes = 0;
        private int additionalSeconds = 0;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            LocalDateTime currentTime = LocalDateTime.now(); // Get current time
            request.setAttribute("currentTime", currentTime); // Set current time as request attribute
            request.getRequestDispatcher("/zeithandling.jsp").forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            LocalDateTime currentTime = LocalDateTime.now();
            if ("reset".equals(action)) {
                // Reset the additional minutes and seconds
                additionalMinutes = 0;
                additionalSeconds = 0;
            } else if ("add5min".equals(action)) {
                // Add 5 minutes to the additional minutes
                additionalMinutes += 5;
            } else if ("add15min".equals(action)) {
                // Add 15 minutes to the additional minutes
                additionalMinutes += 15;
            } else if ("add1hour".equals(action)) {
                // Add 1 hour to the additional minutes
                additionalMinutes += 60;
            } else if ("timewarp".equals(action)) {
                // Get the new time from the request parameter
                String timeString = request.getParameter("time");
                if (timeString != null && !timeString.isEmpty()) {
                    LocalDateTime newTime = LocalDateTime.parse(timeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    if (newTime.isBefore(currentTime)) {
                        throw new ZeitverletzungsException("Raum-Zeit-Kontinuum verletzt");
                    }
                    Duration duration = Duration.between(currentTime, newTime);
                    additionalMinutes += duration.toMinutes();
                    additionalSeconds += duration.minusMinutes(duration.toMinutes()).getSeconds();
                }
            }

            // Update the current time based on the additional minutes and seconds
            currentTime = LocalDateTime.now().plusMinutes(additionalMinutes).plusSeconds(additionalSeconds);

            request.setAttribute("currentTime", currentTime); // Update current time in request attribute

            request.getRequestDispatcher("/zeithandling.jsp").forward(request, response);

            request.getRequestDispatcher("ticket-response").forward(request, response);

            request.setAttribute("currentTime", currentTime); // Update current time in request attribute
            request.getRequestDispatcher("ticket-response").forward(request, response);
        }
        public class ZeitverletzungsException extends RuntimeException {
            public ZeitverletzungsException(String message) {
                super(message);
            }
        }
    }










