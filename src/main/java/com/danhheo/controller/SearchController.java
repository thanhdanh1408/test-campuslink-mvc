package com.danhheo.controller;

import com.danhheo.model.Graduation;
import com.danhheo.model.Job;
import com.danhheo.model.Student;
import com.danhheo.service.GraduationService;
import com.danhheo.service.JobService;
import com.danhheo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class SearchController {

    private final StudentService studentService;
    private final GraduationService graduationService;
    private final JobService jobService;

    public SearchController(DataSource dataSource) {
        this.studentService = new StudentService(dataSource);
        this.graduationService = new GraduationService(dataSource);
        this.jobService = new JobService(dataSource);
    }

    @GetMapping("/search/student")
    public String showStudentSearchForm() {
        return "searchStudentForm";
    }

    @PostMapping("/search/student")
    public String searchStudents(@RequestParam("keyword") String keyword, Model model) {
        List<Student> students = studentService.searchStudents(keyword);
        model.addAttribute("students", students);
        return "studentList";
    }

    @GetMapping("/search/graduation-job")
    public String showGraduationJobSearchForm() {
        return "searchGraduationJobForm";
    }

    @PostMapping("/search/graduation-job")
    public String searchGraduationJob(@RequestParam("soCMND") int soCMND, Model model) {
        List<Graduation> graduations = graduationService.getGraduationsByStudent(soCMND);
        List<Job> jobs = jobService.getJobsByStudent(soCMND);
        model.addAttribute("graduations", graduations);
        model.addAttribute("jobs", jobs);
        model.addAttribute("soCMND", soCMND);
        return "graduationJobList";
    }
}