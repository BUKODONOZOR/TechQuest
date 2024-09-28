package com.TechQuest.TechQuest.persistence.mysql.repository;

import com.TechQuest.TechQuest.persistence.mysql.entity.TeacherClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherClassRepository extends JpaRepository <TeacherClass , Long> {
}
