<?php
session_start();
$nombre=$_SESSION['usernama'];
?>
<html>
    <head>
        <title>
            ¡Rompe Palabras! ¿Cómo Juego?
        </title>
        <meta charset="utf-8">
        <link rel='stylesheet' href='RompePalabras2.css'>
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
        <div id='Como' class="row">
        Como Jugar:
        </div>
        <div class="row">
            <div id='CJ1' class="col-sm-6">
                El objetivo principal es conseguir puntos.
            </div>
            <div id='Add1' class="col-sm-6">
                +10000!
            </div>
        </div>
        <div class="row">
            <div id='CJ2' class="col-sm-6">
                La unica manera de conseguir puntos es responiendo correctamente a preguntas con las palabras en pantalla.
            </div>
            <div id='Add2' class="col-sm-6">
                <img src="ExampleDos.png">
            </div> 
        </div>
        <div class="row">
            <div id='CJ3' class="col-sm-6">
                Si respondes incorrectamente, perderas puntos.
            </div>
            <div id='Add3' class="col-sm-6">
                -1000!
            </div>
        </div>
        <div class="row">
            <div id='CJ4' class="col-sm-6">
                Una vez que respondes correctamente la palabra desaparece, si limpias la pantalla de palabras, conseguiras un bonus masivo.
            </div>
            <div id='Add4' class="col-sm-6">
                <img src="Example.png">
            </div>
        </div>
    </body>
</html>
