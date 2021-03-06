package web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class UserDelServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) 
		throws ServletException, IOException {
		
		
		String userId = req.getParameter("userId");
		
		//查询所有的员工
		UserDao dao = new UserDao();
		Map<String, Object> result = dao.del(userId);
		//转发给JSP
		//将数据绑定到request上
		req.setAttribute("result", result);
		//将请求及数据转发给JSP
		req.getRequestDispatcher("userList").forward(req, res);
	}

	
	
}
















