package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.common.exception.BadRequestException;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.dto.attendance.AttendanceCreateRequest;
import yoot.week1.dto.attendance.AttendanceResponse;
import yoot.week1.service.AttendanceService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/attendances")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    public ApiResponse<AttendanceResponse> create(@Valid @RequestBody AttendanceCreateRequest request, Principal principal) throws BadRequestException, NotFoundException {
        return ApiResponse.success("Attendance created", attendanceService.create(request, principal.getName()));
    }

    @GetMapping("/class/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    public ApiResponse<List<AttendanceResponse>> findByClassId(@PathVariable Long classId) {
        return ApiResponse.success(attendanceService.findByClassId(classId));
    }
}
