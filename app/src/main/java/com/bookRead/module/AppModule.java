package com.bookRead.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

}
