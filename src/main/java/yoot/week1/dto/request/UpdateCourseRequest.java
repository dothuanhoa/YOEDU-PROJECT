package yoot.week1.dto.request;

public record UpdateCourseRequest(
        String courseCode,
        String name,
        String description,
        Double tuitionFee,
        Integer totalSessions,
        Boolean active) {

}
