package yoot.week1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.dto.room.RoomResponse;
import yoot.week1.dto.room.RoomUpsertRequest;
import yoot.week1.service.RoomService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse<List<RoomResponse>>> findAll(){
        return ResponseEntity.ok(ApiResponse.success(roomService.findAll()));
    }

    @GetMapping("/{id}")
    public ApiResponse<RoomResponse> findById(@PathVariable Long id){
        return roomService.findById(id)
                .map(ApiResponse::success)
                .orElseGet(()->ApiResponse.error("Not Found", new RoomResponse()));
    }

    @PostMapping
    public ApiResponse<RoomResponse> save(@RequestBody RoomUpsertRequest request){
        return ApiResponse.success(roomService.save(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<RoomResponse> update(@PathVariable long id, @RequestBody RoomUpsertRequest request){
        return ApiResponse.success(roomService.save(id, request));
    }
}
