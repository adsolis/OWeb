function vacio(q) {
    var i;
    for (i = 0; i < q.length; i++) {
        if (q.charAt(i) != " ") {
            return true;
        }
    }
    return false;
}

function validaNumero(numero) {
    var i;
    Numeros = '0123456789';
    for(i = 0; i < numero.value.length; i++) {
        if (Numeros.indexOf(numero.value.charAt(i),0) == -1) {
            return false;
        }
    }
    return true;
}

function valida(F) {
    
    if (vacio(F.folio1.value) == false) {
        alert("El campo Folio debe tener valor");
        F.folio1.focus();
        return false;
    }

    if (vacio(F.folio2.value) == false) {
        alert("El campo Confirmar Folio debe tener valor");
        F.folio2.focus();
        return false;
    }
	
    if (F.folio1.value.length > 9) {
        alert("La longitud del campo Folio es de 9");
        F.folio1.focus();
        return false;
    }
	
    if (F.folio2.value.length > 9) {
        alert("La longitud del campo Confirmar Folio es de 9");
        F.folio2.focus();
        return false;
    }

    if (validaNumero(F.folio1) == false) {
        alert("El Valor del campo Folio debe ser un numero");
        F.folio1.focus();
        return false;
    }

    if (validaNumero(F.folio2) == false) {
        alert("El Valor del campo Confirmar Folio debe ser un numero");
        F.folio2.focus();
        return false;
    }
    if(F.numClave.value=='true'){
        if(vacio(F.claveFol.value)==false){
        alert("El campo Clave del Folio debe tener valor");
        F.claveFol.focus();
        return false;
        }
    }
    
    if (F.folio1.value == F.folio2.value) {
        return true;
    } else {
        alert("Los campos Folio y Confirmar Folio no coinciden");
        F.folio1.focus();
        return false;
    }
}

function getCredito() {
    tipoCredito.descCred.value = tipoCredito.tipoCred.options[tipoCredito.tipoCred.selectedIndex].text; 
}

function validaSel(F) {
    if (F.tipoCred.value == "0") {
        alert("Debe de seleccionar una opción");
        F.tipoCred.focus();
        return false;
    } else {
        return true;
    }
}

function enviar() {
    window.open("mostrar.jsp", "width= 300 ,height= 400 ");
}


function parpadear() {
    with (document.getElementById("parpadeo").style)
        visibility = (visibility == "visible") ? "hidden" : "visible";
}

function doPrint() {
    if (window.print) {
        window.print();
    }
}


var statSend = false;
function checkSubmit() {
    if (!statSend) {
        statSend = true;
        return true;
    } else {
        alert("El formulario ya se esta enviando...");
        return false;
    }
} 

function popupload(){
        var f=document.createElement("form");
        //f.target="_blank";
        f.method="GET";
        f.action="/ventanaAuxiliar.htm";
        document.body.appendChild(f);
        
        var map= window.open("ventanaAuxiliar.htm", "_blank", "scrollbars=1,width=770,height=600");
        
        if(map){
                f.submit();

        }else{
           alert("OK");
        }
//    window.open("vistaAgenciasAseguradoras.jsp", this.target, 'width=770,height=600');


}