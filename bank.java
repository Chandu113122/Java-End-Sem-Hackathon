
class Bank {
    String name;
    String accNo;
    double balance;
    double deposits = 0;
    double withdrawals = 0;

    Bank(String n, String a, double b) {
        name = n.toUpperCase().trim();
        accNo = a;
        balance = b;
    }

    void deposit(double amount) {
        deposit(amount, "Cash Deposit");
    }

    void deposit(double amount, String desc) {
        balance = balance + amount;
        deposits = deposits + amount;

        System.out.println("Deposit Amount      : Rs. " + amount);
        System.out.println("Transaction Status  : Deposit Successful");
        System.out.println("Description         : " + desc);
        System.out.println("Updated Balance     : Rs. " + balance);
    }

    void withdraw(double amount) {
        withdraw(amount, "Cash Withdrawal");
    }

    void withdraw(double amount, String desc) {
        System.out.println("Withdrawal Amount   : Rs. " + amount);

        if (amount <= balance) {
            balance = balance - amount;
            withdrawals = withdrawals + amount;
            System.out.println("Transaction Status  : Withdrawal Successful");
            System.out.println("Description         : " + desc);
            System.out.println("Updated Balance     : Rs. " + balance);
        } else {
            System.out.println("Transaction Status  : Insufficient Balance");
            System.out.println("Available Balance   : Rs. " + balance);
        }
    }

    void summary(String customerName) {
        System.out.println("\n---------- ACCOUNT SUMMARY ----------");
        System.out.println("Account Holder      : " + name);
        System.out.println("Account Number      : " + accNo);
        System.out.println("Total Deposits      : Rs. " + deposits);
        System.out.println("Total Withdrawals   : Rs. " + withdrawals);
        System.out.println("Final Balance       : Rs. " + balance);

        if (name.equalsIgnoreCase(customerName.trim())) {
            System.out.println("Account Holder Verification: Names Match");
        } else {
            System.out.println("Account Holder Verification: Names Do Not Match");
        }
    }

    public static void main(String[] args) {
        Bank b = new Bank("Ravi Kumar", "1234567890", 10000);

        System.out.println("========== PERSONAL BANKING LEDGER ==========");
        System.out.println("Account Holder Name : " + b.name);
        System.out.println("Account Number      : " + b.accNo);
        System.out.println("Initial Balance     : Rs. " + b.balance);

        System.out.println("\n---------- TRANSACTION DETAILS ----------");

        b.deposit(5000, "Salary Deposit");
        b.withdraw(2000, "Bill Payment");
        b.withdraw(20000, "Shopping");

        b.summary("Ravi Kumar");
        System.out.println("=============================================");
    }
}