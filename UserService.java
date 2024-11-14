import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserService {
    private final Scanner input = new Scanner(System.in);
    private final Map<Integer, User> userDatabase = new HashMap<>();
    private int userIdCounter = 1;

    public void signUp() {
        System.out.println("=== Sign Up ===");
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        input.nextLine();  // Consume newline
        System.out.print("Enter your investment type: ");
        String investmentType = input.nextLine();
        System.out.print("Enter your current savings: ");
        double savings = input.nextDouble();
        System.out.print("Enter your retirement age: ");
        int retirementAge = input.nextInt();
        System.out.print("Enter your annual contribution: ");
        double contribution = input.nextDouble();
        input.nextLine();  // Consume newline

        User newUser = new User(userIdCounter, name, age, investmentType, savings, retirementAge, contribution);
        userDatabase.put(userIdCounter, newUser);
        System.out.println("Sign Up successful! Your user ID is " + userIdCounter + ". You can now log in.");
        userIdCounter++;
    }

    public void login() {
        System.out.println("=== Login ===");
        System.out.print("Enter your user ID: ");
        int userId = input.nextInt();
        input.nextLine();  // Consume newline

        User user = userDatabase.get(userId);
        if (user != null) {
            System.out.println("Welcome, " + user.getName() + "!");
            showUserRetirementPlan(user);
        } else {
            System.out.println("User not found. Please sign up first.");
        }
    }

    public void showUserRetirementPlan(User user) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Your Retirement Plan ===");
            System.out.println("1. View Retirement Details");
            //add System.out.println("2. Add New Investment Type")
            System.out.println("2. Update Retirement Plan");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> viewRetirementDetails(user);
                case 2 -> updateRetirementPlan(user);
                case 3 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewRetirementDetails(User user) {
        System.out.println("\n=== Retirement Details ===");
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Investment Type: " + user.getInvestmentType());
        System.out.println("Current Savings: $" + user.getCurrentSavings());
        System.out.println("Retirement Age: " + user.getRetirementAge());
        System.out.println("Annual Contribution: $" + user.getAnnualContribution());
        double projectedIncome = user.calculateProjectedIncome(0.05);
        System.out.printf("Projected Income at Retirement: $%.2f\n", projectedIncome);
    }

    private void updateRetirementPlan(User user) {
        System.out.println("\n=== Update Retirement Plan ===");
        System.out.print("Enter new current savings: ");
        double newSavings = input.nextDouble();
        System.out.print("Enter new annual contribution: ");
        double newContribution = input.nextDouble();
        System.out.print("Enter new retirement age: ");
        int newRetirementAge = input.nextInt();
        input.nextLine();  // Consume newline

        user.setCurrentSavings(newSavings);
        user.setAnnualContribution(newContribution);
        user.setRetirementAge(newRetirementAge);
        System.out.println("Your retirement plan has been updated successfully.");
    }

    public void aboutUs() {
        System.out.println("=== About Us ===");
        System.out.println("Welcome to the Retirement Investment Planning System.");
        System.out.println("This application helps you plan, track, and optimize your retirement savings.");
        System.out.println("Developed to support financial stability and economic growth.");
    }
}
