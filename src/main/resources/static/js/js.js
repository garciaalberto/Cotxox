
function requestCar(){
    if (document.getElementById("origen").value !== "" && document.getElementById("destino").value !== ""){
        document.getElementById("requestcar").style.display = "none";
        document.getElementById("acceptPayment").style.display = "block";
    } else {
        alert("Por favor, introduce un Origen/Destino para la carrera");
    }
}