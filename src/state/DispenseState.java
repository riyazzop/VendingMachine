package state;

public class DispenseState implements  VendingMachineState{

    @Override
    public String getState() {
        return "dispense";
    }
}
