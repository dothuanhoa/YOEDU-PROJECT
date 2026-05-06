package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.Course;
import yoot.week1.dto.course.CourseResponse;
import yoot.week1.dto.course.CourseUpsertRequest;
import yoot.week1.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponse>>> getCourse(){
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    };

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponse>> getCourseById(@PathVariable long id){
        return courseService.findById(id)
                .map(c -> ResponseEntity.ok(ApiResponse.success(c)))
                .orElseThrow(()->new NotFoundException("Cant find course id: "+id));
    };

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponse>> create(@Valid @RequestBody CourseUpsertRequest request){
        return ResponseEntity.ok(ApiResponse.success(courseService.create(request)));
    };

    @PutMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<CourseResponse>> create(@PathVariable Long id, @Valid @RequestBody CourseUpsertRequest request){
        return ResponseEntity.ok(ApiResponse.success(courseService.update(id, request)));
    };

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Delete success"));
    }
}
