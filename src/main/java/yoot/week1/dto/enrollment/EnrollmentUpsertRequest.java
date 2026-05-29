package yoot.week1.dto.enrollment;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import yoot.week1.domain.enums.EnrollmentStatus;

import java.time.LocalDate;

@Getter
@Setter
public class EnrollmentUpsertRequest {
    @NotNull
    private Long studentId;
    
    @NotNull
    private Long courseClassId;
    
    @NotNull
    private LocalDate enrolledAt;
    
    @NotNull
    private EnrollmentStatus status;
    
    private String note;
}
