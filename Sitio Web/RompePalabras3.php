<?php
session_start();
$nombre=$_SESSION['usernama'];
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, "http://127.0.0.1:4567/MejorUsuario");
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($curl);
curl_close($curl);
?>
<html>
    <head>
        <title>
            ¡Rompe Palabras! Leaderboard
        </title>
        <meta charset='utf-8'>
        <link rel='stylesheet' href='RompePalabras3.css'>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <meta name= "viewport" content="width=device-width, initial-scale=1">
  <style>
  .affix {
    top: 20px;
    z-index: 9999 !important;
  }
  </style>
    </head>
    <body>
      <div class="container-fluid">
        <div id='Pestañas' class="row">
                  <div class="col">
                  <a class="nav-link" href="RompePalabras.php">Juego</a>
                  </div>
                  <div class="col">
                    <a class="nav-link" href="RompePalabras2.php">Como Jugar</a>
                  </div>
                  <div class="col">
                    <a class="nav-link" href="RompePalabras3.php">Leaderboard</a>
                  </div>
                  <div class="col">
                    <a class="nav-link" href="RompePalabras4.php">PMF</a>
                  </div>
                  <div class="col">
                    <?php
                    echo "<a class='nav-link'>".$nombre."</a>";
                    ?>
                  </div>
                </ul>
        </div>
        <div id="Leaderboard" class="row">
            <div id="section1">
              <label>Top Usuario del Mundo!</label>
            <?php
            echo "<label>".$response."</label>";
            ?>
            </div>
          </div>
          <div id='login' class="row">
            <p>
              ¿No tienes una cuenta?
            </p>
          </div>
            <div id="Links" class="row">
              <a href='CrearCuenta.html'>
                Registrate gratuitamente!
              </a>
            </div>
            <div id="Cuenta" class="row">
              <p>
              ¿Ya tenes cuenta?
              </p>
            </div>
            <div id="Loggs" class="row">
              <a href='LogIn.html'>
                ¡Logueate aca!
              </a>
            </div>
    </body>
</html>