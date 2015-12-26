package root.workshop.Controller;

import android.app.Fragment;
import android.app.Activity;
import android.app.FragmentManager;

import android.app.FragmentTransaction;

import org.androidannotations.annotations.EBean;

@EBean(scope = EBean.Scope.Singleton)
public class MyFragmentManager {

    private Activity activity;
    private FragmentManager fragmentManager;




    public MyFragmentManager() {
    }


    public MyFragmentManager init(Activity activity){
        this.activity = activity;
        fragmentManager = activity.getFragmentManager();
        return this;
        }

    public void setFragment(int containerViewId, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.replace(containerViewId, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
            fragmentTransaction.commit();
        }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
        }

}
