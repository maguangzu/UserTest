/**
 * BookListServlet.java
 * com.book.servlet
 * 2016-8-23 		Administrator
 * Copyright (c) 2016, Oracle Harbin All Rights Reserved.
*/

package com.zccp.bms.servlet;

import com.zccp.bms.entity.UserInfo;
import com.zccp.bms.service.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 查询
 */
public class UserServletName extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6106814938137504300L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserBiz userBiz = new UserBiz();
		String loginanme = req.getParameter("loginname");
		List<UserInfo> userList = userBiz.findUserName(loginanme);
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);

	}
}

