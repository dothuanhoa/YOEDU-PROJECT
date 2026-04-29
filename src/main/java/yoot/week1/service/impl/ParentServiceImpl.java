package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import yoot.week1.domain.entity.Parent;
import yoot.week1.dto.request.UpdateParentRequest;
import yoot.week1.repository.ParentReposity;
import yoot.week1.repository.StudentRepository;
import yoot.week1.service.ParentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentReposity parentReposity;
    private final StudentRepository studentRepository;

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
        if(studentRepository.existsByParent_Id(id)){
            throw new RuntimeException("Parent has student in yoot");
        }
        parentReposity.deleteById(id);
    }

    public boolean existById(long id){
        return parentReposity.existsById(id);
    }

    public Parent update(Long id, UpdateParentRequest request){
        Parent parent = findById(id).orElseThrow(() -> new RuntimeException("Parent not found"));
        if (StringUtils.hasText(request.fullName()) ){
            parent.setFullName(request.fullName());
        }
        if (StringUtils.hasText(request.email())){
            parent.setEmail(request.email());
        }

        if(StringUtils.hasText(request.phone())){
            parent.setPhone(request.phone());
        }

        if (request.address()!=null){
            parent.setAddress(request.address());
        }

        return parentReposity.save(parent);
    }
}
