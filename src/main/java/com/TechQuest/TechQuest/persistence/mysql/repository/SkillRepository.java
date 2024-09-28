package com.TechQuest.TechQuest.persistence.mysql.repository;

import com.TechQuest.TechQuest.persistence.mysql.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository <Skill , Long> {
}
