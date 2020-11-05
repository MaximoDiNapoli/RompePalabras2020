<?php
session_start();
$nombre=$_POST["usernamer"];
$mail=$_POST["mailer"];
if(empty($nombre) || empty($mail)){
    header("Location: CrearCuenta.html");
    exit();
}
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, "http://127.0.0.1:4567/comprobarExistenciaDeUnUsuario");
curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($curl, CURLOPT_POST, true);
$data = [
    'username' => $nombre,
    'email' => $mail
];
curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: text/plain'));
curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($data));
$response = curl_exec($curl);
if ($response == "true") {
    header("Location: CrearCuenta.html");
}
else {
    curl_close($curl);
    $curl = curl_init();
    curl_setopt($curl, CURLOPT_URL, "http://127.0.0.1:4567/AgregarUsuario");
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($curl, CURLOPT_POST, true);
    curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: text/plain'));
    curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($data));
    $response = curl_exec($curl);
    $_SESSION["usernama"] = $nombre;
    header("Location: RompePalabras.php");
}
curl_close($curl);
?>