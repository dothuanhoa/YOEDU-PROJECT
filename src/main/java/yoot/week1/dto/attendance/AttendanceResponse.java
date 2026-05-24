package yoot.week1.dto.attendance;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
//không khai báo từ truy xuất thì chỉ truy xuất được trong cùng pakage
public class AttendanceResponse {
    Long id;
    Long courseClassId;
    String className;
    Long studentId;
    String studentName;
    LocalDate attendanceDate;
    String status;
    String note;
    Long recordedByUserId;
    String recordedByUsername;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
