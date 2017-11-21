//验证文件的大小
function getFileSize(obj){
	var objValue = obj.value;
    if (objValue==""){
    	box.subfai("请选择文件",function(){setTimeout("closePop()",3000);});
    	return false;
    }
    var fileLenth=-1;
    try {
        //对于IE判断要上传的文件的大小
        var fso = new ActiveXObject("Scripting.FileSystemObject");
        fileLenth=parseInt(fso.getFile(objValue).size);
    } catch (e){
        try{
            //对于非IE获得要上传文件的大小
             fileLenth=parseInt(obj.files[0].size);
        }catch (e) {
            fileLenth=-1;
        }
    }
    return fileLenth;
}
	
//校验上传文件类型
function isLegalFiletype(filename) {
	//jpg,jpeg,png,gif,bmp
	var pattern = /[\.]([j|J|p|P|g|G|b|B][p|P|e|E|n|N|m|M][g|G|p|P])|([j|J|p|P|g|G|b|B][p|P|e|E|n|N|m|M][g|G|p|P|e|E][g|G])$/;
	if (!pattern.exec(filename)) {
		alert("文件格式不正确，请上传图片格式的文件");
		return false;
	}
	return true;
}