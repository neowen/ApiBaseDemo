package com.github.neowen.apibasedemo.view;


import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.github.neowen.apibasedemo.ApiItem;
import com.github.neowen.apibasedemo.ApiItemListActivity;
import com.github.neowen.apibasedemo.R;
import com.github.neowen.apibasedemo.common.CommonAdapter;
import com.github.neowen.apibasedemo.common.ViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ZWX on 15/10/15.
 */
public class ViewListActivity extends ApiItemListActivity {

    @Override
    protected void addApiItemData() {
        super.addApiItemData();
        ApiItem apiItem = new ApiItem("Touch", TouchActivity.class);
        mApiItems.add(apiItem);

        apiItem = new ApiItem("ListView Animation(Base)", ListViewAnimationActivity.class);
        mApiItems.add(apiItem);
    }

}