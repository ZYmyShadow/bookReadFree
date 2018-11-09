package com.bookRead.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bookRead.base.Constant;
import com.bookRead.bean.Recommend;
import com.bookRead.myapplication.R;
import com.bumptech.glide.Glide;
import com.easyadapter.recyclerview.EasyRVAdapter;
import com.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

public class RecommendAdapter extends EasyRVAdapter<Recommend.RecommendBooks> {

    public RecommendAdapter(Context context, List<Recommend.RecommendBooks> list) {
        super(context, list, R.layout.item_recommend_list);
    }

    protected void onBindData(EasyRVHolder holder, int position, Recommend.RecommendBooks item) {
        ImageView ivRecommendCover = holder.getView(R.id.ivRecommendCover);
        Glide.with(mContext).load(Constant.IMG_BASE_URL + item.cover).into(ivRecommendCover);

        holder.setText(R.id.tvRecommendTitle, item.title)
                .setText(R.id.tvRecommendShort, item.lastChapter);
    }
}
