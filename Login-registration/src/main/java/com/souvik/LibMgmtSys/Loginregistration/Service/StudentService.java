package com.souvik.LibMgmtSys.Loginregistration.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souvik.LibMgmtSys.Loginregistration.Model.Student;
import com.souvik.LibMgmtSys.Loginregistration.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	public StudentRepository studentRepository;
	
	List<Student> list = new ArrayList<>();
	
	public void sendStudentDetailsforRegistration(Student stu) {
		int return_code=studentRepository.CheckStudentId(stu);
		if ( return_code == 1)
			System.out.println("Username Already Exists");
		else
			studentRepository.RegisterStudent(stu);
		
		int rtn_cd=studentRepository.CheckStudentEmail(stu);
		if ( rtn_cd == 1)
			System.out.println("Email_id Already Exists");
		else
			studentRepository.RegisterStudent(stu);
	}

	public void sendUserDetailsforLogin(Student stu) {
		studentRepository.VerifyStudent(stu);
		
	}
}
