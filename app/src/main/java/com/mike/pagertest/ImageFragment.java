package com.mike.pagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageFragment extends Fragment {
    private ImageView mImage;
    private String mResId;

    public static ImageFragment newInstance(String resId) {

        Bundle args = new Bundle();
        args.putString("resId", resId);

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        processArgs();
        View view = inflater.inflate(R.layout.fr_myfragment, container, false);
        mImage = (ImageView) view.findViewById(R.id.image);
        Picasso.with(getActivity())
                .load(mResId)
                .resize(600, 900)
                .into(mImage);
        return view;
    }

    private void processArgs() {
        if (getArguments() != null) {
            mResId = getArguments().getString("resId");
        }
    }

    @Override
    public void onDetach() {
        mImage.setImageDrawable(null);
        super.onDetach();
    }
}
