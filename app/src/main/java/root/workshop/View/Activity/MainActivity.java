package root.workshop.View.Activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;

import root.workshop.Controller.MyFragmentManager;
import root.workshop.R;
import root.workshop.View.Fragment.Auth_;


@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @InstanceState
    boolean isStarted=false;

    @Bean
    MyFragmentManager myFragmentManager;

    @AfterInject
    void init() {
        if(!isStarted){
            myFragmentManager.init(this).setFragment(R.id.layout,new Auth_(),true);
            isStarted=true;}
        else
            myFragmentManager.init(this);
    }

    @Override
    public void onBackPressed() {
        if(myFragmentManager.getFragmentManager().getBackStackEntryCount()>1) myFragmentManager.getFragmentManager().popBackStack();
        else this.finish();
    }
}