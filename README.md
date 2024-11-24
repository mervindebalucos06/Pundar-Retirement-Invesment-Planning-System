# Pundar: Retirement Investment Planning System

## I. Project Overview
**Pundar** is a Java-based retirement investment planning application designed to help users plan, track, and optimize their retirement savings. Users can sign up, log in, and manage their personalized investment plans by choosing between **Conservative** and **Aggressive** investment strategies. The system calculates the projected income at retirement based on user inputs and supports financial literacy and long-term planning.

## II. Application of OOP Principles
This project applies key Object-Oriented Programming (OOP) principles:

1. **Encapsulation**  
   - User data, such as name, age, and investment details, is encapsulated within the `User` and `InvestmentPlan` classes.
   - Access to these details is controlled through getters and setters, ensuring data integrity and security.

2. **Abstraction**  
   - The `InvestmentPlan` abstract class defines the common structure for investment strategies, such as `calculateProjectedIncome`, while specific implementations are provided in the `ConservativePlan` and `AggressivePlan` subclasses.

3. **Inheritance**  
   - `ConservativePlan` and `AggressivePlan` inherit from the `InvestmentPlan` abstract class, promoting code reuse and the implementation of specific behavior.

4. **Polymorphism**  
   - The `calculateProjectedIncome` method is overridden in each subclass, enabling dynamic behavior based on the investment type selected by the user.

## III. Integration with the Sustainable Development Goal (SDG)
The project aligns with **Sustainable Development Goal (SDG) 8: Decent Work and Economic Growth** by fostering financial stability and encouraging long-term planning. The application empowers users to make informed investment decisions, contributing to personal financial health and economic sustainability.

## IV. Instructions for Running the Program
Follow these steps to run the **Pundar** program:

1. **Clone the Repository**

2. **Compile the Program**  
Ensure you have a Java compiler (JDK 8 or above) installed. Use the following command to compile the program:

3. **Run the Program**  
Navigate to the `bin` directory and run the `Main` class:

4. **Interact with the Program**  
- **Sign Up**: Create a new account.
- **Login**: Access your personalized retirement planning dashboard.
- **Add Retirement Details**: Input savings, contributions, and retirement age.
- **View and Update Plans**: View or modify your investment details.
- **About Us**: Learn more about the program's purpose and goals.
- **Exit**: Quit the application.

5. **Dependencies**
- The program uses Java core libraries (`java.util.*`) and follows a modular structure for organization.