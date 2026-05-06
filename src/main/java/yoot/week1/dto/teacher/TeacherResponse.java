package yoot.week1.dto.teacher;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import yoot.week1.domain.enums.TeacherRole;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TeacherResponse {
    private Long id;
    private String teacherCode;
    private String fullName;
    private String phone;
    private String email;
    private TeacherRole teacherRole;
    private String cccdImageUrl;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
