package root.workshop.Controller.Adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import root.workshop.Model.MindMap;
import root.workshop.View.Dialog.CreateMindMapDialog.EditColorBack;
import root.workshop.View.Dialog.CreateMindMapDialog.EditColorFor;
import root.workshop.View.Dialog.CreateMindMapDialog.tabtext_;
import root.workshop.View.Fragment.MindMapGroups;
import root.workshop.View.Fragment.MindMapList_;

/**
 * Created by root on 22.12.15.
 */
public class MindMapSectionsPagerAdapter extends FragmentStatePagerAdapter {

    public MindMapSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            // find first fragment...
            MindMapList_ ft1 = new MindMapList_();
            return ft1;
        }
        if (position == 1)
        {
            // find first fragment...
            MindMapGroups ft2 = new MindMapGroups();
            return ft2;
        }


        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "ИДЕИ";
            case 1:
                return "ГРУППЫ";

        }
        return null;
    }
}
