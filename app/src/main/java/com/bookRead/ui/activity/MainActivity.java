package com.bookRead.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bookRead.AppComponent;
import com.bookRead.base.BaseActivity;
import com.bookRead.module.MainActivityModule;
import com.bookRead.myapplication.R;
import com.bookRead.ui.component.DaggerMainActivityComponent;
import com.bookRead.ui.contract.MainContract;
import com.bookRead.ui.fragment.RecommendFragment;
import com.bookRead.ui.presenter.MainActivityPresenter;
import com.bookRead.ui.view.RVPIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
public class MainActivity extends BaseActivity implements MainContract.View{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.indicator)
    RVPIndicator mIndicator;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    private List<Fragment> mTabContents;
    private FragmentPagerAdapter mAdapter;
    private List<String> mDatas;

    @Inject
    MainActivityPresenter mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
        configViews();
    }

    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public void initToolBar() {
        setTitle("");
    }

    public void initDatas() {
        mDatas = Arrays.asList("追书", "社区", "发现");
        mTabContents = new ArrayList<>();

        for (String data : mDatas) {
//            RecommendFragment fragment = RecommendFragment.newInstance(data);
            RecommendFragment fragment = new RecommendFragment();
            mTabContents.add(fragment);
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            public int getCount() {
                return mTabContents.size();
            }


            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }
        };
    }

    public void configViews() {
        // 设置显示Toolbar
        setSupportActionBar(mToolbar);
        // 设置Tab上的标题
        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mAdapter);
        // 设置关联的ViewPager
        mIndicator.setViewPager(mViewPager, 0);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ab_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }
}
