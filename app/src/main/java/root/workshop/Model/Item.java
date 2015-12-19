package root.workshop.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Item {
    private static int id = -11000;

    @DatabaseField private String content;
    @DatabaseField private String itemId;
    @DatabaseField private String parentItemId;

    public Item(String content,Item parentItem){

        this.content=content;
        this.itemId=id+content;
        if(parentItem!=null){this.parentItemId=parentItem.getItemId();}
        else this.parentItemId=null;
        id++;
    }

    public Item(String content){

        this.content=content;
        this.itemId=id+content+content.hashCode();
        this.parentItemId=null;
        id++;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getItemId() {
        return itemId;
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }
}
