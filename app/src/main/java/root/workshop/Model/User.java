package root.workshop.Model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12.12.15.
 */
public class User {

   // @ForeignCollectionField
    private List<MindMap> mindMaps;

   // @ForeignCollectionField
    private List<ViewItemInfo> itemsViewsInfo;

    @DatabaseField
    private String login;

    @DatabaseField
    private String pass;

    @DatabaseField
    private String name;

    @DatabaseField
    private String surName;

    @DatabaseField
    private String id;

    public User() {
        mindMaps=new ArrayList<>();
        itemsViewsInfo=new ArrayList<>();
    }


    public List<MindMap> getMindMaps() {
        return mindMaps;
    }

    public void setMindMaps(List<MindMap> mindMaps) {
        this.mindMaps = mindMaps;
    }

    public List<ViewItemInfo> getItemsViewsInfo() {
        return itemsViewsInfo;
    }

    public void setItemsViewsInfo(List<ViewItemInfo> itemsViewsInfo) {
        this.itemsViewsInfo = itemsViewsInfo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
