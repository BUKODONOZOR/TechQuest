package com.TechQuest.TechQuest;


import com.TechQuest.TechQuest.persistence.mysql.entity.Skill;
import com.TechQuest.TechQuest.persistence.mysql.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.TechQuest.TechQuest.persistence.mysql.enums.SkillType.TECHNOLOGY;

@SpringBootApplication
public class TechQuestApplication implements CommandLineRunner {

	@Autowired
	private SkillRepository skillRepository;

	public static void main(String[] args) {
		SpringApplication.run(TechQuestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Crear una nueva habilidad (Skill)
		Skill skill = new Skill();
		skill.setName("Java Programming");
		skill.setType(TECHNOLOGY);
		skill.setDescription("Skill for developing applications in Java.");

		// Guardar la habilidad en la base de datos
		skillRepository.save(skill);

		// Consultar todas las habilidades en la base de datos
		List<Skill> skills = skillRepository.findAll();
		skills.forEach(System.out::println);
	}
}