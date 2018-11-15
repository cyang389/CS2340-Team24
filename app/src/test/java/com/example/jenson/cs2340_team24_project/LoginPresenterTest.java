




package com.example.jenson.cs2340_team24_project;


import com.example.jenson.cs2340_team24_project.UI.Controllers.LoginPresenter;
import com.example.jenson.cs2340_team24_project.UI.Controllers.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
    public class LoginPresenterTest {

        @Mock
        private LoginView view;
        @Mock
        private LoginPresenter presenter;

        @Before
        public void setUp() throws Exception {
            presenter = new LoginPresenter(view);
        }

        @Test
        public void shouldShowErrorWhenEmailIsEmpty() throws Exception {
            when(view.getEmail()).thenReturn("");
            presenter.attemptLogin();
            verify(view).showEmailError(R.string.error_invalid_email);
        }

        @Test
        public void shouldShowErrorWhenPasswordIsEmpty() throws Exception {
            when(view.getEmail()).thenReturn("email");
            when(view.getPassword()).thenReturn("");
            presenter.attemptLogin();
            verify(view).showPasswordError(R.string.error_invalid_password);
        }

        @Test
        public void shouldGetLoginWhenEmialAndPassWordCorrect() throws Exception {
            when(view.getEmail()).thenReturn("email");
            when(view.getPassword()).thenReturn("password");
            view.setEmail("email");
            view.setPassword("password");
            presenter.attemptLogin();
            verify(view).startMainActivity();

        }

        @Test
        public void shouldGetLoginWhenEmialAndPassWordInvalid() throws Exception {
            when(view.getEmail()).thenReturn("email");
            when(view.getPassword()).thenReturn("password");
            view.setEmail("wrongEmail");
            view.setPassword("wrongPassword");

            presenter.attemptLogin();
            verify(view).showLoginError();
        }



}
