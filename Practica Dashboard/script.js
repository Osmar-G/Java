function cargar(seccion) {
    const titulo = document.getElementById("titulo");
    const contenido = document.getElementById("contenido");

    // ---------- INICIO ----------
    if (seccion === "home") {
        titulo.textContent = "Inicio";
        contenido.innerHTML = `
            <div class="cards">

                <div class="card">
                    <img src="img/user.jpg" class="icon">
                    <h3>Usuarios</h3>
                    <p>24</p>
                </div>

                <div class="card">
                    <img src="img/sales.jpg" class="icon">
                    <h3>Ventas</h3>
                    <p>156</p>
                </div>

                <div class="card">
                    <img src="img/alert.jpg" class="icon">
                    <h3>Alertas</h3>
                    <p>3</p>
                </div>

            </div>
        `;
    }
    // ---------- USUARIOS ----------
    if (seccion === "usuarios") {
        titulo.textContent = "Usuarios";
        contenido.innerHTML = `
            <h2>Lista de Usuarios</h2>
            <ul>
                <li>Juan Pérez</li>
                <li>María López</li>
                <li>Carlos Díaz</li>
            </ul>
        `;
    }

    // ---------- REPORTES ----------
    if (seccion === "reportes") {
        titulo.textContent = "Reportes";
        contenido.innerHTML = `
            <h2>Reportes del Sistema</h2>
            <img src="img/sales.jpg" width="120">
            <p>Gráficas e informes próximamente.</p>
        `;
    }

    // ---------- CONFIGURACIÓN ----------
    if (seccion === "config") {
        titulo.textContent = "Configuración";
        contenido.innerHTML = `
            <h2>Opciones del Sistema</h2>
            <p>Ajustes generales y preferencias del usuario.</p>
        `;
    }
}