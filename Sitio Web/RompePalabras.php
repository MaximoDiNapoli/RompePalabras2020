<?php
session_start();
$nombre=$_SESSION['NombreUsuario'];
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
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href='https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap' rel='stylesheet'>
    <link href='https://fonts.googleapis.com/css?family=VT323&display=swap' rel='stylesheet'>
</head>
<body>
    <div id='Pestañas'>
        <ul>
            <a href='RompePalabras.php'>Juego</a>
            <a href='RompePalabras2.php'>Como Jugar</a>
            <a href='RompePalabras3.php'>Merch</a>
            <a href='RompePalabras4.php'>PMF</a>
            <?php
            echo"<a>".$nombre."</a>";
            ?>
        </ul>
    </div>
    <div id='Contenido'>
        <div id='RompePalabras'>
            <img src='Rompe Palabras.png' style='width:300px; height:300px;''>
        </div>
        <div id='RpPl'>
        <h1>
            ROMPE PALABRAS
        </h1>
        </div>
        <div id='Triv1'>
        <h2>
                El juego de trivia Nª1 del mundo!
        </h2>
        </div>
        <div id='Descargas' style='margin: auto; width: 70%; border: 3px solid black; padding: 10px;''>
            <h3 style='text-align: center;'>Descarga ahora!</h3>
            <div id='Downloads'>
                <ul>
            <a id='yes' href='http://www.google.com/search?q=demo' target='_blank'>
            PC & MAC
            </a>
            <a href='http://www.google.com/search?q=demo' target='_blank'>
            <img src='ps_store.png' style='width: 25%; height: 12%'></a>
            <a href='http://www.google.com/search?q=demo' target='_blank'>
            <img src='google.png' style='width: 25%; height: 12%'></a>
            <a href='http://www.google.com/search?q=demo' target='_blank'>
            <img src='switch.png' style='width: 12%; height: 15%'>
            </a>
        </ul>
            </div>
        </div>
        <div id='YT'> 
            <iframe width='420' height='315'
            src='https://www.youtube.com/embed/fc6N1vSo-SU'>
            </iframe> 
        </div>
        <div id='Derechos'>
            <p>
                    Nintendo Switch is a trademark of Nintendo. Google Play is a registered logo of Google LLC. IOS is a registered trademark of Apple INC.
            </p>
        </div>
        <div id='Condiciones'>
            <a href='http://www.google.com/search?q=demo' target='_blank' style='color: rgb(0, 0, 0)';>
                Terminos y Condiciones
            </a>
        </div>
    </div>
</body>
</html>";
?>