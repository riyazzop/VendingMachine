package payment;

public class CoinPayment implements  PaymentStrategy{
    public  void pay(double amount){
        System.out.println("Paying amount "+amount + " via coins");
    }
}
