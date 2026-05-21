package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.dto.parent.ParentResponse;
import yoot.week1.dto.parent.ParentUpsertRequest;
import yoot.week1.service.ParentService;

import java.util.List;

@RestController
@RequestMapping(value = "/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF', 'CASHIER')")
    public ResponseEntity<ApiResponse<List<ParentResponse>>> findAll(){
        return ResponseEntity.ok(ApiResponse.success(parentService.findAll()));
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF', 'CASHIER')")
    public ResponseEntity<ApiResponse<ParentResponse>> findById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(parentService.findById(id)));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ResponseEntity<ApiResponse<ParentResponse>> create(@Valid @RequestBody ParentUpsertRequest request){
        return ResponseEntity.ok(ApiResponse.success(parentService.create(request)));
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")

    public ResponseEntity<ApiResponse<ParentResponse>> update(@PathVariable Long id, @Valid @RequestBody ParentUpsertRequest request){
        return ResponseEntity.ok(ApiResponse.success(parentService.update(id, request)));
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")

    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long id){
        parentService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Delete success"));
    }
}
