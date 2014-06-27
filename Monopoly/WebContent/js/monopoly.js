var Monopoly = function(cfg){
	var that = this;
	that.playerList = []; //Beinhaltet die anderen Spieler
	that.myTurn = false; //Gibt an, ob ich am Zug bin
	that.myPlayer; //Mein eigenes Player Objekt
	that.gameId; //Id des Spiels
	that.optionsMenu = new OptionsMenu(that); //Optionsmenue mit Aktionen des Spielers
	that.fieldList = [];
	that.isRunning = false;
	
	//Selectors:
	that.otherPlayers = $("#otherPlayers");
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
		if(data.event != undefined){
			if(data.event == "sessionLost"){
				alert("Ihre Session ist abgelaufen! Bitte treten Sie einem neuen Spiel bei!");
				location.href = "/Monopoly";
				return;
			}
		}
		
		
		monopoly.isRunning = data.isRunning;
		
		if(data.player.hasWon == true){
			alert("Sie haben das Spiel gewonnen!");
			location.href= "/Monopoly";
		}
		
		that.playerList = [];
		//Gegner Liste neu erstellen
		for(var i = 0; i< data.otherPlayers.length; i++){
			var pl = new Player(data.otherPlayers[i].id, data.otherPlayers[i].name,data.otherPlayers[i].guthaben);
			
			pl.position = data.otherPlayers[i].position;
			pl.setIcon(data.otherPlayers[i].icon);
			pl.hasLost = data.otherPlayers[i].hasLost;
			pl.streetOwnList = [];
			for(var j = 0; j < data.otherPlayers[i].streetOwnList.length; j++){
				pl.streetOwnList.push(
								data.otherPlayers[i].streetOwnList[j].name
						);
			}

			
			that.playerList.push(pl);
		}
		
		
		//eigene Player Daten verarbeiten
		that.myPlayer = new Player(data.player.id, data.player.name, data.player.guthaben);
		that.myPlayer.streetOwnList = [];
		
		for(var i = 0; i < data.player.streetOwnList.length; i++){
			that.myPlayer.streetOwnList.push(
							data.player.streetOwnList[i].name
					);
		}
		that.myPlayer.position = data.player.position;
		that.myPlayer.userState = data.player.userState;
		that.myPlayer.setIcon(data.player.icon);
		that.myPlayer.isAdmin = data.player.isAdmin;
		that.myPlayer.hasLost = data.player.hasLost;
		
		that.myTurn = data.myTurn;
		
		for(var i = 0; i< data.fields.length; i++){
			that.fieldList.push(
					new Field(
							data.fields[i].id,
							data.fields[i].typ,
							data.fields[i].name,
							data.fields[i].owner,
							data.fields[i].playerId,
							data.fields[i].miete
							)
					);
		}
		
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
			$(that.myPlayer.getIcon()).detach().appendTo("#field_"+that.myPlayer.position);

			
			
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
			
			//Aktuelle Liste leeren
			$(that.otherPlayers).empty();
			
			//Durch player array iterieren
			for(var i = 0; i < that.playerList.length; i++){
				 var li = $("<li></li>");
				 if(that.playerList[i].hasLost){
					 $(li).addClass("hasLost");
				 }
				 //Name eintragen
				 $(li).append("<span><label>Name: </label>"+that.playerList[i].name+"</span>");
				 
				 //Guthaben eintragen
				 $(li).append("<span><label>Guthaben: </label>"+that.playerList[i].guthaben+"</span>");
				 
				 //Listeneintrag hinzufuegen
				 $(that.otherPlayers).append(li);

				//Position aktualisieren
				$(that.playerList[i].getIcon()).detach().appendTo("#field_"+that.playerList[i].position);
			}
			
	};
	
	
	that.startGame = function(){
		that.myPlayer.userState = 0;
	};
	
	that.addPlayer = function(id, name, guthaben){
		that.playerList.push(new Player(id, name, guthaben));
	};
	
	that.init = function(){
		that.getUpdates();
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
	that.messageField = $("#message");
	that.startGameButton = $("#startGameButton");
	that.startGameContainer = $("#startGame");
	
	that.handleOptions = function(){
		if(monopoly.myPlayer.isAdmin == false || monopoly.isRunning){
			$(that.startGameContainer).remove();
		}
		
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
			//$(that.buildButton).removeAttr("disabled");
			$(that.endTurnButton).attr("disabled","disabled");
			$(that.giveUpButton).show();
		}
		
		//Spieler steht auf einer freien Strasse
		if(monopoly.myPlayer.userState == 1){
			$(that.wuerfelButton).attr("disabled","disabled");
			$(that.buyButton).removeAttr("disabled");
			//$(that.buildButton).removeAttr("disabled");
			$(that.endTurnButton).removeAttr("disabled");
		}
		
		//Spieler kann nicht kaufen, muss Zug beenden oder bauen
		if(monopoly.myPlayer.userState == 2){
			$(that.wuerfelButton).attr("disabled","disabled");
			$(that.buyButton).attr("disabled","disabled");
			//$(that.buildButton).removeAttr("disabled");
			$(that.endTurnButton).removeAttr("disabled");
		}
	};
	
	
	that.wuerfeln = function(){
		var data = {};
		that.request(data);
	};
	
	that.endTurn = function(){
		var data = {};
		that.request(data);
	};
	
	that.buy = function(){
		var data = {"action":"buy"};
		that.request(data);
	};
	
	that.giveUp = function(){
		var data = {"action": "giveUp"};
		that.request(data);
	};
	
	that.build = function(streetId){
		
		//Bau Feld bestimmen (Neues Menue) und Daten per Request mitgeben
		
		var data = {"action":"build", "streetId": streetId, "buildAmount": 1};
		that.request(data);
	};
	
	that.startGame = function(){
		if(monopoly.playerList.length == 0){
			alert("Bitte warten, bis mindestens 1 Spieler beigetreten ist!");
		}else{
			var data = {"action":"startGame"};
			that.request(data);
			$(that.startGameContainer).remove();
		}
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
	};
	
	//Ergebnis der Aktion auswerten 
	that.handleRequest = function(data){
		$(that.messageField).html(data.message);
		
		//Wenn Aufgegeben, dann zur Startseite verweisen
		if(data.event == "giveUp"){
			alert("Sie haben das Spiel verloren!");
			location.href = "/Monopoly";
		}else{
			//Erneuter AJAX Befehl zum Daten aktualisieren
			monopoly.getUpdates();
		}
	};
	
	that.init = function(){
		$(that.wuerfelButton).click(that.wuerfeln);
		$(that.buyButton).click(that.buy);
		$(that.buildButton).click(that.build);
		$(that.giveUpButton).click(that.giveUp);
		$(that.endTurnButton).click(that.endTurn);
		$(that.startGameButton).click(that.startGame);
		
		
	};
	
	that.init();
};


