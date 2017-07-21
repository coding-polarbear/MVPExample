package com.example.baehyeonbin.mvpexample.Data;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by baehyeonbin on 2017. 7. 21..
 */

public class SampleImageData {
    private SampleImageData() {

    }

    public static SampleImageData sampleImageData;

    public static SampleImageData getInstance() {
        if (sampleImageData == null) {
            sampleImageData = new SampleImageData();
        }
        return sampleImageData;
    }

    public ArrayList<ImageItem> getImages(Context context, int size) {
        ArrayList<ImageItem> items = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            Random random = new Random();
            final int r = random.nextInt(3);
            final String name = String.format("sample_%02d",r);
            final int resource = context.getResources().getIdentifier(name, "drawable",context.getApplicationContext().getPackageName());
            items.add(new ImageItem(resource, name));
            for(ImageItem item : items)
                Log.d("asdf",Integer.toString(item.getImageRes()));
        }
        return items;
    }
}
