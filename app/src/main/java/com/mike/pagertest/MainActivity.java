package com.mike.pagertest;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.flipview.FlipView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FlipViewAdapter mAdapter;
    private SamplePagerAdapter mPagerAdapter1;
    private SamplePagerAdapter mPagerAdapter2;
    private SamplePagerAdapter mPagerAdapter3;
    private SamplePagerAdapter mPagerAdapter4;
    private ViewPager mPager1;
    private ViewPager mPager2;
    private ViewPager mPager3;
    private ViewPager mPager4;
    private View mBtn;
    private FlipView mFlipView;
    private List<View> mItems = new ArrayList<>();
    private int mNextId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager1 = new ViewPager(this);
        mPager1.setId(mNextId++);
        mPager1.setOffscreenPageLimit(1);
        mPager2 = new ViewPager(this);
        mPager2.setId(mNextId++);
        mPager2.setOffscreenPageLimit(1);
        mPager3 = new ViewPager(this);
        mPager3.setId(mNextId++);
        mPager3.setOffscreenPageLimit(1);
        mPager4 = new ViewPager(this);
        mPager4.setId(mNextId++);
        mPager4.setOffscreenPageLimit(1);
        mBtn = findViewById(R.id.btn);
        mFlipView = (FlipView) findViewById(R.id.flip_view);

        mAdapter = new FlipViewAdapter(this);
        mFlipView.setAdapter(mAdapter);
        mFlipView.setShadowPaintColor(Color.TRANSPARENT);
        mFlipView.setCascadeFlippingOffset(30);
        mFlipView.setMaxSinglePageFlipAnimDuration(2000);
        mFlipView.setCascadeFlipDuration(4000);


        final List<String> list1 = new ArrayList<>();
        list1.add("http://p1.pichost.me/i/29/1522634.jpg");
        list1.add("http://www.tintup.com/blog/wp-content/uploads/2014/05/fame.jpg");
        list1.add("http://www.prettycrown.com/wp-content/uploads/2015/08/desktop-wallpapers.jpg");
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this))
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        int a = 0;
                    }
                });
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

        mBtn.setOnClickListener(this);

        setupPagers();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private Bitmap viewToBitmap(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        final Bitmap viewBeforeBitmap = view.getDrawingCache();
        Bitmap bitmap = viewBeforeBitmap.copy(viewBeforeBitmap.getConfig(), true);
        viewBeforeBitmap.recycle();
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            mItems.clear();
            mItems.add(mPager1);
            mItems.add(mPager2);
            mItems.add(mPager3);
            mItems.add(mPager4);
            mAdapter.setItems(mItems);
            mFlipView.flipTo(0);
            mFlipView.setFlippingCascade(true);
            if (mFlipView.getCurrentPage() == 0) {
                mFlipView.smoothFlipTo(mFlipView.getPageCount() - 1);
            } else {
                mFlipView.smoothFlipTo(0);
            }
        }
    }

    private void setupPagers() {
        List<String> list1 = new ArrayList<>();
        list1.add("http://p1.pichost.me/i/29/1522634.jpg");
        list1.add("http://www.tintup.com/blog/wp-content/uploads/2014/05/fame.jpg");
        list1.add("http://www.prettycrown.com/wp-content/uploads/2015/08/desktop-wallpapers.jpg");
        List<String> list2 = new ArrayList<>();
        list2.add("http://www.tintup.com/blog/wp-content/uploads/2014/05/fame.jpg");
        list2.add("http://www.prettycrown.com/wp-content/uploads/2015/08/desktop-wallpapers.jpg");
        list2.add("http://p1.pichost.me/i/29/1522634.jpg");
        List<String> list3 = new ArrayList<>();
        list3.add("http://www.prettycrown.com/wp-content/uploads/2015/08/desktop-wallpapers.jpg");
        list3.add("http://p1.pichost.me/i/29/1522634.jpg");
        list3.add("http://www.tintup.com/blog/wp-content/uploads/2014/05/fame.jpg");
        List<String> list4 = new ArrayList<>();
        list4.add("http://p1.pichost.me/i/29/1522634.jpg");
        list4.add("http://www.tintup.com/blog/wp-content/uploads/2014/05/fame.jpg");
        list4.add("http://www.prettycrown.com/wp-content/uploads/2015/08/desktop-wallpapers.jpg");
        mPagerAdapter1 = new SamplePagerAdapter(getFragmentManager());
        mPagerAdapter2 = new SamplePagerAdapter(getFragmentManager());
        mPagerAdapter3 = new SamplePagerAdapter(getFragmentManager());
        mPagerAdapter4 = new SamplePagerAdapter(getFragmentManager());
        mPagerAdapter1.setItems(list1);
        mPagerAdapter2.setItems(list2);
        mPagerAdapter3.setItems(list3);
        mPagerAdapter4.setItems(list4);

        mPager1.setAdapter(mPagerAdapter1);
        mPager2.setAdapter(mPagerAdapter2);
        mPager3.setAdapter(mPagerAdapter3);
        mPager4.setAdapter(mPagerAdapter4);
    }
}
