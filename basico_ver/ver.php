<?php
require 'conexion.php';

//Obtener todos los registros 
$sql =  "SELECT * FROM usuarios ORDER BY id DESC";
$stmt = $pdo->prepare($sql);
$stmt->execute();

$usuarios = $stmt->fetchALL(PDO::FETCH_ASSOC);

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Usuarios</title>
</head>
<body>
    <h2>Regsitros Guardados</h2>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Correo</th>
            <th>Edad</th>
</tr>
<?php foreach($usuarios as $u): ?>
    <tr>
        <td><?php echo $u['id'];?></td>
        <td><?php echo $u['nombre'];?></td>
        <td><?php echo $u['correo'];?></td>
        <td><?php echo $u['edad'];?></td>
</tr>
<?php endforeach; ?>
</table>
<br>
<a href="index.html">Volver</a>
</body>
</html>