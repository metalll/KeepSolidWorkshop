package root.workshop.View.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import root.workshop.BL.GlobalManager;
import root.workshop.Controller.Adapter.MindMapAdapter;
import root.workshop.Model.MindMap;
import root.workshop.R;

@EFragment(R.layout.fragment_mind_map_list)
public class MindMapList extends Fragment {

@ViewById(R.id.grid_view)
GridView gridView;

    public MindMapList() {}

    @AfterViews
    void showMindMaps()
    {

        gridView.setAdapter(new MindMapAdapter(getActivity().getBaseContext()));

    }

    @Click
    void fab_button()
    {
        GlobalManager.getInstance().getUser().getMindMaps().add( new MindMap("Новый mind map"));
        showMindMaps();
    }
}
