package com.easyadapter.abslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.easyadapter.helper.DataHelper;

import java.util.List;

public abstract class EasyLVAdapter<T> extends BaseAdapter implements DataHelper<T> {

    protected Context mContext;
    protected List<T> mList;
    protected int[] layoutIds;
    protected LayoutInflater mLInflater;

    protected EasyLVHolder holder = new EasyLVHolder();

    public EasyLVAdapter(Context context, List<T> list, int... layoutIds) {
        this.mContext = context;
        this.mList = list;
        this.layoutIds = layoutIds;
        this.mLInflater = LayoutInflater.from(mContext);
    }

    public EasyLVAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mList = list;
        this.mLInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    public Object getItem(int position) {
        return mList == null ? null : mList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        int layoutId = getViewCheckLayoutId(position);
        holder = holder.get(mContext, position, convertView, parent, layoutId);
        convert(holder, position, mList.get(position));
        return holder.getConvertView(layoutId);
    }

    private int getViewCheckLayoutId(int position) {
        int layoutId;
        if (layoutIds == null || layoutIds.length == 0) {
            layoutId = getLayoutId(position, mList.get(position));
        } else {
            layoutId = layoutIds[getLayoutIndex(position, mList.get(position))];
        }
        return layoutId;
    }

    /**
     * 若构造函数没有指定layoutIds, 则必须重写该方法
     *
     * @param position
     * @param item
     * @return layoutId
     */
    public int getLayoutId(int position, T item) {
        return 0;
    }
    /**
     * 指定item布局样式在layoutIds的索引。默认为第一个
     *
     * @param position
     * @param item
     * @return
     */
    public int getLayoutIndex(int position, T item) {
        return 0;
    }

    public abstract void convert(EasyLVHolder holder, int position, T t);

    public boolean addAll(List<T> list) {
        boolean result = mList.addAll(list);
        notifyDataSetChanged();
        return result;
    }

    public boolean addAll(int position, List list) {
        boolean result = mList.addAll(position, list);
        notifyDataSetChanged();
        return result;
    }

    public void add(T data) {
        mList.add(data);
        notifyDataSetChanged();
    }

    public void add(int position, T data) {
        mList.add(position, data);
        notifyDataSetChanged();
    }

    public void clear() {
        mList.clear();
        notifyDataSetChanged();
    }

    public boolean contains(T data) {
        return mList.contains(data);
    }

    public T getData(int index) {
        return mList.get(index);
    }

    public void modify(T oldData, T newData) {
        modify(mList.indexOf(oldData), newData);
    }

    public void modify(int index, T newData) {
        mList.set(index, newData);
        notifyDataSetChanged();
    }

    public boolean remove(T data) {
        boolean result = mList.remove(data);
        notifyDataSetChanged();
        return result;
    }

    public void remove(int index) {
        mList.remove(index);
        notifyDataSetChanged();
    }
}
