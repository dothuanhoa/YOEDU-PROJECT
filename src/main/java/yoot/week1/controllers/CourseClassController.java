package yoot.week1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.enums.ClassStatus;
import yoot.week1.dto.courseclass.CourseClassResponse;
import yoot.week1.dto.courseclass.CourseClassUpsertRequest;
import yoot.week1.service.CourseClassService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/course-classes")
@RequiredArgsConstructor
public class CourseClassController {
    private final CourseClassService courseClassService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<List<CourseClassResponse>> findAll(@RequestParam(required = false)ClassStatus status){
        if (status != null){
            return ApiResponse.success(courseClassService.findAll(status));
        }else {
            return ApiResponse.success(courseClassService.findAll());
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<CourseClassResponse> findById(@PathVariable Long id){
        return courseClassService.findById(id)
                .map(ApiResponse::success)
                .orElseGet(()->ApiResponse.error("Cant find course class id: "+id, new CourseClassResponse()));

    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<CourseClassResponse> create(@RequestBody CourseClassUpsertRequest req){
        return ApiResponse.success(courseClassService.create(req));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<CourseClassResponse> update(@PathVariable Long id, @RequestBody CourseClassUpsertRequest req){
        return ApiResponse.success(courseClassService.update(id, req));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ApiResponse<String> delete(@PathVariable Long id){
        courseClassService.delete(id);
        return ApiResponse.success("Deleted");
    }
}
