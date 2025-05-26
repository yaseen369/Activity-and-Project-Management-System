package ssk.activity.model;

import java.util.Date;
import java.util.Objects;

public class Project {
    private String projectCode;
    private String projectName;
    private Date creationDate;
    private Date modificationDate;
    private boolean active;

    public Project(String projectCode, String projectName) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.creationDate = new Date();
        this.active = true;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Project{" +
               "projectCode='" + projectCode + '\'' +
               ", projectName='" + projectName + '\'' +
               ", active=" + active +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectCode, project.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectCode);
    }
}
