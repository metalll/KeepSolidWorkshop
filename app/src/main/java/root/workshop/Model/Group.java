package root.workshop.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 26.12.15.
 */
public class Group {
    private static int id = 0;

    private String name;
    private String groupId;

    private Map<String,MindMap>mindMaps;

    private int backround;
    private int foreground;

    public Group(String name,int backround,int foreground) {

        this.name=name;
        this.backround=backround;
        this.foreground=foreground;

        groupId="group:"+id;

        mindMaps=new HashMap<>();

    }


    public Map<String, MindMap> getMindMaps() {
        return mindMaps;
    }

    public void setMindMaps(Map<String, MindMap> mindMaps) {
        this.mindMaps = mindMaps;
    }
}
