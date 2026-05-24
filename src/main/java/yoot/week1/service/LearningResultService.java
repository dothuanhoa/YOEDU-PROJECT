package yoot.week1.service;

import yoot.week1.common.exception.BadRequestException;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.dto.learningresult.LearningResultCreateRequest;
import yoot.week1.dto.learningresult.LearningResultResponse;

import java.util.List;

public interface LearningResultService {
    LearningResultResponse create(LearningResultCreateRequest request, String username);
    List<LearningResultResponse> findByStudentId(Long studentId, String username) throws BadRequestException, NotFoundException;
}
