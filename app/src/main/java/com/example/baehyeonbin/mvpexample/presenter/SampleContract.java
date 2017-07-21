package com.example.baehyeonbin.mvpexample.presenter;

import android.content.Context;

import com.example.baehyeonbin.mvpexample.Data.ImageItem;
import com.example.baehyeonbin.mvpexample.Data.SampleImageData;

import java.util.ArrayList;

/**
 * Created by baehyeonbin on 2017. 7. 21..
 */

public interface SampleContract {
    interface View {
        void addItems(ArrayList<ImageItem> items, boolean isClear);
        void notifyAdapter();
    }
    interface Presenter {
        void attachView(View view);
        void detachView();
        void setSampleImageData(SampleImageData sampleImageData);
        void loadItem(Context context, boolean isClear);
    }
}
