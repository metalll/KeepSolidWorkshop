package root.workshop.Controller.Adapter;



import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;


import root.workshop.View.Dialog.CreateMindMapDialog.EditColorBack;
import root.workshop.View.Dialog.CreateMindMapDialog.EditColorBack_;
import root.workshop.View.Dialog.CreateMindMapDialog.EditColorFor;
import root.workshop.View.Dialog.CreateMindMapDialog.EditColorFor_;
import root.workshop.View.Dialog.CreateMindMapDialog.tabtext_;

/**
 * Created by root on 21.12.15.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter
{

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            // find first fragment...
            tabtext_ ft1 = new tabtext_();
            return ft1;
        }
        if (position == 1)
        {
            // find first fragment...
            EditColorFor_ ft2 = new EditColorFor_();
            return ft2;
        }
        else if (position == 2)
        {
            // find first fragment...
            EditColorBack_ ft3 = new EditColorBack_();
            return ft3;
        }

        return null;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }




    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "ТЕКСТ";
            case 1:
                return "ШРИФТ";
            case 2:
                return "ФОН";
        }
        return null;
    }
}