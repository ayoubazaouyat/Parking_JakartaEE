<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Öffnungszeiten</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }

        .form-wrapper {
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 30px;
        }

        .form-wrapper h2 {
            color: #333;
            margin-top: 0;
        }

        .form-wrapper label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        .form-wrapper input[type="text"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 3px;
            width: 100%;
            max-width: 300px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        .form-wrapper button[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-weight: bold;
        }

        .form-wrapper button[type="submit"]:hover {
            background-color: #45a049;
        }

        .links-wrapper {
            text-align: center;
            margin-top: 20px;
        }

        .links-wrapper a {
            display: inline-block;
            margin-right: 10px;
            text-decoration: none;
            color: #fff;
            padding: 8px 16px;
            border-radius: 3px;
            transition: background-color 0.3s ease;
        }

        .links-wrapper a:nth-child(1) {
            background-color: #4CAF50;
            border: 1px solid #4CAF50;
        }

        .links-wrapper a:nth-child(1):hover {
            background-color: #45a049;
        }

        .links-wrapper a:nth-child(2),
        .links-wrapper a:nth-child(3) {
            background-color: #333;
            border: 1px solid #333;
        }

        .links-wrapper a:nth-child(2):hover,
        .links-wrapper a:nth-child(3):hover {
            background-color: #555;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Parkhaus Verwaltung</h1>

    <div class="form-wrapper">
        <h2>Öffnungszeiten aktualisieren:</h2>
        <form method="post" action="zeit-servlet">
            <label for="openingHours">Neue Öffnungszeiten eingeben:</label>
            <input type="text" id="openingHours" name="openingHours">
            <button type="submit">Absenden</button>
        </form>
    </div>

    <div class="form-wrapper">
        <h2>Preis des Tickets aktualisieren:</h2>
        <form action="price-servlet" method="post">
            <label for="ticketPrice">Neuen Preis eingeben:</label>
            <input type="text" id="ticketPrice" name="ticketPrice">
            <button type="submit">Absenden</button>
        </form>
    </div>

    <div class="links-wrapper">
        <a href="visualisation">Visualisierung</a>
        <a href="TotalSales-servlet">Gesamtumsatz</a>
        <a href="index.jsp" style="background-color: #FF0000;">Zurück zur Startseite</a>
    </div>
</div>
</body>
</html>
