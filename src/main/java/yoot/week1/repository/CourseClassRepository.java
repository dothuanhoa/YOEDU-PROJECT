package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.CourseClass;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {
}
