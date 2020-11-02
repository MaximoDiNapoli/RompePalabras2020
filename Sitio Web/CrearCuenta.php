<?php
session_start();
$nombre=$_POST["username"];
$mail=$_POST["mail"];
if(empty($nombre) || empty($email)){
    header("Location: CrearCuenta.html");
    exit();
    }
$data = [
    'username' => $nombre,
    'email' => $mail
];
echo "entro data";
$url = "http://127.0.0.1:4567/Usuarios";
$curl = curl_init();
echo "inicio curl";
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_POST, true);
curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($data));
curl_setopt($curl, CURLOPT_HTTPHEADER, [
    'Content-Type: application/json'
  ]);
echo "todo correcto";
$response = curl_exec($curl);
curl_close($curl);
header("Location: RompePalabras.html");
?>