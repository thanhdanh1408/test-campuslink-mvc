package com.danhheo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.danhheo.controller.StudentController;
import com.danhheo.dao.GraduationDAO;
import com.danhheo.dao.JobDAO;
import com.danhheo.dao.MajorDAO;
import com.danhheo.dao.SchoolDAO;
import com.danhheo.dao.StudentDAO;
import com.danhheo.service.GraduationService;
import com.danhheo.service.JobService;
import com.danhheo.service.MajorService;
import com.danhheo.service.SchoolService;
import com.danhheo.service.StudentService;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
public class AppConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean
    public SchoolDAO schoolDAO(DataSource dataSource) {
        return new SchoolDAO(dataSource);
    }
    @Bean
    public SchoolService schoolService(DataSource dataSource) {
        return new SchoolService(dataSource);
    }
    
    @Bean
    public StudentDAO studentDAO(DataSource dataSource) {
        return new StudentDAO(dataSource);
    }
    @Bean
    public StudentService studentService(DataSource dataSource) {
        return new StudentService(dataSource);
    }
    
    @Bean
    public MajorDAO majorDAO(DataSource dataSource) {
        return new MajorDAO(dataSource);
    }
    @Bean
    public MajorService majorService(DataSource dataSource) {
        return new MajorService(dataSource);
    }
    
    @Bean
    public JobDAO jobDAO(DataSource dataSource) {
        return new JobDAO(dataSource);
    }
    @Bean
    public JobService jobService(DataSource dataSource) {
        return new JobService(dataSource);
    }
    
    @Bean
    public GraduationDAO graduationDAO(DataSource dataSource) {
        return new GraduationDAO(dataSource);
    }
    @Bean
    public GraduationService graduationService(DataSource dataSource) {
        return new GraduationService(dataSource);
    }
    
    @Bean
    public StudentController studentController(DataSource dataSource) {
        return new StudentController(dataSource);
    }
}