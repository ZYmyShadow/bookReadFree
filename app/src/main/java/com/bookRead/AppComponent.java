package com.bookRead;

import android.content.Context;

import com.bookRead.api.BookApi;
import com.bookRead.module.AppModule;
import com.bookRead.module.BookApiModule;

import dagger.Component;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
@Component(modules = {AppModule.class, BookApiModule.class})
public interface AppComponent {
    Context getContext();
    BookApi getBookApi();
}
