package com.kentoapps.mvvm.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.kentoapps.mvvm.App;
import com.kentoapps.mvvm.usecase.LoginUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kento on 2016/12/27.
 */
@Module
public class AppModule {
    public App app;
    public Fragment fragment;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    LoginUseCase provideLoginUseCase() {
        return new LoginUseCase();
    }
}

