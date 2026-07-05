package state;

public class HasMoneyState implements VendingMachineState{


    @Override
    public String getState() {
        return "has-money";
    }
}
