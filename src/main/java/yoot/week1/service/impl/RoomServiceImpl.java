package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.Room;
import yoot.week1.dto.room.RoomResponse;
import yoot.week1.dto.room.RoomUpsertRequest;
import yoot.week1.repository.RoomRepository;
import yoot.week1.service.RoomService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final ModelMapper mapper;
    private RoomResponse map(Room room){
        return mapper.map(room, RoomResponse.class);
    }

    public List<RoomResponse> findAll(){
        return roomRepository.findAll().stream().map(this::map).toList();
    }

    public Optional<RoomResponse> findById(Long id){
        return roomRepository.findById(id)
                .map(this::map);
    }

    public RoomResponse save(RoomUpsertRequest request){
        Room r = mapper.map(request, Room.class);
        Room response = roomRepository.save(r);
        return map(response);
    }

    public RoomResponse save(long id, RoomUpsertRequest request){
        Room r = mapper.map(request, Room.class);
        r.setId(id);
        Room response = roomRepository.save(r);
        return map(response);
    }
}
