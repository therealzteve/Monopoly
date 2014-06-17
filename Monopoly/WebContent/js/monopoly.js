var Monopoly = function(cfg){
	var that = this;
	that.playerList = []; //Beinhaltet die anderen Spieler
	that.myTurn = false; //Gibt an, ob ich am Zug bin
	that.myPlayer; //Mein eigenes Player Objekt
	that.gameId; //Id des Spiels
	that.optionsMenu = new OptionsMenu(that); //Optionsmenue mit Aktionen des Spielers
	
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
		
		
		that.playerList = [];
		//Gegner Liste neu erstellen
		for(var i = 0; i< data.otherPlayers.length; i++){
			var pl = new Player(data.otherPlayers[i].name,data.otherPlayers[i].guthaben);
			
			pl.position = data.otherPlayers[i].position;
			pl.setIcon(data.otherPlayers[i].icon);
			pl.hasLost = data.otherPlayers[i].hasLost;
			
			for(var j = 0; j < data.otherPlayers[i].streetOwnList.length; j++){
				pl.streetOwnList.push(
						new Street(
								data.otherPlayers[i].streetOwnList[j].id,
								data.otherPlayers[i].streetOwnList[j].name,
								data.otherPlayers[i]
								)
						);
			}

			
			that.playerList.push(pl);
		}
		
		
		//eigene Player Daten verarbeiten
		that.myPlayer = new Player(data.player.name, data.player.guthaben);
		that.myPlayer.streetOwnList = [];
		
		console.log(data.player.streetOwnList.length);
		for(var i = 0; i < data.player.streetOwnList.length; i++){
			console.log(data.player.streetOwnList[i]);
			that.myPlayer.streetOwnList.push(
					new Street(
							data.player.streetOwnList[i].id,
							data.player.streetOwnList[i].name,
							that.myPlayer
							)
					);
		}
		that.myPlayer.position = data.player.position;
		that.myPlayer.userState = data.player.userState;
		that.myPlayer.setIcon(data.player.icon);
		that.myPlayer.isAdmin = data.player.isAdmin;
		that.myPlayer.hasLost = data.player.hasLost;
		
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
			$(that.myPlayer.getIcon()).detach().appendTo("#field_"+that.myPlayer.position);
			
			
			
			//Eigene Spielfelder aktualisieren
				//Eigentum kennzeichnen
		
				//Haeuser kennzeichnen
		
			
			//Eigene Kartenliste aktualisieren
			$(that.ownedStreetsList).empty();
			for(var i = 0; i< that.myPlayer.streetOwnList.length; i++){
				$(that.ownedStreetsList).append(
						"<li>"
						+that.myPlayer.streetOwnList[i].name
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
				 console.log(that.playerList[i]);
				$(that.playerList[i].getIcon()).detach().appendTo("#field_"+that.playerList[i].position);
			}
			
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
		if(monopoly.myPlayer.isAdmin == false){
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
	
	that.build = function(){
		
		//Bau Feld bestimmen (Neues Menue) und Daten per Request mitgeben
		
		var data = {"action":"build", "streetId": 0, "buildAmount": 1};
		that.request(data);
	};
	
	that.startGame = function(){
		var data = {"action":"startGame"};
		that.request(data);
		$(that.startGameContainer).remove();
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
var Player = function(name, guthaben){
	var that = this;
	that.name = name;
	that.guthaben = guthaben;
	that.streetOwnList;
	that.position;
	that.userState = -1;
	that.isAdmin = false;
	that.hasLost;
	that._icon;
	
	that.setIcon = function(imgPath){
		if(!$("#icon_"+that.name).length > 0){
			that._icon = $("<img class='car_icon' src='/Monopoly/img/figuren/auto"+imgPath+".png' id='icon_"+that.name+"' style='z-index:100; position:relative; padding-top:15px; width:45px; height:20px'/>");
		}else{
			that._icon = $("#icon_"+that.name);
		}
	};
	
	that.getIcon = function(){
		return that._icon;
	};
};

var Street = function(id, name, owner, miete){
	var that = this;
	that.name = name;
	that.id = id;
	that.owner = owner;
	that.miete = miete;
	
	
	/**
	 * Initializes street object
	 */
	that.init = function(){
		console.log(that.id);
		$("#field_"+that.id).data("streetid", that.id);
		$("#field_"+that.id).data("name", that.name);
		$("#field_"+that.id).data("owner", that.owner);
		$("#field_"+that.id).data("miete", that.miete);
	};
	
	
	that.init();
};


var monopoly = new Monopoly();
