$(function() {
	//保存当前的点击的class样式
	var clazz = "navLinkHover";
	var two_clazz = "hover";
	//保存当前点击的链接的地址
	var $seller_one = $("a[name='seller_one']");
	var $seller_two = $("a[name='seller_two']");
	$seller_one.each(function(){
		$(this).click(function(){
			$.cookie("checkFPath",$(this).attr("href"),{domain:"51offer.com",path:"/"});
			$.cookie("checkCPath",null,{domain:"51offer.com",path:"/"});
			$.cookie("checkCId",null,{domain:"51offer.com",path:"/"});
		});
		if($.cookie("isFirstLoad") ==1 ){
			if($.cookie("sellerType")== 1 || $.cookie("sellerType")== 3 || $.cookie("sellerType")== 4 || $.cookie("sellerType")== 6){
				$("#admin_goods_management").addClass(clazz);
				$.cookie("checkFPath",$("#admin_goods_management").attr("href"),{domain:"51offer.com",path:"/"});
				$.cookie("checkCPath",null,{domain:"51offer.com",path:"/"});
				$.cookie("checkCId",null,{domain:"51offer.com",path:"/"});
				$.cookie("isFirstLoad",null,{domain:"51offer.com",path:"/"});
			}else{
				$("#admin_coupon_management").addClass(clazz);
				$.cookie("checkFPath",$("#admin_coupon_management").attr("href"),{domain:"51offer.com",path:"/"});
				$.cookie("checkCPath",null,{domain:"51offer.com",path:"/"});
				$.cookie("checkCId",null,{domain:"51offer.com",path:"/"});
				$.cookie("isFirstLoad",null,{domain:"51offer.com",path:"/"});
			}
		}
	});   
	$seller_one.each(function(){
		if($.cookie("checkFPath")==$(this).attr("href")){
			$(this).addClass(clazz);
		}
	}); 
	$seller_two.each(function(index){
		$(this).click(function(){
			$.cookie("checkCPath",$(this).attr("href").replace(/%2C/g,"/"),{domain:"51offer.com",path:"/"});
			$.cookie("checkCId",$(this).attr("id"),{domain:"51offer.com",path:"/"});
			if(null !=$.cookie("checkFPath")){
				$.cookie("checkFPath",null,{domain:"51offer.com",path:"/"});
			}
		});
	}); 
	
	$seller_two.each(function(index){
		var seller_two_id = $.cookie("checkCId");
		$seller_one.each(function(index){
			if(null !=seller_two_id && seller_two_id.indexOf($(this).attr("id"))>=0){
				$("#"+seller_two_id).addClass(two_clazz);
				$(this).addClass(clazz);
				return;
			}
		});
	}); 
});