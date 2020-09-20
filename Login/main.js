const validar = () => {
    var user = document.getElementById("usuario").value;
    var password = document.getElementById("passwor").value;	
    if(user == "pelele" && password == "1234"){
        alert("Usuario y Contraseña validos");
    }
    else{
        alert("Usuario y Contraseña invalidos");
    }
}