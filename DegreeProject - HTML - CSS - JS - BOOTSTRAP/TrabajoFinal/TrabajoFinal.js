             var contador = 1;
             var tablero = document.getElementById("tablero");
             var brickColors = ["#31D0B0", "#5BD031", "#E3D61B", "#E33D1B", "#E259C6"];
             var ctx = tablero.getContext("2d");
             var ballRadius = 10;
             var x = tablero.width / 2;
             var y = tablero.height - 30;
             var dx = 2;
             var dy = -2;

             //definimos la raqueta que golpeara la bola 
             var raquetaAltura = 10;
             var raquetaAncho = 75;
             //posición en el eje X
             var raquetaX = (tablero.width - raquetaAncho) / 2;

             //control de la raqueta

             var botonDerecho = false;
             var botonIzquierdo = false;

             //Variables de los ladrillos
             /*el número de filas*/
             var ladrillosFilas = 3;
             /*el número de columnas*/
             var ladrillosColumnas = 5;
             /*ancho Ladrillos*/
             var ladrillosAncho = 75;
             /*largo ladrillos*/
             var ladrillosAlto = 20;
             /*margen entre ladrillos*/
             var brickPadding = 10;
             /*margen derecho*/
             var brickOffsetTop = 30;
             /*margen izquierdo*/
             var brickOffsetLeft = 30;

             //Variable contador para la puntuacion
             var score = 0;

             /*Guardaremos nuestros ladrillos en una matriz bidimensional que contendrá las columnas (c) de los ladrillos. Cada columna contendrá,
             a su vez, toda la fila (r) de ladrillos.
             (c)== columns || (r)== rows
             */
             var bricks = [];
             for (c = 0; c < ladrillosColumnas; c++) {
                 bricks[c] = [];
                 for (r = 0; r < ladrillosFilas; r++) {
                     bricks[c][r] = {
                         x: 0,
                         y: 0,
                         status: 1
                     };
                 }
             }


             document.addEventListener("keydown", keyDownHandler, false);
             document.addEventListener("keyup", keyUpHandler, false);



             //la tecla de la flecha izquierda representa el 37, la de la flecha derecha el 39, por lo que al pusarlas se pondrán a true 
             function keyDownHandler(e) {
                 if (e.keyCode == 39) {
                     botonDerecho = true;
                 } else if (e.keyCode == 37) {
                     botonIzquierdo = true;
                 }
             }

             function keyUpHandler(e) {
                 if (e.keyCode == 39) {
                     botonDerecho = false;
                 } else if (e.keyCode == 37) {
                     botonIzquierdo = false;
                 }
             }

           

             function collisionDetection() {
                 for (c = 0; c < ladrillosColumnas; c++) {
                     for (r = 0; r < ladrillosFilas; r++) {
                         var b = bricks[c][r];
                         /*
                    La posición "x" de la bola es mayor que la posición "x" del ladrillo
La posición "x" de la bola es menor que la posición del ladrillo más el ancho del ladrillo
La posición "y" de la bola es mayor que la posición "y" del ladrillo.
La posición "y" de la bola es menor que la posición del ladrillo más su altura.*/
                         if (b.status == 1) {
                             if (x > b.x && x < b.x + ladrillosAncho && y > b.y && y < b.y + ladrillosAlto) {
                                 dy = -dy;
                                 b.status = 0;
                                 score++;
                                 //Cuando la puntuacion sea igual a todos los ladrillos
                                 if (score == ladrillosFilas * ladrillosColumnas) {
                                     alert("HAS GANADO,FELICIDADES");
                                     var nombreUsuario = prompt("Introduzca un nombre para la partida");
                                 
                                     localStorage.setItem("NombreBrick" + contador, nombreUsuario);
                                     localStorage.setItem("ScoreBrick" + contador, score);
                                     contador++
                                     document.location.reload();
                                 }
                             }
                         }
                     }
                 }
             }

             function drawScore() {
                 ctx.font = "16px Arial";
                 ctx.fillStyle = "#E6D8D8";
                 ctx.fillText("Score: " + score, 8, 20);
             }

             function drawBall() {
                 ctx.beginPath();
                 ctx.arc(x, y, ballRadius, 0, Math.PI * 2);
                 ctx.fillStyle = "#BF3FB2";
                 ctx.fill();
                 ctx.closePath();
             }

             function drawPaddle() {
                 ctx.beginPath();
                 ctx.rect(raquetaX, tablero.height - raquetaAltura, raquetaAncho, raquetaAltura);
                 ctx.fillStyle = "#0095DD";
                 ctx.fill();
                 ctx.closePath();
             }

             function drawBricks() {
                 for (c = 0; c < ladrillosColumnas; c++) {
                     for (r = 0; r < ladrillosFilas; r++) {
                         if (bricks[c][r].status == 1) {
                             var brickX = (c * (ladrillosAncho + brickPadding)) + brickOffsetLeft;
                             var brickY = (r * (ladrillosAlto + brickPadding)) + brickOffsetTop;
                             bricks[c][r].x = brickX;
                             bricks[c][r].y = brickY;
                             ctx.beginPath();
                             ctx.rect(brickX, brickY, ladrillosAncho, ladrillosAlto);
                             ctx.fillStyle = brickColors[Math.floor(Math.random() * brickColors.length)];
                             ctx.fill();
                             ctx.closePath();
                         }
                     }
                 }
             }



             function draw() {

                 ctx.clearRect(0, 0, tablero.width, tablero.height);
                 drawBricks();
                 drawBall();
                 drawPaddle();
                 collisionDetection();
                 drawScore();

                 if (x + dx > tablero.width - ballRadius || x + dx < ballRadius) {
                     dx = -dx;
                 }

                 if (y + dy < ballRadius) {
                     dy = -dy;

                 }

                 //El fin del juego en caso de que la bola toque la parte inferior del tablero 
                 else if (y + dy > tablero.height - ballRadius) {
                     if (x > raquetaX && x < raquetaX + raquetaAncho) {
                         dy = -dy;
                     } else {
                         alert("GAME OVER");

                         var nombreUsuario = prompt("Introduzca un nombre para la partida");
                         localStorage.setItem("NombreBrick" + contador, nombreUsuario);
                         localStorage.setItem("ScoreBrick" + contador, score);
                         contador++
                         document.location.reload();

                     }
                 }
                 //VELOCIDADES DE LA RAQUETA
                 if (botonDerecho) {
                     raquetaX = raquetaX + 8;
                 } else if (botonIzquierdo) {
                     raquetaX = raquetaX - 8;
                 }

                 x += dx;
                 y += dy;

                 //Si no quieres que tu animación se detenga,
                 requestAnimationFrame(draw);


             }
             draw();
