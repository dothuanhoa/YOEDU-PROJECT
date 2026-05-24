package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.Attendance;
import yoot.week1.domain.entity.CourseClass;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    boolean existsByCourseClass_IdAndStudent_IdAndAttendanceDate(Long courseClassId, Long studentId, LocalDate attendanceDate);
    List<Attendance> findByStudentId(Long studentId);
    List<Attendance> findByCourseClassId(Long courseClassId);
}
