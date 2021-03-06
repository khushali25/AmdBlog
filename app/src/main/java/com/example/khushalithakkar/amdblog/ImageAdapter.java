package com.example.khushalithakkar.amdblog;

import android.content.Context;
import android.provider.Settings;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Khushali Thakkar on 7/8/2017.
 */

public class ImageAdapter extends PagerAdapter {
    Context mContext;

  ImageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {

        return sliderImagesId.length;
    }

    private int[] sliderImagesId = new int[]{
            R.drawable.imgice, R.drawable.bg, R.drawable.imgsky,
            R.drawable.imgice, R.drawable.bg, R.drawable.imgsky,
    };

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == ((ImageView) obj);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageView mImageView = new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mImageView.setImageResource(sliderImagesId[i]);
        ((ViewPager) container).addView(mImageView, 0);
        return mImageView;

    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        ((ViewPager) container).removeView((ImageView) obj);
    }
}
