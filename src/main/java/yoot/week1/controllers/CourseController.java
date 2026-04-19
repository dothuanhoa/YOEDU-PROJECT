package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.domain.entity.Course;
import yoot.week1.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<ApiResponse<List<Course>>> getCourse(){
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    };

    @GetMapping("/courses/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@Valid @RequestParam long id){
        Optional<Course> course = courseService.findById(id);
        return course.map(value -> ResponseEntity.ok(ApiResponse.success(value)))
                .orElseGet(()->ResponseEntity.notFound().build());
    };

    @PostMapping("/courses")
    public ResponseEntity<ApiResponse<Course>> save(@Valid @RequestBody Course course){
        return ResponseEntity.ok(ApiResponse.success(courseService.save(course)));
    };
}
