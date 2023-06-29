<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="style.css">
<head>
    <title>Öffnungszeiten</title>

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
        <h2>Update the ticket price:</h2>
        <form action="price-servlet" method="post">
            <label for="ticketPrice">Enter new price:</label>
            <input type="text" id="ticketPrice" name="ticketPrice">
            <button type="submit">Submit</button>
        </form>
    </div>

    <div class="links-wrapper">
        <a href="visualisation">Visualisierung</a>
        <a href="TotalSales-servlet">Gesamtumsatz</a>
        <a href="index.jsp" style="background-color: #FF0000;">Zurück zur Startseite</a>
    </div>
    <div class="form-wrapper">
        <h2>Feedback anzeigen:</h2>
        <a href="feedback-servlet"><button> Show feedbacks </button></a>
    </div>
</div>
</body>
</html>
