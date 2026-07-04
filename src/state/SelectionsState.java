package state;

public class SelectionsState implements  VendingMachineState{
    @Override
    public void next(VendingMachineStateContext context) {

    }

    @Override
    public String getState() {
        return "selection";
    }
}
