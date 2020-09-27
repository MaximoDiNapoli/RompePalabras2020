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
    <link rel='stylesheet' href='RompePalabras4.css'>
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
    <h1 style='color: rgb(255, 251, 0);font-family: 'Press Start 2P', cursive;margin-left: 250px;'> Preguntas Más Frecuentes</h1>
    <div id='P1'>
        <p>P: ¿Es el juego completamente gratis?</p>
        <p>R: El juego es gratis, pero para poder conseguir una ganancia para mantener el juego online hemos añadido microtransacciones cosmeticas.</p>
    </div>
    <div id='R1'>
        $$$
    </div>
    <div id='P2'>
        <p>P: ¿Se te guarda el progreso?</p>
        <p>R: Sí. Si sales del juego mediante el menu, tu progreso se guardara, de lo contrario perderas el progreso de la partida actual y tendras que empezar de nuevo.</p>
    </div>
    <div id='R2'>
        QUIT
    </div>
    <div id='P3'>
        <p>P: ¿Qué puedo hacer si me olvido de mi contraseña de usuario?</p>
        <p>R: Presiona en el juego el link en 'Olvide mi contraseña' y te enviaran un codigo de verificacion para una contraseña nueva.</p>
    </div>
    <div id='R3'>
        ???
    </div>
    <div id='P4'>
        <p>P: Los servidores se llenaron ¿Por qué es eso?</p>
        <p>R: En horarios picos a veces la masiva cantidad de jugadores saturan el servidor por lo que se te pondrá en una cola de espera para cuando haya lugar disponible, si adquieres algún cosmético irás a una cola de alta prioridad mucho más rápida</p>
    </div>
    <div id='R4'>
        ¡Servidor lleno!
    </div>
    <div id='P5'>
        <p>P: ¿Cuáles son los requisitos para jugarlo?</p>
        <p>R: Recomendamos mínimo tener 4 GB de RAM
            400 megas de espacio libre en el disco
            I3 6300 o similar 
            Tarjeta grafica con 1 GB VRAM 
            Aunque lo óptimo serian 16 GB de RAM
            1 GB de espacio libre en el disco
            I7 7300 o similar
            Tarjeta gráfica con 4 GB de VRAM
        </p>    
    </div>
    <div  id='R5'>
        <img src='lapece.png' width='400px' height='300px'>
    </div>
</body>
</html>