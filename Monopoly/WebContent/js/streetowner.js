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
				
				//Add a button to enable build
				var btn = $("<input type='button' value='Bauen' ></input>");
				$(btn).click(function(){console.log(streetId);
					monopoly.optionsMenu.build(streetId);
				});
				
				
				$(monopoly.optionsMenu.messageField).html(
						$(this).data("name") +
						" gehört bereits dir!" + 
						"<br>aktueller Mietpreis:"+ $(this).data("miete")+"<br>"
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