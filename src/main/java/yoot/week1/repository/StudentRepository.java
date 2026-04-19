package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
