var xpopup = window.xpopup || (function(document, $) {

    var _locale        = 'en',
        that           = {};


    that.show = function(url,callback) {
		$.get(url,function(html){
			$("#dialog").html(html)


			$('.special').css({'top':($(window).height()-$('.special').outerHeight(true))/2})
			xpopup.popupChangePos();
			if ('function' == typeof(callback)){
				callback();
			}
		})

		$("#dialog ._btnCancel").live("click",function(e){

			$("#dialog").html('');

		});
		
	};
	that.popupChangePos = function(){
		$(window).bind("resize",function(){
			var popupH = $('.popup').outerHeight();
			var popupW = $('.popup').outerWidth(); 
			var windowH = $(window).height();
			var windowW = $(window).width();
			$('.popup').css({'top':(windowH-popupH)/2, 'left':(windowW - popupW)/2});
		});
		$(window).resize();
	};

	return that;
}(document, window.jQuery));

window.xpopup = xpopup;