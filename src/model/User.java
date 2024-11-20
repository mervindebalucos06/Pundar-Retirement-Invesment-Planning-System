package src.model;
public class User {
  private final int userId;
  private final String name;
  private final int age;
  private final InvestmentPlan investmentPlan;

  public User(int userId, String name, int age, InvestmentPlan investmentPlan) {
    this.userId = userId;
    this.name = name;
    this.age = age;
    this.investmentPlan = investmentPlan;
  }

  //getter and setter

  public InvestmentPlan getInvestmentPlan() {
    return investmentPlan;
  }

  public double getProjectedIncome(double growthRate) {
    return investmentPlan.calculateProjectedIncome(growthRate); // polymorphic call
  }

  public int getUserId() {
    return userId;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public double calculateProjectedIncome(double annualGrowthRate) {
    return investmentPlan.calculateProjectedIncome(annualGrowthRate);
  }
}

