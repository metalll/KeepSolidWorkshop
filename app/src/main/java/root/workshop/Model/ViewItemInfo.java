package root.workshop.Model;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.Random;

/**
 * Created by root on 12.12.15.
 */
public class ViewItemInfo {
    private Bitmap icon;
    private int backgrColor;
    private Point location;





    public ViewItemInfo(Point location) {
        this.location=location;
        icon=null;
        backgrColor=getRandColor();
    }

    public int getBackgrColor() {
        return backgrColor;
    }

    public void setBackgrColor(int backgrColor) {
        this.backgrColor = backgrColor;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    private int getRandColor(){
        int colors[]=new int[3];
        colors[0]=Color.RED;
        colors[1]=Color.GREEN;
        colors[2]=Color.YELLOW;
        Random random = new Random();

        return colors[random.nextInt(3)];
    }
}
