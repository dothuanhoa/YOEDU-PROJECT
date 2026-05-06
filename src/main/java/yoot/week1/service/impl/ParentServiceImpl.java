package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.Parent;
import yoot.week1.dto.parent.ParentResponse;
import yoot.week1.dto.parent.ParentUpsertRequest;
import yoot.week1.repository.ParentRepository;
import yoot.week1.service.ParentService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final ModelMapper mapper;

    private ParentResponse map(Parent parent){
        return mapper.map(parent, ParentResponse.class);
    }

    public List<ParentResponse> findAll(){
        return parentRepository.findAll()
                .stream().map(this::map).toList();
    }

    public ParentResponse findById(Long id){
        return parentRepository.findById(id)
                .map(this::map)
                .orElseThrow(()->new NotFoundException("Cant find parent id: "+id));
    }

    public ParentResponse create(ParentUpsertRequest request){
        Parent parent = mapper.map(request, Parent.class);
        parent.setCreatedAt(LocalDateTime.now());
        parent.setUpdatedAt(LocalDateTime.now());
        return map(parentRepository.save(parent));
    }

    public ParentResponse update(Long id, ParentUpsertRequest request){
        Parent parent = mapper.map(request, Parent.class);
        parent.setId(id);
        parent.setUpdatedAt(LocalDateTime.now());
        return map(parentRepository.save(parent));
    }

    public void delete(Long id){
        if (parentRepository.existsById(id)){
            parentRepository.deleteById(id);
        }else{
            throw new NotFoundException("Delete fail (not found) parent id: "+id);
        }
    }
}
