package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
