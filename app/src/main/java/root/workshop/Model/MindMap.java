package root.workshop.Model;

import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@DatabaseTable
public class MindMap {
  //  @ForeignCollectionField
    private List<Item> itemMap = new ArrayList();
    private ViewItemInfo viewItemInfo;
    private int backgr;
    @DatabaseField
    private String content;

    public MindMap(String content,int backgr){
        this.content=content;
        this.backgr = backgr;
    }

    public void addItem(String content,Item root)
    {

        Item item=new Item(content,root);
        itemMap.add(item);
    }

    public List<Item> getItemMap() {
        return itemMap;
    }

    public ViewItemInfo getViewItemInfo() {
        return viewItemInfo;
    }

    public void setViewItemInfo(ViewItemInfo viewItemInfo) {
        this.viewItemInfo = viewItemInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBackgr() {
        return backgr;
    }

    public void setBackgr(int backgr) {
        this.backgr = backgr;
    }
}
