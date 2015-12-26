package root.workshop.View.Fragment;


import android.app.Fragment;
import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import root.workshop.Controller.Adapter.MindMapSectionsPagerAdapter;
import root.workshop.Controller.Adapter.SectionsPagerAdapter;
import root.workshop.Model.MindMap;
import root.workshop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MindMapTab extends Fragment {


    private MindMapSectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    public MindMapTab() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mind_map_tab, null);


        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.YELLOW));

        // tab slider
        sectionsPagerAdapter = new MindMapSectionsPagerAdapter(this.getChildFragmentManager());

        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager)view.findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);






        return view;
    }

}
