<%@ page import="com.example.parhausprj.Offnungzeitenservlet" %>
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
      background-color:black;
      margin: 0;
      padding: 0;
    }
    header img {
      display: block; /* make the image a block element */
      margin: 0 auto; /* center the image horizontally */
      max-height: 250px; /* set the maximum height of the image */
      animation: fade-in 3.5s ease-out;
      width: auto; /* set the width of the image to auto */

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
    section{
      color: white;

    }

  </style>
</head>
<body>
  <h1>See u soon !</h1>

</body>
</html>