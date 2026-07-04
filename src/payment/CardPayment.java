package payment;

public class CardPayment implements  PaymentStrategy{
    public  void pay(double amount){
        System.out.println("Paying amount "+amount +" via Card");
    }
}
