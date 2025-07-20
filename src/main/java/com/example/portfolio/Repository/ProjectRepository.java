package com.example.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.Model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}