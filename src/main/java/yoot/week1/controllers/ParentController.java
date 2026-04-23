package yoot.week1.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.domain.entity.Parent;
import yoot.week1.dto.request.UpdateParentRequest;
import yoot.week1.service.ParentService;

import java.util.List;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Parent>>> getParents(){
        return ResponseEntity.ok(ApiResponse.success(parentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Parent>> getParentById(@PathVariable long id){
        Parent parent = parentService.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
        return ResponseEntity.ok(ApiResponse.success(parent));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Parent>> save(@Valid @RequestBody Parent parent){
        return ResponseEntity.ok(ApiResponse.success(parentService.save(parent)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable long id){
        if (!parentService.existById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("parent id not exist", null));
        }
        parentService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("deleted"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Parent>> update(
            @PathVariable long id,
            @Valid @RequestBody UpdateParentRequest request){
        return ResponseEntity.ok(ApiResponse.success("Update success",parentService.update(id, request)));
    }

}
