package root.workshop.BL;

import root.workshop.Model.MindMap;
import root.workshop.Model.User;

/**
 * Created by root on 15.12.15.
 */
public class GlobalManager {
    private static GlobalManager instatnce=new GlobalManager();
    public static GlobalManager getInstance() {
        return instatnce;
    }
    private User user;
    private MindMap mindMap;



    public void init()
    {

        user=new User();
        user.setId("Default User");
        user.setLogin("admin");
        user.setPass("admin");


    }
    public User getUser(){return user;}

    public MindMap getMindMap() {
        return mindMap;
    }

    public void setMindMap(MindMap mindMap) {
        this.mindMap = mindMap;
    }
}
