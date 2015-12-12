package root.workshop.View.Fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import root.workshop.Controller.MyFragmentManager;
import root.workshop.R;

@EFragment(R.layout.fragment_reg)
public class Reg extends Fragment {

    public Reg() {}

    @ViewById(R.id.input_name) EditText _nameText;
    @ViewById(R.id.input_surname) EditText _surNameText;
    @ViewById(R.id.input_login_reg) EditText _loginText;
    @ViewById(R.id.input_password) EditText _passwordText;
    @ViewById(R.id.retry_input_password)EditText _retryPasswordText;
    @ViewById(R.id.btn_signup) Button _signupButton;
    @ViewById(R.id.link_login) TextView _loginLink;

    @Bean
    MyFragmentManager fragmentManager;

    @Click
    void btn_signup(){
        signup();
    }

    @Click
    void link_login(){
        fragmentManager.getFragmentManager().popBackStack();}

    public void signup() {
            if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Создание уч. записи...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String surName = _surNameText.getText().toString();
        String login = _loginText.getText().toString();
        String password = _passwordText.getText().toString();
        String retryPassword = _retryPasswordText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        fragmentManager.getFragmentManager().popBackStack();

    }

    public void onSignupFailed() {


        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String surName = _surNameText.getText().toString();
        String login = _loginText.getText().toString();
        String password = _passwordText.getText().toString();
        String retryPassword = _retryPasswordText.getText().toString();

        if (name.isEmpty()) {
            _nameText.setError("введите ваше имя");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (surName.isEmpty()) {
            _surNameText.setError("введите вашу фамилию");

            valid = false;
        } else {
            _surNameText.setError(null);
        }


        if (login.isEmpty() ||login.length()<4) {
            if(login.isEmpty())_loginText.setError("введите ваш логин");
            else _loginText.setError("логин должен быть не меньше 4 символов");
            valid = false;
        } else {
            _loginText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            if(password.isEmpty()){_passwordText.setError("введите пароль");}
            else{ _passwordText.setError("пароль должен быть от 4 до 10 символов"); }
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (retryPassword.isEmpty() || retryPassword.length() < 4 || retryPassword.length() > 10||(!password.equals(retryPassword))) {
            if(retryPassword.isEmpty())_retryPasswordText.setError("введите пароль");
            else if(!password.equals(retryPassword)) _retryPasswordText.setError("пароли должны совпадать");
            else _retryPasswordText.setError("пароль должен быть от 4 до 10 символов");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        return valid;
    }
}



