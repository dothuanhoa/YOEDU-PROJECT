package yoot.week1.service;

import yoot.week1.dto.teacher.TeacherResponse;
import yoot.week1.dto.teacher.TeacherUpsertRequest;

import java.util.List;

public interface TeacherService {
    List<TeacherResponse> findAll();
    TeacherResponse findById(Long id);
    TeacherResponse create(TeacherUpsertRequest request);
    TeacherResponse update(Long id, TeacherUpsertRequest request);
    void delete(Long id);
}
