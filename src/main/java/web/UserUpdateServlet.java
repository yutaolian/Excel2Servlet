package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class UserUpdateServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) 
		throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); 
		String userId = req.getParameter("id");
		String idCode = req.getParameter("idCode");
		String name = req.getParameter("name");
		String national = req.getParameter("national");
		String education = req.getParameter("education");
		String position = req.getParameter("position");
		String title = req.getParameter("title");
		String note = req.getParameter("note");
		
		User user = new User();
		user.setId(Integer.parseInt(userId));
		user.setIdCode(idCode);
		user.setName(name);
		user.setNational(national);
		user.setEducation(education);
		user.setPosition(position);
		user.setTitle(title);
		user.setNote(note);
		//查询所有的员工
		UserDao dao = new UserDao();
		Map<String, Object> msg= dao.updateUserByUser(user);
		
		if (msg.get("flag").equals(false)) {
			res.setContentType("text/html");
			res.setHeader("content-type","text/html;charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("  <script type='text/javascript'> alert('"+msg.get("msg")+"')</script>");
			out.println("</HTML>");
			out.flush();
			out.close();
			req.getRequestDispatcher("userPreUpdate?userId="+userId);
		}else{
			//转发给JSP
			//将数据绑定到request上
			req.setAttribute("result", msg);
			//将请求及数据转发给JSP
			req.getRequestDispatcher("userInfo?userId="+userId).forward(req, res);
		}
	
	}

	
	
}
















