package root.workshop.View.Dialog.CreateMindMapDialog;


import android.app.Fragment;
import android.graphics.Color;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.TextChange;
import org.androidannotations.annotations.ViewById;

import root.workshop.BL.GlobalManager;
import root.workshop.Controller.MyFragmentManager;
import root.workshop.R;
import root.workshop.View.MyView.GridMindMapItemView;


@EFragment(R.layout.fragment_tabtext)
public class tabtext extends Fragment {


    @ViewById(R.id.exampleText)
    GridMindMapItemView examleView ;

    @ViewById(R.id.text)
    TextView text;

    public tabtext() {}

    @Bean
    MyFragmentManager myFragmentManager;

    @AfterViews
    void init(){



        text.setText(GlobalManager.getInstance().getMindMap().getContent());



        examleView.setText(GlobalManager.getInstance().getMindMap().getContent());
        examleView.setForegroundView(GlobalManager.getInstance().getMindMap().getForeground());
        examleView.setBackgroundView(GlobalManager.getInstance().getMindMap().getBackgr());
        examleView.setbAlpha(GlobalManager.getInstance().getMindMap().getbAlpha());
        examleView.setfAlpha(GlobalManager.getInstance().getMindMap().getfAlpha());
        examleView.invalidate();

    }

    @TextChange(R.id.text)
    void textChange()
    {
        examleView.setText(text.getText().toString());
        GlobalManager.getInstance().getMindMap().setContent(text.getText().toString());
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }
}
