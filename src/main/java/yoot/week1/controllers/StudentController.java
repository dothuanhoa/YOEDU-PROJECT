package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.domain.entity.Student;
import yoot.week1.dto.request.UpdateStudentRequest;
import yoot.week1.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents(){
        return ResponseEntity.ok(ApiResponse.success(studentService.findByAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable long id){
        Student student = studentService.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return ResponseEntity.ok(ApiResponse.success(student));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> save(@Valid @RequestBody Student student){
        return ResponseEntity.ok(ApiResponse.success(studentService.save(student)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable long id){
        if (!studentService.existById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Student id not exist", null));
        }
        studentService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("deleted"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> update(
            @PathVariable long id,
            @Valid @RequestBody UpdateStudentRequest request){
        return ResponseEntity.ok(ApiResponse.success("Update success",studentService.update(id, request)));
    }
}
