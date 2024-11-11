public class User {
  private String name;
  private final int age;
  private final double currentSavings;
  private final int retirementAge;
  private double annualContribution;

  public User(String name, int age, double currentSavings, int retirementAge, double annualContribution) {
    this.name = name;
    this.age = age;
    this.currentSavings = currentSavings;
    this.retirementAge = retirementAge;
    this.annualContribution = annualContribution;
  }

  public int getAge() {
    return age;
  }
  
  public int getRetirementAge() {
    return retirementAge;
  }
  
  public double getCurrentSavings() {
    return currentSavings;
  }

  public double annualContributions() {
    return annualContribution;
  }

  public void annualContributions(double annualContribution) {
    if (annualContribution >= 0) {
      this.annualContribution = annualContribution;
    } else {
      System.out.println("Annual contribution cannot be negative.");
    }
  }
  
  


  //getter and setter
}
