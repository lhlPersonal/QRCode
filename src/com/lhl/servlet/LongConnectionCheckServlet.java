package com.lhl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhl.bean.LoginUserVo;
import com.lhl.bean.UserVo;

public class LongConnectionCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String uuid = request.getParameter("uuid");
		String jsonStr = "";

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		UserVo userVo = (UserVo) request.getServletContext().getAttribute(uuid);
		if (userVo != null) {
			jsonStr = "{\"uname\":\"" + userVo.getUname() + "\"}";
			request.getServletContext().removeAttribute(uuid);
		}

		try (PrintWriter out = response.getWriter()) {
			out.print(jsonStr);
		}
	}
}