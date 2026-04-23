package yoot.week1.service;

import yoot.week1.domain.entity.Teacher;
import yoot.week1.dto.request.UpdateTeacherRequest;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAll();
    Optional<Teacher> findById(long id);
    Teacher save(Teacher teacher);
    void delete(long id);
    boolean existById(long id);
    Teacher update(Long id, UpdateTeacherRequest request);
}
