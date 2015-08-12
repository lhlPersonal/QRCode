package com.lhl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhl.bean.LoginUserVo;
import com.lhl.bean.UserVo;

public class PhoneLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhoneLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");

		UserVo userVo = (UserVo) request.getServletContext().getAttribute(uuid);
		if (userVo == null) {
			userVo = new UserVo();
			userVo.setUname(uname);
			userVo.setUpwd(upwd);

			request.getServletContext().setAttribute(uuid, userVo);
		}
		PrintWriter out = response.getWriter();
		out.print("success");
		out.flush();
		out.close();
	}
}