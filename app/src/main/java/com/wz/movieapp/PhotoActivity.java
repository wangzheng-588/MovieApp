package com.wz.movieapp;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by wz on 17-5-30.
 */

public class PhotoActivity extends BaseActivity {
    @BindView(R.id.photo_view)
    PhotoView mPhotoView;

    @Override
    protected void init() {
        String imageUrl = getIntent().getStringExtra("imageUrl");
        Glide.with(this).load(imageUrl).into(mPhotoView);
    }

    @Override
    protected int setLayoutResID() {
        return R.layout.activity_photo;
    }
}
