package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.dto.teacher.TeacherResponse;
import yoot.week1.dto.teacher.TeacherUpsertRequest;
import yoot.week1.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TeacherResponse>>> findAll(){
        return ResponseEntity.ok(ApiResponse.success(teacherService.findAll()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<TeacherResponse>> findById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(teacherService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TeacherResponse>> create(@Valid @RequestBody TeacherUpsertRequest request){
        return ResponseEntity.ok(ApiResponse.success(teacherService.create(request)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<TeacherResponse>> update(@PathVariable Long id, @Valid @RequestBody TeacherUpsertRequest request){
        return ResponseEntity.ok(ApiResponse.success(teacherService.update(id, request)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long id){
        teacherService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Delete success"));
    }
}