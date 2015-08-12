package com.lhl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhl.util.TwoDimensionCode;

public class GetQrCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String appPath = request.getServletContext().getRealPath("/") + "/";
		String uuid = UUID.randomUUID().toString();

		String content = request.getServletContext().getInitParameter("url")
				+ "?uuid=" + uuid;
		String qrCodeImg = "";
		String imgPath = "/QRCode/img/";

		if (request.getSession().getAttribute("aaaa") == null) {
			qrCodeImg = appPath + "img\\002.png";
			imgPath += "002.png";
			request.getSession().setAttribute("aaaa", "1111");
		} else {
			qrCodeImg = appPath + "img\\" + uuid + ".png";
			imgPath += uuid + ".png";
		}

		TwoDimensionCode handler = new TwoDimensionCode();
		handler.encoderQRCode(content, qrCodeImg, "png");

		String jsonStr = "{\"uuid\":" + "\"" + uuid + "\",\"qrCodeImg\":\""
				+ imgPath + "\"}";
		out.print(jsonStr);
		out.flush();
		out.close();
	}
}