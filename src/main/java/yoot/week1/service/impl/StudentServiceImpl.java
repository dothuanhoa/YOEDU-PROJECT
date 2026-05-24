package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.Student;
import yoot.week1.dto.parent.ParentResponse;
import yoot.week1.dto.student.StudentResponse;
import yoot.week1.dto.student.StudentUpsertRequest;
import yoot.week1.repository.ParentRepository;
import yoot.week1.repository.StudentRepository;
import yoot.week1.service.StudentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final ModelMapper mapper;

    private StudentResponse map(Student student){
        return mapper.map(student, StudentResponse.class);
    }
    @Override
    public List<StudentResponse> findByAll() {
        return studentRepository.findAll().stream().map(student -> map(student)).toList();
    }

    public Optional<StudentResponse> findById(long id){
        return studentRepository.findById(id)
                .map(this::map);
    }

    public Student getStudent(long id){
        return studentRepository.getStudentById(id);
    }

    public StudentResponse create(StudentUpsertRequest request){
        Student s = mapper.map(request, Student.class);
        parentRepository.findById(request.getParentId())
                .ifPresent(p->s.setParent(p));
        Student result = studentRepository.save(s);
        return map(result);
    }
    public StudentResponse update(Long id, StudentUpsertRequest request){
        Student s = mapper.map(request, Student.class);
        s.setId(id);
        parentRepository.findById(request.getParentId())
                .ifPresent(p->s.setParent(p));
        Student result = studentRepository.save(s);
        return map(result);
    }

    public void delete(Long id) throws NotFoundException{
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }else{
            throw new NotFoundException("Delete error (not found) student id: "+id);
        }
    }

    private StudentResponse map2(Student student){
        StudentResponse result = new StudentResponse();
        ParentResponse pResult = new ParentResponse();
        if(student.getParent()!=null){
            pResult.setId(student.getParent().getId());
            pResult.setFullName(student.getParent().getFullName());
            pResult.setEmail(student.getParent().getEmail());
            pResult.setPhone(student.getParent().getPhone());
            pResult.setAddress(student.getParent().getAddress());
            pResult.setRelationship(student.getParent().getRelationship());
            pResult.setCreatedAt(student.getParent().getCreatedAt());
            pResult.setUpdatedAt(student.getParent().getUpdatedAt());
        }
        result.setId(student.getId());
        result.setFullName(student.getFullName());
        result.setGender(student.getGender());
        result.setNote(student.getNote());
        result.setPhone(student.getPhone());
        result.setStatus(student.getStatus());
        result.setStudentCode(student.getStudentCode());
        result.setCreatedAt(student.getCreatedAt());
        result.setUpdatedAt(student.getUpdatedAt());
        result.setGradeLevel(student.getGradeLevel());
        result.setDateOfBirth(student.getDateOfBirth());
        result.setLatestScore(student.getLatestScore());
        result.setSchoolName(student.getSchoolName());
        result.setParent(student.getParent());
        return result;
    }
}
