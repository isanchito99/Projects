var contador = 1
var contadorBrick = 1
var contadorSnake = 1
var contadorPong = 1

function genera_tablaBrick() {
    // Obtener la referencia del elemento body
    var body = document.getElementsByTagName("body")[0];

    // Crea un elemento <table> y un elemento <tbody>
    var tabla = document.createElement("table");
    var tblBody = document.createElement("tbody");

    // Crea las celdas
    for (var i = 0; i < 1; i++) {
        // Crea las hileras de la tabla
        var hilera = document.createElement("tr");
        var hilera2 = document.createElement("tr");

        for (var j = 1; j < 2; j++) {
            // Crea un elemento <td> y un nodo de texto, haz que el nodo de
            // texto sea el contenido de <td>, ubica el elemento <td> al final
            // de la hilera de la tabla
            var celdaTH = document.createElement("th");
            var celdaTH2 = document.createElement("th");
            var celdaNombre = document.createElement("td");
            var celdaNombre2 = document.createElement("td");
            var textoCeldaTH = document.createTextNode("Nombre de Usuario");
            var textoCeldaTH2 = document.createTextNode("Score de Usuario");
            var textoCelda = document.createTextNode(localStorage.getItem("NombreBrick" + contadorBrick));
            var textoCelda2 = document.createTextNode(localStorage.getItem("ScoreBrick" + contadorBrick));

            celdaTH.appendChild(textoCeldaTH);
            celdaTH2.appendChild(textoCeldaTH2);
            celdaNombre.appendChild(textoCelda);
            celdaNombre2.appendChild(textoCelda2);
            hilera2.appendChild(celdaTH);
            hilera2.appendChild(celdaTH2);
            hilera.appendChild(celdaNombre);
            hilera.appendChild(celdaNombre2);

        }

        // agrega la hilera al final de la tabla (al final del elemento tblbody)
        tblBody.appendChild(hilera2);
        tblBody.appendChild(hilera);

    }

    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    // appends <table> into <body>
    body.appendChild(tabla);
     contadorBrick++;
    // modifica el atributo "border" de la tabla y lo fija a "2";
    tabla.setAttribute("border", "2");
    tabla.setAttribute("id", "tablaBrick");
    tabla.setAttribute("class", "col-md-4");
}


function genera_tablaSnake() {
    // Obtener la referencia del elemento body
    var body = document.getElementsByTagName("body")[0];

    // Crea un elemento <table> y un elemento <tbody>
    var tabla = document.createElement("table");
    var tblBody = document.createElement("tbody");

    // Crea las celdas
    for (var i = 0; i < 1; i++) {
        // Crea las hileras de la tabla
        var hilera = document.createElement("tr");
        var hilera2 = document.createElement("tr");

        for (var j = 1; j < 2; j++) {
            // Crea un elemento <td> y un nodo de texto, haz que el nodo de
            // texto sea el contenido de <td>, ubica el elemento <td> al final
            // de la hilera de la tabla
            var celdaTH = document.createElement("th");
            var celdaTH2 = document.createElement("th");
            var celdaNombre = document.createElement("td");
            var celdaNombre2 = document.createElement("td");
            var textoCeldaTH = document.createTextNode("Nombre de Usuario");
            var textoCeldaTH2 = document.createTextNode("Score de Usuario");
            var textoCelda = document.createTextNode(localStorage.getItem("NombreSnake" + contadorSnake));
            var textoCelda2 = document.createTextNode(localStorage.getItem("ScoreSnake" + contadorSnake));

            celdaTH.appendChild(textoCeldaTH);
            celdaTH2.appendChild(textoCeldaTH2);
            celdaNombre.appendChild(textoCelda);
            celdaNombre2.appendChild(textoCelda2);
            hilera2.appendChild(celdaTH);
            hilera2.appendChild(celdaTH2);
            hilera.appendChild(celdaNombre);
            hilera.appendChild(celdaNombre2);

        }

        // agrega la hilera al final de la tabla (al final del elemento tblbody)
        tblBody.appendChild(hilera2);
        tblBody.appendChild(hilera);

    }

    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    // appends <table> into <body>
    body.appendChild(tabla);
    contadorSnake++;
    // modifica el atributo "border" de la tabla y lo fija a "2";
    tabla.setAttribute("border", "2");
    tabla.setAttribute("id", "tablaSnake");
    tabla.setAttribute("class", "col-md-4");
}

function genera_tablaPong() {
    // Obtener la referencia del elemento body
    var body = document.getElementsByTagName("body")[0];

    // Crea un elemento <table> y un elemento <tbody>
    var tabla = document.createElement("table");
    var tblBody = document.createElement("tbody");

    // Crea las celdas
    for (var i = 0; i < 1; i++) {
        // Crea las hileras de la tabla
        var hilera = document.createElement("tr");
        var hilera2 = document.createElement("tr");

        for (var j = 1; j < 2; j++) {
            // Crea un elemento <td> y un nodo de texto, haz que el nodo de
            // texto sea el contenido de <td>, ubica el elemento <td> al final
            // de la hilera de la tabla
            var celdaTH = document.createElement("th");
            var celdaTH2 = document.createElement("th");
            var celdaNombre = document.createElement("td");
            var celdaNombre2 = document.createElement("td");
            var textoCeldaTH = document.createTextNode("Nombre de Usuario");
            var textoCeldaTH2 = document.createTextNode("Score de Usuario");
            var textoCelda = document.createTextNode(localStorage.getItem("NombrePong" + contadorPong));
            var textoCelda2 = document.createTextNode(localStorage.getItem("ScorePong" + contadorPong));

            celdaTH.appendChild(textoCeldaTH);
            celdaTH2.appendChild(textoCeldaTH2);
            celdaNombre.appendChild(textoCelda);
            celdaNombre2.appendChild(textoCelda2);
            hilera2.appendChild(celdaTH);
            hilera2.appendChild(celdaTH2);
            hilera.appendChild(celdaNombre);
            hilera.appendChild(celdaNombre2);

        }

        // agrega la hilera al final de la tabla (al final del elemento tblbody)
        tblBody.appendChild(hilera2);
        tblBody.appendChild(hilera);
    }

    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    // appends <table> into <body>
    body.appendChild(tabla);
    contadorPong++;
    // modifica el atributo "border" de la tabla y lo fija a "2";
    tabla.setAttribute("border", "2");
    tabla.setAttribute("id", "tablaPong");
    tabla.setAttribute("class", "col-md-4");
}


window.onload = function mainHallofFame() {
    for (var long = 0; long < 5; long++) {

        genera_tablaBrick()

        genera_tablaSnake()
        genera_tablaPong()
        contador++;
    }

}
