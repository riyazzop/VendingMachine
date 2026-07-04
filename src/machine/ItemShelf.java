package machine;

import product.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import  java.util.Map;
public class ItemShelf {
    private int shelfCode;
    private List<Item> items;
    private boolean isSoldOut;

    public ItemShelf(int shelfCode) {
        this.shelfCode = shelfCode;
        this.items = new ArrayList<>();
        this.isSoldOut = false;
    }

    public int getShelfCode() {
        return shelfCode;
    }
    public  List<Item> getItems(){
        return Collections.unmodifiableList(items);
    }

    public boolean getIsSoldOut() {
        return isSoldOut;
    }

    public void setShelfCode(int shelfCode) {
        this.shelfCode = shelfCode;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        if (isSoldOut) setIsSoldOut(false);
    }
    public Item dispenseItem(){
        Item item = items.removeFirst();
        if (items.isEmpty()){
            setIsSoldOut(true);
        }
        return  item;
    }
    public void setIsSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }
    public void addItem(Item item){
        items.add(item);
        if(isSoldOut) setIsSoldOut(false);
    }
    public  void removeItem(Item item){
        items.remove(item);
        if(items.isEmpty())setIsSoldOut(true);
    }
    public  boolean hasItems(){
        return !getIsSoldOut();
    }
}
