package state;

public class HasMoneyState implements VendingMachineState{
    @Override
    public void next(VendingMachineStateContext context) {

    }

    @Override
    public String getState() {
        return "has-money";
    }
}
