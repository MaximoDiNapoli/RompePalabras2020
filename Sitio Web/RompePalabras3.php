<?php
session_start();
$nombre=$_SESSION['usernama'];
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
                  <a class="nav-link" href="RompePalabras.html">Juego</a>
                  </div>
                  <div class="col">
                    <a class="nav-link" href="RompePalabras2.html">Como Jugar</a>
                  </div>
                  <div class="col">
                    <a class="nav-link" href="RompePalabras3.html">Leaderboard</a>
                  </div>
                  <div class="col">
                    <a class="nav-link" href="RompePalabras4.html">PMF</a>
                  </div>
                  <div class="col">
                    <?php
                    echo "<a class='nav-link'>".$nombre."</a>";
                    ?>
                  </div>
                </ul>
        </div>
        <div id="Leaderboard" class="row">
            <div class=".overflow-auto" id="section1">
              <label>Tabla general</label>
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>Usuario</th>
                    <th>Calificación</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Jugador Epsilon</td>
                    <td>5000</td>
                  </tr>
                  <tr>
                    <td>Jugador Epsilon</td>
                    <td>5000</td>
                  </tr>
                  <tr>
                    <td>Jugador Epsilon</td>
                    <td>5000</td>
                  </tr>
                  <tr>
                    <td>Jugador Epsilon</td>
                    <td>5000</td>
                  </tr>
                  <tr>
                    <td>Jugador Epsilon</td>
                    <td>5000</td>
                  </tr>
                  <tr>
                    <td>Jugador Epsilon</td>
                    <td>5000</td>
                  </tr>
                  <tr>
                    <td>Jugador Epsilon</td>
                    <td>5000</td>
                  </tr>
                  <tr>
                    <td>Jugador Epsilon</td>
                    <td>5000</td>
                  </tr>
                  <tr>
                    <td>Jugador Epsilon</td>
                    <td>5000</td>
                  </tr>
                </tbody>
              </table>
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