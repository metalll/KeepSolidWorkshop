package root.workshop.View.Fragment;


import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import root.workshop.BL.GlobalManager;
import root.workshop.Controller.Adapter.MindMapAdapter;
import root.workshop.Controller.MyFragmentManager;
import root.workshop.Model.MindMap;
import root.workshop.R;

import root.workshop.View.Dialog.CreateMindMapDialog.createMindMapDialog;
import root.workshop.View.Dialog.CreateMindMapDialog.createMindMapDialog_;

@EFragment
public class MindMapList extends Fragment implements DialogInterface.OnDismissListener {

@ViewById(R.id.grid_view) protected GridView gridView;
protected FloatingActionButton fab;
protected View view;
protected createMindMapDialog_ dialog ;

    public MindMapList() {}

    @Bean
    MyFragmentManager myFragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_mind_map_list,null);
        fab=(FloatingActionButton)view.findViewById(R.id.fab_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab_button();
            }
        });

        return view;
    }

    @AfterViews
    void showMindMaps() {
        gridView.setAdapter(new MindMapAdapter(this.getView().getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GlobalManager.getInstance().setMindMap((MindMap) parent.getAdapter().getItem(position));
                myFragmentManager.setFragment(R.id.layout,new MindMapGeneral(),true);
            }
        });

    }

    void fab_button() {
        dialog = new createMindMapDialog_();
        dialog.setOnDismissListener(this);
        dialog.show(myFragmentManager.getFragmentManager(), null);}

    @Override
    public void onDismiss(DialogInterface dialog) {
        showMindMaps();
    }
}