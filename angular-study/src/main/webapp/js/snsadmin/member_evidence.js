$(function(){
	$("#search").click(function(){
		$("#currentPage").val(1);
	});
	
//	  //全选
//    $("#selectAll").click(function(){
//      $("input[name='selectData']").each(function(){
//    	  if (this.checked) {
//    		   this.checked = false;
//		   }
//    	  else {
//    		   this.checked = true;
//    	   }
//      });
//    });
	
	
	//不通过
	$('.unpass').click(function(){
		var temp = $(this).attr("data-val");
		var group_id = $(this).attr("group_id");
		var path = $(this).attr("path");
		var update_member_id = $(this).attr("update_member_id");
		
		if(group_id == ''){
			$("#countrys").removeAttr('disabled');
			$("#searchSchool").removeAttr('readonly');
		} else {
			$("#countrys").attr('value',$(this).attr("country_id"));
			$("#countrys").attr('disabled','disabled');
			$("#searchSchool").attr('readonly','readonly');
			$("#searchSchool").attr('value',$(this).attr("school"));
			$("#group_id").val(group_id);
		}
		
		$("#update_member_id").val(update_member_id);
		$("#evidence_id").val(temp);
		$("#path").val(path);
		$("#type").val(2);
		$('.unpass2').show();	
		$('.popupBack').show();	
		return false;
	});
  //通过
  $('.pass').click(function(){
		var temp = $(this).attr("data-val");
		var group_id = $(this).attr("group_id");
		var path = $(this).attr("path");
		var update_member_id = $(this).attr("update_member_id");
		
		if(group_id == ''){
			$("#countrys").removeAttr('disabled');
			$("#searchSchool").removeAttr('readonly');
		} else {
			$("#countrys").attr('value',$(this).attr("country_id"));
			$("#countrys").attr('disabled','disabled');
			$("#searchSchool").attr('readonly','readonly');
			$("#searchSchool").attr('value',$(this).attr("school"));
			$("#group_id").val(group_id);
		}
		$("#update_member_id").val(update_member_id);
		$("#evidence_id").val(temp);
		$("#path").val(path);
		$("#type").val(1);
		$('.pass2').show();	
		$('.popupBack').show();	
		return false;
	});
//   //批量恢复
//  $("#batchRecover").click(function(){
//	  var arrayIds = new Array();
//	  $("input[name='selectData']:checked").each(function(i){
//		  arrayIds[i] = this.value;
//	  });
//	  if(arrayIds.length > 0){
//		  
//		  $("#param_member_ids").val(arrayIds);
//		  $("#type").val(1);
//		  $("#updateForm").submit();
//	  } else {
//		  alert("请选择要恢复的数据");
//	  }
//  });
//  //批量冻结
//  $("#batchForbidden").click(function(){
//	  var arrayIds = new Array();
//	  $("input[name='selectData']:checked").each(function(i){
//		  arrayIds[i] = this.value;
//	  });
//	  if(arrayIds.length > 0){
//		  $("#param_member_ids").val(arrayIds);
//		  $("#type").val(2);
//		  $('.freeze').show();	
//		  $('.popupBack').show();	
//	  } else {
//		  alert("请选择要冻结的数据");
//	  }
//	  return false;
//  });
  //弹出框取消
	$('.btn_cancel').click(function(){
		$('.popup').hide();	
		$('.popupBack').hide();	
		return false;
	});
  //弹出框确定
	$('.freeze .btn_ok').click(function(){
		var searchSchool = $.trim($("#searchSchool").val());
		var subject = $.trim($("#subject").val());
		var forbiddenReason = $.trim($("#forbiddenReason").val());
		var member_id = $("#update_member_id").val();
		if($("#type").val() == 1){
			if(searchSchool.length == 0 && $("#searchSchool").attr('disabled') != 'disabled'){
				alert("请输入学校!");
			} else if(subject.length == 0){
				alert("请输入专业");
			}else {
				checkEvidence(searchSchool, subject, member_id);
			}
		} else {
			if(forbiddenReason.length == 0){
				alert("请输入理由!");
				return false;
			} 
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

	
	/**
	 * 学校@
	 */
	$("#searchSchool").autocomplete(ctx + "/school/getSchoolByCondition.do", {
		minChars:1,
		highlight: false,
		scroll: true,
		scrollHeight: 300,
		dataType: "json", 
		cacheLength:1,
		extraParams:{country_id:function(){return $('#countrys option:selected').val();}},
		parse: function(data) {
             return $.map(data, function(row) {
                 return {
                     data: row,
                     value: row.name,
                     result: row.name
                 };
             });
         },
         formatItem: function(item) {
        	 return item.name; 
         }
	}).result(function(e, item) {
		$("#searchSchool").val(item.name + "_" + item.id);
    });
	
	//检验是否已经验证
	function checkEvidence(school, subject, member_id){
		jQuery.ajax({
	        url : ctx+"/evidence/checkEvidence.do",  
	        processData : true,
	        dataType : "json",
	        type : "post",
	        data : {school:school, subject:subject, member_id:member_id},
	        success : function(data) {
	        	if (data.flag == 1) {
	        		alert("该用户已经有相同学校和专业的offer被审核通过");
	        		return false;
	        	} else {
					$('.popup').hide();	
					$('.popupBack').hide();
					$("#updateForm").submit();
	        	}
	        },  
	        error : function(e) {
	        }  
	    });
	}
});

/**
 * 分页
 */
function jump(pageIndex){
	$("#currentPage").val(pageIndex);
	$("#searchForm").submit();
}