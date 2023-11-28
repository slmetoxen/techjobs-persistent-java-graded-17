package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;

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
        return "redirect:";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {
        model.addAttribute(skillRepository.save(newSkill));
        if (errors.hasErrors()) {
            return "skills/add";
        }

        return "redirect:";
    }


    @GetMapping("view/{skill}")
    public String displayViewSkill(Model model, @PathVariable int skill) {

        Optional optSkill = skillRepository.findById(skill);
        if (optSkill.isPresent()) {
            Skill description = (Skill) optSkill.get();
            model.addAttribute("description", description);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}

