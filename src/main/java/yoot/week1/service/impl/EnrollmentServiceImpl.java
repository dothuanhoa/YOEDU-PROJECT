package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yoot.week1.common.exception.BadRequestException;
import yoot.week1.domain.entity.CourseClass;
import yoot.week1.domain.entity.Enrollment;
import yoot.week1.domain.entity.Student;
import yoot.week1.domain.entity.User;
import yoot.week1.domain.enums.EnrollmentStatus;
import yoot.week1.dto.enrollment.EnrollmentResponse;
import yoot.week1.dto.enrollment.EnrollmentUpsertRequest;
import yoot.week1.repository.EnrollmentRepository;
import yoot.week1.service.AuthService;
import yoot.week1.service.CourseClassService;
import yoot.week1.service.EnrollmentService;
import yoot.week1.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseClassService courseClassService;
    private final AuthService authService;
    private final ModelMapper mapper;

    private EnrollmentResponse map(Enrollment en){
        return mapper.map(en, EnrollmentResponse.class);
    }

    @Transactional
    public EnrollmentResponse create(EnrollmentUpsertRequest request) {
        if (enrollmentRepository.existsByStudent_IdAndCourseClass_Id(request.getStudentId(), request.getCourseClassId())) {
            throw new BadRequestException("Student is already enrolled in this class");
        }

        CourseClass courseClass = courseClassService.getCourseClass(request.getCourseClassId());
        long activeCount = enrollmentRepository.countByCourseClass_IdAndStatus(request.getCourseClassId(), EnrollmentStatus.ACTIVE);
        if (activeCount >= courseClass.getMaxStudents()) {
            throw new BadRequestException("Class is full");
        }

        Student student = studentService.getStudent(request.getStudentId());
        Enrollment enrollment = mapper.map(request, Enrollment.class);
        enrollment.setStudent(student);
        enrollment.setCourseClass(courseClass);
        return map(enrollmentRepository.save(enrollment));
    }

    @Transactional(readOnly = true)
    public List<EnrollmentResponse> findByClassId(Long classId) {
        return enrollmentRepository.findByCourseClass_Id(classId).stream().map(this::map).toList();
    }

    @Transactional(readOnly = true)
    public List<EnrollmentResponse> findByStudentId(Long studentId, String username) {
        User user = authService.findActiveUserByUsername(username);
        if (user.getRole().name().equals("PARENT")) {
            //Đăng nhập bằng PARENT chỉ được coi con của người đó, không được coi con người ta
            studentService.getStudentForParent(studentId, user.getParent().getId());
        }
        return enrollmentRepository.findByStudent_Id(studentId).stream().map(this::map).toList();
    }

    public Enrollment getEnrollment(Long studentId, Long classId) {
        return enrollmentRepository.findByStudentIdAndCourseClassId(studentId, classId)
                .orElseThrow(() -> new BadRequestException("Enrollment not found for student and class"));
    }

}
