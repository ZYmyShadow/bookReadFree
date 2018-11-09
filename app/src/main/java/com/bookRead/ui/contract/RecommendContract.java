package com.bookRead.ui.contract;

import com.bookRead.bean.Recommend;

import java.util.List;

public interface RecommendContract {
    interface View {
        void showRecommendList(List<Recommend.RecommendBooks> list);
    }
    interface Presenter { }
}
