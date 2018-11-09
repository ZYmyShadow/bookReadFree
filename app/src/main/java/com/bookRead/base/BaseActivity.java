package com.bookRead.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bookRead.AppComponent;
import com.bookRead.BookApplication;

import butterknife.ButterKnife;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
public abstract class BaseActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setupActivityComponent(BookApplication.getsInstance().getAppComponent());
        initToolBar();
        initDatas();
        configViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public abstract int getLayoutId();

    protected abstract void setupActivityComponent(AppComponent appComponent);

    public abstract void initToolBar();

    public abstract void initDatas();

    /**
     *  对各种控件进行设置、适配、填充数据
     */
    public abstract void configViews();
}