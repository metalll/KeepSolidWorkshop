package root.workshop.Model;

import android.graphics.Bitmap;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 12.12.15.
 */
public class User {
    private String login;
    private String password;
    private String name;
    private String surname;
    private Bitmap avatar;

    private Map<String,Group> groups;
    private Map<String,MindMap> mindMaps;




}