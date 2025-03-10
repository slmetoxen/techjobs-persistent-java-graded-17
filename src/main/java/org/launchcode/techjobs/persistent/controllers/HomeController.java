package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
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

        model.addAttribute("jobs", jobRepository.findAll());


        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	   // model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm( @ModelAttribute @Valid Job newJob,
                                     Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");

            // List<Employer> employers = (List<Employer>) employerRepository.findAll();
            return "add";
        } else {
            Employer employer = employerRepository.findById(employerId).orElse(new Employer());
            newJob.setEmployer(employer);

            List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
            newJob.setSkills(skillObjs);

            //model.addAttribute("employers",employerRepository.findAll());
            //List<Employer> employers = (List<Employer>) employerRepository.findAll();
            //newJob.setEmployer(employers);

//            Employer jobResult = (List<Employer>) employerRepository.findAllById(employerId);
//            newJob.setEmployer(jobResult);
        }
//        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//        newJob.setSkills(skillObjs);

        jobRepository.save(newJob);
        return "redirect:";
    }


//    @PostMapping("add")
//    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
//                                    Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Job");
//            // model.addAttribute("employers",employerRepository.findAll());
//            model.addAttribute("skills", skillRepository.findAll());
//
//            return "add";
//
//
//        } else {
//
//            Optional<Employer> result = employerRepository.findById(employerId);
//            if (result.isPresent()) {
//                Employer employer = result.get();
//                model.addAttribute("employers", employerRepository.findAll());
//                newJob.setEmployer(employer);
//            }
//
//            if (skills != null) {
//                List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//                newJob.setSkills(skillObjs);
//            }
//
//            jobRepository.save(newJob);
//            return "redirect:";
//        }
//
//    }


    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Optional<Job> jobResult = jobRepository.findById(jobId);
        if (jobResult.isPresent()) {
            Job job = jobResult.get();
            model.addAttribute("job",job);

    }
            return "view";
        }
    }






