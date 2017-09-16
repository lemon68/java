
/* 初始化validate 事件 */
$.validator.setDefaults({
            errorElement: null, //添加的标签为空
            onfocusout: true,  //鼠标离开输入框校验
            errorPlacement: function (error, element) {
                //验证时，默认执行的函数，为可以为空
                //$(element).addClass('vid');
            }
        });
