package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.LearningResult;

public interface LearningResultRepository extends JpaRepository<LearningResult, Long> {
    boolean existsByStudentIdAndCourseClassIdAndResultMonth(Long studentId, Long courseClassId,
                                                            java.time.LocalDate resultMonth);

    java.util.List<LearningResult> findByStudentId(Long studentId);
}
