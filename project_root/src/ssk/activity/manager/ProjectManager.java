package ssk.activity.manager;

import ssk.activity.model.Project;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    private List<Project> projects;

    public ProjectManager() {
        this.projects = new ArrayList<>();
    }

    public Project addProject(String projectCode, String projectName) {
        if (projectCode == null || projectCode.trim().isEmpty() || projectName == null || projectName.trim().isEmpty()) {
            System.out.println("Invalid project code or name. Cannot add project.");
            return null;
        }
        if (findProjectByCode(projectCode) != null) {
            System.out.println("Project with code '" + projectCode + "' already exists.");
            return null;
        }
        Project newProject = new Project(projectCode, projectName);
        projects.add(newProject);
        System.out.println("Project '" + projectName + "' (Code: " + projectCode + ") added successfully.");
        return newProject;
    }

    public void displayProjects() {
        if (projects.isEmpty()) {
            System.out.println("No projects available.");
            return;
        }
        System.out.println("--- Project List ---");
        for (Project project : projects) {
            if (project != null) {
                System.out.println("Project Code: " + project.getProjectCode());
                System.out.println("Project Name: " + project.getProjectName());
                System.out.println("--------------------");
            } else {
                System.out.println("Project data is missing (null).");
            }
        }
    }

    public void displayProjectByCode(String projectCode) {
        if (projectCode == null || projectCode.trim().isEmpty()) {
            System.out.println("Invalid project code provided.");
            return;
        }
        Project foundProject = findProjectByCode(projectCode);
        if (foundProject == null) {
            System.out.println("Project with code '" + projectCode + "' not found.");
        } else {
            System.out.println("--- Project Details ---");
            System.out.println("Project Code: " + foundProject.getProjectCode());
            System.out.println("Project Name: " + foundProject.getProjectName());
            System.out.println("-----------------------");
        }
    }

    public Project findProjectByCode(String projectCode) {
        if (projects == null || projectCode == null) {
            return null;
        }
        for (Project project : projects) {
            if (project != null && project.getProjectCode().equals(projectCode)) {
                return project;
            }
        }
        return null;
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projects);
    }
}
