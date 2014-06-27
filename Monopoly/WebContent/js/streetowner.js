$(".field").click(function(){
	if($(this).data("typ") == "street"){
		if($(this).data("playerId") != ""){
			
			//if anyone is owner of the street
			$(monopoly.optionsMenu.messageField).html(
					$(this).data("name") +
					" gehört bereits " +
					$(this).data("owner")
				);
			
			//If user is the owner of street
			if($(this).data("playerId") == monopoly.myPlayer.id){
				var streetId = $(this).data("streetid");
				
				var htmlText = $(this).data("name") +
				" gehört bereits dir!" + 
				"<br>aktueller Mietpreis:"+ $(this).data("miete")+"<br>";
				
				//Add a button to enable build
				var btn = $("<input type='button' value='Bauen' ></input>");
				
				
				if(monopoly.myPlayer.userState == -1){
					htmlText = htmlText + "Bauen ist nur w&auml;hrend des Spielzugs m&ouml;glich <br>"
					$(btn).attr("disabled","disabled");
				}else{
					$(btn).click(function(){
						monopoly.optionsMenu.build(streetId);
					});
				}
				
				
				$(monopoly.optionsMenu.messageField).html(
						htmlText
					).append(btn);
				
				
				
			}
			
			
		}else{
			$(monopoly.optionsMenu.messageField).html(
					$(this).data("name") +
					" ist noch frei"
				);
		}
	}else{
		$(monopoly.optionsMenu.messageField).html(
				$(this).data("name")
			);
	}
});