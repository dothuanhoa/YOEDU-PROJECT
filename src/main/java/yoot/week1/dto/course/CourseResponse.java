package yoot.week1.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CourseResponse {
    private Long id;

    private String courseCode;

    private String name;

    private String description;

    private double tuitionFee;

    private int totalSessions;

    private boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
