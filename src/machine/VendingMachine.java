package machine;


import exceptions.InsufficientMoney;
import exceptions.ItemNotAvailable;
import payment.PaymentStrategy;
import product.Item;
import state.*;

public class VendingMachine {
    private static VendingMachine instance;
    private Inventory inventory;
    private VendingMachineStateContext stateContext;
    private PaymentStrategy paymentStrategy;
    private int selectedShelfCode;
    private double insertedMoney;
    private VendingMachine(){
        inventory = new Inventory();
        stateContext = new VendingMachineStateContext();
        paymentStrategy = null;
    }
    public  static VendingMachine getInstance(){
        if (instance == null){
            synchronized (VendingMachine.class){
                if (instance == null){
                    instance = new VendingMachine();
                }
            }
        }
        return instance;
    }
    public void insertMoney(double money){
        if (money > 0){
            insertedMoney += money;
        }
        stateContext.setState(new HasMoneyState());
    }
    public void selectItem(int shelfCode) throws InsufficientMoney {
        if (inventory.canPurchaseItem(shelfCode,insertedMoney)){
            selectedShelfCode=shelfCode;
            stateContext.setState(new SelectionState());
        }
        else{
            throw new InsufficientMoney("The money you inserted is less than product price please insert more money");
        }
    }
    public Item dispenseItem() throws ItemNotAvailable {
        Item item = inventory.getItem(selectedShelfCode);
        stateContext.setState(new DispenseState());
        if (insertedMoney > item.getPrice()){
            System.out.println("Giving change "+(insertedMoney - item.getPrice())+" back to user");
        }
        if (inventory.isShelfEmpty(selectedShelfCode)){
            stateContext.setState((new OutOfStockState()));
        }
        else {
            stateContext.setState(new IdleState());
        }
        insertedMoney = 0;
        selectedShelfCode = -1;

        return item;
    }
    public void cancelTransaction(){
        System.out.println("Transaction cancelled , refunding user money :"+insertedMoney);
        insertedMoney = 0;
        selectedShelfCode = -1;
        stateContext.setState(new IdleState());
    }
    public Inventory getInventory(){
        return inventory;
    }
    public void setPaymentStrategy(PaymentStrategy strategy){
        this.paymentStrategy = strategy;
    }
    public String getState(){
        return stateContext.getState();
    }
}
