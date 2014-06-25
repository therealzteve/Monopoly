$(".field").click(function(){
	if($(this).data("typ") == "street"){
		if($(this).data("owner") != ""){
			$(monopoly.optionsMenu.messageField).html(
					$(this).data("name") +
					" gehört bereits " +
					$(this).data("owner")
				);
			if($(this).data("owner") == monopoly.myPlayer.name){
				$(monopoly.optionsMenu.messageField).html(
						$(this).data("name") +
						" gehört bereits dir!"
					);
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