import exceptions.InsufficientMoney;
import exceptions.ItemNotAvailable;
import machine.Inventory;
import machine.ItemShelf;
import machine.VendingMachine;
import payment.CoinPayment;
import product.Item;
import product.ItemType;

void main() {
    VendingMachine machine = VendingMachine.getInstance();
    machine.setPaymentStrategy(new CoinPayment());
    Inventory inventory = machine.getInventory();
    ItemShelf cokeShelf = new ItemShelf(101);
    ItemShelf pepsiShelf = new ItemShelf(102);
    inventory.addShelf(cokeShelf);
    inventory.addShelf(pepsiShelf);
    for (int i = 0; i < 3; i++) {
        Item coke = new Item();
        coke.setPrice(25);
        coke.setItemType(ItemType.COKE);
        inventory.addItemToShelf(cokeShelf.getShelfCode(),coke);
    }
    for (int i = 0; i < 2; i++) {
        Item pepsi = new Item();
        pepsi.setPrice(20);
        pepsi.setItemType(ItemType.PEPSI);
        inventory.addItemToShelf(pepsiShelf.getShelfCode(),pepsi);
    }
    System.out.println("vending machine is started (exit) for exit");
    Scanner sc = new Scanner(System.in);
    while(true){
        System.out.println("State : "+machine.getState());
        System.out.println("Please insert money or (exit)");
        String input = sc.next();
        if (input.equalsIgnoreCase("exit")){
            break;
        }
        double insertedMoney;
        try{
            insertedMoney  =Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount try again");
            machine.cancelTransaction();
            continue;
        }

        machine.insertMoney(insertedMoney);
        System.out.println("Inserted money : "+ insertedMoney + "State : "+machine.getState());
        System.out.println("Enter the shelf code for item purchase (coke : 101 , Pepsi : 102) or cancel ");
        String shelfInput  = sc.next();
        if (shelfInput.equalsIgnoreCase("cancel")){
            machine.cancelTransaction();
            System.out.println("Transaction cancelled");
            continue;
        }
        int shelfCode;
        try{
            shelfCode = Integer.parseInt(shelfInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid shelfcode , try again");
            machine.cancelTransaction();
            continue;
        }
        try{
            machine.selectItem(shelfCode);
            System.out.println("Item selected, State : "+machine.getState());
            Item dispensed = machine.dispenseItem();
            System.out.println("Selected item is dispensed : "+dispensed.getItemType());
            System.out.println("State : "+machine.getState());


        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
            machine.cancelTransaction();
            continue;
        }


    }
    System.out.println("Good bye");
    sc.close();

}