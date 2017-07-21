package com.example.baehyeonbin.mvpexample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.baehyeonbin.mvpexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by baehyeonbin on 2017. 7. 21..
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_view)
    ImageView imageView;

    public ImageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
