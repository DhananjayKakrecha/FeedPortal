<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Error Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f8f9fa;
    }

    .error-container {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      height: 100vh;
      text-align: center;
    }

    .error-heading {
      font-size: 4rem;
      font-weight: bold;
      color: #34495e; /* Dark blue color */
      margin-bottom: 2rem;
    }

    .error-message {
      font-size: 2rem;
      color: #6c757d;
      margin-bottom: 1rem;
    }

    .error-link {
      color: #fff;
      background-color: #34495e; /* Dark blue color */
      border-color: #34495e; /* Dark blue color */
      padding: 0.5rem 1.5rem;
      font-size: 1.5rem;
      border-radius: 0.25rem;
      text-decoration: none;
    }

    @media (max-width: 576px) {
      .error-heading {
        font-size: 3rem;
      }

      .error-message {
        font-size: 1.25rem;
      }
    }
  </style>
</head>

<body>
  <div class="error-container">
    <h1 class="error-heading">Error: Username Already Exists</h1>
    <p class="error-message">The username you provided already exists. Please choose a different username.</p>
    <a class="error-link" href="Index.jsp">Go back to Home!</a><br>
  </div>
</body>

</html>