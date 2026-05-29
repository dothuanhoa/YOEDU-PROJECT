package yoot.week1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.dto.enrollment.EnrollmentResponse;
import yoot.week1.dto.enrollment.EnrollmentUpsertRequest;
import yoot.week1.service.EnrollmentService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    @Operation(summary = "Create enrollment", description = "Creates a enrollment for a student and course class")
    @io.swagger.v3.oas.annotations.responses.ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Enrollment created successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid request payload"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Missing or invalid JWT token"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Insufficient permission")
    })
    public ApiResponse<EnrollmentResponse> create(@RequestBody EnrollmentUpsertRequest request){
        return ApiResponse.success("Enrollment created", enrollmentService.create(request));
    }

    @GetMapping("/class/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF', 'PARENT')")
    @Operation(summary = "List Enrollment by class", description = "Returns enrollments for the specified class.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Enrollment returned successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Missing or invalid JWT token"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Insufficient permission"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Class not found")
    })
    public ApiResponse<List<EnrollmentResponse>> findByClassId(@PathVariable Long classId) {
        return ApiResponse.success(enrollmentService.findByClassId(classId));
    }

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF','PARENT')")
    @Operation(summary = "List Enrollment by student", description = "Returns enrollments for the specified student.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Enrollment returned successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Missing or invalid JWT token"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Insufficient permission"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Student not found")
    })
    public ApiResponse<List<EnrollmentResponse>> findByStudentId(@PathVariable Long studentId, Principal principal) {
        return ApiResponse.success(enrollmentService.findByStudentId(studentId, principal.getName()));
    }
}
