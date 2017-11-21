$(function(){
	$("#search").click(function(){
		$("#currentPage").val(1);
	});
	
	  //全选
    $("#selectAll").click(function(){
      $("input[name='selectData']").each(function(){
    	  if (this.checked) {
    		   this.checked = false;
		   }
    	  else {
    		   this.checked = true;
    	   }
      });
    });
	
	
	  //单个冻结
	$('.frozen').click(function(){
		var temp = $(this).attr("data-val");
		var array = new Array();
		array[0] = temp;
		$("#param_member_ids").val(array);
		$("#type").val(2);
		$('.freeze').show();	
		$('.popupBack').show();	
		return false;
	});
  //单个恢复
  $('.recover').click(function(){
		var temp = $(this).attr("data-val");
		var array = new Array();
		array[0] = temp;
		$("#param_member_ids").val(array);
		$("#type").val(1);
		$("#updateForm").submit();
		return false;
	});
   //批量恢复
  $("#batchRecover").click(function(){
	  var arrayIds = new Array();
	  $("input[name='selectData']:checked").each(function(i){
		  arrayIds[i] = this.value;
	  });
	  if(arrayIds.length > 0){
		  
		  $("#param_member_ids").val(arrayIds);
		  $("#type").val(1);
		  $("#updateForm").submit();
	  } else {
		  alert("请选择要恢复的数据");
	  }
  });
  //批量冻结
  $("#batchForbidden").click(function(){
	  var arrayIds = new Array();
	  $("input[name='selectData']:checked").each(function(i){
		  arrayIds[i] = this.value;
	  });
	  if(arrayIds.length > 0){
		  $("#param_member_ids").val(arrayIds);
		  $("#type").val(2);
		  $('.freeze').show();	
		  $('.popupBack').show();	
	  } else {
		  alert("请选择要冻结的数据");
	  }
	  return false;
  });
  //弹出框取消
	$('.btn_cancel').click(function(){
		$('.popup').hide();	
		$('.popupBack').hide();	
		$("#param_member_ids").val('');
		$("#type").val('');
	});
  //弹出框确定
	$('.freeze .btn_ok').click(function(){
		var forbiddenReason = $("#forbiddenReason").val();
		if(forbiddenReason.length == 0){
			alert("请输入冻结理由!");
		} else if(forbiddenReason.length > 500){
			alert("冻结理由长度不能大于500");
		} else {
			$('.popup').hide();	
			$('.popupBack').hide();
			$("#updateForm").submit();
		}
		
	});
	// 冻结原因
	$('.reason').click(function(){
		$("#reasonShow").html($(this).attr("reason"));
		$('.freezeWhy').show();	
		$('.popupBack').show();	
	});
	$('.btn_cancel').click(function(){
		$('.popup').hide();	
		$('.popupBack').hide();	
	});
});

/**
 * 分页
 */
function jump(pageIndex){
	$("#currentPage").val(pageIndex);
	$("#searchForm").submit();
}