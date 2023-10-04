const equipos = [
    {
        name: 'Hawks',
        data: {
          nombre: 'Atlanta Hawks',
          estadio: 'State Farm Arena',
          img: "img/equipos/hawks.png",
          conferencia: 'Este'
        }
      },
    {
      name: 'Celtics',
      data: {
        nombre: 'Boston Celtics',
        estadio: 'TD Garden',
        img: "img/equipos/boston.png",
        conferencia: 'Este'
      }
    },
    {
        name: 'Nets',
        data: {
          nombre: 'Brooklyn Nets',
          estadio: 'Barclays Center',
          img: "img/equipos/nets.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Hornets',
        data: {
          nombre: 'Charlotte Hornets',
          estadio: 'Spectrum Center',
          img: "img/equipos/hornets.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Bulls',
        data: {
          nombre: 'Chicago Bulls',
          estadio: 'United Center',
          img: "img/equipos/bulls.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Cavaliers',
        data: {
          nombre: 'Cleveland Cavaliers',
          estadio: 'Rocket Mortgage FieldHouse',
          img: "img/equipos/cavaliers.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Mavericks',
        data: {
          nombre: 'Dallas Mavericks',
          estadio: 'American Airlines Center',
          img: "img/equipos/mavericks.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Nuggets',
        data: {
          nombre: 'Denver Nuggets',
          estadio: 'Ball Arena',
          img: "img/equipos/nuggets.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Pistons',
        data: {
          nombre: 'Detroit Pistons',
          estadio: 'Little Caesars Arena',
          img: "img/equipos/pistons.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Warriors',
        data: {
          nombre: 'Golden State Warriors',
          estadio: 'Chase Center',
          img: "img/equipos/warriors.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Rockets',
        data: {
          nombre: 'Houston Rockets',
          estadio: 'Toyota Center',
          img: "img/equipos/rockets.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Pacers',
        data: {
          nombre: 'Indiana Pacers',
          estadio: 'Bankers Life Fieldhouse',
          img: "img/equipos/pacers.png",
          conferencia: 'Este'
        }
      },
     
      {
        name: 'Clippers',
        data: {
          nombre: 'Los Angeles Clippers',
          estadio: 'Crypto.com Arena',
          img: "img/equipos/clippers.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Lakers',
        data: {
          nombre: 'Los Angeles Lakers',
          estadio: 'Crypto.com Arena',
          img: "img/equipos/lakers.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Grizzlies',
        data: {
          nombre: 'Memphis Grizzlies',
          estadio: 'FedExForum',
          img: "img/equipos/grizzlies.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Heat',
        data: {
          nombre: 'Miami Heat',
          estadio: 'FTX Arena',
          img: "img/equipos/heat.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Bucks',
        data: {
          nombre: 'Milwaukee Bucks',
          estadio: 'Fiserv Forum',
          img: "img/equipos/bucks.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Timberwolves',
        data: {
          nombre: 'Minnesota Timberwolves',
          estadio: 'Target Center',
          img: "img/equipos/timberwolves.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Pelicans',
        data: {
          nombre: 'New Orleans Pelicans',
          estadio: 'Pelicans Stadium',
          img: "img/equipos/pelicans.png",
          conferencia: 'Este'
        }
      },

      {
        name: 'Knicks',
        data: {
          nombre: 'New York Knicks',
          estadio: 'Madison Square Garden',
          img: "img/equipos/knicks.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Thunder',
        data: {
          nombre: 'Oklahoma City Thunder',
          estadio: 'Paycom Center',
          img: "img/equipos/thunder.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Magic',
        data: {
          nombre: 'Orlando Magic',
          estadio: 'Amway Center',
          img: "img/equipos/magic.png",
          conferencia: 'Este'
        }
      },
      {
        name: '76ers',
        data: {
          nombre: 'Philadelphia 76ers',
          estadio: 'Wells Fargo Center',
          img: "img/equipos/76ers.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Suns',
        data: {
          nombre: 'Phoenix Suns',
          estadio: 'Footprint Center',
          img: "img/equipos/suns.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Blazers',
        data: {
          nombre: 'Portland Trail Blazers',
          estadio: 'Footprint Center',
          img: "img/equipos/blazers.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Kings',
        data: {
          nombre: 'Sacramento Kings',
          estadio: 'Golden 1 Center',
          img: "img/equipos/kings.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Spurs',
        data: {
          nombre: 'San Antonio Spurs',
          estadio: 'Frost Bank Center',
          img: "img/equipos/spurs.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Raptors',
        data: {
          nombre: 'Toronto Raptors',
          estadio: 'Scotiabank Arena',
          img: "img/equipos/raptors.png",
          conferencia: 'Este'
        }
      },
      {
        name: 'Jazz',
        data: {
          nombre: 'Utah Jazz',
          estadio: 'Vivint Arena',
          img: "img/equipos/jazz.png",
          conferencia: 'Oeste'
        }
      },
      {
        name: 'Wizards',
        data: {
          nombre: 'Washington Wizards',
          estadio: 'Capital One Arena',
          img: "img/equipos/wizards.png",
          conferencia: 'Este'
        }
      }
    
  ];
  
  document.addEventListener("DOMContentLoaded", function () {
    const equiposList = document.getElementById("equipos-list");

    equipos.forEach((equipo) => {
        const equipoColumn = document.createElement("div");
        equipoColumn.classList.add("col-md-4", "mb-4");

        const card = document.createElement("div");
        card.classList.add("card");

        const img = document.createElement("img");
        img.src = equipo.data.img;
        img.classList.add("card-img-top");
        img.alt = equipo.data.nombre;
        //Aplico Estilos
        img.style.width = "320px"; 
        img.style.height = "300px"; 
        const cardBody = document.createElement("div");
        cardBody.classList.add("card-body");

        const cardTitle = document.createElement("h5");
        cardTitle.classList.add("card-title");
        cardTitle.textContent = equipo.data.nombre;
        cardTitle.style.fontWeight = "bold";;

        const cardTextEstadio = document.createElement("p");
        const cardTextConferencia = document.createElement("p");  
        cardTextEstadio.textContent = `Estadio: ${equipo.data.estadio} `;
        cardTextConferencia.textContent= `Conferencia: ${equipo.data.conferencia}`;

        cardBody.appendChild(cardTitle);
        cardBody.appendChild(cardTextEstadio);
        cardBody.appendChild(cardTextConferencia);

        card.appendChild(img);
        card.appendChild(cardBody);

        equipoColumn.appendChild(card);
        equiposList.appendChild(equipoColumn);
    });
});
  // Acceder a la información de un equipo específico
  const equipoCeltics = equipos.find(equipo => equipo.name === 'Celtics');
  console.log("Nombre del equipo Celtics:", equipoCeltics.data.nombre);
  console.log("Estadio del equipo Celtics:", equipoCeltics.data.estadio);
  console.log("Imagen del equipo Celtics:", equipoCeltics.data.img);
  console.log("Conferencia del equipo Celtics:", equipoCeltics.data.conferencia);
  