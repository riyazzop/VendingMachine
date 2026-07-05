package state;

public class OutOfStockState implements  VendingMachineState{

    @Override
    public String getState() {
        return "out-of-stock";
    }
}
