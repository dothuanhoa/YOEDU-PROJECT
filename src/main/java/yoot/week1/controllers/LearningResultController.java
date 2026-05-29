package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.dto.learningresult.LearningResultCreateRequest;
import yoot.week1.dto.learningresult.LearningResultResponse;
import yoot.week1.service.LearningResultService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/learning-results")
@RequiredArgsConstructor
public class LearningResultController {
    private final LearningResultService learningResultService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    public ApiResponse<LearningResultResponse> create(@Valid @RequestBody LearningResultCreateRequest request, Principal principal) {
        return ApiResponse.success("Learning result created", learningResultService.create(request, principal.getName()));
    }

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF','PARENT')")
    public ApiResponse<List<LearningResultResponse>> findByStudentId(@PathVariable Long studentId, Principal principal, @RequestParam(required = false) Integer month,  @RequestParam(required = false) Integer year) {
        if(month != null && year!=null){
            return ApiResponse.success(learningResultService.findByStudentId(studentId, principal.getName(), month, year));
        }else{
            return ApiResponse.success(learningResultService.findByStudentId(studentId, principal.getName()));
        }
    }
}
