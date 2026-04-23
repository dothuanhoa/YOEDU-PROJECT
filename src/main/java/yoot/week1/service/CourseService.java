package yoot.week1.service;

import yoot.week1.domain.entity.Course;
import yoot.week1.dto.request.UpdateCourseRequest;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    Optional<Course> findById(Long id);
    Course save(Course course);
    void delete(Long courseId);
    boolean existById(Long id);
    Course updateCourse(Long id, UpdateCourseRequest request);
}
