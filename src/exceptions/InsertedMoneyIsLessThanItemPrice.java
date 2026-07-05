package exceptions;

public class InsertedMoneyIsLessThanItemPrice extends  Exception{
    public InsertedMoneyIsLessThanItemPrice(String message){
        super(message);
    }
}
