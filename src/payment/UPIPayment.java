package payment;

public class UPIPayment implements  PaymentStrategy{
    public void pay(double amount){
        System.out.println("Paying amount "+amount+ " via UPI");
    }
}
