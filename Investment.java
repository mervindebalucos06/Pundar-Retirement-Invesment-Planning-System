public class Investment {
  private String type;
  private double annualReturnRate;

  public Investment(String type, double annualReturnRate) {
    this.type = type;
    this.annualReturnRate = annualReturnRate;
  }

  public double CalculateReturns(double principal, int years) {
    return principal * Math.pow((1 + annualReturnRate / 100), years);
  }
  
}
