<?php
$usuario = $_POST['nombre'];
$pass = $_POST['passwor'];
 
if(empty($usuario) || empty($pass)){
header("Location: LogIn.html");
exit();
}
echo "did this";
$conexion=mysqli_connect("localhost","root","alumnoipm","RP");
if (!$conexion) {
    die('Error de conexión: ' . mysqli_connect_error());
}
echo "conecto";
$result = mysqli_query($conexion,"SELECT * from Usuarios where NombreUsuario='$usuario'")or die("Error: ".mysqli_error($conexion));;
echo "agarro";
if($row = mysqli_fetch_array($result)){
    echo "entro if 1";
    if($row['ContrasenaUsuario'] == $pass){
        echo "entro if 2";
        session_start();
        $_SESSION['NombreUsuario'] = $usuario;
        $_SESSION['sesion'] = $row['idUsuarios'];
        echo "llego";
        header("Location: RompePalabras.php");
    }
    else{
        echo "entro else 1";
        header("Location: LogIn.html");
        exit();
    }
}
else{
    echo "entro else2";
    header("Location: CrearCuenta.html");
    exit();
}
//session_start();
//$nombre=$_GET["nombre"];
//$contra=$_GET["passwor"];
//$conexion=mysqli_connect("localhost","root","alumnoipm","RP");
//$idUsuario=mysqli_query($conexion,"SELECT idUsuarios as idsito FROM RP.Usuarios WHERE NombreUsuario = '$nombre' AND ContrasenaUsuario = '$contra'")or die("Error: ".mysqli_error($conexion));
//$datos=mysqli_query($conexion,"SELECT ALL FROM RP.Usuarios WHERE NombreUsuario = '$nombre' AND ContrasenaUsuario = '$contra'")or die("Error: ".mysqli_error($conexion));
//if (!$conexion) {
//    die('Error de conexión: ' . mysqli_connect_error());
//}
//else if ($idUsuario){
//    echo "OK";
//    header('Location: RompePalabras.php');
//}
?>