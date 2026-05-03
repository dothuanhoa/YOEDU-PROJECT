package yoot.week1.dto.student;

import lombok.Data;
import lombok.NoArgsConstructor;
import yoot.week1.domain.entity.Parent;
import yoot.week1.domain.enums.Gender;
import yoot.week1.domain.enums.StudentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StudentUpsertRequest {
    private String studentCode;
    private String fullName;
    private LocalDate dateOfBirth;
    private Gender gender = Gender.OTHER;
    private String gradeLevel;
    private String schoolName;
    private String phone;
    private Long parentId;
    private StudentStatus status = StudentStatus.ACTIVE;
    private BigDecimal latestScore = BigDecimal.ZERO;
    private String note;
}
