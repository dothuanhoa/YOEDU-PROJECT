package yoot.week1.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import yoot.week1.domain.entity.Parent;
import yoot.week1.domain.entity.Student;
import yoot.week1.dto.request.UpdateParentRequest;
import yoot.week1.dto.request.UpdateStudentRequest;
import yoot.week1.repository.StudentRepository;
import yoot.week1.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> findByAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(long id){
        return studentRepository.findById(id);
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public void delete(long id){
        studentRepository.deleteById(id);
    }

    public boolean existById(long id){
        return studentRepository.existsById(id);
    }

    public Student update(Long id, UpdateStudentRequest request){
        Student student = findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        if (StringUtils.hasText(request.studentCode())) {
            student.setStudentCode(request.studentCode());
        }
        if (StringUtils.hasText(request.fullName())) {
            student.setFullName(request.fullName());
        }
        if (StringUtils.hasText(request.gradeLevel())) {
            student.setGradeLevel(request.gradeLevel());
        }
        if (StringUtils.hasText(request.schoolName())) {
            student.setSchoolName(request.schoolName());
        }
        if (StringUtils.hasText(request.phone())) {
            student.setPhone(request.phone());
        }
        if (request.note() != null) {
            student.setNote(request.note());
        }
        if (request.dateOfBirth() != null) {
            student.setDateOfBirth(request.dateOfBirth());
        }
        if (request.gender() != null) {
            student.setGender(request.gender());
        }
        if (request.parent() != null) {
            student.setParent(request.parent());
        }
        if (request.status() != null) {
            student.setStatus(request.status());
        }
        if (request.latestScore() != null) {
            student.setLatestScore(request.latestScore());
        }
        return studentRepository.save(student);
    }

}
