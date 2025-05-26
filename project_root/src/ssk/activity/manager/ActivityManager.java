package ssk.activity.manager;

import ssk.activity.model.Activity;
import ssk.activity.model.User;
import java.util.ArrayList;
import java.util.List;

public class ActivityManager {
    private List<Activity> activities;

    public ActivityManager() {
        this.activities = new ArrayList<>();
    }

    public Activity addActivity(User user, String projectCode, String projectName,
                                String workHours, String workDescription, String workLocation) {
        if (user == null || projectCode == null || projectCode.trim().isEmpty() ||
            projectName == null || projectName.trim().isEmpty() ||
            workHours == null || workHours.trim().isEmpty() ||
            workDescription == null || workDescription.trim().isEmpty() ||
            workLocation == null || workLocation.trim().isEmpty()) {
            System.out.println("Failed to add activity: All fields must be provided.");
            return null;
        }

        Activity newActivity = new Activity(user, projectCode, projectName,
                                            workHours, workDescription, workLocation);

        if (!newActivity.areWorkHoursValid()) {
            System.out.println("Failed to add activity: Invalid work hours format. Please use HH:MM.");
            return null;
        }

        activities.add(newActivity);
        System.out.println("Activity for Project '" + projectName + "' added successfully.");
        return newActivity;
    }

    public void displayActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities available.");
            return;
        }
        System.out.println("--- Activity List ---");
        for (int i = 0; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            if (activity != null) {
                System.out.printf("%d. Project Code: %s, Project Name: %s, User: %s, Date: %s, Work Hours: %s\n",
                                  (i + 1), activity.getProjectCode(), activity.getProjectName(),
                                  activity.getUser() != null ? activity.getUser().getUsername() : "N/A",
                                  activity.getDate(), activity.getWorkHours());
            } else {
                System.out.println("Activity data is missing (null) at index " + (i + 1) + ".");
            }
        }
        System.out.println("---------------------");
    }

    public Activity deleteActivityByIndex(int index) {
        if (index < 1 || index > activities.size()) {
            System.out.println("Invalid choice. Activity not deleted.");
            return null;
        }
        Activity deletedActivity = activities.remove(index - 1);
        System.out.printf("Activity for Project '%s' has been successfully deleted.\n",
                          deletedActivity.getProjectName());
        return deletedActivity;
    }

    public List<Activity> getAllActivities() {
        return new ArrayList<>(activities);
    }
}
