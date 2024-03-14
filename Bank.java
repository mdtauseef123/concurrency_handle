class ATM {
    synchronized public void checkBalance(String accHolder){
        System.out.println(accHolder + " checking the Balance");
    }
    synchronized public void withdraw(String accHolder, int amt){
        System.out.println(accHolder + " is withdrawing " + amt + " rupees of money");
    }
}

class Customer1 extends Thread {
    ATM obj;
    public Customer1(ATM obj){
        this.obj = obj;
    }
    public void run(){
        obj.checkBalance("Faizan Azizi");
        obj.withdraw("Faizan Azizi", 25000);
    }
}

class Customer2 extends Thread {
    ATM obj;
    public Customer2(ATM obj){
        this.obj = obj;
    }
    public void run(){
        obj.checkBalance("Md Tauseef Akhtar");
        obj.withdraw("Md Tauseef Akhtar", 500000);
    }
}
public class Bank {
    public static void main(String[] args) {
        ATM obj = new ATM();
        Customer1 cust1 = new Customer1(obj);
        Customer2 cust2 = new Customer2(obj);
        cust1.start();
        cust2.start();
    }
}
