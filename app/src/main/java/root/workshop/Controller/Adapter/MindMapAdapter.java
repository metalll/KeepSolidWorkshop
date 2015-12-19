package root.workshop.Controller.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import root.workshop.BL.GlobalManager;
import root.workshop.Model.Item;
import root.workshop.Model.MindMap;
import root.workshop.View.MyView.GridMindMapItemView;

/**
 * Created by root on 15.12.15.
 */
public class MindMapAdapter extends BaseAdapter {

    private Context context;

    public MindMapAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
       return GlobalManager.getInstance().getUser().getMindMaps().size();
    }

    @Override
    public Object getItem(int position) {
       if(position<GlobalManager.getInstance().getUser().getMindMaps().size())
       {
           return GlobalManager.getInstance().getUser().getMindMaps().get(position);
       }
        return null;
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
            view=new GridMindMapItemView(context,GlobalManager.getInstance().getUser().getMindMaps().get(position).getContent(),GlobalManager.getInstance().getUser().getMindMaps().get(position).getViewItemInfo().getBackgrColor());

        }
        else
        {
            view = (GridMindMapItemView) convertView;

        }
        view.setId(position);
        return view;
    }

}
