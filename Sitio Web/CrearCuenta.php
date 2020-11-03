<?php
session_start();
$nombre=$_POST["usernamer"];
$mail=$_POST["mailer"];
$_SESSION["usernama"] = $nombre;
if(empty($nombre) || empty($mail)){
    header("Location: CrearCuenta.html");
    exit();
}
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, "http://127.0.0.1:4567/AgregarUsuario");
curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($curl, CURLOPT_POST, true);
$data = [
    'username' => $nombre,
    'email' => $mail
];
curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: text/plain'));
curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($data));
$response = curl_exec($curl);
curl_close($curl);
header("Location: RompePalabras.php");
?>