<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="style.css">
<head>
  <title>Parkplatz reservieren</title>

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
