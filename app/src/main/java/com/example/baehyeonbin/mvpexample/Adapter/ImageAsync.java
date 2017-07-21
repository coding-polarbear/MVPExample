package com.example.baehyeonbin.mvpexample.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.baehyeonbin.mvpexample.Data.ImageItem;

import java.lang.ref.WeakReference;

/**
 * Created by baehyeonbin on 2017. 7. 21..
 */

public class ImageAsync extends AsyncTask<Integer,Void,Bitmap> {
    private final WeakReference<ImageView> imageViewReference;
    private Context mContext;
    public ImageAsync(ImageView imageView,Context context) {
        imageViewReference = new WeakReference<ImageView>(imageView);
        this.mContext = context;
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return BitmapFactory.decodeResource(mContext.getResources(), params[0], options);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        imageViewReference.get().setImageResource(0);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageViewReference.get().setImageBitmap(bitmap);
    }
}
