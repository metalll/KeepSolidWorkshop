package root.workshop.View.Dialog.CreateMindMapDialog;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import root.workshop.BL.GlobalManager;
import root.workshop.Controller.Adapter.MindMapAdapter;
import root.workshop.Controller.Adapter.SectionsPagerAdapter;
import root.workshop.Model.MindMap;
import root.workshop.View.Dialog.CreateMindMapDialog.createMindMapDialog;
import root.workshop.R;

@EFragment
public class createMindMapDialog extends DialogFragment
{
    @ViewById(R.id.text)
    TextView textView;
    private DialogInterface.OnDismissListener mListener;

    public void setOnDismissListener(DialogInterface.OnDismissListener listener){
        mListener = listener;
    }



    @Click(R.id.btn_create)
    void create()
    {
        GlobalManager.getInstance().getUser().getMindMaps().add(GlobalManager.getInstance().getMindMap());
        getDialog().dismiss();
    }

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;


    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState)
    {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        return dialog;
    }

    @AfterViews
    void init(){
        MindMap mindMap=new MindMap("Идея");
        mindMap.setBackgr(getResources().getColor(R.color.primary_darker));
        mindMap.setForeground(getResources().getColor(R.color.white));
        mindMap.setbAlpha(255);
        mindMap.setfAlpha(255);

        GlobalManager.getInstance().setMindMap(mindMap);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.dialog_create_mind_map, container);

        // tab slider
        sectionsPagerAdapter = new SectionsPagerAdapter(this.getChildFragmentManager());

        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager)view.findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



            }

            @Override
            public void onPageSelected(int position) {
                EditColorFor_ fragment;
                tabtext_ fragmentT;
                EditColorBack_ fragmentB;

                if(position==1)
                {

                    fragment=(EditColorFor_)viewPager.getAdapter().instantiateItem(viewPager,viewPager.getCurrentItem());
                    fragment.init();
                }
                if(position==0)
                {
                    fragmentT=(tabtext_)viewPager.getAdapter().instantiateItem(viewPager,viewPager.getCurrentItem());
                    fragmentT.init();
                }

                if(position==2)
                {
                    fragmentB=(EditColorBack_)viewPager.getAdapter().instantiateItem(viewPager,viewPager.getCurrentItem());
                    fragmentB.init();
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });






        return view;
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mListener !=null) {
            mListener.onDismiss(dialog);
        }
    }

}