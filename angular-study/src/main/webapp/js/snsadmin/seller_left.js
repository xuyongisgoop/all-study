var menu_im_path = "http://www.51offer.com/im";
//var menu_im_path = "http://new.51offer.com/im";
var menueImFlag = 0;
$(function() {
	//保存当前的点击的class样式
	var one_clazz = "navLinkHover";
	var two_clazz = "hover";
	//保存当前点击的链接的地址
	var $seller_one = $("a[name='seller_one']");
	var $seller_two = $("a[name='seller_two']");
	
	$seller_one.each(function(index){
		$(this).click(function(){
			$.cookie("checkFPath",$(this).attr("href"),{domain:"51offer.com",path:"/"});
			$.cookie("checkCPath",null,{domain:"51offer.com",path:"/"});
			$.cookie("checkCId",null,{domain:"51offer.com",path:"/"});
		});
		if($.cookie("isFirstLoad") ==1){
			$("#seller_goods_management").addClass(one_clazz);
			$.cookie("checkFPath",$("#seller_goods_management").attr("href"),{domain:"51offer.com",path:"/"});
			$.cookie("checkCPath",null,{domain:"51offer.com",path:"/"});
			$.cookie("checkCId",null,{domain:"51offer.com",path:"/"});
			$.cookie("isFirstLoad",null,{domain:"51offer.com",path:"/"});
		}
	}); 
	$seller_one.each(function(index){
		if($.cookie("checkFPath") == $(this).attr("href")){
			$(this).addClass(one_clazz);
			return;
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
				$(this).addClass(one_clazz);
				return;
			}
		});
	}); 
	jQuery.ajax({//订单统计
        url : ctx+"/seller_order/menu_order_total.do",  
        processData : true,
        dataType : "json",
        type : "post",
        success : function(data) {
        	if(data.result_code == 200) {
            	$("#sumOrderCount").html(data.sumOrderCount);
            	$("#urgentOrderCount").html(data.urgentOrderCount);
            	$("#needOrderCount").html(data.needOrderCount);
            	$("#newOrderCount").html(data.newOrderCount);
        	}
        }
    });
});

//获取或建立IM关系
function contactSeller(userId, goodsId, orderCode){
	var url = menu_im_path + "/message!getUserIMRelation.action?callBack=?";
	var sellerId = $.cookie("loginId");
	if(sellerId == null || isNaN(sellerId)){
		if(confirm("账号已退出，是否重新登录?")){
			window.location.href = ctx+'/user/login.html';
		}
	}
	var data = {userid:userId, merid:sellerId, mer_name:$.cookie("companyName"),goods_id:goodsId,order_id:orderCode};
	jQuery.ajax({//加载用户列表
        url : url,  
        processData : true,
        dataType : "json",
        type : "post",
        data : data,
        success : function(rdata) {
        	if(rdata == 0){
    			//alert('错误了！');
    		} else {
    			var flag = 0;
    			if(205 == rdata.resultCode && window.location.href.indexOf("/userIm/userIm.do") < 0) {//新加关系
    				flag = 1;
    			}
    			window.location.href = ctx + "/userIm/userIm.do?userId=" + userId + "&orderCode=" + orderCode + "&aflag=" + flag;
    		}
        },  
        error : function(e) {}
    });
}