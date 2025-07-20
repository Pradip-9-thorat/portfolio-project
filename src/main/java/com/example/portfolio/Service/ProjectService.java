package com.example.portfolio.Service;

import com.example.portfolio.Model.Project;
import com.example.portfolio.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository prorepo;

    // ✅ Get all projects
    public List<Project> getAllProjects() {
        return prorepo.findAll();
    }

    // ✅ Get project by ID
    public Optional<Project> getProjectById(Long id) {
        return prorepo.findById(id);
    }

    // ✅ Create new project
    public Project createProject(Project project) {
        return prorepo.save(project);
    }

    // ✅ Update project
    public Project updateProject(Long id, Project updatedProject) {
        return prorepo.findById(id).map(project -> {
            project.setTitle(updatedProject.getTitle());
            project.setDescription(updatedProject.getDescription());
            project.setTechStack(updatedProject.getTechStack());
            project.setGithubLink(updatedProject.getGithubLink());
            project.setLiveDemoLink(updatedProject.getLiveDemoLink());
            project.setImageUrl(updatedProject.getImageUrl());
            return prorepo.save(project);
        }).orElseGet(() -> {
            updatedProject.setId(id);
            return prorepo.save(updatedProject);
        });
    }

    // ✅ Delete project
    public void deleteProject(Long id) {
        prorepo.deleteById(id);
    }
}
