package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            //employerRepository.findAll();
            return "add";
        } else {
            employerRepository.findById(employerId);
            List<Employer> employers = (List<Employer>) employerRepository.findAll();
            newJob.setEmployer((Employer) employers);
    }

        jobRepository.save(newJob);
        return "redirect:";
    }


    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Optional<Job> jobResult = jobRepository.findById(jobId);
        if (jobResult.isPresent()) {
            Job job = jobResult.get();
            model.addAttribute("jobs", jobRepository.findAll());
    }
            return "view";
        }
    }


    //        } else {
//            return "redirect:../";

//    @GetMapping("view/{skill}")
//    public String displayViewSkill(Model model, @PathVariable int employerId) {
//
//        Optional optEmployer = skillRepository.findById(employerId);
//        if (optEmployer.isPresent()) {
//            Employer employer = (Employer) optEmployer.get();
//            model.addAttribute("employer", employer);
//            return "skills/view";
//        } else {
//            return "redirect:../";
//        }
//    }

    //    @GetMapping("view/{employerId}")
//    public String displayViewEmployer(Model model, @PathVariable int employerId) {
//
//        Optional optEmployer = employerRepository.findById(employerId);
//        if (optEmployer.isPresent()) {
//            Employer employer = (Employer) optEmployer.get();
//            model.addAttribute("employer", employer);
//            return "employers/view";
//        } else {
//            return "redirect:../";
//        }




