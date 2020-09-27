<?php
session_start();
$nombre=$_SESSION['NombreUsuario'];
?>
<html>
<head>
    <title>
        ¡Rompe Palabras! ¿Cómo Juego?
    </title>
    <meta charset='utf-8'>
    <link rel='stylesheet' href='RompePalabras2.css'>
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
    <div id='Como'>
        <h1> Como Jugar</h1>
    </div>
    <div id='CJ1'>
        <p>El objetivo principal es conseguir puntos.</p>
    </div>
    <div id='Add1'>
        10000!
    </div>
    <div id='CJ2'>
        <p>La unica manera de conseguir puntos es responiendo correctamente a preguntas con las palabras en pantalla.</p>
    </div>
    <div id='Add2'>
        <p style='font-size: 145%'> ¿Cuándo cayó el muro de Berlín?</p>
        <img src='Cruz.png' style='width: 8%; height: 17%;'>
        <img src='nada.png' style='width:10px; height:40px;'>
        <img src='Cruz.png' style='width: 8%; height: 17%;'>
        <img src='nada.png' style='width:10px; height:40px;'>
        <img src='Tick.png' style='width: 8%; height: 17%;'>
        <p style='font-size: 165%;'>Pangea    Rojo     1989</p>
    </div>
    <div id='CJ3'>
        <p>Si respondes incorrectamente, perderas puntos.</p>
    </div>
    <div id='Add3'>
        <p>-1000!</p>
    </div>
    <div id='CJ4'>
        <p>Una vez que respondes correctamente la palabra desaparece, si limpias la pantalla de palabras, conseguiras un bonus masivo.</p>
    </div>
    <div id='Add4'>
        <p style='margin-left: 27%;'>Paleta</p>
        <p style='font-size: 250%;'>1000000!</p>
        <p style='margin-top: 3%;'>Bufanda</p>
        <p style='margin-top: 3%; margin-left: 65%;'>Twitter</p>
    </div>
</body>
</html>
