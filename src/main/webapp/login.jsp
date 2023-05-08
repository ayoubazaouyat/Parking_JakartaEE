<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color:#FFEBB3;
            margin: 0;
            padding: 0;
        }

        form {
            margin-bottom: 40px;
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"], input[type="password"] {
            padding: 5px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 3px;
            width: 100%;
            max-width: 300px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 5px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        * {
            box-sizing: border-box;
        }

        .row {
            display: flex;
        }

        .column {
            flex: 50%;
            padding: 10px;
            height: 740px;
        }

        

        div.center {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>


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
<body>
<div class="center">
    <div>
        <h1>Admin Login</h1>
        <form action="login.jsp" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <input type="submit" value="Login">
        </form>
    </div>
</div>
</body>
</html>


