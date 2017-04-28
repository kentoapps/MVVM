package com.kentoapps.mvvm;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.kentoapps.mvvm.di.AppComponent;
import com.kentoapps.mvvm.di.AppModule;
import com.kentoapps.mvvm.di.DaggerAppComponent;

/**
 * Created by kento on 2017/04/26.
 */

public class App extends Application {
    protected AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent(Fragment fragment) {
        return App.getAppComponent(fragment.getContext().getApplicationContext());
    }

    public static AppComponent getAppComponent(Context context) {
        App app = (App) context.getApplicationContext();
        return app.appComponent;
    }
}
