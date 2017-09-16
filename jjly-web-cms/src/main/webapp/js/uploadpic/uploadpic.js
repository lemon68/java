//java demo:http://www.oschina.net/question/727950_174276
// 文件上传
jQuery(function() {
    var $ = jQuery,
    	//图片上传按钮
        $btn = $('#ctlBtn'),
        //图片上传状态
        state = 'pending',

        // 优化retina, 在retina下这个值是2
        // ratio = window.devicePixelRatio || 1,

        // 缩略图大小
        // thumbnailWidth = 100 * ratio,
        // thumbnailHeight = 100 * ratio,
        thumbnailWidth = 120,
        thumbnailHeight = 110,
        //定义控件
        uploader;

    //控件自定义参数 参数是json数组形式
   /*
   	*  fromDataValue ：标识符，用于区别不同的图片控件，可自定义
   	*  server ： 后台服务地址
   	*  fileNumLimit ：图片限制个数
   	*  fileSizeLimit ： 限制最大的上传大小
   	*  fileSingleSizeLimit ：限制单张上传大小
   	*  pickId ：添加图片按钮ID
   	*  pickLabel ：添加图片按钮 描述
   	*
    */
    // 参数demo
	// var datas = {
	// 	"uploader": [
	// 		{
	// 			'fromDataValue': '001',
	// 			'server': '../server/fileupload.php',
	// 			'fileNumLimit':'1',
	// 			'fileSizeLimit':'200',
	// 			'fileSingleSizeLimit':'20',
	// 			'pickId':'picker',
	// 			'pickLabel':'+'
	// 		}
	// 		]
	// 	};
	var datas = {
		"uploader": [
			{
    			'fromDataValue': '001',
    			'server': '/attachment/upload',
    			'fileNumLimit':'5',
    			'fileSizeLimit':'200',
    			'fileSingleSizeLimit':'20',
    			'pickId':'picker',
    			'pickLabel':'+',
    			//fileVal:'urlfile'
    			//'method':'GET'
    		}
			]
		};
	//初始化上传控件
	uploader = initUploader(datas);
	//给对应控件添加事件
	addEvent(uploader);

    //开始上传图片
  /*  $btn.on( 'click', function() {
    	// console.log(uploader);
    	var upLen = uploader.length;
    	console.log(upLen);
    	for (var i = 0; i < upLen; i++) {
    		if ( uploader[i].state === 'uploading' ) {
	            uploader[i].stop();
	        } else {
	            uploader[i].upload();
	            //图片上传完毕后重置队列
	            // uploader.reset();
	        }
    	};
        
    });*/

    function initUploader(datas) {
    	var upObj = [];
    	// console.log(datas.uploader[2]);
    	objlen = datas.uploader.length;
    	for (var i = 0; i < objlen; i++) {
    		var thisObj = datas.uploader[i];
    		// console.log(thisObj);
    		 uploader = WebUploader.create({
		    	formData: {
		            uid: thisObj.fromDataValue
		        },
		        // 不压缩image
		        resize: false,

		        // swf文件路径
		        swf: 'js/Uploader.swf',
		        // 自动上传
		        auto: true,

		        // 文件接收服务端。
		        server: thisObj.server,
		        //开启重复上传
		        duplicate: true,

		        // 选择文件的按钮。可选。
		        //图片上传最大数量
		        fileNumLimit: thisObj.fileNumLimit,
		        // 所以图片大小
		        fileSizeLimit: thisObj.fileSizeLimit * 1024 * 1024,    // 200 M
		        // 单个图片大小
		        fileSingleSizeLimit: thisObj.fileSingleSizeLimit * 1024 * 1024,   // 20 M

		        pick: {
		                id: '#'+thisObj.pickId,
		                label: thisObj.pickLabel
		            },
		        // 只允许选择文件，可选。
		        accept: {
		            title: 'Images',
		            extensions: 'gif,jpg,jpeg,bmp,png',
		            mimeTypes: 'image/*'
		        }
		    });
    		 upObj.push(uploader);
    	};
    	
    	return upObj;
    };
    
	function addEvent(uploader) {
		// console.log(uploader[0]);
		var upLen = uploader.length;
		for (var i = 0; i < upLen; i++) {

			// 当有文件添加进来的时候
			// console.log(uploader[i].options.pick.id);
			var pickId = uploader[i].pickId;
			uploader[i].on( 'fileQueued', function(file) {
	    		//dom操作
	    		var pickId = this.options.pick.id;
	    		// console.log(pickId);
	    		var _this = this;
		    	var $li = $(
		    			//----
		    			'<li id="'+($.data(document.body,'attachId')+1)+'">'+
	              			'<img id="showImg">'+
	              			//<a href="http://cspic.dzq.com/'+$.data(document.body,'path')+'" target="_blank">'</a>'+
	             			'<img id="del" class="uploadpic-delete" src="/images/kh_del.png" />'+
             		    '</li>'
		    			//---
		                ),
		            //$img = $li.find('img');
		    	    $img = $li.find('#showImg');
		        //从队列中删除文件
			    $li.on('click', '#del', function() {
				    _this.removeFile(file, true);
				    var id = $li.attr("id");
				    deleteContractAttach(id,$li);
				});

		        // 新增图片 $list.append( $li );
		        $(pickId).before($li);


		        // 创建缩略图
		        this.makeThumb( file, function( error, src ) {
		            if ( error ) {
		                $img.replaceWith('<span>不能预览</span>');
		                return;
		            }

		            $img.attr( 'src', src );
		        }, 100, 100 );
		    });
		    // 文件上传过程中创建进度条实时显示。
		    uploader[i].on( 'uploadProgress', function( file, percentage ) {
		        var $li = $( '#'+file.id ),
		            $percent = $li.find('.progress span');

		        // 避免重复创建
		        if ( !$percent.length ) {
		            $percent = $('<p class="progress"><span></span></p>')
		                    .appendTo( $li )
		                    .find('span');
		        }

		        $percent.css( 'width', percentage * 100 + '%' );
		    });

		    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
		    uploader[i].on( 'uploadSuccess', function(file,response) {
		    	//图片地址
		    	$.data(document.body,'path',response.resultObj['path']);
		    	//记录返回的附件id
		    	$.data(document.body,'attachId',(response.resultObj.id));
		    	var attachId = response.resultObj.id;
		    	var id=$("#attachId").val();
		    	id+=attachId+","
		    	$("#attachId").val(id);
		        $( '#'+file.id ).addClass('upload-state-done');
		    });

		    // 文件上传失败，现实上传出错。
		    uploader[i].on( 'uploadError', function( file ) {
		    	
		        var $li = $( '#'+file.id ),
		            $error = $li.find('div.error');

		        // 避免重复创建
		        if ( !$error.length ) {
		            $error = $('<div class="error"></div>').appendTo( $li );
		        }

		        $error.text('上传失败');
		    });

		    // 完成上传完了，成功或者失败，先删除进度条。
		  /*  uploader[i].on( 'uploadComplete', function( file ) {
		    	alert('?');
		        $( '#'+file.id ).find('.progress').remove();
		    });

		    uploader[i].on( 'all', function( type ) {
		        if ( type === 'startUpload' ) {
		            this.state = 'uploading';
		        } else if ( type === 'stopUpload' ) {
		            this.state = 'paused';
		        } else if ( type === 'uploadFinished' ) {
		            this.state = 'done';
		        }

		        if ( state === 'uploading' ) {
		            $btn.text('暂停上传');
		        } else {
		            $btn.text('开始上传');
		        }
		    });*/
		};
	};
	//删除附件
	function deleteContractAttach(id,obj){
		var url="/contractattach/contractattach-deleteAttach?id="+id;
		$.easymsg.confirm(
				'温馨提示',
				'你确定要删除选中的合同附件么？',
				function(r){
					if(r){
						controlImageNum('newAdd');
						obj.remove();
						//删除处理
						var idStr = $("#attachId").val();
						var ids = idStr.split(",");
						ids.splice(jQuery.inArray(id,ids),1);
						if(ids.length>1){
							$("#attachId").val(ids.join(","));
						}else{
							$("#attachId").val("");
						}
						$.ajax({ 
							type:"GET",
							url:url,
									success:function(data){
										data = $.parseJSON(data);
										if(data.success){
											$.easymsg.alert('温馨提示', '合同附件'+data.resultMsg, 'info');
											$("#"+id).remove();
											return false;
										}
										$.easymsg.alert('温馨提示', data.resultMsg, 'warning');
									}
						});
					}
				}
			);
	}
	//控制上传控件的显示和隐藏
	function controlImageNum(flag){

		  var num;
		  if(flag=="newAdd"){
			  num = $(".uploadpic-list").find("li").length-2;
		  }else{
			  num = $(".uploadpic-list").find("li").length-1;
		  }
		
		if(num>=5){
			$("#picker").hide();
		}else{
			$("#picker").show();
		}
	}
	//添加按钮
    //uploader.addButton({
	//     id: '#picker1',
	//     innerHTML: '继续上传'
	// });
	
});
