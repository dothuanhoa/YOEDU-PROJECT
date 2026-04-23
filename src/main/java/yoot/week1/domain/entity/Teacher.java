package yoot.week1.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import yoot.week1.domain.AuditableEntity;
import yoot.week1.domain.enums.TeacherRole;

@Entity
@Data
@Table(name = "teachers")
public class Teacher extends AuditableEntity {
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String teacherCode;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String fullName;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String phone;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String email;

    @Enumerated(EnumType.STRING)
    private TeacherRole teacherRole;

    @Column(columnDefinition = "varchar(255)")
    private String cccdImageUrl;

    @Column(nullable = false)
    private boolean isActive;
}
