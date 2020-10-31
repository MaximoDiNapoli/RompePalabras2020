<?php
$nombre=$_POST["user"];
$mail=$_POST["email"];
echo $mail;
echo $nombre;
$data = [
    'username' => $nombre,
    'email' => $mail
];
echo "entro data";
$url = "http://127.0.0.1:4567";
$curl = curl_init($url);
echo "inicio curl";
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_POST, true);
curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($data));
echo "todo correcto";
?>