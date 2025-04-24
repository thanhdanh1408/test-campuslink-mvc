package com.danhheo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jobstatistics?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root"); // Thay bằng username của bạn
        dataSource.setPassword("1234"); // Thay bằng password của bạn
        return dataSource;
    }
}