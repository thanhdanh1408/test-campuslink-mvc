package com.danhheo.controller;

import com.danhheo.model.Graduation;
import com.danhheo.model.Student;
import com.danhheo.service.GraduationService;
import com.danhheo.service.MajorService;
import com.danhheo.service.SchoolService;
import com.danhheo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final GraduationService graduationService;
    private final SchoolService schoolService;
    private final MajorService majorService;

    public StudentController(DataSource dataSource) {
        this.studentService = new StudentService(dataSource);
        this.graduationService = new GraduationService(dataSource);
        this.schoolService = new SchoolService(dataSource);
        this.majorService = new MajorService(dataSource);
    }

    @GetMapping("/student/form")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("graduation", new Graduation());
        model.addAttribute("schools", schoolService.getAllSchools());
        model.addAttribute("majors", majorService.getAllMajors());
        return "studentForm";
    }

    @PostMapping("/student/save")
    public String saveStudent(
            @ModelAttribute("student") Student student,
            @ModelAttribute("graduation") Graduation graduation,
            Model model) {
        // Kiểm tra thủ công các trường bắt buộc
        boolean hasError = false;
        if (student.getSoCMND() == null || student.getHoTen() == null || student.getHoTen().trim().isEmpty()) {
            model.addAttribute("studentError", "Số CMND và Họ Tên không được để trống");
            hasError = true;
        }
        if (graduation.getSoCMND() == null || graduation.getMaTruong() == null || graduation.getMaNganh() == null) {
            model.addAttribute("graduationError", "Số CMND, Mã Trường, Mã Ngành không được để trống");
            hasError = true;
        }
        if (graduation.getNgayTN() == null) {
            model.addAttribute("dateError", "Ngày tốt nghiệp không được để trống");
            hasError = true;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date parsedDate = sdf.parse(sdf.format(graduation.getNgayTN()));
                if (parsedDate.after(new Date())) {
                    model.addAttribute("dateError", "Ngày tốt nghiệp không được trong tương lai");
                    hasError = true;
                }
            } catch (ParseException e) {
                model.addAttribute("dateError", "Ngày tốt nghiệp không hợp lệ");
                hasError = true;
            }
        }

        if (hasError) {
            model.addAttribute("schools", schoolService.getAllSchools());
            model.addAttribute("majors", majorService.getAllMajors());
            return "studentForm";
        }

        // Lưu dữ liệu
        studentService.saveStudent(student);
        graduationService.saveGraduation(graduation);
        
        System.out.println("Luu");
        return "redirect:/";
    }
}