package plan;

import model.Investment;
import model.User;

public class RetirementPlan {
  private final User user;
  private final Investment investment;

  public RetirementPlan(User user, Investment investment) {
    this.user = user;
    this.investment = investment;
  }

  public double calculateProjectedSavings() {
    int yearsToRetirement = user.getRetirementAge() - user.getAge();

    double futureValue = user.getCurrentSavings();

    for (int i = 0; i < yearsToRetirement; i++) {
      futureValue += user.getAnnualContribution();
      futureValue = investment.CalculateReturns(futureValue, 1);
    }
    return futureValue;
  }
}