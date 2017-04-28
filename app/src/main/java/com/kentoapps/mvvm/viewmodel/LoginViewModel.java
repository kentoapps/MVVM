package com.kentoapps.mvvm.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;

import com.kentoapps.mvvm.usecase.LoginUseCase;

import javax.inject.Inject;

/**
 * Created by kento on 2017/04/21.
 */

public class LoginViewModel {

    private final LoginUseCase useCase;
    public ObservableField<String> user =  new ObservableField<>();
    public ObservableField<String> userError = new ObservableField<>();
    public ObservableField<String> password =  new ObservableField<>();
    public ObservableField<String> passwordError = new ObservableField<>();

    @Inject
    public LoginViewModel(LoginUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Log in process
     * @param view
     */
    public void onButtonClick(View view) {
        if (isEmpty()) return;
        useCase.run(user.get(), password.get());
    }

    /**
     * Validate EditText
     */
    private boolean isEmpty() {
        boolean fail = false;
        if (TextUtils.isEmpty(user.get())) {
            userError.set("error");
            fail = true;
        }
        if (TextUtils.isEmpty(password.get())) {
            passwordError.set("error");
            fail = true;
        }
        return fail;
    }

    @BindingAdapter("errorText")
    public static void setErrorMessage(TextInputEditText view, String errorMessage) {
        view.setError(errorMessage);
    }
}
