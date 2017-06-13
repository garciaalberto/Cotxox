
function requestCar(){
    if (document.getElementById("origen").value !== "" && document.getElementById("destino").value !== ""){
        document.getElementById("requestcar").style.display = "none";
        document.getElementById("acceptPayment").style.display = "block";
    } else {
        document.getElementById("alerta").style.display = "block";
    }
}

function acceptPayment(){
        document.getElementById("acceptPayment").style.display = "none";
        document.getElementById("ride").style.display = "block";
}

function ride(){
        document.getElementById("mapa").style.display = "none";
        document.getElementById("ride").style.display = "none";
        document.getElementById("payment").style.display = "block";
}

function rate(){
        document.getElementById("payment").style.display = "none";
        document.getElementById("rate").style.display = "block";
}