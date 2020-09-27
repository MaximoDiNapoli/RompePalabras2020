<?php
    session_start();
    $nombre=$_POST["nombre"];
    $edad=$_POST["edad"];
    $pais=$_POST["pais"];
    $ciudad=$_POST["ciudad"];
    $contra=$_POST["passwor"];
    $conexion=mysqli_connect("localhost","root","alumnoipm","RP");
    if (!$conexion) {
        die('Error de conexión: ' . mysqli_connect_error());
    }
    $var = mysqli_query($conexion,"SELECT NombreUsuario FROM Usuarios;")or die("Error: ".mysqli_error($conexion));
    while($nombre == $var){
        echo "Nombre ocupado, ingrese otro nombre";
        $nombre=$_POST["nombre"];
    }
    mysqli_query($conexion,"INSERT INTO CarritoDeCompra(idCarrito,CantProductos,PrecioTotalProductos) values(null,0,0);")or die("Error: ".mysqli_error($conexion));
    $Carrito=mysqli_query($conexion,"SELECT max(idCarrito) as nroCarrito FROM CarritoDeCompra;")or die("Error: ".mysqli_error($conexion));
    $fila = mysqli_fetch_assoc($Carrito);
    $id = $fila['nroCarrito'];
    mysqli_query($conexion,"INSERT INTO Usuarios(idUsuarios, NombreUsuario, ContrasenaUsuario, EdadUsuario, CiudadUsuario, PaisUsuario, CarritoDeCompra_idCarrito) 
    values(null,'$nombre','$contra','$edad','$pais','$ciudad','$id');")or die("Error: ".mysqli_error($conexion));
    header('Location: RompePalabras.html');
?>