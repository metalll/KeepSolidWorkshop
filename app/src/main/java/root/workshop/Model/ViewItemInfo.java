package root.workshop.Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * Created by root on 12.12.15.
 */
@DatabaseTable
public class ViewItemInfo {
    private Bitmap icon;
    @DatabaseField private String iconOfBase64;
    @DatabaseField private int backgrColor;
    @DatabaseField private double x;
    @DatabaseField private double y;
    @DatabaseField private String id;





    public ViewItemInfo(double x,double y) {
        this.x=x;
        this.y=y;
        icon=null;
        iconOfBase64=null;
        backgrColor=getRandColor();
    }

    public int getBackgrColor() {
        return backgrColor;
    }

    public void setBackgrColor(int backgrColor) {
        this.backgrColor = backgrColor;
    }

    public Bitmap getIcon() {
        if(icon!=null)
            return icon;

        if(iconOfBase64!=null){
            byte[] decodedArr = Base64.decode(iconOfBase64, Base64.DEFAULT);
            icon = BitmapFactory.decodeByteArray(decodedArr,0, decodedArr.length);
        }
            return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon=icon;

        Bitmap bitmap = icon;
        ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, BAOS);
        byte[] bytes = BAOS.toByteArray();
        this.iconOfBase64 = Base64.encodeToString(bytes, 0);
    }

    private int getRandColor(){
        int colors[]=new int[3];
        colors[0]=Color.RED;
        colors[1]=Color.GREEN;
        colors[2]=Color.YELLOW;
        Random random = new Random();

        return colors[random.nextInt(3)];
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
