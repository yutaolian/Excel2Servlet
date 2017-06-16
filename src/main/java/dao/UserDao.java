package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.User;
import util.DateFormatUtil;
import util.IdcardInfoExtractor;
import util.IdcardValidator;
import util.JdbcUtil;

public class UserDao {

	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();
		try {
			List<Map<String, Object>> result = jdbcUtil.findResultWithParams("select * from user", null);
			for (Map<String, Object> m : result) {
				User user = new User();
				user.setId(Integer.parseInt(m.get("id")+""));
				user.setName(m.get("name")+"");
				user.setIdCode(m.get("id_code")+"");
				user.setBrithday(m.get("brithday")+"");
				user.setEducation(m.get("education")+"");
				user.setNational(m.get("national")+"");
				user.setNote(m.get("note")+"");
				user.setTitle(m.get("title")+"");
				user.setSex(m.get("sex")+"");
				user.setPosition(m.get("position")+"");
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.releaseConn();
		}
		return list;
	}

	public Map<String, Object> saveUsers(List<Map<Integer, String>> data) {
		Map<String, Object> map = new HashMap<>();
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();
		try {
			for (int i = 0; i < data.size(); i++) {
				String idCode = data.get(i).get(1);
				IdcardValidator iv = new IdcardValidator();
				if (!iv.isValidatedAllIdcard(idCode)) {
					map.put("flag", false);
					map.put("msg", "第"+(i+1)+"行身份证非法");
					return map;
				}else{
					String sql = "insert into user (name, id_code,sex,brithday,national,education,position,title,note) values (?, ?,?, ?,?, ?,?, ?,?)"; 
			        List<Object> params = new ArrayList<Object>(); 
			        //姓名
			        params.add(data.get(i).get(0)); 
			        params.add(idCode);
			        IdcardInfoExtractor ie = new IdcardInfoExtractor(idCode);  
			        //性别
			        params.add(ie.getGender());
			        //生日
			        params.add(DateFormatUtil.getStringFormatDate(ie.getBirthday()));
			        
			        params.add(data.get(i).get(2)); 
			        params.add(data.get(i).get(3)); 
			        params.add(data.get(i).get(4)); 
			        params.add(data.get(i).get(5)); 
			        params.add(data.get(i).get(6)); 
			        
					jdbcUtil.updateByPreparedStatement(sql, params);
					map.put("flag", true);
				}
			}
			map.put("msg", "插入"+data.size()+"条用户数据");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "保存异常");
		} finally {
			jdbcUtil.releaseConn();
		}
		return map;
	}

	public 	Map<String, Object> del(String userId) {
		Map<String, Object> map = new HashMap<>();
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();
		
		String sql = "delete from user where id = "+userId;
		try {
			jdbcUtil.updateByPreparedStatement(sql, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", "删除异常");
		} finally {
			jdbcUtil.releaseConn();
		}
		
		return map;
		
	}

	public User getOneByUserId(String userId) {
		Map<String, Object> map = new HashMap<>();
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();
		String sql = "select * from user where id = "+userId;
		try {
			List<Map<String, Object>> findResult = jdbcUtil.findResult(sql);
			
			if (findResult.size() == 1) {
				User user = new User();
				Map<String, Object> m = findResult.get(0);
				user.setId(Integer.parseInt(m.get("id")+""));
				user.setName(m.get("name")+"");
				user.setIdCode(m.get("id_code")+"");
				user.setBrithday(m.get("brithday")+"");
				user.setEducation(m.get("education")+"");
				user.setNational(m.get("national")+"");
				user.setNote(m.get("note")+"");
				user.setTitle(m.get("title")+"");
				user.setSex(m.get("sex")+"");
				user.setPosition(m.get("position")+"");
				return user;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", "数据异常");
			return null;
			
		} finally {
			jdbcUtil.releaseConn();
		}
		return null;
	}

	public Map<String, Object> updateUserByUser(User user) {
		Map<String, Object> map = new HashMap<>();
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();
		try {
				String idCode = user.getIdCode();
				IdcardValidator iv = new IdcardValidator();
				if (!iv.isValidatedAllIdcard(idCode)) {
					map.put("flag", false);
					map.put("msg", "身份证号非法");
					return map;
				}else{
					String sql = "update user set name = ?, id_code = ?,sex = ?,brithday = ?,national = ?,education = ?,position = ?,title = ?,note = ? where id = ? "; 
			        List<Object> params = new ArrayList<Object>(); 
			        //姓名
			        params.add(user.getName()); 
			        params.add(idCode);
			        IdcardInfoExtractor ie = new IdcardInfoExtractor(idCode);  
			        //性别
			        params.add(ie.getGender());
			        //生日
			        params.add(DateFormatUtil.getStringFormatDate(ie.getBirthday()));
			        
			        params.add(user.getNational()); 
			        params.add(user.getEducation()); 
			        params.add(user.getPosition()); 
			        params.add(user.getTitle()); 
			        params.add(user.getNote()); 
			        params.add(user.getId());
					jdbcUtil.updateByPreparedStatement(sql, params);
					map.put("flag", true);
				}
			map.put("msg", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", false);
			map.put("msg", "修改异常");
		} finally {
			jdbcUtil.releaseConn();
		}
		return map;
	}
	
	
	

}
