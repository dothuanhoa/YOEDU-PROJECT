package yoot.week1.service;

import yoot.week1.domain.entity.Parent;
import yoot.week1.dto.request.UpdateParentRequest;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    List<Parent> findAll();
    Optional<Parent> findById(long id);
    Parent save(Parent parent);
    void delete(long id);
    boolean existById(long id);
    Parent update(Long id, UpdateParentRequest request);
}
