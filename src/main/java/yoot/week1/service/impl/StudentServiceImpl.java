package yoot.week1.service.impl;

import org.springframework.stereotype.Service;
import yoot.week1.domain.entity.Student;
import yoot.week1.repository.StudentRepository;
import yoot.week1.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> findByAll() {
        return studentRepository.findAll();
    }
}
