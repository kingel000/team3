$(document).ready(function(){
	headCart();
	receiveCount();
	
	function headCart(){
		var cartList = []
		$.ajax({
			url: "/web/main/headCart.do",
			type: "POST",
			data: JSON.stringify(cartList),
			contentType: "application/json; charset=utf-8;",
			dataType: "json",
			success: function(data){
				cartList = data;
				var count = data.length;
				if(count > 0){
					$('#ps-cart').append("<a class='ps-cart__toggle' href='#'><span><i>"+count+"</i></span><i class='ps-icon-shopping-cart'></i></a>");
					for(var i=0;i<data.length;i++	){
						$('#ps-cart__content').append("<div class='ps-cart-item'><a class='ps-cart-item__close' href='/web/purchase/deleteCart.do?num="+data[i].num+"'></a>"
								+"<div class='ps-cart-item__thumbnail'><a href='/web/product/detailProduct.do?num="+data[i].product_num+"'></a>");
						if(data[i].thumbnail == null){
							$('#ps-cart__content').append("<img src=\"/web/resources/images/basic2.jpg\">");
						}else{
							$('#ps-cart__content').append("<img src=\"/web/ajax/displayFile.do?fileName="+data[i].thumbnail+"\">");
						}		
						
						
						$('#ps-cart__content').append("</div><div class='ps-cart-item__content'><a class='ps-cart-item__title' href='/web/product/detailProduct.do?num="+data[i].product_num
								+"'>"+data[i].product_title+"</a><p><span>Price:<i>"+data[i].price+" ￦</i></span></p></div></div>");
					}
				}else{
					$('#ps-cart').append("<a class='ps-cart__toggle' href='#'><i class='ps-icon-shopping-cart'></i></a>");
				}   
			},
			error: function(){
				$('#ps-cart').append("<a class='ps-cart__toggle' href='#'><i class='ps-icon-shopping-cart'></i></a>");
	        }
		});
	}
	
	function receiveCount(){
		var receive = []
		$.ajax({
			url: "/web/chat/receiveCount.do",
			type: "POST",
			data: JSON.stringify(receive),
			contentType: "application/json; charset=utf-8;",
			dataType: "json",
			success: function(data){
				if(data ==0){
					$('#ps-dropdown').empty();
					return;
				}
				$('#ps-dropdown').empty();
				$('#ps-dropdown').append("<a href='/web/member/mypage.do'>Message:"+data+"</a>");
			},
			error: function(){
				$('#ps-dropdown').empty();
	        }
		});
	}
});