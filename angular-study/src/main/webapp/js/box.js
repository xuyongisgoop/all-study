var box = window.box || (function(document, $) {

    var _locale        = 'en',
        _defaultLocale = 'en',
        _animate       = true,
        _backdrop      = 'static',
        _defaultHref   = 'javascript:;',
        _classes       = '',
        _btnClasses    = {},
        _icons         = {},
        /* last var should always be the public object we'll return */
        that           = {};

	//提交成功、保存成功
    that.subsuc = function(str,callback) {
		var tpl = '<div class="popup popup1"><div class="section2"><i class="correct"></i>' + str + '</div></div><div class="popupBack"></div>';
		if( $("#qr_popup_d").length == 0){
			$("body").append(tpl);
		}
		if(typeof(callback) == 'function') callback();
    };

	//保存失败
    that.subfai = function(str,callback) {
		var tpl = '<div class="popup popup1"><div class="section2"><i class="error"></i>' + str + '</div></div><div class="popupBack"></div>';
		if( $("#qr_popup_d").length == 0){
			$("body").append(tpl);
		}
		if(typeof(callback) == 'function') callback();
    };
    
    that.confirmPay = function(strTitle,strContent,callback) {
		var tpl = '<div class="popup popup1 pay"><div class="title">' + strTitle + '<i class="popupClose _btnCancel"></i></div><div class="section"><p class="p3">' + strContent + '</p><div class="wrap" style="width:200px;"><button class="pbtn_ok _btnOk" type="button">已完成支付</button><button class="pbtnCancel _btnCancel" type="button">支付遇到问题</button></div></div></div><div class="popupBack"></div>';
		if($(".popup popup1 pay").length == 0){
			$("body").append(tpl);
		}
		$(".pay").show();
		$(".popupBack").show();

		$("button._btnOk").focus();

		$("._btnOk").one('click',function(){
			window.location.reload(true);
			$(".popup").remove();
			$(".popupBack").remove();
			if(typeof(callback) == 'function') callback();
			return true;
		})

		$("._btnCancel").one('click',function(){
			window.location.reload(true);
			$(".popup").remove();
			$(".popupBack").remove();
			return false;
		})
    };
	
	//一行文字的
    that.confirmOne = function(strTitle,strContent,callback) {
		var tpl = '<div class="popup popup1 commonpopup"><div class="title">' + strTitle + '<i class="popupClose _btnCancel"></i></div><div class="section"><p class="p1">' + strContent + '</p><div class="wrap"><button class="btn_ok _btnOk" type="button">确定</button><button class="_btnCancel" type="button">取消</button></div></div></div><div class="popupBack commonPopupBack"></div>';
		if( $(".commonpopup").length == 0){
			$("body").append(tpl);
		}
		$(".commonpopup").show();
		$(".commonPopupBack").show();
		
		//$(".freezeWhy").hide();
		//$(".freeze").hide();

		$("button._btnOk").focus();

		$("._btnOk").one('click',function(){
			$(".commonpopup").remove();
			$(".commonPopupBack").remove();
			if(typeof(callback) == 'function') callback();
			return true;
		})

		$("._btnCancel").one('click',function(){
			$(".commonpopup").remove();
			$(".commonPopupBack").remove();
			return false;
		})
    };


	that.dialog = function(str){
		
	}

    return that;
}(document, window.jQuery));

window.box = box;