<%@ page import="com.example.parhausprj.Offnungzeitenservlet" %>
<%@ page import="com.example.parhausprj.PriceServlet" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Parkhauss 404 - Home</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color:#FFEBB3;
      margin: 0;
      padding: 0;
    }
    header img {
      display: block; /* make the image a block element */
      margin: 0 auto; /* center the image horizontally */
      max-height: 250px; /* set the maximum height of the image */
      animation: fade-in 3.5s ease-out;
      width: auto; /* set the width of the image to auto */
      border-radius: 40px;

    }
    @keyframes fade-in {
      0% {
        opacity: 0;
        transform: scale(0.9);
      }
      100% {
        opacity: 1;
        transform: scale(1);
      }
    }
    
    .btn-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: calc(40vh - 30px);
    }
    .btn-container button {
      padding: 16px 24px;
      border: none;
      border-radius: 16px;
      font-size: 1.2rem;
      font-weight: bold;
      color: black;
      background-color: #FFCA33;
      cursor: pointer;
      transition: all 0.3s ease;
      margin: 0 16px;
    }
    .btn-container button:hover {
      background-color: #fff;
      color: #333;
    }
    .green{
      color: #57e857;
    }
    section{
      color: black;

    }

  </style>
</head>
<body>
<header>
  <img src="https://static.vecteezy.com/system/resources/previews/016/770/608/original/parking-road-sign-on-transparent-background-free-png.png" alt="header image">

</header>
<script>
  function updateClock() {
    var now = new Date(); // aktuelle Zeit abrufen
    var day = now.getDate(); // Tag abrufen
    var month = now.getMonth() + 1; // Monat abrufen (Januar = 0, Februar = 1, ...)
    var year = now.getFullYear(); // Jahr abrufen
    var hours = now.getHours(); // Stunden abrufen
    var minutes = now.getMinutes(); // Minuten abrufen
    var seconds = now.getSeconds(); // Sekunden abrufen
    var timeString = day + '.' + month + '.' + year + ' ' + hours + ':' + minutes + ':' + seconds; // Zeitformat erstellen
    document.getElementById('clock').innerHTML = timeString; // Zeit in das HTML-Element schreiben
  }
  setInterval(updateClock, 1000); // Die Uhrzeit alle Sekunde aktualisieren
</script>
<section>

  <div style="text-align:center;">
    <h1>Welcome To Parkhauss 404</h1>
    <h1 id="clock"></h1>
    <h2>Opening Hours:  ${Offnungzeitenservlet.openingHours}</h2>
    <p class="green"> Free Places : ${Offnungzeitenservlet.Freeplaces}</p>
    <p> Price per Hour : ${PriceServlet.ticketPrice} &#8364 </p>
    <% %>
  </div>
</section>
<div class="btn-container">
  <a href="ticket-servlet"><button>Get a Ticket</button></a>
  <a href="hello-servlet"><button>Pay for your Ticket</button></a>
  <a href="verlust-servlet"><button class="lost-btn">Lost your Ticket?</button></a>
  <a href="login.jsp"><button class="lost-btn">for owner!</button></a>
</div>

</body>
</html>
