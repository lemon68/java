// 七牛图片上传
var uploader = Qiniu.uploader({
    runtimes: 'html5,flash,html4',      // 上传模式，依次退化
    browse_button: 'fileBtn',         // 上传选择的点选按钮，必需
    uptoken_url:Util.common.baseUrl+"/weixin/upload.qiniu/getToken.do", // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
    get_new_uptoken: false,             // 设置上传文件的时候是否每次都重新获取新的uptoken

    domain: 'http://onz7jo1wu.bkt.clouddn.com/', // bucket域名，下载资源时用到，必需
    container: 'imgDom',             // 上传区域DOM ID，默认是browser_button的父元素
    max_file_size: '100mb',             // 最大文件体积限制
    flash_swf_url: 'path/of/plupload/Moxie.swf',  //引入flash，相对路径
    max_retries: 3,                     // 上传失败最大重试次数
    dragdrop: true,                     // 开启可拖曳上传
    drop_element: 'imgDom',          // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    chunk_size: '4mb',                  // 分块上传时，每块的体积
    auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
    init: {
        'FilesAdded': function(up, files) {
            plupload.each(files, function(file) {
                // 文件添加进队列后，处理相关的事情
            });
        },
        'BeforeUpload': function(up, file) {
            // 每个文件上传前，处理相关的事情
        },
        'UploadProgress': function(up, file) {
            // 每个文件上传时，处理相关的事情
        },
        'FileUploaded': function(up, file, info) {
            var op=up.getOption();
            var targetContainer=op.tigger_container;
            var progress = new FileProgress(file, targetContainer);
            var url=progress.getCompleteImg(up, info, "-img");

            var domain =up.getOption('domain');
            var res =eval('('+info+')');
            var imgUrl = domain+res.key;
            console.log(imgUrl)
            // recharge.$set('payVoucherT',imgUrl)
            $("#showImg").attr( "src", imgUrl );
            $(".upPhone").css("display","block")
        },

        'Error': function(up, err, errTip) {
            //上传出错时，处理相关的事情
        },
        'UploadComplete': function() {
            //队列文件处理完毕后，处理相关的事情
        },
        'Key': function(up, file) {
            // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
            // 该配置必须要在unique_names: false，save_key: false时才生效
            var key = file.name;
            // do something with key here
            return key
        }
    }
});