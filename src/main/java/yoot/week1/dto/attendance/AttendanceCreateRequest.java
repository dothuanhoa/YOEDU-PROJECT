package yoot.week1.dto.attendance;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import yoot.week1.domain.entity.CourseClass;
import yoot.week1.domain.entity.Student;
import yoot.week1.domain.entity.User;
import yoot.week1.domain.enums.AttendanceStatus;

import java.time.LocalDate;

@Getter
@Setter
public class AttendanceCreateRequest {
    @NotNull
    Long courseClassId;

    @NotNull
    Long studentId;

    @NotNull
    LocalDate attendanceDate;

    @NotNull
    AttendanceStatus status;

    @Size(max = 255)
    String note;
}
