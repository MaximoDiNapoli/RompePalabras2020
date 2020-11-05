<?php
session_start();
$nombre=$_SESSION['usernama'];
?>
<html>
    <head>
        <title>
            ¡Rompe Palabras! Preguntas mas frecuentes
        </title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="RompePalabras4.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=VT323&display=swap" rel="stylesheet">
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
        <div id="Titulo" class="row">Preguntas Más Frecuentes</div>
        <div class="row">
            <div id="P1" class="col-sm-6">
                <p>P: ¿Es el juego completamente gratis?</p>
                <p>R: El juego es gratuito y sin microtransacciones por el momento. Hay planes para añadirle cosméticos pagos.</p>
            </div>
            <div id="R1" class="col-sm-6">
                $$$
            </div>
        </div>
        <div class="row">
            <div id="P2" class="col-sm-6">
                <p>P: ¿Cuál es el sistema de puntuación?</p>
                <p>R: Se utiliza un sistema de ELO. Mientras más victorias consecutivas tengas, más alto sera tu ELO, pero si pierdes mucho, bajará considerablemente.</p>
            </div>
            <div id="R2" class="col-sm-6">
                ELO: 1500
            </div>
        </div>
        <div class="row">
            <div id="P3" class="col-sm-6">
                <p>P: ¿Qué puedo hacer si me olvido de mi contraseña de usuario?</p>
                <p>R: Presiona en el juego el link en "Olvide mi contraseña" y te enviaran un codigo de verificacion para una contraseña nueva.</p>
            </div>
            <div id="R3" class="col-sm-6">
                ???
            </div>
        </div>
        <div class="row">
            <div id="P4" class="col-sm-6">
                <p>P: Los servidores se llenaron ¿Por qué es eso?</p>
                <p>R: En horarios picos a veces la masiva cantidad de jugadores saturan el servidor por lo que se te pondrá en una cola de espera para cuando haya lugar disponible, si adquieres algún cosmético irás a una cola de alta prioridad mucho más rápida</p>
            </div>
            <div id="R4" class="col-sm-6">
                ¡Servidor lleno!
            </div>
        </div>
        <div class="row">
            <div id="P5" class="col-sm-6">
                <p>P: ¿Cuáles son los requisitos para jugarlo?</p>
                <p>R: Recomendamos mínimo tener 4 GB de RAM
                    400 megas de espacio libre en el disco, 
                    I3 6300 o similar, 
                    tarjeta grafica con 1 GB VRAM 
                    aunque lo óptimo serian 16 GB de RAM, 
                    1 GB de espacio libre en el disco, 
                    I7 7300 o similar y 
                    tarjeta gráfica con 4 GB de VRAM
                </p>    
            </div>
            <div id="R5" class="col-sm-6">
                <img src="lapece.png" width="400px" height="300px">
            </div>
        </div>
    </body>
</html>