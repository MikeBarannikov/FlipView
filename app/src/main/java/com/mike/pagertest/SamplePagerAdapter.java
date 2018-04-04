package com.mike.pagertest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SamplePagerAdapter extends FragmentStatePagerAdapter {

    List<String> mItems = new ArrayList<>();

    public SamplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment.newInstance(mItems.get(position));
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    public void setItems(List<String> list) {
        mItems = list;
        notifyDataSetChanged();
    }
}
