package root.workshop.View.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import root.workshop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MindMapGroups extends Fragment {


    public MindMapGroups() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mind_map_groups, container, false);
    }

}
