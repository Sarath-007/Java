package com.company;
class BankAccount{
    private double balance;
    private String name;

    public BankAccount(String name) {
        this.name = name;
        balance=0.0;
    }
    public double getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println(name+" has "+ balance);
    }
    public void withdraw(double amount){
        if(balance<amount){
            System.out.println("Insufficient balance");
        }
        else{
            balance-=amount;
            System.out.println(name+" has "+balance);
        }
    }
    public void transfer(double amount ,BankAccount acc ){
        if(this.balance<amount){
            System.out.println("Insufficient balance");
        }
        else{
            this.balance-=amount;
            acc.balance+=amount;
            System.out.println("Transaction success");
            System.out.println("The balance in "+ this.name+" 's account is "+this.balance);
            System.out.println("The balance in "+acc.name+" 's account is "+acc.balance);
        }

    }
}
public class Bank_account {
    public static void main(String[] args) {
        BankAccount sarath=new BankAccount("Sarath");
        sarath.deposit(500.0);
        BankAccount raj=new BankAccount("Raj");
        raj.deposit(200.0);
        sarath.transfer(100.0,raj);
        raj.withdraw(100.0);
        System.out.println("The balance is "+raj.getBalance());
        raj.withdraw(900.0);

    }
}
