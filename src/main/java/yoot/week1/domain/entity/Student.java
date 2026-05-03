package yoot.week1.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import yoot.week1.domain.AuditableEntity;
import yoot.week1.domain.enums.Gender;
import yoot.week1.domain.enums.StudentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "students")
public class Student extends AuditableEntity {

    @Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
    private String studentCode;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String fullName;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender = Gender.OTHER;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String gradeLevel;

    @Column(columnDefinition = "varchar(100)")
    private String schoolName;

    @Column(columnDefinition = "varchar(20)")
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Enumerated(EnumType.STRING)
    private StudentStatus status = StudentStatus.ACTIVE;

    @Column(columnDefinition = "decimal(5,2)")
    private BigDecimal latestScore = BigDecimal.ZERO;

    @Column(columnDefinition = "varchar(255)")
    private String note;

}
