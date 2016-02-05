package com.mike.pagertest;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class FlipViewAdapter extends BaseAdapter {

    private final Context mContext;
    List<View> mItems = new ArrayList<>();

    public FlipViewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = mItems.get(position);
        }

        return view;
    }

    public void setItems(List<View> list) {
        mItems = list;
        notifyDataSetChanged();
    }
}
