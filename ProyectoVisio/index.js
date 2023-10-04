const url = 'https://nba-stats-db.herokuapp.com/api/playerdata/season/2023';
const url2 = 'https://nba-stats-db.herokuapp.com/api/playerdata/season/2023/?page=2';
let listaJugadores = [];

window.onload = async function () {

    listaJugadores = await llamarApi();
    

    console.log(listaJugadores);

    listaJugadores.results.forEach(jugador => {
        console.log(jugador.player_name+" Edad : "+jugador.age+" PTS : "+jugador.PTS+" AST : "+jugador.AST+" BLK : "+jugador.BLK+" STL : "+jugador.STL+" DRB : "+jugador.DRB+" Partidos jugados: "+jugador.games);
    });

}

async function llamarApi() {

    return await fetch(url)
        .then(res => res.json())
        .then(data => {
            return data;
        })
        .catch(error => console.log(error));

}

async function llamarApiTodasLasPaginas() {
    const urlBase = 'https://nba-stats-db.herokuapp.com/api/playerdata/season/2023';
    const listaJugadores = [];

    let currentPage = 2;
    let totalPages = 7;

    while (currentPage <= totalPages) {
        const url = `${urlBase}/?page=${currentPage}`;
        const data = await llamarApi(url);

        if (data.results) {
            listaJugadores.push(...data.results);
        }

        if (data.pages && data.pages.total) {
            totalPages = data.pages.total;
        }

        currentPage++;
    }

    return listaJugadores;
}

function buscarJugador() {
    const inputNombre = document.getElementById('nombre').value;
    const jugadorEncontrado = listaJugadores.results.find(jugador => jugador.player_name.toLowerCase() === inputNombre.toLowerCase());
    const jugadorEncontradoElement = document.getElementById('jugadorEncontrado');
    const datosJugadorEncontrado = document.getElementById('datosJugador');
    if (jugadorEncontrado) {
        jugadorEncontradoElement.textContent = `El jugador ${jugadorEncontrado.player_name} está en la lista.`;
        datosJugadorEncontrado.textContent = `Los datos de  ${jugadorEncontrado.player_name} son:\n EDAD:${jugadorEncontrado.age},
        \n PUNTOS:${jugadorEncontrado.PTS},\n ASISTENCIAS:${jugadorEncontrado.AST},\n 
        TAPONES:${jugadorEncontrado.BLK}, \nROBOS:${jugadorEncontrado.STL}, 
        \nREGATES:${jugadorEncontrado.DRB},\n PARTIDOS JUGADOS:${jugadorEncontrado.games} `;
        //console.log(`El jugador ${jugadorEncontrado.player_name} está en la lista.`);
    } else {
        window.alert("El jugador no se encuentra en el JSON");
        inputNombre.value = '';
        window.location.reload();
     //console.log(`El jugador ${inputNombre} no se encuentra en la lista.`);
    }
}


 

