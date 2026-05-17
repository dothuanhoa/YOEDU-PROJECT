package yoot.week1.dto.courseclass;

import jakarta.validation.constraints.*;
import lombok.Data;
import yoot.week1.domain.entity.Course;
import yoot.week1.domain.entity.Room;
import yoot.week1.domain.entity.ScheduleSlot;
import yoot.week1.domain.entity.Teacher;
import yoot.week1.domain.enums.ClassStatus;

import java.time.LocalDate;

@Data
public class CourseClassUpsertRequest{
        @NotBlank @Size(max = 20)
        String classCode;

        @NotBlank @Size(max = 100)
        String name;

        @NotNull
        Long courseId;

        @NotNull
        Long roomId;

        @NotNull
        Long scheduleSlotId;

        @NotNull
        Long mainTeacherId;

        Long assistantTeacherId;

        @NotNull
        LocalDate startDate;

        @NotNull
        LocalDate endDate;

        @NotNull @Min(1) Long maxStudents;

        @NotNull @DecimalMin("0.0") Double tuitionFee;

        @NotNull ClassStatus status;
}
