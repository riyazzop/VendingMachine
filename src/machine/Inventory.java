package machine;

import exceptions.ItemNotAvailable;
import product.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Integer,ItemShelf> itemsInventory;
    public Inventory(){
        itemsInventory = new HashMap<>();
    }
    public void addShelf( ItemShelf shelf){
        itemsInventory.put(shelf.getShelfCode(),shelf);
    }
    public void addItemToShelf(int shelfCode, Item item){
        itemsInventory.get(shelfCode).addItem(item);
    }
    public Item getItem(int shelfCode) throws ItemNotAvailable {
        ItemShelf shelf = itemsInventory.get(shelfCode);
        if(shelf.hasItems()){
            return shelf.dispenseItem();
        }
        throw new ItemNotAvailable("The item is already sold out");
    }

}
