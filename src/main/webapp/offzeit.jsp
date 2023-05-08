<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Öffnungszeiten</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color:#FFEBB3;
            margin: 0;
            padding: 0;
        }
        form {
            margin-bottom: 40px;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"] {
            padding: 5px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 3px;
            width: 100%;
            max-width: 300px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }
        button[type="submit"] {
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


    </style>
</head>
<body>

<div class="row">
    <div class="column" style="background-color:#FFEBB3;">
        <h2>Update the opening hours:</h2>
        <form method="post" action="zeit-servlet"><br><br>
            <label> Enter the new opening hours :</label>
            <input type="text" name="openingHours">
            <a href="index.jsp"><button type="submit" >Submit</button></a>
        </form>
    </div>
    <div class="column" style="background-color:#FFF2CC;">
        <h2>Update the price of the Ticket:</h2>
        <form action="price-servlet" method="post"><br><br>
            <label for="ticketPrice"> Enter the new price:</label>
            <input type="text" id="ticketPrice" name="ticketPrice">
            <a href="index.jsp"> <button type="submit"  >Submit</button></a>
        </form>
    </div>
</div>
<button onclick=\"window.location.href='index.jsp'\">Back to Home</button>
</body>
</html>

