<?php
require 'conexion.php';

if(!empty($_GET['id'])){
    $id = intval($_GET['id']);

    // Guardar cambios
    if(!empty($_POST)){
        $sql = "UPDATE usuarios SET nombre=:nombre, correo=:correo, edad=:edad, estado_civil=:estado_civil, telefono=:telefono, direccion=:direccion WHERE id=:id";
        $stmt = $pdo->prepare($sql);
        $stmt->bindParam(':nombre', $_POST['nombre']);
        $stmt->bindParam(':correo', $_POST['correo']);
        $stmt->bindParam(':edad', $_POST['edad']);
        $stmt->bindParam(':estado_civil', $_POST['estado_civil']);
        $stmt->bindParam(':telefono', $_POST['telefono']);
        $stmt->bindParam(':direccion', $_POST['direccion']);
        $stmt->bindParam(':id', $id);
        $stmt->execute();
        header("Location: mostrar.php");
    }

    // Obtener datos actuales
    $sql = "SELECT * FROM usuarios WHERE id=:id";
    $stmt = $pdo->prepare($sql);
    $stmt->bindParam(':id', $id);
    $stmt->execute();
    $usuario = $stmt->fetch(PDO::FETCH_ASSOC);
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h2>Editar Usuario</h2>
    <?php if($usuario): ?>
    <form action="" method="POST">
        <label>Nombre:</label><br>
        <input type="text" name="nombre" value="<?php echo $usuario['nombre']; ?>" required><br><br>

        <label>Correo:</label><br>
        <input type="email" name="correo" value="<?php echo $usuario['correo']; ?>" required><br><br>

        <label>Edad:</label><br>
        <input type="number" name="edad" value="<?php echo $usuario['edad']; ?>" required><br><br>

        <label>Estado Civil:</label><br>
        <select name="estado_civil" required>
            <option value="Soltero" <?php if($usuario['estado_civil']=='Soltero') echo 'selected'; ?>>Soltero</option>
            <option value="Casado" <?php if($usuario['estado_civil']=='Casado') echo 'selected'; ?>>Casado</option>
            <option value="Divorciado" <?php if($usuario['estado_civil']=='Divorciado') echo 'selected'; ?>>Divorciado</option>
            <option value="Viudo" <?php if($usuario['estado_civil']=='Viudo') echo 'selected'; ?>>Viudo</option>
        </select><br><br>

        <label>Teléfono:</label><br>
        <input type="text" name="telefono" value="<?php echo $usuario['telefono']; ?>" required><br><br>

        <label>Dirección:</label><br>
        <input type="text" name="direccion" value="<?php echo $usuario['direccion']; ?>" required><br><br>

        <button type="submit">Guardar Cambios</button>
    </form>
    <?php else: ?>
        <p>Usuario no encontrado</p>
    <?php endif; ?>
    <br>
    <a href="mostrar.php">Volver a la Lista</a>
</body>
</html>
