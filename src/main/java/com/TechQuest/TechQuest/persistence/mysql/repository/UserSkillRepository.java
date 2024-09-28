package com.TechQuest.TechQuest.persistence.mysql.repository;

import com.TechQuest.TechQuest.persistence.mysql.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> {
}
