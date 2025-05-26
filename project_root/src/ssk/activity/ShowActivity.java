package ssk.activity;

import ssk.activity.model.Activity;

public class ShowActivity {

    private Activity activity;

    public ShowActivity(Activity activity) {
        this.activity = activity;
    }

    public void displayActivityInfo() {
        if (activity == null) {
            System.out.println("No activity data available to display.");
            return;
        }
        System.out.println("--- Activity Details ---");
        System.out.println("User: " + (activity.getUser() != null ? activity.getUser().getUsername() : "N/A"));
        System.out.println("Date: " + activity.getDate());
        System.out.println("Project Code: " + activity.getProjectCode());
        System.out.println("Project Name: " + activity.getProjectName());
        System.out.println("Work Hours: " + activity.getWorkHours());
        System.out.println("Work: " + activity.getWorkDescription());
        System.out.println("Work Location: " + activity.getWorkLocation());
        System.out.println("------------------------");
    }
}
