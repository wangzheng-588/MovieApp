package com.wz.movieapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {


    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayoutResID());
        mBind = ButterKnife.bind(this);
        init();

    }



    protected abstract void init();

    protected abstract int setLayoutResID();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind!=mBind.EMPTY){
            mBind.unbind();
        }
    }

}
