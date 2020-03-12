$(document).ready(function(){
	$('#file').on("change",fileChange);
	
	$("#upload").click(function(){
		$('#file').click();
    });
	
	function fileChange() {
        fileTransmit();
    }

	function fileTransmit(){
		var file = $("input[name=file]")[0].files[0];
		console.log(file);
        var formData = new FormData();
        formData.append("file", file);
        
        $.ajax({
	        type: "post",
	        url: "/web/ajax/uploadFile.do",
	        data: formData,
	        dataType: "text",
	        processData: false,
	        contentType: false,
	        // 업로드 성공하면
	        success: function(data) {	
	            $("input[name=fileName]").attr('value',data);
	            alert(data);
	        }
	    });
	}
});