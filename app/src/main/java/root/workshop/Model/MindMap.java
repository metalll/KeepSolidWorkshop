package root.workshop.Model;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by root on 12.12.15.
 */
public class MindMap {
    private Map<String,Item> itemMap=new WeakHashMap<>();
    private String content;

    public MindMap(String content){
        this.content=content;
    }

    public void addItem(String content,Item root)
    {
        Item item=new Item(content,root);
        itemMap.put(item.getItemId(),item);
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }
}
