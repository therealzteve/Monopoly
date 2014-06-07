$(".field").click(function(){
	$(monopoly.optionsMenu.messageField).html(
			$(this).data("name") +
			" gehört bereits " +
			$(this).data("owner").name
		);
});