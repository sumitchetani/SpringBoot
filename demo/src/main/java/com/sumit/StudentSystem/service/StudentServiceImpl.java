package com.sumit.StudentSystem.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumit.StudentSystem.model.Student;
import com.sumit.StudentSystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
@Autowired
private StudentRepository studentRepository;

@Override
public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

@Override
public List<Student> getAllStudents() {
	// TODO Auto-generated method stub
	return studentRepository.findAll();
}

@Override
public boolean deleteStudent(int id) {
	boolean res = false;
	try {
		studentRepository.deleteById(id);
		 res = true;
	}catch (Exception e) {
		 res = false;
	}
	return res;
}

@Override
public boolean update(Student student) {
	boolean res = false;
	try {
		studentRepository.save(student);
		res=true;
	}catch (HibernateException e) {
		// e.printStackTrace();
		res = false;
	}
	return res;
}

@Override
public String deleteAll(Student student) {

	String s = "Notok";
	try {
	studentRepository.delete(student);
	s="ok";
	}
	catch (HibernateException e) {
		s = "Notok";
	}
	return s;
	
}





}
