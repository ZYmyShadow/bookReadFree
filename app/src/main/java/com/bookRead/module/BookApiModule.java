package com.bookRead.module;

import com.bookRead.api.BookApi;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
@Module
public class BookApiModule {
    @Provides
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
        return builder.build();
    }

    @Provides
    protected BookApi provideMusicService(OkHttpClient okHttpClient) {
        return BookApi.getInstance(okHttpClient);
    }
}
