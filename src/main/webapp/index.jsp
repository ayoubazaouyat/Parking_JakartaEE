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
      background-color:#FAFAD2;
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
      color: white;
      background-color: #20409a;
      cursor: pointer;
      transition: all 0.3s ease;
      margin: 0 16px;
    }
    .btn-container button:hover {
      background-color: #fff;
      color: #333;
    }
     .admin-support-container {
  position: absolute;
  top: 0;
  left: 0;
  
}
  .uhr-btn {
  position: absolute;
  top: 0;
  right: 0;
  
}
.lost-btn, .log-btn {
  margin-left: 0px;
  width: 180px;
  padding: 16px 24px;
}
  
    .green{
      color: #57e857;
    }
    section{
      color: #20409a;

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
  <script>
  function supportCall() {
    
    window.location.href = "tel:017662049220"; // Hier ersetzen Sie 0123456789 durch die Telefonnummer, die angerufen werden soll
  }
</script>

  <div style="text-align:center;">
    <h1>Welcome To Parkhauss 404</h1>
    <h1 class="uhr-btn" id="clock"></h1>
    <h3>Opening Hours:  ${Offnungzeitenservlet.openingHours}</h3>
    <h4 class="green"> Free Places : ${Offnungzeitenservlet.Freeplaces}</h4>
    <h4> Price per Hour : ${PriceServlet.ticketPrice} &#8364 </h4>
    <% %>
  </div>
</section>
<div class="btn-container">
  <a href="ticket-servlet"><button>Get a Ticket</button></a>
  <a href="hello-servlet"><button>Pay for your Ticket</button></a>
  <a href="verlust-servlet"><button>Lost your Ticket?</button></a>
  
</div>
<div class="admin-support-container">
    <a href="login.jsp"><button class="lost-btn">Admin &#x1F464</button></a>
    <button class="log-btn" onclick="supportCall()">Support &#x1F4DE </button>
    
  </div>
<div class="Qr"style="text-align:center; margin-top: -80px;" >

<a href="https://form.jotform.com/231312960388053" rel="nofollow">
  <img src="https://www.jotform.com/uploads/Parkhaus404services/form_files/231312960388053_1683927497_qrcode_muse.png" width="100%" style="max-width: 200px" alt="QR Code for Jotform form">
</a>
 <h3>Scan it to Giv us a Feedback</h3>
</div>



</body>
</html>
