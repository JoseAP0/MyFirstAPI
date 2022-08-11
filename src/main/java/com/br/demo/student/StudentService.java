package com.br.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    public void registerStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());

        if (optionalStudent.isPresent()){
            throw new IllegalStateException("Email already registered");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {

        if (!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("Student with id: " + studentId + "do not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Integer studentId, String name, String email) {

        Student student = studentRepository.findById(studentId).orElseThrow( () ->
                                            new IllegalStateException("The given student does not exist."));

        if (name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }
    }
}
