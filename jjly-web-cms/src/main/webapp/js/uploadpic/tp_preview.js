
var baseUrl="../images/";
//需要页面预读入获取根目录
function getBaseUrl(url){
	baseUrl=url;
}

//logo（一张）   添加
function previewImageLogo(file,logoWidth,logoHeight) {
    var MAXWIDTH = 200;
    var MAXHEIGHT = 200;
    var div = document.getElementById('previewLogo');

    if (file.files && file.files[0]) {
        div.innerHTML = '<div id="divImgLogo" class="four_tj_position"><img id="imgLogo"/> <img id="imgLogoDel" class="four_tj_position_delete" src="'+baseUrl+'four_delete.png" onclick="delImgLogo()"/></div>';
        var img = document.getElementById('imgLogo');
        img.onload = function () {
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, logoWidth, logoHeight);
            img.width = rect.width;
            img.height = rect.height;
        }
        var reader = new FileReader();
        reader.onload = function (evt) { img.src = evt.target.result; }
        reader.readAsDataURL(file.files[0]);

    }else {
    	var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="'; 
    	file.select();
        file.blur();
    	var src = document.selection.createRange().text; 
    	div.innerHTML += '<img id=newImage>'; 
    	var img = document.getElementById('newImage'); 
    	img.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image)";
    	img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src; 
    	var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight); 
    	img.parentNode.removeChild(img);
    	status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height); 
    	      div.innerHTML += '<div id=divImgLogo class="four_tj_position">'+
    	    	  "<div id=imgLogo style='width:"+logoWidth+"px;height:"+logoHeight+"px;"+sFilter+src+"\"'></div>"+
    	      '<img id="imgLogoDel" style="z-index:2;position: absolute;top: -5px;right: -5px;" src="'+baseUrl+'four_delete.png" onclick="delImgLogo()"/>'+
    	      '</div>';
    } 
    
    var imgAdd=document.getElementById('imgAdd4');
	imgAdd.style.display="none"; 

}

// 主图删除
function delImgLogo(){
	if(!confirm("确认删除？")){
		return ;
	}
	var div=document.getElementById('divImgLogo');
	div.parentNode.removeChild(div);
	var imgAdd=document.getElementById('imgAdd4');
	imgAdd.style.display="block";
}

// 主图（一张）   添加
function previewImageHome(file) {
    var MAXWIDTH = 100;
    var MAXHEIGHT = 100;
    var div = document.getElementById('previewHome');

    if (file.files && file.files[0]) {
        div.innerHTML = '<div id="divImgHome" class="four_tj_position"><img id="imgHome"/> <img id="imgHomeDel" class="four_tj_position_delete" src="'+baseUrl+'four_delete.png" onclick="delImgHome()"/></div>';
        var img = document.getElementById('imgHome');
        img.onload = function () {
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, 88, 88);
            img.width = rect.width;
            img.height = rect.height;
        }
        var reader = new FileReader();
        reader.onload = function (evt) { img.src = evt.target.result; }
        reader.readAsDataURL(file.files[0]);

    }else {
    	var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="'; 
    	file.select();
        file.blur();
    	var src = document.selection.createRange().text; 
    	div.innerHTML += '<img id=newImage>'; 
    	var img = document.getElementById('newImage'); 
    	img.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image)";
    	img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src; 
    	var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight); 
    	img.parentNode.removeChild(img);
    	status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height); 
    	      div.innerHTML += '<div id=divImgHome class="four_tj_position">'+
    	    	  "<div id=imgHome style='width:88px;height:88px;"+sFilter+src+"\"'></div>"+
    	      '<img id="imgHomeDel" style="z-index:2;position: absolute;top: -5px;right: -5px;" src="'+baseUrl+'four_delete.png" onclick="delImgHome()"/>'+
    	      '</div>';
    } 
    
    var imgAdd=document.getElementById('imgAdd1');
	imgAdd.style.display="none"; 

}

// 主图删除
function delImgHome(){
	if(!confirm("确认删除？")){
		return ;
	}
	var div=document.getElementById('divImgHome');
	div.parentNode.removeChild(div);
	var imgAdd=document.getElementById('imgAdd1');
	imgAdd.style.display="block";
}


