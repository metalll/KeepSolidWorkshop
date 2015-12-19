package root.workshop.View.Fragment;


import android.app.ProgressDialog;
import android.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import root.workshop.BL.GlobalManager;
import root.workshop.Controller.MyFragmentManager;
import root.workshop.R;

@EFragment(R.layout.fragment_auth)
public class Auth extends Fragment {


    public Auth() {}




    @ViewById(R.id.input_login) EditText _loginText;
    @ViewById(R.id.input_password) EditText _passwordText;
    @ViewById(R.id.btn_login) Button _loginButton;
    @ViewById(R.id.link_signup) TextView _signupLink;
    boolean isAuth=false;



    @Bean
    MyFragmentManager myFragmentManager;

    @Click
    void link_signup(){ myFragmentManager.setFragment(R.id.layout,new Reg_(),true); }

    @Click
    void btn_login()
    {
        login();
    }

    public void login() {
        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(getActivity(),R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Аутентификация...");
        progressDialog.show();

        String login = _loginText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Аутентификация логика
        if(login.equals(GlobalManager.getInstance().getUser().getLogin())&&password.equals(GlobalManager.getInstance().getUser().getPass()))
        {
            isAuth=true;
        }



        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        if(isAuth)onLoginSuccess();
                        else onLoginFailed();

                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);

            myFragmentManager.setFragment(R.id.layout, new MindMapList_(), true);
    }

    public void onLoginFailed() {
        Toast.makeText(getActivity().getBaseContext(), "Неверный логин или пароль", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String login = _loginText.getText().toString();
        String password = _passwordText.getText().toString();

        if (login.isEmpty() || login.length()<4) {
            _loginText.setError("введите не менее 4 символов");
            valid = false;
        } else {
            _loginText.setError(null);
        }

        if (password.isEmpty() || password.length() < 5 ) {
            _passwordText.setError("введите не менее 5 символов");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }


}


