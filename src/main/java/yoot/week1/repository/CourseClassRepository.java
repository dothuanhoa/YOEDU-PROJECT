package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.CourseClass;
import yoot.week1.domain.enums.ClassStatus;
import yoot.week1.dto.courseclass.CourseClassResponse;

import java.util.Collection;
import java.util.List;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {
    CourseClass getCourseClassesById(long id);

    List<CourseClass> findAllByStatus(ClassStatus status);
}
