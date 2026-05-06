package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
