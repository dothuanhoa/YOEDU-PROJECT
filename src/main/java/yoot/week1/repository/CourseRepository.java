package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yoot.week1.domain.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT o FROM Course o WHERE o.isActive=1")
    List<Course> findCourseActive();
}
