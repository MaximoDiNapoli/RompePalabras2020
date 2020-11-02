<?php
session_start();
$nombre=$_POST["usernamer"];
$mail=$_POST["mailer"];
if(empty($nombre) || empty($email)){
    header("Location: CrearCuenta.html");
    exit();
}
$_SESSION["usernama"] = $nombre;
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, "http://127.0.0.1:4567/Usuarios");
curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($curl, CURLOPT_POST, true);
$data = [
    'username' => $nombre,
    'email' => $mail
];
curl_setopt($curl, CURLOPT_POSTFIELDS, $data);
$response = curl_exec($curl);
curl_close($curl);
header("Location: RompePalabras.html");
?>