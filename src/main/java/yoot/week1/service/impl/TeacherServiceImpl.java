package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import yoot.week1.domain.entity.Teacher;
import yoot.week1.dto.request.UpdateTeacherRequest;
import yoot.week1.repository.StudentRepository;
import yoot.week1.repository.TeacherRepository;
import yoot.week1.service.TeacherService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findById(long id){
        return teacherRepository.findById(id);
    }

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public void delete(long id){
        teacherRepository.deleteById(id);
    }

    public boolean existById(long id){
        return teacherRepository.existsById(id);
    }

    public Teacher update(Long id, UpdateTeacherRequest request){
        Teacher teacher = findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
        if (StringUtils.hasText(request.teacherCode())){
            teacher.setTeacherCode(request.teacherCode());
        }
        if (StringUtils.hasText(request.fullName())){
            teacher.setFullName(request.fullName());
        }
        if (StringUtils.hasText(request.email())){
            teacher.setEmail(request.email());
        }

        if(request.phone()!=null){
            teacher.setPhone(request.phone());
        }

        if (request.teacherRole()!=null){
            teacher.setTeacherRole(request.teacherRole());
        }

        if (request.cccdImageUrl()!=null){
            teacher.setCccdImageUrl(request.cccdImageUrl());
        }

        if (request.active()!=null){
            teacher.setActive(request.active());
        }

        return teacherRepository.save(teacher);
    }
}
