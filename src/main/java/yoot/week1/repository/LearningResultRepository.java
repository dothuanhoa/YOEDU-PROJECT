package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yoot.week1.domain.entity.LearningResult;

import java.time.LocalDate;
import java.util.List;

public interface LearningResultRepository extends JpaRepository<LearningResult, Long> {
    boolean existsByStudentIdAndCourseClassIdAndResultMonth(Long studentId, Long courseClassId,
                                                            java.time.LocalDate resultMonth);

    List<LearningResult> findByStudentIdOrderByResultMonthDesc(Long studentId);

    @Query("SELECT o FROM LearningResult o WHERE o.student.id = :studentId and MONTH(o.resultMonth) = :m and YEAR(o.resultMonth)= :y")
    List<LearningResult> findByStudentIdFilterMonthYear(@Param("studentId")Long studentId, @Param("m") Integer m, @Param("y") Integer y);
}
