package yoot.week1.service;

import yoot.week1.dto.room.RoomResponse;
import yoot.week1.dto.room.RoomUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<RoomResponse> findAll();
    Optional<RoomResponse> findById(Long id);
    RoomResponse save(RoomUpsertRequest request);
    RoomResponse save(long id, RoomUpsertRequest request);
}
