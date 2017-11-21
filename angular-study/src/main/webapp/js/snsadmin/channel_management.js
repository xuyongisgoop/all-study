$(function(){
	
	//设置版主
	$('.setModerator').click(function(){
		var channel_id = $(this).attr("data-val");
		$("#setModerator").find("#channel_id").val(channel_id);
		$('.freeze').show();	
		$('.popupBack').show();	
		return false;
	});
  
  //推荐频道
  $(".recommend").click(function(){
	  var channel_id = $(this).attr("data-val");
	  var type = $(this).attr("type");
	  var ret = confirm("确认推荐吗？");
	  if(ret){
		  $("#setRecommendChannel").find("#channel_id").val(channel_id);
		  $("#setRecommendChannel").find("#type").val(type);
		  $("#setRecommendChannel").submit();
	  }
  });

  //弹出框取消
	$('.btn_cancel').click(function(){
		$('.popup').hide();	
		$('.popupBack').hide();	
		return false;
	});
  //弹出框确定
	$('.freeze .btn_ok').click(function(){
		$('.popup').hide();	
		$('.popupBack').hide();
		$("#setModerator").submit();
		
	});
	// 冻结原因
	$('.reason').click(function(){
		$("#reasonShow").html($(this).attr("reason"));
		$('.freezeWhy').show();	
		$('.popupBack').show();	
	});
});

/**
 * 分页
 */
function jump(pageIndex){
	$("#currentPage").val(pageIndex);
	$("#searchForm").submit();
}