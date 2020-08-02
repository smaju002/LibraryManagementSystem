package com.souvik.LibMgmtSys.Loginregistration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.souvik.LibMgmtSys.Loginregistration.Model.Student;
import com.souvik.LibMgmtSys.Loginregistration.Repository.StudentRepository;
import com.souvik.LibMgmtSys.Loginregistration.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	public StudentService stuService;
	
	@Autowired
	public StudentRepository stuRepository;
	
	
	//Get Method
	@RequestMapping("/library")
	public String WelcomeLibrary(){
		return "Welcome Students to the Online Library Management System!!!";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/library/register")
	public void StudentRegister(@RequestBody Student stu) {
		stuService.sendStudentDetailsforRegistration(stu);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/library/login")
	public void StudentLogin(@RequestBody Student stu) {
		stuService.sendUserDetailsforLogin(stu);
	}

}
