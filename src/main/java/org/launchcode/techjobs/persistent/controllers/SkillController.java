package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
@RequestMapping("skills")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute(skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }


    @GetMapping("view/{skill}")
    public String displayViewSkill(Model model, @PathVariable int skill) {

        Optional<Skill> optEmployer = skillRepository.findById(skill);
        if (optEmployer.isPresent()) {
            Skill skills = optEmployer.get();
            model.addAttribute("skill", skills);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}

