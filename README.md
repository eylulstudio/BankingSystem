#JAVA BANKING SYSTEM PROJECT

### Project Description
This project is a Java application that simulates a banking system. 
The project demonstrates Object-Oriented Programming (OOP) principles, UML diagrams, 
JUnit tests, and Git/GitHub usage.

### Features
- Account operations:
  - Deposit
  - Withdraw
  - Transfer between accounts
  
- Account types:
  - CheckingAccount (with overdraft feature)
  - SavingsAccount (with interest feature)
  
- Loan operations:
  - Take a loan
  - Pay a loan
  - Track remaining debt and balance
  
- Transaction records
- Monthly report
- Clean and organized OOP structure

- OOP Structure
  - Encapsulation: private/protected variables and getter/setter
  - Polymorphism: abstract withdraw method implemented differently in each account type
  - Inheritance: Account → SavingsAccount / CheckingAccount
  - Interface: Transferable interface enforces transfer method
  
  - Unit Tests
  - Deposit, Withdraw, Transfer, Take/Pay Loans
  - Bank and Loan class logic tested
  - All tests pass successfully (green) in Eclipse

- Git & Kanban
  - GitHub commit history and Kanban board used for task management
  


### How to Run 
1. Open the project in Eclipse.
2. Run the `Main.java` file.
3. The console will show the following options:
   1. Deposit → Deposit money into an account
   2. Withdraw → Withdraw money from an account
   3. Transfer → Transfer money between accounts
   4. View Transactions → Show transaction history
   5. View Balances → Show account balances
   6. Monthly Report → Display monthly report
   7. Take Loan → Create a loan
   0. Exit → Exit the application
   
### UML and Other Files
- UML Class Diagram and Use Case Diagram are in the `uml` folder
- Kanban board managed on GitHub Projects
- Project repository on GitHub includes all commits and history