// 附图 （4张）  添加
var img_count=0;
var img_index=0;
function previewImage(file,maxCount) {	
    var MAXWIDTH = 100;
    var MAXHEIGHT = 100;
    var div = document.getElementById('previewAttacted');
    
if(img_count<maxCount){
    if (file.files && file.files[0]) {
        div.innerHTML += '<div id="divAttacted'+img_index+'" class="four_tj_position"><img id="imgAttacted' + img_index + '"/> <img class="four_tj_position_delete" src="'+baseUrl+'four_delete.png" onclick="delPreviewImage(this, '+img_index+','+maxCount+')"/></div>';
        var img = document.getElementById('imgAttacted' + img_index);
        img.onload = function () {
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, 88, 88);
            img.width = rect.width;
            img.height = rect.height;

        }
        var reader = new FileReader();
        reader.onload = function (evt) { img.src = evt.target.result; }
        reader.readAsDataURL(file.files[0]);
		
    }
    else {
    	var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="'; 
    	file.select();
        file.blur();
    	var src = document.selection.createRange().text; 
    	div.innerHTML += '<img id=newImage>'; 
    	var img = document.getElementById('newImage'); 
    	img.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image)";
    	img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src; 
    	var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight); 
    	img.parentNode.removeChild(img);
    	status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height); 
    	      div.innerHTML += '<div id="divAttacted'+img_index+'" class="four_tj_position">'+
    	    	  "<div id=imgAttacted"+img_index+" style='width:88px;height:88px;"+sFilter+src+"\"'></div>"+
    	      '<img style="z-index:2;position: absolute;top: -5px;right: -5px;" src="'+baseUrl+'four_delete.png" onclick="delPreviewImage(this, '+img_index+','+maxCount+')"/>'+
    	      '</div>';
    } 
    
    var imgAdd=document.getElementById('imgAdd2');
    var preFile=document.getElementById('attactedFile'+img_index);
    preFile.style.display="none";
    img_index++;
	img_count++;
	
    var newFile=document.createElement("input");
	newFile.id='attactedFile'+img_index;
	newFile.name='attactedFile'+img_index;
	newFile.type="file";
	newFile.setAttribute("onchange","previewImage(this,"+maxCount+")");
    imgAdd.appendChild(newFile);
    
	if(img_count>=maxCount){
		imgAdd.style.display="none";
	}
}
	
}
//附图 （4张）  删除
function delPreviewImage(event,img_index,maxCount,picId){
	if(!confirm("确认删除？")){
		return ;
	}
	var preFile=document.getElementById('attactedFile'+img_index);
	if(preFile!=null){
		preFile.parentNode.removeChild(preFile);
	}else{
		var img=document.getElementById("imgAttacted"+img_index);
		saveDelPhoto(img.src, picId);
	}
	var div=document.getElementById('divAttacted' + img_index);
	div.parentNode.removeChild(div);
	
	if(img_count==maxCount){
		var imgAdd=document.getElementById('imgAdd2');
		imgAdd.style.display="block";
	}
	img_count--;
}

