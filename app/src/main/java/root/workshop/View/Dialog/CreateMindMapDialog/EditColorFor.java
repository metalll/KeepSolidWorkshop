package root.workshop.View.Dialog.CreateMindMapDialog;


import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import root.workshop.BL.GlobalManager;
import root.workshop.R;

import root.workshop.View.MyView.GridMindMapItemView;


@EFragment
public class EditColorFor extends Fragment {

    View view;



    ColorPicker picker ;

    OpacityBar opacityBar;
    SaturationBar saturationBar;
    ValueBar valueBar;


    GridMindMapItemView exampleView;

    public EditColorFor() { }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_edit_color_for,null);
        picker=(ColorPicker)view.findViewById(R.id.picker);
        opacityBar=(OpacityBar)view.findViewById(R.id.opacityBar);
        saturationBar=(SaturationBar)view.findViewById(R.id.saturationbar);
        valueBar=(ValueBar)view.findViewById(R.id.valuebar);

        picker.addOpacityBar(opacityBar);
        picker.addSaturationBar(saturationBar);
        picker.addValueBar(valueBar);

        exampleView=(GridMindMapItemView)view.findViewById(R.id.exampleView);
        view.setFocusable(true);

        picker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                GlobalManager.getInstance().getMindMap().setForeground(color);
                exampleView.setForegroundView(GlobalManager.getInstance().getMindMap().getForeground());

            }
        });




        init();
        return view;


    }

    @AfterViews
    void init()
    {


        picker.setColor(GlobalManager.getInstance().getMindMap().getForeground());

        exampleView.setText(GlobalManager.getInstance().getMindMap().getContent());
        exampleView.setForegroundView(GlobalManager.getInstance().getMindMap().getForeground());
        exampleView.setBackgroundView(GlobalManager.getInstance().getMindMap().getBackgr());
        exampleView.setbAlpha(GlobalManager.getInstance().getMindMap().getbAlpha());
        exampleView.setfAlpha(GlobalManager.getInstance().getMindMap().getfAlpha());
        exampleView.invalidate();






    }



}
