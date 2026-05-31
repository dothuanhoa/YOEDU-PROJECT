package yoot.week1.dto.enrollment;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EnrollmentResponse {
    private Long id;
    private Long studentId;
    private String studentName;
    private Long courseClassId;
    private String className;
    private LocalDate enrolledAt;
    private String status;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
