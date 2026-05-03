package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.dto.student.StudentResponse;
import yoot.week1.dto.student.StudentUpsertRequest;
import yoot.week1.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll(){
        return ResponseEntity.ok(studentService.findByAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id){
        //return ResponseEntity.ok(studentService.findById(id));
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(()->new NotFoundException("Cant find student id: "+id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentUpsertRequest req){
        return ResponseEntity.ok(studentService.create(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> create(@PathVariable Long id,StudentUpsertRequest req){
        return ResponseEntity.ok(studentService.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }


}
