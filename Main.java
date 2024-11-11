import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter your name: ");
    String name = input.nextLine();
    System.out.println("Enter your current age: ");
    int age = input.nextInt();
    System.out.println("Enter your current savings: ");
    double savings  = input.nextDouble();
    System.out.println("Enter your target retirement age: ");
    int retirementAge = input.nextInt();
    System.out.println("Enter your annual contribution: ");
    double annualContribution = input.nextDouble();

    User user = new User(name, age, savings, retirementAge, annualContribution);

    System.out.println("Select an investment type(stocks, bonds, etc.): ");
    String type = input.nextLine();
    System.out.println("Enter the annual  return rate of this invesment (%): ");
    double returnRate = input.nextDouble();


    Investment investment = new Investment(type, returnRate);

    RetirementPlan plan = new RetirementPlan(user, investment);
    double projectedSavings = plan.calculateProjectedSavings();

    System.out.printf("Projected retirement savings: %.2f\n", projectedSavings);

    input.close();

  }
}
