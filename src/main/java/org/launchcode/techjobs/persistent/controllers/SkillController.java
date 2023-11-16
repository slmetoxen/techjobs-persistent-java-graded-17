package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

public class SkillController {

//    @GetMapping("add")
//    public String displayAddSkillForm(Model model) {
//        model.addAttribute(new Employer());
//        return "employers/add";
//    }
//
//    @PostMapping("add")
//    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
//                                         Errors errors, Model model) {
//
//        if (errors.hasErrors()) {
//            return "employers/add";
//        }
//
//        return "redirect:";
//    }
//
//    @GetMapping("view/{employerId}")
//    public String displayViewEmployer(Model model, @PathVariable int employerId) {
//
//        Optional optEmployer = null;
//        if (optEmployer.isPresent()) {
//            Employer employer = (Employer) optEmployer.get();
//            model.addAttribute("employer", employer);
//            return "employers/view";
//        } else {
//            return "redirect:../";
//        }
//
//    }
//}
}
