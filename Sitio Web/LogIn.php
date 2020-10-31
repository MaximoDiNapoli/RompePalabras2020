<?php
$usuario = $_POST['username'];
$mail = $_POST['email'];
if(empty($usuario) || empty($mail)){
header("Location: LogIn.html");
exit();
}
$nombre=$_POST["user"];
$mail=$_POST["email"];
$data = json_encon(array(
    'username' => $nombre,
    'email' => $mail
));
?>