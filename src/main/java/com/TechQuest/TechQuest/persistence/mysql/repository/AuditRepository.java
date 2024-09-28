package com.TechQuest.TechQuest.persistence.mysql.repository;

import com.TechQuest.TechQuest.persistence.mysql.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository <Audit , Long > {

}
