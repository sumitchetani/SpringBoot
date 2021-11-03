package com.sumit.StudentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.StudentSystem.model.Student;
import com.sumit.StudentSystem.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public String add(@RequestBody Student student) {

		studentService.saveStudent(student);
		return "new student is added";

	}

	@GetMapping("/getAll")
	public List<Student> getAllStudents() {

		return studentService.getAllStudents();
	}

	@PutMapping("/update")
	public String update(@RequestBody Student student) {
		studentService.update(student);
		return "updation Success";
	}

	@DeleteMapping("/delete{Id}")
	public String delete(@RequestParam("Id") int Id) {
		String msg = "";
		boolean res = studentService.deleteStudent(Id);
		if (res) {
			msg = "deleted successfully";
		} else {
			msg = "not deleted";
		}

		return msg;
	}
	
	
@DeleteMapping("deleteAll")
public String delete(@RequestBody Student student) {
	
	String res = studentService.deleteAll(student);
	return res;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
