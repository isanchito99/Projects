var app = require('./server'); // Import the Express application instance from server.js
var homeRoutes = require('./routes/home.routes');
var cartRoutes = require('./routes/cart.routes');

app.use('/', homeRoutes);

//app.use('/',cartRoutes)
