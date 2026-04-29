package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.domain.entity.Teacher;
import yoot.week1.dto.request.UpdateTeacherRequest;
import yoot.week1.service.StudentService;
import yoot.week1.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Teacher>>> getTeachers(){
        return ResponseEntity.ok(ApiResponse.success(teacherService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Teacher>> getTeacherById(@PathVariable long id){
        Teacher teacher = teacherService.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        return ResponseEntity.ok(ApiResponse.success(teacher));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Teacher>> save(@Valid @RequestBody Teacher teacher){
        return ResponseEntity.ok(ApiResponse.success(teacherService.save(teacher)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable long id){
        if (!teacherService.existById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Teacher id not exist", null));
        }
        teacherService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("deleted"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Teacher>> update(
            @PathVariable long id,
            @Valid @RequestBody UpdateTeacherRequest request){
        return ResponseEntity.ok(ApiResponse.success("Update success",teacherService.update(id, request)));
    }
}
