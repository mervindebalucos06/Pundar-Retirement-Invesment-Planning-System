import java.util.Scanner;

public class Main {
  private static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    boolean exit = false;

    while (!exit) {
      System.out.println("=== Retirement Investment Planning System ===");
      System.out.println("1. Sign Up");
      System.out.println("2. Login");
      System.out.println("3. About Us");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");

      int choice = input.nextInt();
      input.nextLine();

      switch (choice) {
        case 1 -> signUp();
        case 2 -> login();
        case 3 -> aboutUs();
        case 4 -> {
          System.out.println("Exiting... Goodbye!");
          exit = true;
        } 
      default -> System.out.println("Invalid choice. Please try again.");
    }
    input.close();
    }
  }

  private static void signUp() {
    System.out.println("=== Sign Up ==");
    System.out.println("Enter your name: ");
    String name = input.nextLine();
    System.out.println("Enter your age: ");
    int age = input.nextInt();
    System.out.println("Enter your current savings: ");
    double savings = input.nextDouble();
    System.out.println("Enter your retirement age: ");
    int retirementAge = input.nextInt();
    System.out.println("Enter your annual contribution: ");
    double contribution = input.nextDouble();

    System.out.println("Sign Up successful! You can now log in.");
  }

  // Login Method
  private static void login() {
    System.out.println("=== Login ===");
    System.out.print("Enter your user ID: ");
    int userId = input.nextInt();

    //User user = userDAO.getUser(userId);
    if (user != null) {
      System.out.println("Welcome, " + user.getName() + "!");
      showUserRetirementPlan(user);
    } else {
      System.out.println("User not found. Please sign up first.");
    }
  }

  // Display and manage user retirement details
  private static void showUserRetirementPlan(User user) {
    boolean exit = false;

    while (!exit) {
      System.out.println("\n=== Your Retirement Plan ===");
      System.out.println("1. View Retirement Details");
      System.out.println("2. Update Retirement Plan");
      System.out.println("3. Logout");
      System.out.print("Choose an option: ");

      int choice = input.nextInt();
      input.nextLine(); // Consume newline

      switch (choice) {
        case 1 -> viewRetirementDetails(user);
        case 2 -> updateRetirementPlan(user);
        case 3 -> {
          System.out.println("Logging out...");
          exit = true;
        }
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  // View Retirement Details
  private static void viewRetirementDetails(User user) {
    System.out.println("\n=== Retirement Details ===");
    System.out.println("Name: " + user.getName());
    System.out.println("Age: " + user.getAge());
    System.out.println("Current Savings: $" + user.getCurrentSavings());
    System.out.println("Retirement Age: " + user.getRetirementAge());
    System.out.println("Annual Contribution: $" + user.getAnnualContribution());
  }

  // Update Retirement Plan
  private static void updateRetirementPlan(User user) {
    System.out.println("\n=== Update Retirement Plan ===");
    System.out.print("Enter new current savings: ");
    double newSavings = input.nextDouble();
    System.out.print("Enter new annual contribution: ");
    double newContribution = input.nextDouble();
    System.out.print("Enter new retirement age: ");
    int newRetirementAge = input.nextInt();

    // Update the user object with new details
    user.setCurrentSavings(newSavings);
    user.setAnnualContribution(newContribution);
    user.setRetirementAge(newRetirementAge);

    // Update the user in the database
    //userDAO.updateUser(user);
    System.out.println("Your retirement plan has been updated successfully.");
  }

  // About Us Method
  private static void aboutUs() {
    System.out.println("=== About Us ===");
    System.out.println("Welcome to the Retirement Investment Planning System.");
    System.out.println("This application helps you plan, track, and optimize your retirement savings.");
    System.out.println("Developed to support financial stability and economic growth.");
  }
}
  


