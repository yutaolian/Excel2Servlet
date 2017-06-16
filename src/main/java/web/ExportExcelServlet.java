package web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import dao.UserDao;
import entity.User;

public class ExportExcelServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		session.setAttribute("state", null);
		// 生成提示信息，
		res.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			// 进行转码，使其支持中文文件名
			codedFileName = java.net.URLEncoder.encode("用户列表详情", "UTF-8");
			res.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			// response.addHeader("Content-Disposition", "attachment; filename="
			// + codedFileName + ".xls");
			// 产生工作簿对象
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 产生工作表对象
			HSSFSheet sheet = workbook.createSheet();
			// 获得全部库存列表
			UserDao dao = new UserDao();
			List<User> users = dao.findAll();
			{
				HSSFRow row = sheet.createRow((int) 0);// 创建一行
				{
					HSSFCell cell = row.createCell((int) 0);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("姓名");
				}
				{
					HSSFCell cell = row.createCell((int) 1);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("身份分证号");
				}
				{
					HSSFCell cell = row.createCell((int)2);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("性别");
				}
				{
					HSSFCell cell = row.createCell((int) 3);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("出生日期");
				}
				{
					HSSFCell cell = row.createCell((int) 4);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("民族");
				}
				{
					HSSFCell cell = row.createCell((int) 5);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("学历");
				}
				{
					HSSFCell cell = row.createCell((int) 6);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("职务");
				}
				{
					HSSFCell cell = row.createCell((int) 7);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("职称");
				}
				{
					HSSFCell cell = row.createCell((int) 8);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("备注");
				}
				
			}
			
			for (int i = 0; i < users.size(); i++) {
				
				
				HSSFRow row = sheet.createRow((int) i+1);// 创建一行
				User user = users.get(i);
				{
					HSSFCell cell = row.createCell((int) 0);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(user.getName());
				}
				{
					HSSFCell cell = row.createCell((int) 1);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(user.getIdCode());
				}
				{
					HSSFCell cell = row.createCell((int) 2);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(user.getSex());
				}
				{
					HSSFCell cell = row.createCell((int) 3);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(user.getBrithday());
				}
				{
					HSSFCell cell = row.createCell((int) 4);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(user.getNational());
				}
				{
					HSSFCell cell = row.createCell((int) 5);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(user.getEducation());
				}
				{
					HSSFCell cell = row.createCell((int) 6);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(user.getPosition());
				}
				{
					HSSFCell cell = row.createCell((int) 7);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(user.getTitle());
				}
				{
					HSSFCell cell = row.createCell((int) 8);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(user.getNote());
				}
			}
			fOut = res.getOutputStream();
			workbook.write(fOut);
		} catch (UnsupportedEncodingException e1) {
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {
			}
			session.setAttribute("state", "open");
		}
		System.out.println("文件生成...");
	}

}
