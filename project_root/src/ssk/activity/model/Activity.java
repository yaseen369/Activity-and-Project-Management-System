package ssk.activity.model;

import java.util.Date;
import java.util.Objects;

public class Activity {
    private Date date;
    private User user;
    private String projectCode;
    private String projectName;
    private String workHours;
    private String workDescription;
    private String workLocation;

    public Activity(User user, String projectCode, String projectName,
                    String workHours, String workDescription, String workLocation) {
        this.date = new Date();
        this.user = user;
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.workHours = workHours;
        this.workDescription = workDescription;
        this.workLocation = workLocation;
    }

    public Date getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getWorkHours() {
        return workHours;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public boolean areWorkHoursValid() {
        if (workHours == null || workHours.trim().isEmpty()) {
            return false;
        }

        String[] parts = workHours.split(":");
        if (parts.length != 2) {
            return false;
        }

        try {
            int hours = Integer.parseInt(parts[0].trim());
            int minutes = Integer.parseInt(parts[1].trim());

            return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getTotalHours() {
        if (!areWorkHoursValid()) {
            return 0.0;
        }
        String[] parts = workHours.split(":");
        int hours = Integer.parseInt(parts[0].trim());
        int minutes = Integer.parseInt(parts[1].trim());
        return hours + (minutes / 60.0);
    }

    @Override
    public String toString() {
        return "Activity{" +
               "date=" + date +
               ", user=" + (user != null ? user.getUsername() : "N/A") +
               ", projectCode='" + projectCode + '\'' +
               ", projectName='" + projectName + '\'' +
               ", workHours='" + workHours + '\'' +
               ", workDescription='" + workDescription + '\'' +
               ", workLocation='" + workLocation + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(date, activity.date) &&
               Objects.equals(user, activity.user) &&
               Objects.equals(projectCode, activity.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, user, projectCode);
    }
}
