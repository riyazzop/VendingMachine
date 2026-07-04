package state;

public class DispenseState implements  VendingMachineState{
    @Override
    public void next(VendingMachineStateContext context) {

    }

    @Override
    public String getState() {
        return "dispense";
    }
}
