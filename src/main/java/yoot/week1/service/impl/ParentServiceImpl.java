package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yoot.week1.domain.entity.Parent;
import yoot.week1.dto.request.UpdateParentRequest;
import yoot.week1.repository.ParentReposity;
import yoot.week1.service.ParentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentReposity parentReposity;

    public List<Parent> findAll(){
        return parentReposity.findAll();
    }

    public Optional<Parent> findById(long id){
        return parentReposity.findById(id);
    }

    public Parent save(Parent parent){
        return parentReposity.save(parent);
    }

    public void delete(long id){
        parentReposity.deleteById(id);
    }

    public boolean existById(long id){
        return parentReposity.existsById(id);
    }

    public Parent update(Long id, UpdateParentRequest request){
        Parent parent = findById(id).orElseThrow(() -> new RuntimeException("Parent not found"));
        if (request.fullName()!=null){
            parent.setFullName(request.fullName());
        }
        if (request.email()!=null){
            parent.setEmail(request.email());
        }

        if(request.phone()!=null){
            parent.setPhone(request.phone());
        }

        if (request.address()!=null){
            parent.setAddress(request.address());
        }

        return parentReposity.save(parent);
    }
}
