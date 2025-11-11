document.getElementById("calcularBtn").addEventListener("click", function() {
    // Obtener los valores de los precios
    var precio1 = parseInt(document.getElementById("precio1").value) || 0;
    var precio2 = parseInt(document.getElementById("precio2").value) || 0;
    var precio3 = parseInt(document.getElementById("precio3").value) || 0;
    var precio4 = parseInt(document.getElementById("precio4").value) || 0;
    var precio5 = parseInt(document.getElementById("precio5").value) || 0;

    // Calcular el total
    var total = precio1 + precio2 + precio3 + precio4 + precio5;

    // Obtener el pago del cliente
    var pago = parseInt(document.getElementById("pagoCliente").value) || 0;

    // Condicional
    if (pago >= total) {
        var cambio = pago - total;
        alert(
            "El total de la compra es: " + total +
            "\nEl pago del cliente es: " + pago +
            "\nEl cambio es: " + cambio
        );
    } else {
        alert(
            "El total de la compra es: " + total +
            "\nEl pago del cliente es: " + pago +
            "\nFalta dinero para completar la compra."
        );
    }
});
