package yoot.week1.dto.course;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseUpsertRequest {
    @Size(max = 20)
    private String courseCode;

    @Size(max = 100)
    private String name;

    @Size(max = 500)
    private String description;

    @Min(value = 0)
    private Double tuitionFee;

    @Min(value = 0)
    private Integer totalSessions=24;

    private Boolean active = true;

}
