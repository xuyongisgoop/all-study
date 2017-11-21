

//select
function selectui(selectuiValue){
	var selectBtn = $(selectuiValue);
	var selectUi = selectBtn.next('ul');
	selectBtn.toggle(function(){
			selectUi.css({'left':selectBtn.offset().left,'width':selectBtn.innerWidth(), 'top':selectBtn.offset().top + selectBtn.innerHeight(), 'display':'block'});	
		},
		function(){
			selectUi.hide()	
		}
	);
	selectUi.children('li').click(function(){
		var resultStr = $(this).children('a').text();
		selectUi.hide();
		selectBtn.children('div').text(resultStr);
		selectBtn.children('input').val(resultStr);
	})
}

String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {  
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {  
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);  
    } else {  
        return this.replace(reallyDo, replaceWith);  
    }  
}

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
