public class User {
  private String name;
  private int age;
  private double currentSavings;
  private int retirementAge;
  private double annualContribution;

  public User(String name, int age, double currentSavings, int retirementAge, double annualContribution) {
    this.name = name;
    this.age = age;
    this.currentSavings = currentSavings;
    this.retirementAge = retirementAge;
    this.annualContribution = annualContribution;
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
  
  


  //getter and setter
}
