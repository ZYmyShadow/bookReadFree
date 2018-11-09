package com.bookRead.ui.presenter;

import android.content.Context;

import com.bookRead.api.BookApi;
import com.bookRead.ui.contract.MainContract;

import javax.inject.Inject;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
public class MainActivityPresenter implements MainContract.Presenter {
    private Context context;
    private BookApi musicApi;

    @Inject
    public MainActivityPresenter(Context context, BookApi musicApi){
        this.context = context;
        this.musicApi = musicApi;
    }
}
