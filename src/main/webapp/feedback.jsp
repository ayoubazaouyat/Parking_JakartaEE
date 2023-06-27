<!DOCTYPE html>
<html lang="en">
<head>
    <title>Feedback</title>
    <link rel="stylesheet" type="text/css" href="feedback.css">
</head>
<body>
<h2>Feedback Form</h2>
<form action="feedback-servlet" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="subject">Betreff:</label>
    <select id="subject" name="subject" required>
        <option value="">Bitte wählen</option>
        <option value="complaint">complaint</option>
        <option value="feedback">feedback</option>
    </select><br><br>

    <label for="visit-time">Besuchszeit:</label>
    <input type="datetime-local" id="visit-time" name="visitTime" required><br><br>

    <label for="message">Nachricht:</label><br>
    <textarea id="message" name="message" rows="4" cols="50" required></textarea><br><br>

    <input type="submit" value="Senden">
</form>
</body>
</html>
