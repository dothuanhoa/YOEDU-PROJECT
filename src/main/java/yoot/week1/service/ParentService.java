package yoot.week1.service;

import yoot.week1.dto.parent.ParentResponse;
import yoot.week1.dto.parent.ParentUpsertRequest;

import java.util.List;

public interface ParentService {
    List<ParentResponse> findAll();
    ParentResponse findById(Long id);
    ParentResponse create(ParentUpsertRequest request);
    ParentResponse update(Long id, ParentUpsertRequest request);
    void delete(Long id);
}
