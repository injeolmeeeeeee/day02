package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;



public class BankAccount {
    private final String name;
    private final String accountNumber;
    private float balance;
    private ArrayList<String>[] transactions;
    private boolean closed;
    private Date openDate;
    private Date closeDate;
    
    public String getName() {return name;}
    public String getAccountNumber() {return accountNumber;}
    public float getBalance() {return balance;}
    public List<String>[] getTransactions() {return transactions;}
    public boolean isClosed() {return closed;}
    public Date getOpenDate() {return openDate;}
    public Date getCloseDate() {return closeDate;}
    public void setBalance(float balance) {this.balance = balance;}
    public void setTransactions(ArrayList<String>[] transactions) {this.transactions = transactions;}
    public void setClosed(boolean closed) {this.closed = closed;}
    public void setOpenDate(float openDate) {this.openDate = new Date();}
    

    public BankAccount(String name) {
        this.name=name;
        this.accountNumber=generateAccountNumber();
        this.transactions = new ArrayList[10];
    }

    public BankAccount(String name, float initialBalance) {
        this(name);
        this.balance=initialBalance;
    }

    private String generateAccountNumber() {
            return String.valueOf((Math.random()));
    }

public void deposit(float input) {
    if (input > 0 && !closed) {
        balance += input;
        System.out.println("You have deposited: $" + input);
        addTransaction("Deposit $ " + input + " at " + new Date());
    }   else {
            throw new IllegalArgumentException("Invalid deposit amount or account closed.");
        }
}
    
public void withdraw(float input) {
    if (input > 0 && !closed) {
        balance -= input;
        System.out.println("You have withdrawn: $" + input);
        addTransaction("Withdraw amount $" + input + "at" + new Date());
    }   else {
            throw new IllegalArgumentException("Invalid withdraw amount or account closed.");
        }
}

private void addTransaction(String transaction) {
    for (int i = 0; i<transactions.length; i++) {
        if ((transactions[i]) == null) {
            transactions[i] = new ArrayList<>();
            transactions[i].add(transaction);
            break;
        }
    }
}

public void closeAccount() {
    closed = true;
    closeDate = new Date();
}
}

