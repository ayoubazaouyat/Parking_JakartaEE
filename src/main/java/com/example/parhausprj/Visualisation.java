package com.example.parhausprj;
import com.example.parhausprj.Ticket;
import com.example.parhausprj.TicketResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "Visualisation", value = "/visualisation")
public class Visualisation  extends HttpServlet{
    String occ ;
    String car ;

    public void init() {
         occ = "occupied";
         car = "";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(
                "<html>\n" +
                "<head>\n" +
                "    <title>Park Visualisation </title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color:#FFEBB3;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        parking-lot {\n" +
               /* "             display: flex;\n" +
                "            flex-direction: column;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" + */
                "            position: relative;" +
                "        }\n" +
                "        car {" +
                        "     text-align: center;" +
                        "     margin-top: -80px;" +
                        "}\n"+
                "\n" +
                "        .row {\n" +
                "            display: flex;\n" +
                /*"            justify-content: left;\n" +
                        "    align-items: left;\n" + */
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "\n" +
                "        .spot {\n" +
                "            width: 50px;\n" +
                "            height: 50px;\n" +
                "            background-color: lightgreen;\n" +
                "            border: 1px solid #ccc;\n" +
                "            margin: 5px;\n" +
                "            border-radius: 5px;\n" +
                "            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "\n" +
                "        .occupied {\n" +
                "            background-color: #e74c3c;\n" +
                "        }\n" +
                        ".top-left {\n" +
                        "  position: absolute;" +
                        "  top: 0;\n" +
                        "  left: 0;\n" +
                        "}\n" +
                        "\n" +
                        ".top-right {\n" +
                        "  position: absolute;" +
                        "  top: 0;\n" +
                        "  right: 0;\n" +
                        "}\n" +
                        "\n" +
                        ".bottom-left {\n" +
                        "  position: absolute;"+
                        "  bottom: 0;\n" +
                        "  left: 0;\n" +
                        "}\n" +
                        "\n" +
                        ".bottom-right {\n" +
                        "  position: absolute;"+
                        "  bottom: 0;\n" +
                        "  right: 0;\n" +
                        "}\n"+
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                        "<h2 > Parking lot Visualisation </h2>" +

                "<div class=\"parking-lot\">\n" );

        for (int level = 0 ; level < 4 ; level++) {
            String position ;
            switch (level) {
                case 0 :
                    out.println("<div class = \"top-left\"> <p style = \"text-align: center; \"> <b>First Level</b></p>");
                    break;
                case 1 :
                    out.println("<div class = \"bottom-left\"> <p style = \"text-align: center; \"> <b>Second Level</b></p>");
                    break;
                case 2 :
                    out.println("<div class = \"top-right\"> <p style = \"text-align: center; \"> <b>Third Level</b></p>");
                    break;
                case 3 :
                    out.println("<div class = \"bottom-right\"> <p style = \"text-align: center; \"> <b>Fourth Level</b></p>");
                    break;

            }
            for( int i = 0 ; i < 5 ; i++){
                int k = 0;
                out.println("    <div class=\"row\">"+(level+1) + "- "+(i+1) +"\n");
                for(int j = 0 ; j < 10 ; j++) {

                    int i1 = k + (i * 10 + level * 50);
                    if (Parkhauss.lots[i1] != null) {
                        occ = "occupied";
                        car = Parkhauss.lots[i1];
                    } else {
                        occ = "";
                        car = "";

                    }
                    out.println("        <div class=\"spot " + occ +" \"> "+ i1  +"<div class= \"car\" " +
                            "style = \"text-align: center; margin-top: 0; font-size: 11px;\">"+ car +  "</div>" +" </div>\n");
                    k++;
                }
                out.println("    "+(level+1) + "- "+(i+1) + "</div>\n" );
            }
            out.print("</div>");
        }

        out.println("</p>");
        out.println("</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
