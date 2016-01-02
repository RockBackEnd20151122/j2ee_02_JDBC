/**
 * 
 */
package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;

/**
 * @author RockWang
 *
 */
public class Open {
	
	private static SqlConnecter connecter =new SqlConnecter();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		addStudent();
		
//		List<Student> listStudent = searchAll();
		String sql = "select * from student";
		
		ResultSet rs = connecter.queryAll(sql);
		List<Student> listStudent = new ArrayList<Student>(); 
		try {
			while (rs.next()){
				Student student = new Student();
				student.setId(rs.getInt(rs.findColumn("id")));
				student.setName(rs.getString(rs.findColumn("name")));
				student.setAge(rs.getInt(rs.findColumn("age")));
				student.setAddress(rs.getString(rs.findColumn("address")));
				listStudent.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<listStudent.size(); i++){
			
			Student student = listStudent.get(i);
			
			System.out.println(student.getId() );
			System.out.println(student.getName() );
			System.out.println(student.getAge() );
			System.out.println(student.getAddress() );
		}
		
	}
	
	private void addStudent(){
//		String sql = String.format("insert into student(name,age,address) values('%s',%d,'%s')",student.getName(),student.getAge(),student.getAddress());
		String sql = "insert into student(name,age,address) values('Rock', 32, '金钟路')" ;
		
		connecter.excuteQuery(sql);

	}
	
	private List<Student> searchAll (){
		
		String sql = "select * from student";
		
		ResultSet rs = connecter.queryAll(sql);
		List<Student> listStudent = new ArrayList<Student>(); 
		try {
			while (rs.next()){
				Student student = new Student();
				student.setId(rs.getInt(rs.findColumn("id")));
				student.setName(rs.getString(rs.findColumn("name")));
				student.setAge(rs.getInt(rs.findColumn("age")));
				student.setAddress(rs.getString(rs.findColumn("address")));
				listStudent.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listStudent;
		
	}
}
