package yoot.week1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yoot.week1.service.StudentService;


@RestController
@RequiredArgsConstructor
public class HomeController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("\"data\": \"This is my content\"");
    }

//    @GetMapping("/students")
//    public ResponseEntity<List<Student>> findAll(){
//        return ResponseEntity.ok(studentService.findByAll());
//    }
}
