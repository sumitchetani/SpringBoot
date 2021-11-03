package com.sumit.StudentSystem.service;

import java.util.List;

import com.sumit.StudentSystem.model.Student;

public interface StudentService {
	
  public Student saveStudent(Student student);	
  public boolean update(Student student);
  
  public List<Student> getAllStudents();
  
  public boolean deleteStudent(int id);
  public String deleteAll(Student student);

}
