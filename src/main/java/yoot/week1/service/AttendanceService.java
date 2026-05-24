package yoot.week1.service;

import yoot.week1.common.exception.BadRequestException;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.dto.attendance.AttendanceCreateRequest;
import yoot.week1.dto.attendance.AttendanceResponse;

import java.util.List;

public interface AttendanceService {
    AttendanceResponse create(AttendanceCreateRequest request, String username) throws BadRequestException, NotFoundException;
    List<AttendanceResponse> findByClassId(Long classId);

}
