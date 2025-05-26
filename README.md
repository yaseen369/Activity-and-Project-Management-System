## Activity and Project Management System

### Description
This project details the development of a Java-based activity and project management system. It encompasses modules for displaying activity and project information, managing user accounts including registration, login, and password changes, and handling the addition and deletion of both activities and projects through a main menu interface. Core components include classes defining `Activity` and `Project` objects with their respective attributes and behaviors, such as work hour validation for activities and code-based identification for projects.

### Features
* **User Management:**
    * Register new users with a username and password.
    * User login functionality.
    * Change user passwords.
    * View a list of all registered users.
* **Project Management:**
    * Add new projects with a unique project code and name.
    * View a list of all projects.
    * Display details for a specific project by its code.
* **Activity Management:**
    * Add new activities, linking them to a user and project, with details like work hours, description, and location.
    * Validate work hour input (HH:MM format).
    * View a list of all recorded activities.
    * View detailed information for a specific activity.
    * Delete activities by their list number.
* **Interactive Menu:**
    * A command-line interface (`MainMenu`) for easy navigation and interaction with the system.

### Directory Structure

```
project_root/
└── src/
    └── ssk/
        ├── activity/
        │   ├── manager/
        │   │   ├── ActivityManager.java
        │   │   ├── ProjectManager.java
        │   │   └── UserManager.java
        │   ├── model/
        │   │   ├── Activity.java
        │   │   ├── Project.java
        │   │   └── User.java
        │   ├── ChangePassword.java
        │   └── ShowActivity.java
        └── faaliyet/
            └── menu/
                └── MainMenu.java
```

### How to Compile and Run

To compile and run this Java application, follow these steps:

1.  **Prerequisites:** Ensure you have a Java Development Kit (JDK) installed on your system. You can download it from the official Oracle website or use open-source alternatives like OpenJDK.

2.  **Create Directory Structure:** Create the folder structure as described in the "Directory Structure" section above. For example, create a base folder like `my_java_project`, then `src` inside it, and then `ssk/activity/model`, `ssk/activity/manager`, `ssk/activity`, `ssk/faaliyet/menu` inside `src/ssk`.

3.  **Save Files:** Place each `.java` file into its corresponding directory as shown in the directory structure.

4.  **Open Terminal/Command Prompt:** Navigate to the `my_java_project` directory (the parent directory containing the `src` folder).

5.  **Compile the Code:**
    Execute the following command to compile all Java files:
    ```bash
    javac src/ssk/faaliyet/menu/MainMenu.java src/ssk/activity/manager/*.java src/ssk/activity/model/*.java src/ssk/activity/*.java
    ```
    If compilation is successful, `.class` files will be generated in their respective directories.

6.  **Run the Application:**
    After successful compilation, run the main application class using the command:
    ```bash
    java -cp src ssk.faaliyet.menu.MainMenu
    ```
    The `-cp src` argument tells Java to look for compiled classes within the `src` directory.

### Contributing
Feel free to fork this repository, make improvements, and submit pull requests.

### License
This project is open-source and available under the [MIT License].
