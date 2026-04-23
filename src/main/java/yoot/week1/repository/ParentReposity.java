package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.Parent;

public interface ParentReposity extends JpaRepository<Parent, Long> {
}
