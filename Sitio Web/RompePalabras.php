<?php
session_start();
$nombre = $_SESSION['usernama'];
?>
<html>
    <head>
        <title>
            ¡Rompe Palabras!
        </title>
        <meta charset='utf-8'>
        <link rel='stylesheet' href='RompePalabras.css'>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
        <meta name= "viewport" content="width=device-width, initial-scale=1">
        <link href='https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=VT323&display=swap' rel='stylesheet'>
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
        <div id='Contenido'>
            <div id='RompePalabras' class="row">
                <img src='Rompe Palabras.png'>
            </div>
            <div id='RpPl' class="row">
              ROMPE PALABRAS
            </div>
            <div id='Triv1' class="row">
              El juego de trivia Nª1 del mundo!
            </div>
            <div id='Descargas' class="container">
              <div id="D1" class="row">
                Descarga ahora!
              </div>
              <div id='D2' class="row">
                <a href='http://www.google.com/search?q=demo' target='_blank'>PC & MAC</a>
              </div>
            </div>
        </div>
      </div>
    </body>
</html>