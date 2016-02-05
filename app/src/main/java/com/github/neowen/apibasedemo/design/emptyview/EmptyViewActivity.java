package com.github.neowen.apibasedemo.design.emptyview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.neowen.apibasedemo.R;
import com.github.neowen.apibasedemo.common.MeasureView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Winson on 2016/2/5.
 */
public class EmptyViewActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = EmptyViewActivity.class.getSimpleName();

    View mLoadingView;

    @Bind(R.id.show)
    Button mShow;
    @Bind(R.id.hidden)
    Button mHidden;
    @Bind(R.id.content)
    AbsoluteLayout mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_view_2);
        ButterKnife.bind(this);

        mShow.setOnClickListener(this);
        mHidden.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id) {
            case R.id.show:
                show(mContent);
                break;
            case R.id.hidden:
                hidden(mContent);
                break;
        }

    }

    private void hidden(ViewGroup viewGroup) {
        viewGroup.removeView(mLoadingView);
    }

    private void show(ViewGroup viewGroup) {
        mLoadingView = new MeasureView(this);
        mLoadingView.setBackgroundColor(getResources().getColor(R.color.md_amber_400));
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
        mLoadingView.setLayoutParams(lp);
        viewGroup.addView(mLoadingView, 0);
        if (viewGroup instanceof FrameLayout
                || viewGroup instanceof RelativeLayout
                || viewGroup instanceof AbsoluteLayout) {
            mLoadingView.bringToFront();
        }
    }
}