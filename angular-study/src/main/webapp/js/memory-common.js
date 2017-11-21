$(function(){

	var $main = $('#main');
	var $sidebar = $('#sidebar');
	
	if($main.innerHeight()>$sidebar.innerHeight()){
		// 控制#sidebar和#main等高	
		$('#sidebar').css({'height':$main.innerHeight()});
		
		// #sidebar点击展开与隐藏
		$('.btn_closeSidebar').toggle(function(){
			$sidebar.css({'background':'none','width':'20px'})
			.children('.navWrap').hide();
			$sidebar.find('.right').removeClass('right').addClass('left');
			$main.css({'margin-left':'40px'});				
		},function(){
			$sidebar.css({'background':'','width':'180px'})
			.children('.navWrap').show();
			$sidebar.find('.left').removeClass('left').addClass('right');
			$main.css({'margin-left':'205px'});				
		});
	}

	
/*	
	var $main = $('#main');
	var $sidebar = $('#sidebar');

*/
	//执行复选框	
	checkbox('.choose');
})

//复选框
function checkbox(checkboxClassName){
	$(checkboxClassName).children('li').toggle(function(){
		$(this).children('i').removeClass('chooseboxActive').addClass('chooseboxHover');		
	},function(){
		$(this).children('i').removeClass('chooseboxHover').addClass('chooseboxActive');	
	})
}

//select
function selectui(selectuiValue){
	var selectBtn = $(selectuiValue);
	var selectUi = selectBtn.next('ul');
	selectBtn.bind("click",function(event){
		selectUi.css({'left':selectBtn.offset().left,'width':selectBtn.innerWidth(), 'top':selectBtn.offset().top+2 + selectBtn.innerHeight(), 'display':'block'});	
		event.stopPropagation();    //  阻止事件冒泡
	});
	
	selectUi.children('li').click(function(){
		var resultStr = $(this).children('a').text();
		selectUi.hide();
		selectBtn.children('div').text(resultStr);
		$(this).find('input').val(resultStr);
	});
	$(document).bind("click",function(event){
		selectUi.hide();
		event.stopPropagation();    //  阻止事件冒泡
	});	
}


/* 选项卡1 */
function tab(btn, btnItem, showClass, showClassItem, active){
	var $tabTitleElement = $(btn).find(btnItem);
	var $tabItem = $(showClass).find(showClassItem);
	$tabTitleElement.click(function(){
		$(this).addClass(active).siblings().removeClass(active);
		var index =  $tabTitleElement.index(this);
		$tabItem.eq(index).show().siblings().hide();	
	})
}


