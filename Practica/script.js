const btnPagar = document.getElementById("btnPagar");
const modal = document.getElementById("modalTotal");
const cerrarModal = document.getElementById("cerrarModal");
const aceptar=document.getElementById("aceptar");
const resultado=document.getElementById("resultado");
const pagoInput = document.getElementById("pago");
const cambio=document.getElementById("cambio");
const btnCobrar=document.getElementById("btnCobrar");
let total=0;
btnPagar.addEventListener("click",()=>{
const p1=parseFloat(document.getElementById("producto1").value) || 0;
const p2=parseFloat(document.getElementById("producto2").value) || 0;
const p3=parseFloat(document.getElementById("producto3").value) || 0;
 total=p1+p2+p3;
 if(total<=0){
    alert("Por favor ingrese precios validos");
    return;
 }
 resultado.textContent=`El total a pagar es: $${total.toFixed(2)} MXN`;

 cambio.textContent="";
pagoInput.value="";
 modal.style.display="flex";
});
btnCobrar.addEventListener("click",()=>{
    const pago=parseFloat(pagoInput.value);
    if(isNaN(pago) || pago<=0){
        cambio.textContent="Ingrese un monto valido";
        cambio.style.color="red";
        return;
    }
    if(pago<total){
        cambio.textContent="El monto es insuficiente";
        cambio.style.color="red";
        return;
    }else{
        const vuelto=pago-total;
        cambio.textContent=`Su cambio es: $${vuelto.toFixed(2)} MXN`;
        cambio.style.color="green";
    }
});
cerrarModal.addEventListener("click",()=>
    modal.style.display="none");
aceptar.addEventListener("click",()=>
    modal.style.display="none");
window.addEventListener("click",(e)=>{
    if(e.target===modal){
        modal.style.display="none";
    }
});

