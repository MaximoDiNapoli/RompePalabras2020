<?php
session_start();
$nombre=$_POST["usernamer"];
$mail=$_POST["mailer"];
if(empty($nombre) || empty($mail)){
    header("Location: LogIn.html");
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
$_SESSION["usernama"] = $nombre;
$response = curl_exec($curl);
if ($response == "false"):
    header("Location: LogIn.html");
else:
    header("Location: RompePalabras.php");
endif;
curl_close($curl);
?>