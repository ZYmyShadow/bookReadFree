package com.bookRead.ui.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.bookRead.api.BookApi;
import com.bookRead.bean.Recommend;
import com.bookRead.ui.contract.RecommendContract;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RecommendPresenter implements RecommendContract.Presenter {
    private Context context;
    private BookApi bookApi;

    private RecommendContract.View view;

    @Inject
    public RecommendPresenter(Context context, BookApi bookApi) {
        this.context = context;
        this.bookApi = bookApi;
    }

    public void attachView(RecommendContract.View view) {
        this.view = view;
    }

    public void getRecommendList() {
        Log.i("TAG", "---------------");
        bookApi.getRecommend("male").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Recommend>() {
                    @Override
                    public void onNext(Recommend recommend) {
                        List<Recommend.RecommendBooks> list = recommend.books;
                        if (list != null && !list.isEmpty() && view != null) {
                            view.showRecommendList(list);
                        }
                    }

                    @Override
                    public void onCompleted() {
                        Toast.makeText(context, "请求完成", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
