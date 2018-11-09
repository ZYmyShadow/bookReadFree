package com.bookRead.module;

import com.bookRead.ui.activity.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    MainActivity provideMainActivity() {
        return mainActivity;
    }

}
