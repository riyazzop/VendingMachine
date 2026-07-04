package state;

public class IdleState implements  VendingMachineState{
    public  void next(VendingMachineStateContext context){

    }
    public  String getState(){
        return "idle";
    }
}
