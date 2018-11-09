package com.bookRead.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bookRead.AppComponent;
import com.bookRead.base.BaseFragment;
import com.bookRead.bean.Recommend;
import com.bookRead.module.RecommendFragmentModule;
import com.bookRead.myapplication.R;
import com.bookRead.ui.adapter.RecommendAdapter;
import com.bookRead.ui.component.DaggerRecommendFragmentComponent;
import com.bookRead.ui.contract.RecommendContract;
import com.bookRead.ui.presenter.RecommendPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
public class RecommendFragment extends BaseFragment implements RecommendContract.View{

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;
    //@Bind(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    RecommendPresenter mPresenter;

    private RecommendAdapter mAdapter;
    private List<Recommend.RecommendBooks> mList = new ArrayList<>();

    public int getLayoutResId() {
        return R.layout.fragment_main;
    }


    public void initDatas() {
    }


    public void configViews() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mSwipeRefreshLayout.setColorSchemeResources(R.color.primary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            public void onRefresh() { }
        });
        mAdapter = new RecommendAdapter(mContext, mList);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.attachView(this);
        mPresenter.getRecommendList();
    }

    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerRecommendFragmentComponent.builder()
                .appComponent(appComponent)
                .recommendFragmentModule(new RecommendFragmentModule(this))
                .build()
                .inject(this);
    }

    public void showRecommendList(List<Recommend.RecommendBooks> list) {
        mList.clear();
        mList.addAll(list);

        mAdapter.notifyDataSetChanged();
    }
}
