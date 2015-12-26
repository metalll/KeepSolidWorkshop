package root.workshop.Model;

import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;


public class MindMap {
    private static int          id = 0;

    private String              mindMapId;
    private Map<String,Item>    items;
    private String              userLogin;
    private String              group;

    private MindMap(String userLogin,Item item){
        this.userLogin=userLogin;
        this.items=new HashMap<>();
        items.put(item.getItemId(),item);
        mindMapId="mindMap:"+id;
        id++;
    }

    public void addItem(Item item) {
        items.put(item.getItemId(),item);
    }

    public void remove(String id) {
        items.remove(id);
    }

    public void getItem(String id) {
        items.get(id);
    }

    public String getMindMapId() {
        return mindMapId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
