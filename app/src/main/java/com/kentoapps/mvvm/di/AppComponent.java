package com.kentoapps.mvvm.di;

import com.kentoapps.mvvm.activity.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kento on 2016/12/27.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(LoginActivity fragment);
}
