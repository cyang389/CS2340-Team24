

package com.example.jenson.cs2340_team24_project.UI.Controllers;

import com.example.jenson.cs2340_team24_project.R;

public class  LoginPresenter {
    private LoginView view;


    public LoginPresenter(LoginView view) {

            this.view = view;
        }

        public void attemptLogin() {
            String email = view.getEmail();
            if (email.isEmpty()) {
                view.showEmailError(R.string.error_invalid_email);
                return;
            }

            String password = view.getPassword();
            if (password.isEmpty()) {
                view.showPasswordError(R.string.error_invalid_password);
                return;
            }
            boolean match = view.getEmail().equals(email)
                    && view.getPassword().equals(password);
            if (match) {
                view.startMainActivity();
            }
            view.showLoginError();



        }
    }


