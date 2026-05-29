package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yoot.week1.common.exception.BadRequestException;
import yoot.week1.common.exception.ConflictException;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.LearningResult;
import yoot.week1.domain.entity.User;
import yoot.week1.dto.learningresult.LearningResultCreateRequest;
import yoot.week1.dto.learningresult.LearningResultResponse;
import yoot.week1.repository.LearningResultRepository;
import yoot.week1.service.AuthService;
import yoot.week1.service.CourseClassService;
import yoot.week1.service.LearningResultService;
import yoot.week1.service.StudentService;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class LearningResultServiceImpl implements LearningResultService {
    private final LearningResultRepository learningResultRepository;
    private final StudentService studentService;
    private final CourseClassService courseClassService;
    private final AuthService authService;
    private final ModelMapper mapper;

    @Transactional
    public LearningResultResponse create(LearningResultCreateRequest request, String username) {
        if (learningResultRepository.existsByStudentIdAndCourseClassIdAndResultMonth(
                request.getStudentId(), request.getCourseClassId(), request.getResultMonth())) {
            throw new ConflictException("Learning result already exists for this student, class, and month");
        }

        User user = authService.findActiveUserByUsername(username);
        LearningResult item = new LearningResult();
        item.setStudent(studentService.getStudent(request.getStudentId()));
        item.setCourseClass(courseClassService.getCourseClass(request.getCourseClassId()));
        item.setResultMonth(request.getResultMonth());
        item.setScore(request.getScore());
        item.setTeacherComment(request.getTeacherComment());
        item.setCreatedByUser(user);
        try {
            return toResponse(learningResultRepository.saveAndFlush(item));
        } catch (DataIntegrityViolationException ex) {
            if (isDuplicateLearningResult(ex)) {
                throw new ConflictException("Learning result already exists for this student, class, and month");
            }
            throw ex;
        }
    }

    @Transactional(readOnly = true)
    public List<LearningResultResponse> findByStudentId(Long studentId, String username) throws BadRequestException, NotFoundException {
        User user = authService.findActiveUserByUsername(username);
        if (user.getRole().name().equals("PARENT")) {
            studentService.getStudentForParent(studentId, user.getParent().getId());
        }
        return learningResultRepository.findByStudentIdOrderByResultMonthDesc(studentId).stream().map(this::toResponse).toList();
    }

    private LearningResultResponse toResponse(LearningResult item) {
        LearningResultResponse response = mapper.map(item, LearningResultResponse.class);
        response.setStudentId(item.getStudent().getId());
        response.setStudentName(item.getStudent().getFullName());
        response.setCourseClassId(item.getCourseClass().getId());
        response.setClassName(item.getCourseClass().getName());
        response.setCreatedByUserId(item.getCreatedByUser().getId());
        response.setCreatedByUsername(item.getCreatedByUser().getUsername());

        return response;
    }

    private boolean isDuplicateLearningResult(DataIntegrityViolationException ex) {
        Throwable cause = ex.getMostSpecificCause();
        String message = cause != null ? cause.getMessage() : ex.getMessage();
        return message != null && message.toLowerCase(Locale.ROOT).contains("uq_learning_result");
    }
}
