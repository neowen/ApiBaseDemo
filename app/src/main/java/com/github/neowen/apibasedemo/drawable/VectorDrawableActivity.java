package com.github.neowen.apibasedemo.drawable;

import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.neowen.apibasedemo.R;

/**
 * Created by zhouwenxiang on 2015/12/10.
 */
public class VectorDrawableActivity extends AppCompatActivity {

    public static final String TAG = VectorDrawableActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vectordrawable);

//        NinePatchDrawable npd = new NinePatchDrawable();
        VectorDrawable vd = null;

    }

}