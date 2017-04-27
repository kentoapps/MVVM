package com.kentoapps.mvvm.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kentoapps.mvvm.App;
import com.kentoapps.mvvm.R;
import com.kentoapps.mvvm.databinding.ActivityLoginBinding;
import com.kentoapps.mvvm.viewmodel.LoginViewModel;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    public LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inject ViewModel
        App.getAppComponent(this).inject(this);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel(viewModel);
    }
}
