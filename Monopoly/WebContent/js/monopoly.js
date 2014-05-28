var monopoly = function(config){
	var that = this;
	that.playerList = []; //Beinhaltet die anderen Spieler
	that.myTurn = false; //Gibt an, ob ich am Zug bin
	that.myPlayer; //Mein eigenes Player Objekt
	that.gameId; //Id des Spiels
	
	
	
	/**
	 *  Fuehrt den Ajax Befehl zum Updates holen aus
	 * 
	 */
	that.getUpdates = function(){
		$.ajax({
			url: "/GetUpdateAction",
		}).done(function( data ) {
			//Daten, die zurueck kommen mit handleUpdates verarbeiten
			that.handleUpdates(data);
		});
	};
	
	that.handleUpdates = function(data){
		
		//Handle the players
		/*for(var i = 0; i< data.playerList.length; i++){
			var pl = new Player(data.playerList[i].name,data.playerList[i].guthaben)
			pl.streetOwnList = data.playerList[i].streetOwnList;
			pl.position = data.playerList[i].position;
			that.playerList.push(pl);
		}*/
		
		that.myPlayer = new Player(data.player.name, data.player.guthaben);
		that.myPlayer.streetOwnList = data.player.streetOwnList;
		that.myPlayer.position = data.player.position;
		
		that.myTurn = data.myTurn;
		
		
		//Spielfeld bzw. GUI aktualisieren
		that.updateGUI();
	};
	
	that.updateGUI = function(){
		
	};
	
	
	that.startGame = function(){
		
	};
	
	that.addPlayer = function(name, guthaben){
		that.playerList.push(new Player(name, guthaben));
	};
	
	that.init = function(){
		
		//config verarbeiten
		
		
		//Updater starten
		window.setInterval(that.getUpdates,5000);
	};
	
	that.init();
};

var player = function(name, guthaben){
	var that = this;
	that.name = name;
	that.guthaben = guthaben;
	that.streetOwnList;
	that.position;
};