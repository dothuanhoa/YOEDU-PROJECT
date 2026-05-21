package yoot.week1.domain.entity;


import jakarta.persistence.*;
import lombok.Data;
import yoot.week1.domain.AuditableEntity;
import yoot.week1.domain.enums.ClassStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "course_classes")
public class CourseClass extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String classCode;

    @Column(columnDefinition = "varchar(100)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "schedule_slot_id", nullable = false)
    private ScheduleSlot scheduleSlot;

    @ManyToOne
    @JoinColumn(name = "main_teacher_id", nullable = false)
    private Teacher mainTeacher;

    @ManyToOne
    @JoinColumn(name = "assistant_teacher_id")
    private Teacher assistantTeacher;

    private LocalDate startDate;

    private LocalDate endDate;

    private int maxStudents;

    @Column(columnDefinition = "decimal", precision = 12, scale = 2)
    private BigDecimal tuitionFee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ClassStatus status = ClassStatus.OPEN;
}
