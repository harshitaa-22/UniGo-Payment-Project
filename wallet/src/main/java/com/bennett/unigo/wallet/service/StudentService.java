package com.bennett.unigo.wallet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bennett.unigo.wallet.entity.Student;
import com.bennett.unigo.wallet.repository.StudentRepository;

 import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
        	if (updatedStudent.getName()!= null)
        		existingStudent.setName(updatedStudent.getName());
        	if (updatedStudent.getEnrollmentNo()!= null)
        		existingStudent.setEnrollmentNo(updatedStudent.getEnrollmentNo());
        	if (updatedStudent.getSemester()!= null)
        		existingStudent.setSemester(updatedStudent.getSemester());
        	if (updatedStudent.getCourse()!= null)
        		existingStudent.setCourse(updatedStudent.getCourse());
        	if (updatedStudent.getActive()!= null)
        		existingStudent.setActive(updatedStudent.getActive());
        	if (updatedStudent.getContactNo()!= null)
        		existingStudent.setContactNo(updatedStudent.getContactNo());

            
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
