var Db = require("mongodb").Db;
var Connection = require("mongodb").Connection;
var Server = require("mongodb").Server;
var BSON = require("mongodb").BSON;
var ObjectId = require("mongodb").ObjectId;
var random = require("mersenne");
var N = 9007199254740992;

DatosProvider = function(host,port) {
	this.db = new Db("cosa-node", new Server(host, port, {safe:false}, {auto_reconnect: true}, {}));
	this.db.open(function(){});
}

DatosProvider.prototype.getCollection = function(callback) {
	this.db.collection("dato", function(error, datos_collection) {
		if (error) callback(error)
		else callback(null, datos_collection);
	});
}

DatosProvider.prototype.save = function(dato, callback) {
	this.getCollection(function(error, datos_collection) {
		if (error) callback(error)
		else {
			datos_collection.ensureIndex({codigo:1},{unique:true}, function() {
				datos_collection.insert(dato, function(){
					callback(null, dato)
				});
			});
		}

	});
}

DatosProvider.prototype.list = function(query, limit,  callback) {
	this.getCollection(function(error, datos_collection) {
		if (error) callback(error)
		else {
			datos_collection.find(query).limit(limit).toArray(function(error, results) {
				if (error) callback(error)
				else callback(null, results)
			});
		}
	});
}


var datosProvider = new DatosProvider('localhost', 27017);

exports.create = function(req, res) {
	var datos = [];
	for (var i = 0; i < 10; i++) {
		var cod = random.rand(N);
		var nom = "dato "+cod;
		var cuando = new Date();
		var dato = {
			codigo: cod,
			nombre: nom,
			cuando: cuando
		}
		datos.push(dato);
	}
  datosProvider.save(datos, function(error, datos) {
  	res.writeHead(200, {'Content-Type':'application/json'});
  	res.write(JSON.stringify(datos));
  	res.end();
  }); 
};

exports.jsonList = function(req, res) {
	var k = random.rand(N);
	datosProvider.list({"codigo":{$gt:k}}, 10, function(error, datos){
		res.writeHead(200, {'Content-Type':'application/json'});
  		res.write(JSON.stringify(datos));
  		res.end();
	})
}


exports.list = function(req, res) {
	var k = random.rand(N);
	datosProvider.list({"codigo":{$gt:k}}, 10, function(error, datos){
  		res.render('list', { title: 'Demo', datos: datos });
  	});
};