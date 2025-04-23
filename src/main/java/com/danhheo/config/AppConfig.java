package com.danhheo.config;

import com.danhheo.dao.NganhDAO;
import com.danhheo.dao.SinhVienDAO;
import com.danhheo.dao.TotNghiepDAO;
import com.danhheo.dao.TruongDAO;
import com.danhheo.service.NganhService;
import com.danhheo.service.SinhVienService;
import com.danhheo.service.TotNghiepService;
import com.danhheo.service.TruongService;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.danhheo")
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/jobstatistics");
        dataSource.setUser("root");
        dataSource.setPassword("1234"); // Set your MySQL password
        return dataSource;
    }

    @Bean
    public SinhVienDAO sinhVienDao() {
        return new SinhVienDAO(dataSource());
    }

    @Bean
    public TotNghiepDAO totNghiepDao() {
        return new TotNghiepDAO(dataSource());
    }

    @Bean
    public TruongDAO truongDao() {
        return new TruongDAO(dataSource());
    }

    @Bean
    public NganhDAO nghanhDao() {
        return new NganhDAO(dataSource());
    }

    @Bean
    public SinhVienService sinhVienService() {
        return new SinhVienService(sinhVienDao());
    }

    @Bean
    public TotNghiepService totNghiepService() {
        return new TotNghiepService(totNghiepDao());
    }

    @Bean
    public TruongService truongService() {
        return new TruongService(truongDao());
    }

    @Bean
    public NganhService nghanhService() {
        return new NganhService(nghanhDao());
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}