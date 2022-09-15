package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.StudentDTO;
import com.example.springdatajpa.entity.Student;
import com.example.springdatajpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Integer id, Student student) {
        Optional<Student> foundedStudent = studentRepository.findById(id);

        if (foundedStudent.isPresent()) {
            Student newStudent = foundedStudent.get();

            newStudent.setName(student.getName());
            newStudent.setSurname(student.getSurname());
            newStudent.setStudentNumber(student.getStudentNumber());
            newStudent.setDateOfBirth(student.getDateOfBirth());

            return studentRepository.save(newStudent);
        }
        return null;

    }

    private StudentDTO convertStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setSurname(student.getSurname());
        return studentDTO;
    }


    public List<StudentDTO> getAllStudent() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertStudentDTO)
                .collect(Collectors.toList());

    }

}
