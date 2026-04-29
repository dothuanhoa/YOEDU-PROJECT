package yoot.week1.dto.request;

import yoot.week1.domain.entity.Parent;
import yoot.week1.domain.enums.Gender;
import yoot.week1.domain.enums.Status;

import java.time.LocalDate;

public record UpdateStudentRequest(
        String studentCode,
        String fullName,
        LocalDate dateOfBirth,
        Gender gender,
        String gradeLevel,
        String schoolName,
        String phone,
        Parent parent,
        Status status,
        Double latestScore,
        String note
) {
}
