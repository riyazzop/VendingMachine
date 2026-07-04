package state;

public class OutOfStockState implements  VendingMachineState{
    @Override
    public void next(VendingMachineStateContext context) {

    }

    @Override
    public String getState() {
        return "out-of-stock";
    }
}