/**
 *  Player Objekt in Javascript
 * 
 */
var Player = function(id, name, guthaben){
	var that = this;
	that.id = id;
	that.name = name;
	that.guthaben = guthaben;
	that.streetOwnList;
	that.position;
	that.userState = -1;
	that.isAdmin = false;
	that.hasLost;
	that._icon;
	
	that.setIcon = function(imgPath){
		if(!$("#icon_"+that.id).length > 0){
			that._icon = $("<img class='car_icon' src='/Monopoly/img/figuren/auto"+imgPath+".png' id='icon_"+that.id+"' style='z-index:100; position:relative; padding-top:15px; width:45px; height:20px'/>");
		}else{
			that._icon = $("#icon_"+that.id);
		}
	};
	
	that.getIcon = function(){
		return that._icon;
	};
};

var Field = function(id,typ, name, owner,playerId, miete){
	var that = this;
	that.name = name;
	that.id = id;
	that.typ = typ;
	that.owner = owner;
	that.miete = miete;
	that.playerId = playerId;
	
	
	/**
	 * Initializes street object
	 */
	that.init = function(){
		$("#field_"+that.id).data("streetid", that.id);
		$("#field_"+that.id).data("playerId", that.playerId);
		$("#field_"+that.id).data("name", that.name);
		$("#field_"+that.id).data("owner", that.owner);
		$("#field_"+that.id).data("miete", that.miete);
		$("#field_"+that.id).data("typ", that.typ);
	};
	
	
	that.init();
};


var monopoly = new Monopoly();
