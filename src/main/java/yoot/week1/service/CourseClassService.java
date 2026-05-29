package yoot.week1.service;

import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.CourseClass;
import yoot.week1.domain.enums.ClassStatus;
import yoot.week1.dto.courseclass.CourseClassResponse;
import yoot.week1.dto.courseclass.CourseClassUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface CourseClassService {
    List<CourseClassResponse> findAll();

    Optional<CourseClassResponse> findById(long id);

    CourseClassResponse create(CourseClassUpsertRequest request);

    CourseClassResponse update(Long id, CourseClassUpsertRequest request);

    void delete(long id);

    CourseClass getCourseClass(Long id) throws NotFoundException;

    List<CourseClassResponse> findAll(ClassStatus status);
}
