class ATM {
    synchronized public void checkBalance(String accHolder){
        System.out.println(accHolder + " checking the Balance");
    }
    synchronized public void withdraw(String accHolder, int amt){
        System.out.println(accHolder + " is withdrawing " + amt + " rupees of money");
    }
}

class Customer extends Thread {
    ATM obj;
    String name;
    int amt;
    public Customer(ATM obj, String name, int amt){
        this.obj = obj;
        this.name = name;
        this.amt = amt;
    }
    public void useATM(){
        obj.checkBalance(this.name);
        obj.withdraw(this.name, this.amt);
    }
    public void run(){
        useATM();
    }
}

public class Bank {
    public static void main(String[] args) {
        ATM obj = new ATM();
        Customer customer1 = new Customer(obj, "Md Tauseef Akhtar", 100000);
        Customer customer2 = new Customer(obj, "Faizan Azizi", 98000);
        customer1.start();
        customer2.start();
    }
}
