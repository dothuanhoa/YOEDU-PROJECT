package yoot.week1.dto.request;

import jakarta.validation.constraints.Email;
import yoot.week1.domain.enums.TeacherRole;

public record UpdateTeacherRequest(
        String teacherCode,
        String fullName,
        String phone,
        @Email String email,
        TeacherRole teacherRole,
        String cccdImageUrl,
        Boolean active
) {
}
