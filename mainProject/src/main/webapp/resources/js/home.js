$(document).ready(function(){
	headCart();
	
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
						var src = "/resources/images/";
						$('#ps-cart__content').append("<div class='ps-cart-item'><a class='ps-cart-item__close' href='/web/purchase/deleteCart.do?num="+data[i].num+"'></a>"
								+"<div class='ps-cart-item__thumbnail'><a href='/web/product/detailProduct.do?num="+data[i].product_num+"'></a>"
								+"<img src=\"/web/resources/images/cart-preview/1.jpg\">"
								+"</div><div class='ps-cart-item__content'><a class='ps-cart-item__title' href='/web/product/detailProduct.do?num="+data[i].product_num
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
});