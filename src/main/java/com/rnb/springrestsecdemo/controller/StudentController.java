package com.rnb.springrestsecdemo.controller;


import com.rnb.springrestsecdemo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rnb")
public class StudentController {
    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Name1", 20, "Java"),
            new Student(2, "Name2", 21, "BlockChain")
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public List<Student> addStudent(@RequestBody Student student) {
        students.add(student);
        return students;
    }

    @GetMapping("/token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        CsrfToken csrf = (CsrfToken) request.getAttribute("_csrf");
        return csrf;
    }
}
