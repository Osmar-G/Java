<?php
require 'conexion.php';

// Obtener todos los registros
$sql = "SELECT * FROM usuarios ORDER BY id DESC";
$stmt = $pdo->prepare($sql);
$stmt->execute();

$usuarios = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" href="style.css">
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        a.button { padding: 5px 10px; border-radius: 4px; text-decoration: none; color: white; margin-right: 5px; }
        a.edit { background-color: #2196F3; }
        a.delete { background-color: #f44336; }
        a.button:hover { opacity: 0.9; }
        .volver { display: inline-block; margin-top: 20px; padding: 8px 15px; background-color: #555; color: white; text-decoration: none; border-radius: 4px; }
        .volver:hover { opacity: 0.9; }
    </style>
</head>
<body>
    <h2>Registros Guardados</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Correo</th>
            <th>Edad</th>
            <th>Estado Civil</th>
            <th>Teléfono</th>
            <th>Dirección</th>
            <th>Acciones</th>
        </tr>
        <?php foreach($usuarios as $u): ?>
        <tr>
            <td><?php echo $u['id']; ?></td>
            <td><?php echo $u['nombre']; ?></td>
            <td><?php echo $u['correo']; ?></td>
            <td><?php echo $u['edad']; ?></td>
            <td><?php echo $u['estado_civil']; ?></td>
            <td><?php echo $u['telefono']; ?></td>
            <td><?php echo $u['direccion']; ?></td>
            <td>
                <a class="button edit" href="editar.php?id=<?php echo $u['id']; ?>">Editar</a>
                <a class="button delete" href="eliminar.php?id=<?php echo $u['id']; ?>" onclick="return confirm('¿Desea eliminar este registro?');">Eliminar</a>
            </td>
        </tr>
        <?php endforeach; ?>
    </table>
    <a class="volver" href="index.html">Volver al Formulario</a>
</body>
</html>
