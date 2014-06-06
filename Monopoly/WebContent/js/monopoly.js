var Monopoly = function(cfg){
	var that = this;
	that.playerList = []; //Beinhaltet die anderen Spieler
	that.myTurn = false; //Gibt an, ob ich am Zug bin
	that.myPlayer; //Mein eigenes Player Objekt
	that.gameId; //Id des Spiels
	that.optionsMenu = new OptionsMenu(that); //Optionsmenue mit Aktionen des Spielers
	
	//Selectors:
	that.otherPlayerList = $("#otherPlayers");
	that.guthabenSpan = $("#guthaben");
	that.ownedStreetsList = $("#ownedStreets");
	
	/**
	 *  Fuehrt den Ajax Befehl zum Updates holen aus
	 * 
	 */
	that.getUpdates = function(){
		$.ajax({
			url: "/Monopoly/GetUpdateAction",
		}).done(function( data ) {
			//Daten, die zurueck kommen mit handleUpdates verarbeiten
			data = $.parseJSON(data);
			that.handleUpdates(data);
		});
	};
	
	
	/**
	 *  Verarbeitet Update Dateien
	 * 
	 */
	that.handleUpdates = function(data){
		
		//Gegner Liste neu erstellen
		for(var i = 0; i< data.otherPlayers.length; i++){
			var pl = new Player(data.otherPlayers[i].name,data.otherPlayers[i].guthaben);
			pl.streetOwnList = data.otherPlayers[i].streetOwnList;
			pl.position = data.otherPlayers[i].position;
			pl.icon = data.otherPlayers[i].icon;
			that.playerList.push(pl);
		}
		
		
		//eigene Player Daten verarbeiten
		that.myPlayer = new Player(data.player.name, data.player.guthaben);
		that.myPlayer.streetOwnList = data.player.streetOwnList;
		that.myPlayer.position = data.player.position;
		that.myPlayer.userState = data.player.userState;
		that.myPlayer.icon = data.player.icon;
		
		that.myTurn = data.myTurn;
		
		
		
		//Spielfeld bzw. GUI aktualisieren
		that.updateGUI();
	};
	
	
	
	//Aktualisiert das Spielfeld anhand aktueller Daten
	that.updateGUI = function(){
		
		
		//Menue verarbeiten
		that.optionsMenu.handleOptions();
		
		//Eigenen Spieler aktualisieren:
		
			//Gehaltsfeld aktualisieren
			$(that.guthabenSpan).html(that.myPlayer.guthaben);
			//Position aktualisieren
			$(that.myPlayer.getIcon()).detach().appendTo("#field_"+that.myPlayer.getPosition());
			
			//Eigene Spielfelder aktualisieren
				//Eigentum kennzeichnen
		
				//Haeuser kennzeichnen
		
			//Eigene Kartenliste aktualisieren
			$(that.ownedStreetsList).empty();
			for(var i = 0; i< that.myPlayer.streetOwnList.length; i++){
				$(that.ownedStreetsList).append(
						"<li>"
						+that.myPlayer.streetOwnList[i]
						+"</li>"
				);
			}
		//Liste mit anderen Spielern aktualisieren:
			//Gehaltsfeld aktualisieren
			
			//Position aktualisieren
		
			//Eigene Spielfelder aktualisieren
				//Eigentum kennzeichnen
				
				//Haeuser kennzeichnen
		
			//Eigene Kartenliste aktualisieren
		
	};
	
	
	that.startGame = function(){
		that.myPlayer.userState = 0;
	};
	
	that.addPlayer = function(name, guthaben){
		that.playerList.push(new Player(name, guthaben));
	};
	
	that.init = function(){
		that.getUpdates();
		//config verarbeiten
		
		
		//Updater starten
		//window.setInterval(that.getUpdates,5000);
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
	that.messageField = $("#message");
	
	
	that.handleOptions = function(){
		console.log(monopoly.myPlayer.userState);
		
		//Spieler ist zurzeit nicht an der Reihe
		if(monopoly.myPlayer.userState == -1){
			$(that.wuerfelButton).attr("disabled","disabled");
			$(that.buyButton).attr("disabled","disabled");
			$(that.buildButton).attr("disabled","disabled");
			$(that.endTurnButton).attr("disabled","disabled");
		}
		
		//Spieler bereit zum wuerfeln oder bauen
		if(monopoly.myPlayer.userState == 0){
			$(that.wuerfelButton).removeAttr("disabled");
			$(that.buyButton).attr("disabled","disabled");
			$(that.buildButton).removeAttr("disabled");
			$(that.endTurnButton).attr("disabled","disabled");
		}
		
		//Spieler steht auf einer freien Strasse
		if(monopoly.myPlayer.userState == 1){
			$(that.wuerfelButton).attr("disabled","disabled");
			$(that.buyButton).removeAttr("disabled");
			$(that.buildButton).removeAttr("disabled");
			$(that.endTurnButton).removeAttr("disabled");
		}
		
		//Spieler kann nicht kaufen, muss Zug beenden oder bauen
		if(monopoly.myPlayer.userState == 2){
			$(that.wuerfelButton).attr("disabled","disabled");
			$(that.buyButton).attr("disabled","disabled");
			$(that.buildButton).removeAttr("disabled");
			$(that.endTurnButton).removeAttr("disabled");
		}
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
	
	that.request = function(config){
		$.ajax({
			url: "/Monopoly/GameAction",
			data: config
		}).done(function( data ) {
			
			//Antwort String in JSON Objekt umwandeln
			data = $.parseJSON(data);
			//Daten, die zurueck kommen mit handleUpdates verarbeiten
			that.handleRequest(data);
		});
	}
	
	//Ergebnis der Aktion auswerten 
	that.handleRequest = function(data){
		console.log("handlingRequest");
		$(that.messageField).html(data.message);
		//Erneuter AJAX Befehl zum Daten aktualisieren
		monopoly.getUpdates();
	};
	
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
var Player = function(name, guthaben){
	var that = this;
	that.name = name;
	that.guthaben = guthaben;
	that.streetOwnList;
	that.position;
	that.userState = -1;
	that._icon;
	
	that.setIcon = functino(imgPath){
		that._icon = $("<img src='"+imgPath+"' id='icon_"+that.name+"'/>");
	};
	
	that.getIcon = function(){
		return that._icon;
	};
};


var monopoly = new Monopoly();