$(".field").click(function(){
	if($(this).data("owner") != undefined){
		$(monopoly.optionsMenu.messageField).html(
				$(this).data("name") +
				" gehört bereits " +
				$(this).data("owner").name
			);
	}else{
		$(monopoly.optionsMenu.messageField).html(
				$(this).data("name") +
				" ist noch frei"
			);
	}
});