package com.example.baehyeonbin.mvpexample.presenter;

import android.content.Context;

import com.example.baehyeonbin.mvpexample.Data.ImageItem;
import com.example.baehyeonbin.mvpexample.Data.SampleImageData;

import java.util.ArrayList;

/**
 * Created by baehyeonbin on 2017. 7. 21..
 */

public class MainPresenter implements SampleContract.Presenter{
    private SampleContract.View view;
    private SampleImageData sampleImageData;
    @Override
    public void attachView(SampleContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setSampleImageData(SampleImageData sampleImageData) {
        this.sampleImageData = sampleImageData;
    }

    @Override
    public void loadItem(Context context, boolean isClear) {
        ArrayList<ImageItem> items = sampleImageData.getImages(context, 10);
        view.addItems(items, isClear);
        view.notifyAdapter();
    }
}
