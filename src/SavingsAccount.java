
public class SavingsAccount extends BankAccount {

    private double intRate;

    public SavingsAccount(double rate){

        intRate = rate;
    }

    // Adds the earned interest to the account balance.

    public void addInterest(){

        double interest = getBalance() * intRate / 100;
        deposit(interest);
    }
}
