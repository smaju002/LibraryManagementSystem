package com.souvik.LibMgmtSys.Loginregistration.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.souvik.LibMgmtSys.Loginregistration.Model.Student;

@Repository
public class StudentRepository {
	
	@Autowired
    JdbcTemplate jdbctemplate;

	public StudentRepository(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}
	
	public void RegisterStudent(Student stu){
	    String REGISTER_STUDENT_SQL="insert into spring.student(Id,firstName,lastName,emailId,passwd) values(?,?,?,?,?)"; 
		jdbctemplate.update(REGISTER_STUDENT_SQL, stu.getId(),stu.getFirstName(),stu.getLastName(),stu.getEmailId(),stu.getPasswd());
	}
	
	
	public int CheckStudentId(Student stu) {
		String SEARCH_STUDENT_ID_SQL="select count(*) from spring.student where Id = ?";
		int count = jdbctemplate.queryForObject(SEARCH_STUDENT_ID_SQL,Integer.class,stu.getId());
		return count;
		
	}
	
	public int CheckStudentEmail(Student stu) {
		String SEARCH_STUDENT_EMAIL_SQL="select count(*) from spring.student where emailId = ?";
		int cnt = jdbctemplate.queryForObject(SEARCH_STUDENT_EMAIL_SQL,Integer.class,stu.getEmailId());
		return cnt;
		
	}
	
	public void VerifyStudent(Student stu) {
		int pswd_cnt=0;
		String USERNAME_VERIFY_STUDENT_SQL="select count(*) from spring.student where Id = ?";
		int stu_cnt = jdbctemplate.queryForObject(USERNAME_VERIFY_STUDENT_SQL,Integer.class,stu.getId()); 
		if (stu_cnt == 1) {
			String PASSWORD_VERIFY_STUDENT_SQL="select count(*) from spring.student where Id = ? and passwd = ?";
			pswd_cnt = jdbctemplate.queryForObject(PASSWORD_VERIFY_STUDENT_SQL,Integer.class,stu.getId(),stu.getPasswd());
			System.out.println("value of usr_pswd_cnt" + pswd_cnt);
		}
		else
			System.out.println("You are not Registered, Plese register yourself.");
		
		if (pswd_cnt == 1) {
			System.out.println("Hi"+ stu.getId() + "! You are logged in into the Online Library Management System..");
		}
		else
			System.out.println("Password is not correct for "+ stu.getId());
	}

}
