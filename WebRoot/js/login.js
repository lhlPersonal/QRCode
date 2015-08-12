/**
 * 
 */

function login() {
	alert($.getUrlParam('uuid'));
	$.ajax({
		url : "/QRCode/PhoneLoginServlet",
		type : "post",
		dataType : "text",
		data : {
			uuid : $.getUrlParam('uuid'),
			uname : "1111",
			upwd : "2222"
		},
		cache : false,
		success : function(data) {
			$("body span").text("Login success.Pls watching the page on PC.")
		}
	});
}

(function($) {
	$.getUrlParam = function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}
})(jQuery);

$(function() {
	login();
});
