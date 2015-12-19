package root.workshop.BL;

import root.workshop.Model.Item;
import root.workshop.Model.MindMap;
import root.workshop.Model.User;
import root.workshop.Model.ViewItemInfo;

/**
 * Created by root on 15.12.15.
 */
public class GlobalManager {
    private static GlobalManager instatnce=new GlobalManager();
    public static GlobalManager getInstance() {
        return instatnce;
    }
    private User user;
    public void init()
    {

        user=new User();
        user.setId("Default User");
        user.setLogin("admin");
        user.setPass("admin");

    }
    public User getUser(){return user;}
}
