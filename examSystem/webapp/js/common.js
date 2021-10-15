$(function(){ 
	//提交
	$(".sub-btn").on("click", function(){
		var data = {};
		data.number = $.trim($("input[name=number]").val());
		data.templateId = $.trim($("input[name=templateId]").val());
		data.templateParams = $.trim($("input[name=templateParams]").val());
		if(data.number == ''){
			alert("请输入手机号码");
			return ;
		}
		if(data.templateId == ''){
			alert("请输入模板ID");
			return ;
		}
		$.ajax({
	        url: getBasePath()+"/common",
	        async : true,
	        type: "post",
	        dataType: "text",
	        data: data,
	        success: function (data) {
	        	alert(data);
	        }
    	});
	})
});
