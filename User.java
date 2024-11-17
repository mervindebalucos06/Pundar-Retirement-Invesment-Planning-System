public class User {
  private final int userId;
  private final String name;
  private final int age;
  private final InvestmentPlan investmentPlan;
  private double currentSavings;
  private int retirementAge;
  private double annualContribution;

  public User(int userId, String name, int age, InvestmentPlan investmentPlan) {
    this.userId = userId;
    this.name = name;
    this.age = age;
    this.investmentPlan = investmentPlan;
    // this.currentSavings = currentSavings;
    // this.retirementAge = retirementAge;
    // this.annualContribution = annualContribution;
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

  public void setRetirementAge(int retirementAge) {
    this.retirementAge = retirementAge;
  }

  public void setAnnualContribution(double annualContribution) {
    this.annualContribution = annualContribution;
  }

  public void setCurrentSavings(double currentSavings) {
    this.currentSavings = currentSavings;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public int getRetirementAge() {
    return retirementAge;
  }

  public double getCurrentSavings() {
    return currentSavings;
  }

  public double getAnnualContribution() {
    return annualContribution;
  }

  // public void annualContributions(double annualContribution) {
  //   if (annualContribution >= 0) {
  //     this.annualContribution = annualContribution;
  //   } else {
  //     System.out.println("Annual contribution cannot be negative.");
  //   }
  // }

  public double calculateProjectedIncome(double annualGrowthRate) {
    return investmentPlan.calculateProjectedIncome(annualGrowthRate);
  }
}

