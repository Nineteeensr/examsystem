/**  
 * 
 * @Title:  StudentPaperDaoImpl.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/17 09:36:18
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.kgc.kjde1035.group1.entity.Studentpaper;

/**
 * @author 10217
 *
 */
public class StudentPaperDaoImpl extends BaseDao implements StudentPaperDao {
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet rs = null;
	
	/**
	 * 学生提交答案
	 */
	@Override
	public Integer addPaper(Studentpaper studentpaper) {
		conn = this.getConnection();
		String sql = "insert into studentpaper values(?,?,?,?,?,?)";
		Object[] params = {studentpaper.getSpid(),studentpaper.getUserid(),studentpaper.getSid(),studentpaper.getStudentkey(),studentpaper.getStudentstate(),studentpaper.getPname()};		
		return this.executeUpdate(sql, params);
	}

}
