'use strict';

const express = require('express');

const port = process.env.PORT || 8081;
const app = express();

app.use(express.json());

app.get('/', function (req, res) {
    res.send("Hi, I'm JS service");
});


app.listen(port, () => console.log(`Listening on ${port}`));