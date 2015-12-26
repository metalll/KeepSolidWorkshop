package root.workshop.Controller.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import root.workshop.BL.GlobalManager;
import root.workshop.Model.Item;
import root.workshop.Model.MindMap;
import root.workshop.Model.User;
import root.workshop.View.MyView.GridMindMapItemView;


/**
 * Created by root on 15.12.15.
 */
public class MindMapAdapter extends BaseAdapter {
    Context context;

    public MindMapAdapter(Context context){this.context=context;

    }

    @Override
    public int getCount() {
        return GlobalManager.getInstance().getUser().getMindMaps().size();
    }

    @Override
    public Object getItem(int position) {
        return GlobalManager.getInstance().getUser().getMindMaps().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       GridMindMapItemView view;
        if(convertView==null)
        {
            MindMap mindMap = GlobalManager.getInstance().getUser().getMindMaps().get(position);



            view=new GridMindMapItemView(context);

            view.setForegroundView(mindMap.getForeground());
            view.setBackgroundView(mindMap.getBackgr());
            view.setbAlpha(mindMap.getbAlpha());
            view.setfAlpha(mindMap.getfAlpha());
            view.setText(mindMap.getContent());

            view.invalidate();



        }
        else
        {
            view=(GridMindMapItemView)convertView;
        }
        return view;
    }
}
