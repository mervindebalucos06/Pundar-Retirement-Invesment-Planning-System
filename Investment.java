public class Investment {
  private String type;
  private final double annualReturnRate;

  //constructor
  public Investment(String type, double annualReturnRate) {
    this.type = type;
    this.annualReturnRate = annualReturnRate;
  }
//method to caculate returns
  public double CalculateReturns(double principal, int years) {
    return principal * Math.pow((1 + annualReturnRate / 100), years);
  }
//getters and setter
  public String getType() {
    return type;
  }

  public double getAnnualReturnRate() {
    return annualReturnRate;
  }

  public void setType(String type) {
    this.type = type;
  }
}

