package state;

public interface VendingMachineState {
    public void next(VendingMachineStateContext context);
    public String getState();
}
