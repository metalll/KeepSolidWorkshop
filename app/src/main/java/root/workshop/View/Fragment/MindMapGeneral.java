package root.workshop.View.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import root.workshop.BL.GlobalManager;
import root.workshop.Model.Item;
import root.workshop.Model.MindMap;
import root.workshop.R;
import root.workshop.View.MyView.GridMindMapItemView;
import root.workshop.View.MyView.MindMapView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MindMapGeneral extends Fragment {
    View view;
    FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(200,200);
    FloatingActionButton fab_button;
    MindMapView mapView;
    public MindMapGeneral() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mind_map_general, container, false);
        mapView=(MindMapView)view.findViewById(R.id.MindMapLayout);
        fab_button=(FloatingActionButton)view.findViewById(R.id.fab_button);

        fab_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item=new Item("Идея"+(mapView.getChildCount()+1));
                item.setBackgrColor(getResources().getColor(R.color.primary_darker));
                item.setForegrColor(getResources().getColor(R.color.white));

                GlobalManager.getInstance().getMindMap().getItemMap().add(item);
                init();
            }
        });

        init();
        return view;
    }


    public void init()
    {
        GridMindMapItemView examleView = new GridMindMapItemView(view.getContext());

        mapView.removeAllViews();


        examleView.setText(GlobalManager.getInstance().getMindMap().getContent());
        examleView.setForegroundView(GlobalManager.getInstance().getMindMap().getForeground());
        examleView.setBackgroundView(GlobalManager.getInstance().getMindMap().getBackgr());
        examleView.setbAlpha(GlobalManager.getInstance().getMindMap().getbAlpha());
        examleView.setfAlpha(GlobalManager.getInstance().getMindMap().getfAlpha());

        examleView.invalidate();


        layoutParams.height=mapView.getHeight()/5;
        layoutParams.width=mapView.getWidth()/5;
        layoutParams.gravity= Gravity.CENTER;



        mapView.addView(examleView,layoutParams);



        for(int i=0;i<GlobalManager.getInstance().getMindMap().getItemMap().size();i++)
        {
            Item item = GlobalManager.getInstance().getMindMap().getItemMap().get(i);


            GridMindMapItemView mItem=new GridMindMapItemView(view.getContext());

            mItem.setText(item.getContent());
            mItem.setfAlpha(255);
            mItem.setbAlpha(255);
            mItem.setForegroundView(item.getForegrColor());
            mItem.setBackgroundView(item.getBackgrColor());

            mapView.addView(mItem);



        }



    }
}
