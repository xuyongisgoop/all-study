$(function(){
	var strCookie=companyNames;
	$("#sellerCompanyName").html(decodeURI(strCookie));
	var iconUrlCookie = iconUrls.replace(/%2C/g,",").split(",");
	if(null != iconUrlCookie[0] && "" != iconUrlCookie[0]){
		var iconUrlTrue = ctx+"/images"+iconUrlCookie[0].replace(/%2F/g, "/");
		$("#iconUrl").attr("src",iconUrlTrue); 
	}else{
		$("#iconUrl").attr("src",ctx+"/images/user_logo/user.png"); 
	}
	$("#logout").click(function(e){
		e.preventDefault();
		var url = $(this).attr("href");
		box.confirmOne("退出","确定要退出吗？", function (){
			location.href = url;			
		});
	});
});