package yoot.week1.service;

import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.Student;
import yoot.week1.dto.student.StudentResponse;
import yoot.week1.dto.student.StudentUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentResponse> findByAll();
    Optional<StudentResponse> findById(long id);
    StudentResponse create(StudentUpsertRequest request);
    StudentResponse update(Long id, StudentUpsertRequest request);
    void delete(Long id) throws NotFoundException;
    Student getStudent(long id);
}
