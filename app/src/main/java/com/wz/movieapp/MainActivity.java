package com.wz.movieapp;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wz.movieapp.adapter.FragmentAdapter;
import com.wz.movieapp.fragment.LocalMusicFragment;
import com.wz.movieapp.fragment.LocalVideoFragment;
import com.wz.movieapp.fragment.NetworkMusicFragment;
import com.wz.movieapp.fragment.NetworkVideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.wz.movieapp.R.id.rb_local_music;
import static com.wz.movieapp.R.id.rb_local_video;
import static com.wz.movieapp.R.id.rb_network_music;
import static com.wz.movieapp.R.id.rb_network_video;


public class MainActivity extends BaseActivity {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.rb_local_video)
    RadioButton mRbLocalVideo;
    @BindView(R.id.rb_local_music)
    RadioButton mRbLocalMusic;
    @BindView(R.id.rb_network_music)
    RadioButton mRbNetworkMusic;
    @BindView(R.id.rb_network_video)
    RadioButton mRbNetworkVideo;
    @BindView(R.id.rg_main)
    RadioGroup mRgMain;
    private List<Fragment> mFragments;
    private int mPosition;//当前viewpager选中位置
    private int checkID;//当前radiobutton选中位置


    @Override
    protected void init() {
        mRgMain.check(rb_local_video);

        initFragment();
        mRgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                changeFragment(checkedId);
            }
        });

        initAdapter();
    }


    @Override
    protected int setLayoutResID() {
        return R.layout.activity_main;
    }

    private void changeFragment(@IdRes int checkedId) {
        switch (checkedId) {
            case rb_local_video:
                mPosition = 0;
                break;
            case rb_local_music:
                mPosition = 1;
                break;

            case rb_network_music:
                mPosition = 2;
                break;
            case rb_network_video:
                mPosition = 3;
                break;
        }
        mViewPager.setCurrentItem(mPosition);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new LocalVideoFragment());
        mFragments.add(new LocalMusicFragment());
        mFragments.add(new NetworkMusicFragment());
        mFragments.add(new NetworkVideoFragment());
    }

    private void initAdapter() {

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(mFragments.size());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        checkID = rb_local_video;
                        break;
                    case 1:
                        checkID = rb_local_music;
                        break;

                    case 2:
                        checkID = rb_network_music;
                        break;
                    case 3:
                        checkID = rb_network_video;
                        break;
                }
                mRgMain.check(checkID);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
