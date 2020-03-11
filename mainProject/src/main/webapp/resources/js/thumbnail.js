$(document).ready(function(){
	$('.content').on("dragover", dragOver);
	$('.content').on("dragleave", dragOver);
	$('.content').on("drop", uploadFiles);
	$('#ajaxFile').on("change",ajaxFileChange);
    var flag = true;
    
	function dragOver(e){
	    e.stopPropagation();
	    e.preventDefault();
	    if (e.type == "dragover") {
	        $(e.target).css({
	            "background-color": "black",
	            "outline-offset": "-20px"
	        });
	    } else {
	        $(e.target).css({
	            "background-color": "gray",
	            "outline-offset": "-10px"
	        });
	    }
	}

	function uploadFiles(event) {
		event.preventDefault(); 
	    var files = event.target.files || event.originalEvent.dataTransfer.files;
	    var file = files[0];
	    console.log(file);
	    var formData = new FormData();
	    formData.append("file", file);


	    dragOver(event);
	    if (!flag) {
	        alert('하나만 올려라.');
	        return;
	    }
	    if (files[0].type.match(/image.*/)) {
	                $(event.target).css({
	            "background-image": "url(" + window.URL.createObjectURL(files[0]) + ")",
	            "outline": "none",
	            "background-size": "100% 100%"
	        });
	    }else{
	      alert('이미지가 아닙니다.');
	      return;
	    }
	    
	    $.ajax({
	        type: "post",
	        url: "/web/ajax/uploadAjax.do",
	        data: formData,
	        dataType: "text",
	        processData: false,
	        contentType: false,
	        // 업로드 성공하면
	        success: function(data) {
	            // 이미지 파일이면 썸네일 이미지 출력
	        	console.log("success");
	            if(checkImageType(data)){ 
	            	$(".uploadedList").append("<div><a href='/web/ajax/displayFile.do?fileName="+getImageLink(data)+"'>");
	            	$(".uploadedList").append("<img src='/web/ajax/displayFile.do?fileName="+data+"'></a>");
	            }
	            // 삭제 버튼
	            $(".uploadedList").append("<span data-src="+data+">[삭제]</span></div>");
	            $("#upload").attr('disabled', true);
	            flag = false;
	        }
	    });
	    
		
	}
	//-------------------------------------------------------------
	$("#upload").click(function(){
		$('#ajaxFile').click();
    });
	
	function ajaxFileChange() {

        ajaxFileTransmit();
    }

	function ajaxFileTransmit(){
		var file = $("input[name=ajaxFile]")[0].files[0];
		console.log(file);
        var formData = new FormData();
        formData.append("file", file);
        
        $.ajax({
	        type: "post",
	        url: "/web/ajax/uploadAjax.do",
	        data: formData,
	        dataType: "text",
	        processData: false,
	        contentType: false,
	        // 업로드 성공하면
	        success: function(data) {
	            // 이미지 파일이면 썸네일 이미지 출력
	            if(checkImageType(data)){ 
	            	$(".uploadedList").append("<div><a href='/web/ajax/displayFile.do?fileName="+getImageLink(data)+"'>");
	            	$(".uploadedList").append("<img src='/web/ajax/displayFile.do?fileName="+data+"'></a>");
	            }
	            // 삭제 버튼
	            $(".uploadedList").append("<span data-src="+data+">[삭제]</span></div>");
	            $("#upload").attr('disabled', true);
	            flag = false;
	            $("input[name=fileName]").attr('value',data);
	        }
	    });
	}
	//파일 삭제
	$(".uploadedList").on("click", "span", function(event){
	    alert("이미지 삭제");
	    var that = $(this); // 여기서 this는 클릭한 span태그
	    $.ajax({
	        url: "/web/ajax/deleteFile.do",
	        type: "post",
	        // data: "fileName="+$(this).attr("date-src") = {fileName:$(this).attr("data-src")}
	        // 태그.attr("속성")
	        data: {fileName:$(this).attr("data-src")}, // json방식
	        dataType: "text",
	        success: function(result){
	            if( result == "deleted" ){
	                // 클릭한 span태그가 속한 div를 제거
	            	$(".uploadedList").empty();
	            	 $("#upload").attr('disabled', false);
	                flag = true;
	            }
	        }
	    });
	});
	
	// 원본파일이름을 목록에 출력하기 위해
	function getOriginalName(fileName) {
	    // 이미지 파일이면
	    if(checkImageType(fileName)) {
	        return; // 함수종료
	    }
	    // uuid를 제외한 원래 파일 이름을 리턴
	    var idx = fileName.indexOf("_")+1;
	    return fileName.substr(idx);
	}
	
	// 이미지파일 형식을 체크하기 위해
	function checkImageType(fileName) {
	    // i : ignore case(대소문자 무관)
	    var pattern = /jpg|gif|png|jpeg/i; // 정규표현식
	    return fileName.match(pattern); // 규칙이 맞으면 true
	}
	
	// 이미지파일 링크 - 클릭하면 원본 이미지를 출력해주기 위해
	function getImageLink(fileName) {
	    // 이미지파일이 아니면
	    if(!checkImageType(fileName)) { 
	        return; // 함수 종료 
	    }
	    // 이미지 파일이면(썸네일이 아닌 원본이미지를 가져오기 위해)
	    // 썸네일 이미지 파일명 - 파일경로+파일명 /2017/03/09/s_43fc37cc-021b-4eec-8322-bc5c8162863d_spring001.png
	    var front = fileName.substr(0, 12); // 년원일 경로 추출
	    var end = fileName.substr(14); // 년원일 경로와 s_를 제거한 원본 파일명을 추출
	    console.log(front); // /2017/03/09/
	    console.log(end); // 43fc37cc-021b-4eec-8322-bc5c8162863d_spring001.png
	    // 원본 파일명 - /2017/03/09/43fc37cc-021b-4eec-8322-bc5c8162863d_spring001.png
	    return front+end; // 디렉토리를 포함한 원본파일명을 리턴
	}
	
});