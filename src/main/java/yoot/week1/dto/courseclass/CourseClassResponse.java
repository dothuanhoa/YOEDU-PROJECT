package yoot.week1.dto.courseclass;

import jakarta.persistence.*;
import lombok.Data;
import yoot.week1.domain.entity.Course;
import yoot.week1.domain.entity.Room;
import yoot.week1.domain.entity.ScheduleSlot;
import yoot.week1.domain.entity.Teacher;
import yoot.week1.domain.enums.ClassStatus;
import yoot.week1.dto.course.CourseResponse;
import yoot.week1.dto.room.RoomResponse;
import yoot.week1.dto.teacher.TeacherResponse;

import java.time.LocalDate;

@Data
public class CourseClassResponse{
    private Long id;

    private String classCode;

    private String name;

    private CourseResponse course;

    private RoomResponse room;

    private ScheduleSlot scheduleSlot;

    private TeacherResponse mainTeacher;

    private TeacherResponse assistantTeacher;

    private LocalDate startDate;

    private LocalDate endDate;

    private int maxStudents;

    private Double tuitionFee;

    private ClassStatus status;
}
