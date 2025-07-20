package com.example.portfolio.Controller;

import com.example.portfolio.Model.Project;
import com.example.portfolio.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:3000") // frontend ke liye CORS allow
public class ProjectController {

    @Autowired
    private ProjectService proServ;

    // ✅ Get all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return proServ.getAllProjects();
    }

    // ✅ Get single project by ID
    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return proServ.getProjectById(id);
    }

    // ✅ Create new project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return proServ.createProject(project);
    }

    // ✅ Update existing project
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        return proServ.updateProject(id, project);
    }

    // ✅ Delete project
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        proServ.deleteProject(id);
    }
}
