package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.Promotion;


public interface PromotionRepository extends JpaRepository<Promotion, Long> {


}
