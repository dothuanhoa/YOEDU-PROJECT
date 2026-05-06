package yoot.week1.service;

import yoot.week1.domain.entity.Course;
import yoot.week1.dto.course.CourseResponse;
import yoot.week1.dto.course.CourseUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseResponse> findAll();
    Optional<CourseResponse> findById(Long id);
    CourseResponse create(CourseUpsertRequest request);
    CourseResponse update(Long id, CourseUpsertRequest request);
    void delete(Long id);
}
