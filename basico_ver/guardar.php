<?php
require 'conexion.php';
//Validar que existan los datos
if(!empty($_POST['nombre']) && !empty($_POST['correo']) && !empty($_POST['edad'])){
    $nombre = trim($_POST['nombre']);
    $correo = trim($_POST['correo']);
    $edad = intval($_POST['nombre']);
    //Consulta SQL segura usando prepare
    $sql = "INSERT INTO usuarios (nombre,correo,edad) VALUES (:nombre, :correo, :edad)";
    $stmt = $pdo->prepare($sql);

    $stmt->bindParam(':nombre',$nombre);
    $stmt->bindParam(':correo',$correo);
     $stmt->bindParam(':edad',$edad);

     if($stmt->execute()){
        echo "Datos Guardados Correctamente";
     }else{
        echo"Error al Guardar.";
     }

}else{
    echo"Por Favor complete todos los campos";
}
?>