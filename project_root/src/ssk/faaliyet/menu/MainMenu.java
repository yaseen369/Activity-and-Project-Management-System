package ssk.faaliyet.menu;

import ssk.activity.manager.ActivityManager;
import ssk.activity.manager.ProjectManager;
import ssk.activity.manager.UserManager;
import ssk.activity.model.Activity;
import ssk.activity.model.Project;
import ssk.activity.model.User;
import ssk.activity.ShowActivity;
import ssk.activity.ChangePassword;

import java.util.Scanner;
import java.util.List;

public class MainMenu {

    private static Scanner scanner = new Scanner(System.in);
    private static UserManager userManager = new UserManager();
    private static ProjectManager projectManager = new ProjectManager();
    private static ActivityManager activityManager = new ActivityManager();
    private static ChangePassword changePasswordUtility = new ChangePassword();

    private static final int ADD_ACTIVITY = 1;
    private static final int VIEW_ACTIVITIES = 2;
    private static final int ADD_USER = 3;
    private static final int VIEW_USERS = 4;
    private static final int ADD_PROJECT = 5;
    private static final int VIEW_PROJECTS = 6;
    private static final int DELETE_ACTIVITY = 7;
    private static final int CHANGE_PASSWORD = 8;
    private static final int EXIT = 9;

    public static void main(String[] args) {
        initializeData();

        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            System.out.print("Enter your choice: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case ADD_ACTIVITY:
                    addActivity();
                    break;
                case VIEW_ACTIVITIES:
                    viewActivities();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case VIEW_USERS:
                    viewUsers();
                    break;
                case ADD_PROJECT:
                    addProject();
                    break;
                case VIEW_PROJECTS:
                    viewProjects();
                    break;
                case DELETE_ACTIVITY:
                    deleteActivity();
                    break;
                case CHANGE_PASSWORD:
                    changeUserPassword();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            if (!exit) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println(ADD_ACTIVITY + ". Add New Activity");
        System.out.println(VIEW_ACTIVITIES + ". View Activities");
        System.out.println(ADD_USER + ". Add New User");
        System.out.println(VIEW_USERS + ". View Users");
        System.out.println(ADD_PROJECT + ". Add New Project");
        System.out.println(VIEW_PROJECTS + ". View Projects");
        System.out.println(DELETE_ACTIVITY + ". Delete Activity");
        System.out.println(CHANGE_PASSWORD + ". Change Password");
        System.out.println(EXIT + ". Exit");
        System.out.println("============================");
    }

    private static void addActivity() {
        System.out.println("\n--- Add New Activity ---");

        userManager.displayUsers();
        List<User> users = userManager.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users available. Please add a user first.");
            return;
        }
        System.out.print("Enter username for the activity: ");
        String username = scanner.nextLine().trim();
        User selectedUser = userManager.getUserByUsername(username);
        if (selectedUser == null) {
            System.out.println("User not found. Activity cannot be added.");
            return;
        }

        projectManager.displayProjects();
        List<Project> projects = projectManager.getAllProjects();
        if (projects.isEmpty()) {
            System.out.println("No projects available. Please add a project first.");
            return;
        }
        System.out.print("Enter project code for the activity: ");
        String projectCode = scanner.nextLine().trim();
        Project selectedProject = projectManager.findProjectByCode(projectCode);
        if (selectedProject == null) {
            System.out.println("Project not found. Activity cannot be added.");
            return;
        }

        System.out.print("Enter work hours (HH:MM, e.g., 08:30): ");
        String workHours = scanner.nextLine().trim();
        System.out.print("Enter work description: ");
        String workDescription = scanner.nextLine().trim();
        System.out.print("Enter work location: ");
        String workLocation = scanner.nextLine().trim();

        activityManager.addActivity(selectedUser, selectedProject.getProjectCode(),
                                    selectedProject.getProjectName(), workHours,
                                    workDescription, workLocation);
    }

    private static void viewActivities() {
        System.out.println("\n--- View Activities ---");
        activityManager.displayActivities();

        if (!activityManager.getAllActivities().isEmpty()) {
            System.out.print("Enter the activity number to view details (0 to go back): ");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                return;
            }

            if (choice > 0 && choice <= activityManager.getAllActivities().size()) {
                ShowActivity showActivity = new ShowActivity(activityManager.getAllActivities().get(choice - 1));
                showActivity.displayActivityInfo();
            } else if (choice != 0) {
                System.out.println("Invalid activity number.");
            }
        }
    }

    private static void addUser() {
        System.out.println("\n--- Add New User ---");
        System.out.print("Enter new username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        userManager.registerUser(username, password);
    }

    private static void viewUsers() {
        System.out.println("\n--- View Users ---");
        userManager.displayUsers();
    }

    private static void addProject() {
        System.out.println("\n--- Add New Project ---");
        System.out.print("Enter project code: ");
        String projectCode = scanner.nextLine().trim();
        System.out.print("Enter project name: ");
        String projectName = scanner.nextLine().trim();
        projectManager.addProject(projectCode, projectName);
    }

    private static void viewProjects() {
        System.out.println("\n--- View Projects ---");
        projectManager.displayProjects();
        if (!projectManager.getAllProjects().isEmpty()) {
            System.out.print("Enter project code to view details (or press Enter to go back): ");
            String projectCode = scanner.nextLine().trim();
            if (!projectCode.isEmpty()) {
                projectManager.displayProjectByCode(projectCode);
            }
        }
    }

    private static void deleteActivity() {
        System.out.println("\n--- Delete Activity ---");
        activityManager.displayActivities();
        if (activityManager.getAllActivities().isEmpty()) {
            System.out.println("No activities to delete.");
            return;
        }
        System.out.print("Enter the activity number to delete: ");
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }
        activityManager.deleteActivityByIndex(choice);
    }

    private static void changeUserPassword() {
        System.out.println("\n--- Change Password ---");
        userManager.displayUsers();
        if (userManager.getAllUsers().isEmpty()) {
            System.out.println("No users available to change password for.");
            return;
        }
        System.out.print("Enter username to change password for: ");
        String username = scanner.nextLine().trim();
        User userToModify = userManager.getUserByUsername(username);

        if (userToModify == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter current password: ");
        String oldPassword = scanner.nextLine().trim();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine().trim();

        changePasswordUtility.changeUserPassword(userToModify, oldPassword, newPassword);
    }

    private static void initializeData() {
        System.out.println("Initializing dummy data...");
        userManager.registerUser("john.doe", "password123");
        userManager.registerUser("jane.smith", "securepass");

        projectManager.addProject("P001", "Website Redesign");
        projectManager.addProject("P002", "Mobile App Development");
        projectManager.addProject("P003", "Database Migration");

        User john = userManager.getUserByUsername("john.doe");
        User jane = userManager.getUserByUsername("jane.smith");

        if (john != null && projectManager.findProjectByCode("P001") != null) {
            activityManager.addActivity(john, "P001", "Website Redesign", "08:00", "Frontend development", "Office");
        }
        if (jane != null && projectManager.findProjectByCode("P002") != null) {
            activityManager.addActivity(jane, "P002", "Mobile App Development", "06:30", "Backend API implementation", "Remote");
        }
        System.out.println("Dummy data initialized.");
    }
}
