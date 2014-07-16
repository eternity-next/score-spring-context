var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res) {
  var scores = [50, 20, 70, 80, 90];
  res.send(scores);
});

module.exports = router;
