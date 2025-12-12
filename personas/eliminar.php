<?php
require 'conexion.php';

if(!empty($_GET['id'])){
    $id = intval($_GET['id']);
    $sql = "DELETE FROM usuarios WHERE id=:id";
    $stmt = $pdo->prepare($sql);
    $stmt->bindParam(':id', $id);
    $stmt->execute();
}

header("Location: mostrar.php");
?>
