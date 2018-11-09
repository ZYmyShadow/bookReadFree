package com.bookRead.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookRead.AppComponent;
import com.bookRead.BookApplication;

import butterknife.ButterKnife;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
public abstract class BaseFragment extends Fragment {

    protected View parentView;
    protected FragmentActivity activity;
    protected LayoutInflater inflater;

    protected Context mContext;

    public abstract
    @LayoutRes
    int getLayoutResId();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        parentView = inflater.inflate(getLayoutResId(), container, false);
        activity = getSupportActivity();
        mContext = activity;
        this.inflater = inflater;
        return parentView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setupActivityComponent(BookApplication.getsInstance().getAppComponent());
        initDatas();
        configViews();
    }

    public abstract void initDatas();

    /**
     *  对各种控件进行设置、适配、填充数据
     */
    public abstract void configViews();

    /*public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;
    }*/

    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }


    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public FragmentActivity getSupportActivity() {
        return (FragmentActivity) super.getActivity();
    }

    public Context getApplicationContext() {
        return this.activity == null ? (getActivity() == null ? null : getActivity()
                .getApplicationContext()) : this.activity.getApplicationContext();
    }

    /*protected LayoutInflater getLayoutInflater() {
        return inflater;
    }*/

    protected View getParentView() {
        return parentView;
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);
}
