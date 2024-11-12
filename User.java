public class User {
  private final int userId;
  private final String name;
  private final int age;
  private double currentSavings;
  private int retirementAge;
  private double annualContribution;

  public User(int userId, String name, int age, double currentSavings, int retirementAge, double annualContribution) {
    this.userId = userId;
    this.name = name;
    this.age = age;
    this.currentSavings = currentSavings;
    this.retirementAge = retirementAge;
    this.annualContribution = annualContribution;
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

  public void annualContributions(double annualContribution) {
    if (annualContribution >= 0) {
      this.annualContribution = annualContribution;
    } else {
      System.out.println("Annual contribution cannot be negative.");
    }
  }
  
  public double calculateProjectedIncome(double annualGrowthRate) {
    int yearsUntilRetirement = retirementAge - age;
    double projectedSavings = currentSavings;

    for (int i = 0; i < yearsUntilRetirement; i++) {
      projectedSavings += projectedSavings * annualGrowthRate; // Apply growth
      projectedSavings += annualContribution; // Add annual contribution
    }

    return projectedSavings;
  }


  //getter and setter
}

