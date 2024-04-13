package com.bennett.unigo.wallet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.bennett.unigo.wallet.entity.Student;
import com.bennett.unigo.wallet.service.StudentService;

import jakarta.servlet.http.HttpServletResponse;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    
    @GetMapping(value = "/qrcode/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQRCode(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
        // Generate the QR code based on the ID
        ByteArrayOutputStream outputStream = QRCode.from(id).withSize(250, 250).to(ImageType.PNG).stream();

        // Set content type
        response.setContentType(MediaType.IMAGE_PNG_VALUE);

        // Write the QR code image to the response
        response.getOutputStream().write(outputStream.toByteArray());
        response.getOutputStream().flush();

        return outputStream.toByteArray();
    }
    
}
