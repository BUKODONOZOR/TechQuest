package com.TechQuest.TechQuest.persistence.mysql.repository;

import com.TechQuest.TechQuest.persistence.mysql.entity.MissionEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionEvaluationRepository extends JpaRepository<MissionEvaluation , Long> {
}
