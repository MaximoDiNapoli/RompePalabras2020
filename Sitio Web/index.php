<?php
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "http://127.0.0.1:4567/Usuarios");
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_POST, true);
$data = array(
    'username' => 'dedodododedadada',
    'email' => 'calamities@gmail.com',
);
curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
$output = curl_exec($ch);
$info = curl_getinfo($ch);
curl_close($ch);
?>