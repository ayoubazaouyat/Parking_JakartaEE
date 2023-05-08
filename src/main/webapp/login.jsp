<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1>Login Page</h1>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if ("admin".equals(username) && "1111".equals(password)) {
        // Weiterleitung zur offzeit.jsp, wenn die Anmeldeinformationen korrekt sind
        response.sendRedirect("offzeit.jsp");
    } else if (username != null || password != null) {
        // Ansonsten wird eine Fehlermeldung angezeigt
        out.println("<p>Invalid login credentials. Please try again.</p>");
    }
%>
<form method="post" action="login.jsp">
    <label for="username">Username:</label>
    <input type="text" name="username" id="username" /><br /><br />
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" /><br /><br />
    <input type="submit" value="Login" />
</form>
</body>
</html>
