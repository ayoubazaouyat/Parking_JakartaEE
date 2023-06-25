<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Parkplatz reservieren</title>
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
  <h1>Kundenbereich</h1>
  <br><br>

  <div class="form-wrapper">
    <h2>Parkplatz reservieren:</h2>
    <form action="platz-servlet" method="post">
      <label for="spaceNumber">Geben Sie die Nummer des Platzes zum reservieren ein:</label>
      <input type="text" id="spaceNumber" name="spaceNumber" required>
      <br><br>
      <label for="autonummer">Geben Sie ihre Autonummernschild ein:</label>
      <input type="text" pattern="[A-Za-z]{2}-[A-Za-z]{2}-[0-9]{4}" title="i.e BB-BB-0000" id="autonummer" name="autonummer" required>
      <br><br>
      <button type="submit">Submit</button>
    </form>
  </div>
</div>
</body>
</html>