// 详情图（5张）  添加
var detail_count=0;
var detail_index=0;
function previewImageDetail(file,maxCount) {
    var MAXWIDTH = 100;
    var MAXHEIGHT = 100;
    var div = document.getElementById('previewDetail');
    
	if(detail_count<maxCount){
    if (file.files && file.files[0]) {
        div.innerHTML += '<div id="divDetail'+detail_index+'" class="four_tj_position"><img id="imgDetail' + detail_index + '"/> <img class="four_tj_position_delete" src="'+baseUrl+'four_delete.png" onclick="delPreviewImageDetail(this, '+detail_index+','+maxCount+',null)"/></div>';
        var img = document.getElementById('imgDetail' + detail_index);
        img.onload = function () {
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, 88, 88);
            img.width = rect.width;
            img.height = rect.height;

        }
        var reader = new FileReader();
        reader.onload = function (evt) { img.src = evt.target.result; }
        reader.readAsDataURL(file.files[0]);
       
    }else{
    	var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="'; 
    	file.select();
        file.blur();
    	var src = document.selection.createRange().text; 
    	div.innerHTML += '<img id=newImage>'; 
    	var img = document.getElementById('newImage'); 
    	img.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image)";
    	img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src; 
    	var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight); 
    	img.parentNode.removeChild(img);
    	status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height); 
    	div.innerHTML += '<div id="divDetail'+detail_index+'" class="four_tj_position">'+
    		"<div id=imgDetail"+detail_index+" style='width:88px;height:88px;"+sFilter+src+"\"'></div>"+
    		'<img style="z-index:2;position: absolute;top: -5px;right: -5px;" src="'+baseUrl+'four_delete.png" onclick="delPreviewImageDetail(this, '+detail_index+','+maxCount+',null)"/>'+
    		'</div>';

    } 
    
    var imgAdd=document.getElementById('imgAdd3');
    var preFile=document.getElementById('detailFile'+detail_index);
    preFile.style.display="none";
    detail_index++;
	detail_count++;
	
    var newFile=document.createElement("input");
	newFile.id='detailFile'+detail_index;
	newFile.name='detailFile'+detail_index;
	newFile.type="file";
	newFile.setAttribute("onchange","previewImageDetail(this,"+maxCount+")");
    imgAdd.appendChild(newFile);
	
	if(detail_count>=maxCount){
		var imgAdd=document.getElementById('imgAdd3');
		imgAdd.style.display="none";
	}
   
	}

}

//详情图（5张） 删除
function delPreviewImageDetail(event,img_index,maxCount,picId){
	if(!confirm("确认删除？")){
		return ;
	}
	var preFile=document.getElementById('detailFile'+img_index);
	if(preFile!=null){
		preFile.parentNode.removeChild(preFile);	
	}else{
		var img=document.getElementById("imgDetail"+img_index);
		saveDelPhoto(img.src,picId);
	}
	var div=document.getElementById('divDetail' + img_index);
	div.parentNode.removeChild(div);
	
	if(detail_count==maxCount){
		var imgAdd=document.getElementById('imgAdd3');
		imgAdd.style.display="block";
	}
	detail_count--;
}


// 图片固定大小
function clacImgZoomParam(maxWidth, maxHeight, width, height) {
    var param = { top: 0, left: 0, width: width, height: height };
    if (width > maxWidth || height > maxHeight) {
        rateWidth = width / maxWidth;
        rateHeight = height / maxHeight;

        if (rateWidth > rateHeight) {
            param.width = maxWidth;
            param.height = Math.round(height / rateWidth);
        } else {
            param.width = Math.round(width / rateHeight);
            param.height = maxHeight;
        }
    }

    param.left = Math.round((maxWidth - param.width) / 2);
    param.top = Math.round((maxHeight - param.height) / 2);
    return param;
}

// 图片总量初始化，用于编辑状况
function goodsPhotoInit(showCount,detailCount){
	img_count=showCount;
	img_index=showCount;
	detail_count=detailCount;
	detail_index=detailCount;
}

//图片总量重置      0不重置，1重置
function photoCountReset(attacted,detail){
	if(attacted>0){
		img_count=0;
		img_index=0;
	}
	if(detail>0){
		detail_count=0;
		detail_index=0;
	}
}

// 保存删除的图片    （页面端 需要一个id=delPhoto 的文本控件）
function saveDelPhoto(photoName, picId){
	console.log("picId:"+picId);
	var delPhoto=document.getElementById("delPhoto");
	
	if(picId!=null && picId!="null"){
		if(delPhoto.value!=""){
			delPhoto.value=delPhoto.value+"-"+picId;
		}else{
			delPhoto.value=picId;
		}
	}
}

//是否上传商品标识
var isHomeFileEmpty=true;

//文件控件内容清理
function change(obj){ 
  if(obj.outerHTML!=""){
	  isHomeFileEmpty=false;
	  //var nf = obj.cloneNode(true);
	  // 设计新控件value为空  
	  //nf.value=''; 	  
	  //obj.parentNode.replaceChild(nf, obj);
	  previewImageHome(obj);
  }
} 




