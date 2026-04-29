package yoot.week1.service;

import yoot.week1.domain.entity.Student;
import yoot.week1.dto.request.UpdateStudentRequest;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findByAll();
    Optional<Student> findById(long id);
    Student save(Student student);
    void delete(long id);
    boolean existById(long id);
    Student update(Long id, UpdateStudentRequest request);
}
