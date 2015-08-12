/**
 * 
 */
$(function() {
	var uuid;
	$.get("/QRCode/GetQrCodeServlet", function(data, status) {
		var obj = eval("(" + data + ")");
		// 存储UUID
		uuid = obj.uuid;
		$("body span").text(uuid);
		// 显示二维码
		$("#QrCodeImg").attr("src", obj.qrCodeImg.replace(/A/g, "\\"));
		// 开始验证登录
		validateLogin();
	});

	function validateLogin() {
		$.get("/QRCode/LongConnectionCheckServlet?uuid=" + uuid, function(data,
				status) {
			if (data == "") {
				validateLogin();
			} else {
				window.location.href = "welcome.jsp";
			}
		});
	}
});