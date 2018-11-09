package com.bookRead;

import android.app.Application;

import com.bookRead.module.AppModule;
import com.bookRead.module.BookApiModule;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
public class BookApplication extends Application {
    private static BookApplication sInstance;
    private AppComponent appComponent;


    public void onCreate() {
        super.onCreate();
        this.sInstance = this;
        initCompoent();
    }

    public static BookApplication getsInstance() {
        return sInstance;
    }

    private void initCompoent() {
        appComponent = DaggerAppComponent.builder()
                .bookApiModule(new BookApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
