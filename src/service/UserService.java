package src.service;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import src.model.InvestmentPlan;
import src.model.User;
import src.plan.AggressivePlan;
import src.plan.ConservativePlan;

public class UserService {
    private final Scanner input = new Scanner(System.in);
    private final Map<Integer, User> userDatabase = new HashMap<>();
    private int userIdCounter = 1;

    public void signUp() {
        System.out.println("=== Sign Up ===");
        try {
            System.out.print("Enter your name: ");
            String name = input.nextLine();

            int age = promptForInt("Enter your age: ", 1, 120);
            double savings = promptForDouble("Enter your current savings: ", 0, Double.MAX_VALUE);
            double contribution = promptForDouble("Enter your annual contribution: ", 0, Double.MAX_VALUE);
            int retirementAge = promptForInt("Enter your retirement age: ", age + 1, 120);

            System.out.print("Choose an investment type (1 for Conservative, 2 for Aggressive): ");
            int planType = input.nextInt();
            input.nextLine(); // Consume newline

            InvestmentPlan plan;
            switch (planType) {
                case 1 -> plan = new ConservativePlan(savings, contribution, retirementAge);
                case 2 -> plan = new AggressivePlan(savings, contribution, retirementAge);
                default -> throw new IllegalArgumentException("Invalid investment type. Choose 1 or 2.");
            }

            User newUser = new User(userIdCounter++, name, age, plan);
            userDatabase.put(newUser.getUserId(), newUser);

            System.out.println("Sign Up successful! You can now log in.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please try again.");
            input.nextLine(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void login() {
        System.out.println("=== Login ===");
        try {
            int userId = promptForInt("Enter your user ID: ", 1, Integer.MAX_VALUE);

            User user = userDatabase.get(userId);
            if (user != null) {
                System.out.println("Welcome, " + user.getName() + "!");
                showUserRetirementPlan(user);
            } else {
                System.out.println("User not found. Please sign up first.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid user ID.");
            input.nextLine(); // Clear invalid input
        }
    }

    public void showUserRetirementPlan(User user) {
        boolean exit = false;
        while (!exit) {
            try {
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
                    case 3 -> exit = true;
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 3.");
                input.nextLine(); // Clear invalid input
            }
        }
    }

    private void viewRetirementDetails(User user) {
        InvestmentPlan investmentPlan = user.getInvestmentPlan();
        System.out.println("\n=== Retirement Details ===");
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Current Savings: $" + investmentPlan.getCurrentSavings());
        System.out.println("Retirement Age: " + investmentPlan.getRetirementAge());
        System.out.println("Annual Contribution: $" + investmentPlan.getAnnualContribution());
        double projectedIncome = user.calculateProjectedIncome(0.05);
        System.out.printf("Projected Income at Retirement: $%.2f\n", projectedIncome);
    }

    private void updateRetirementPlan(User user) {
        System.out.println("\n=== Update Retirement Plan ===");
        try {
            double newSavings = promptForDouble("Enter new current savings: ", 0, Double.MAX_VALUE);
            double newContribution = promptForDouble("Enter new annual contribution: ", 0, Double.MAX_VALUE);
            int newRetirementAge = promptForInt("Enter new retirement age: ", user.getAge() + 1, 120);

            InvestmentPlan plan = user.getInvestmentPlan();
            plan.setCurrentSavings(newSavings);
            plan.setAnnualContribution(newContribution);
            plan.setRetirementAge(newRetirementAge);

            System.out.println("Your retirement plan has been updated successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please try again.");
            input.nextLine(); // Clear invalid input
        }
    }


    public void aboutUs() {
        System.out.println("=== About Us ===");
        System.out.println("Welcome to the Retirement Investment Planning System.");
        System.out.println("This application helps you plan, track, and optimize your retirement savings.");
        System.out.println("Developed to support financial stability and economic growth.");
    }

    // Helper methods for input validation
    private int promptForInt(String message, int min, int max) {
        int value;
        while (true) {
            try {
                System.out.print(message);
                value = input.nextInt();
                if (value < min || value > max) {
                    throw new IllegalArgumentException("Value must be between " + min + " and " + max + ".");
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                input.nextLine(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private double promptForDouble(String message, double min, double max) {
        double value;
        while (true) {
            try {
                System.out.print(message);
                value = input.nextDouble();
                if (value < min || value > max) {
                    throw new IllegalArgumentException("Value must be between " + min + " and " + max + ".");
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                input.nextLine(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
