package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.Enrollment;
import yoot.week1.domain.enums.EnrollmentStatus;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByStudent_IdAndCourseClass_Id(Long studentId, Long courseClassId);

    long countByCourseClass_IdAndStatus(Long courseClassId, EnrollmentStatus status);

    List<Enrollment> findByCourseClass_Id(Long courseClassId);

    Optional<Enrollment> findByStudent_IdAndCourseClass_Id(Long studentId, Long courseClassId);

    List<Enrollment> findByStudent_Id(Long studentId);
}
