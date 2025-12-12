<?php
require 'conexion.php';


if(
    !empty($_POST['nombre']) && 
    !empty($_POST['correo']) && 
    !empty($_POST['edad']) &&
    !empty($_POST['estado_civil']) &&
    !empty($_POST['telefono']) &&
    !empty($_POST['direccion'])
){
    $nombre = trim($_POST['nombre']);
    $correo = trim($_POST['correo']);
    $edad = intval($_POST['edad']);
    $estado_civil = trim($_POST['estado_civil']); 
    $telefono = trim($_POST['telefono']);
    $direccion = trim($_POST['direccion']);

    // Consulta SQL segura usando prepare
    $sql = "INSERT INTO usuarios (nombre, correo, edad, estado_civil, telefono, direccion) 
            VALUES (:nombre, :correo, :edad, :estado_civil, :telefono, :direccion)";

    $stmt = $pdo->prepare($sql);

    $stmt->bindParam(':nombre', $nombre);
    $stmt->bindParam(':correo', $correo);
    $stmt->bindParam(':edad', $edad);
    $stmt->bindParam(':estado_civil', $estado_civil); 
    $stmt->bindParam(':telefono', $telefono);
    $stmt->bindParam(':direccion', $direccion);

    if($stmt->execute()){
        echo "Datos Guardados Correctamente";
    } else {
        echo "Error al Guardar.";
    }

} else {
    echo "Por Favor complete todos los campos";
}
?>
