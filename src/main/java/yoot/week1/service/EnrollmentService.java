package yoot.week1.service;

import yoot.week1.dto.enrollment.EnrollmentResponse;
import yoot.week1.dto.enrollment.EnrollmentUpsertRequest;

import java.util.List;

public interface EnrollmentService {
    EnrollmentResponse create(EnrollmentUpsertRequest request);
    List<EnrollmentResponse> findByClassId(Long classId);
    List<EnrollmentResponse> findByStudentId(Long studentId, String username);
}
