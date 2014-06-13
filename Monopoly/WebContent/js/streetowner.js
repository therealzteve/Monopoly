$(".field").click(function(){
	$(monopoly.optionsMenu.messageField).html($(this).streetId+" gehört bereits "+$(this).player);
});