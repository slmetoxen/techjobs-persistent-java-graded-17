package org.launchcode.techjobs.persistent.models.data;


import org.launchcode.techjobs.persistent.models.Skill;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
