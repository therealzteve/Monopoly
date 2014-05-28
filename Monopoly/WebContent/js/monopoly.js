var monopoly = function(config){
	var that = this;
	that.playerList = []; //Beinhaltet die anderen Spieler
	that.myTurn = false; //Gibt an, ob ich am Zug bin
	that.myPlayer; //Mein eigenes Player Objekt
	that.gameId; //Id des Spiels
	that.optionsMenu = new OptionsMenu(that); //Optionsmenue mit Aktionen des Spielers
	
	
	
	/**
	 *  Fuehrt den Ajax Befehl zum Updates holen aus
	 * 
	 */
	that.getUpdates = function(){
		$.ajax({
			url: "/GetUpdateAction",
		}).done(function( data ) {
			//Daten, die zurueck kommen mit handleUpdates verarbeiten
			data = $.JSON(data);
			that.handleUpdates(data);
		});
	};
	
	
	/**
	 *  Verarbeitet Update Dateien
	 * 
	 */
	that.handleUpdates = function(data){
		
		//Gegner Liste neu erstellen
		for(var i = 0; i< data.playerList.length; i++){
			var pl = new Player(data.otherPlayers[i].name,data.otherPlayers[i].guthaben);
			pl.streetOwnList = data.otherPlayers[i].streetOwnList;
			pl.position = data.otherPlayers[i].position;
			that.playerList.push(pl);
		}
		
		
		//eigene Player Daten verarbeiten
		that.myPlayer = new Player(data.player.name, data.player.guthaben);
		that.myPlayer.streetOwnList = data.player.streetOwnList;
		that.myPlayer.position = data.player.position;
		that.myPlayer.userState = data.player.userState;
		
		that.myTurn = data.myTurn;
		
		
		
		//Spielfeld bzw. GUI aktualisieren
		that.updateGUI();
	};
	
	
	
	//Aktualisiert das Spielfeld anhand aktueller Daten
	that.updateGUI = function(){
		
		
		//Sofern Spieler am Zug ist, Menue zeigen
		if(that.myTurn){
			that.optionsMenu.show();
		}
		
		//Eigenen Spieler aktualisieren:
		
			//Gehaltsfeld aktualisieren
		
			//Position aktualisieren
		
			//Eigene Spielfelder aktualisieren
				//Eigentum kennzeichnen
		
				//Haeuser kennzeichnen
		
			//Eigene Kartenliste aktualisieren
		
		//Liste mit anderen Spielern aktualisieren:
			//Gehaltsfeld aktualisieren
			
			//Position aktualisieren
		
			//Eigene Spielfelder aktualisieren
				//Eigentum kennzeichnen
				
				//Haeuser kennzeichnen
		
			//Eigene Kartenliste aktualisieren
		
	};
	
	
	that.startGame = function(){
		that.player.userState = 0;
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


/**
 *  Bedient das Optionsmenue
 * 
 */
var OptionsMenu = function(monopoly){
	var that = this;
	that.menu = $("#menu");
	that.wuerfelButton = $("#wuerfelButton");
	that.buyButton = $("#buyButton");
	that.buildButton = $("#buildButton");
	that.giveUpButton = $("#giveUpButton");
	that.endTurnButton = $("#endTurnButton");
	
	
	that.handleOptions = function(){
		if(monopoly.gameState == 0){
			$(that.wuerfelButton).enable();
			$(that.buyButton).disable();
			$(that.buildButton).enable();
			$(that.endTurnButton).disable();
		}
		if(monopoly.gameState == 1){
			$(that.wuerfelButton).disable();
			$(that.buyButton).enable();
			$(that.buildButton).enable();
			$(that.endTurnButton).enable();
		}
		if(monopoly.gameState == 2){
			$(that.wuerfelButton).disable();
			$(that.buyButton).disable();
			$(that.buildButton).enable();
			$(that.endTurnButton).enable();
		}
	};
	
	that.show = function(){
		$(menu).show();
		that.handleOptions();
	};
	
	that.hide = function(){
		$(menu).hide();
	};
	
	that.wuerfeln = function(){
		var data = {};
		that.request(data);
		that.hide();
	};
	
	that.endTurn = function(){
		var data = {};
		that.request(data);
		that.hide();
	};
	
	that.buy = function(){
		var data = {"action":"buy"};
		that.request(data);
	};
	
	that.giveUp = function(){
		var data = {"action": "giveUp"};
		that.request(data);
	};
	
	that.build = function(){
		
		//Bau Feld bestimmen (Neues Menue) und Daten per Request mitgeben
		
		var data = {"action":"build", "streetId": 0, "buildAmount": 1};
		that.request(data);
	};
	
	that.request(config){
		$.ajax({
			url: "/GameAction",
			data: config
		}).done(function( data ) {
			//Daten, die zurueck kommen mit handleUpdates verarbeiten
			that.handleRequest(data);
		});
	}
	
	//Ergebnis der Aktion auswerten 
	that.handleRequest(data){
		
		//Erneuter AJAX Befehl zum Daten aktualisieren
		monopoly.getUpdates();
	}
	
	that.init = function(){
		$(that.wuerfelButton).click(that.wuerfeln);
		$(that.buyButton).click(that.buy);
		$(that.buildButton).click(that.build);
		$(that.giveUpButton).click(that.giveUp);
	};
	
	that.init();
};


/**
 *  Player Objekt in Javascript
 * 
 */
var player = function(name, guthaben){
	var that = this;
	that.name = name;
	that.guthaben = guthaben;
	that.streetOwnList;
	that.position;
	that.userState;
};


