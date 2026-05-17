package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.Teacher;
import yoot.week1.dto.teacher.TeacherResponse;
import yoot.week1.dto.teacher.TeacherUpsertRequest;
import yoot.week1.repository.ParentRepository;
import yoot.week1.repository.TeacherRepository;
import yoot.week1.service.TeacherService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final ModelMapper mapper;

    private TeacherResponse map(Teacher teacher){
        return mapper.map(teacher, TeacherResponse.class);
    }

    public List<TeacherResponse> findAll(){
        return teacherRepository.findAll()
                .stream().map(this::map).toList();
    }

    public TeacherResponse findById(Long id){
        return teacherRepository.findById(id)
                .map(this::map)
                .orElseThrow(()-> new NotFoundException("Cant find teacher id: "+id));
    }

    public TeacherResponse create(TeacherUpsertRequest request){
        Teacher teacher = mapper.map(request, Teacher.class);
        return map(teacherRepository.save(teacher));
    }
    public TeacherResponse update(Long id, TeacherUpsertRequest request){
        Teacher teacher = mapper.map(request, Teacher.class);
        teacher.setId(id);
        return map(teacherRepository.save(teacher));
    }

    public void delete(Long id){
        if (teacherRepository.existsById(id)){
            teacherRepository.deleteById(id);
        }else {
            throw new NotFoundException("Cant delete (not found) teacher id: "+ id);
        }
    }
}
