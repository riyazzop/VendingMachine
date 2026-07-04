package state;

public class VendingMachineStateContext {
    private VendingMachineState currentState;
    public  VendingMachineStateContext(){
        currentState =  new IdleState();
    }
    public  void setState(VendingMachineState newState){
        currentState = newState;
    }
    public  void next(){
        currentState.next(this);
    }
    public  String getState(){
         return currentState.getState();
    }
}


