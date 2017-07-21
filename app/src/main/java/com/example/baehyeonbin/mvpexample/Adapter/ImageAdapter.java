package com.example.baehyeonbin.mvpexample.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.baehyeonbin.mvpexample.Data.ImageItem;
import com.example.baehyeonbin.mvpexample.R;

import java.util.ArrayList;

/**
 * Created by baehyeonbin on 2017. 7. 21..
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private Context mContext;
    private ArrayList<ImageItem> mImageItems;

    public ImageAdapter(Context context) {
        this.mContext = context;
    }

    public void setImageItems(ArrayList<ImageItem> imageItems) {
        this.mImageItems = imageItems;
    }

    public void clear() {
        if(mImageItems != null) {
            mImageItems.clear();
            mImageItems = null;
        }
    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_image,parent,false));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        if(holder == null) return;
        final ImageItem imageItem = mImageItems.get(position);
        new ImageAsync(holder.imageView,mContext).execute(imageItem.getImageRes());

    }

    @Override
    public int getItemCount() {
        return mImageItems.size();
    }
}
