$(function(){
	$("#search").click(function(){
		$("#currentPage").val(1);
	});
});
/**
 * 分页
 */
function jump(pageIndex){
	$("#currentPage").val(pageIndex);
	$("#searchForm").submit();
}