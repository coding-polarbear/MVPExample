package com.example.baehyeonbin.mvpexample;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.baehyeonbin.mvpexample.Adapter.ImageAdapter;
import com.example.baehyeonbin.mvpexample.Data.ImageItem;
import com.example.baehyeonbin.mvpexample.Data.SampleImageData;
import com.example.baehyeonbin.mvpexample.presenter.MainPresenter;
import com.example.baehyeonbin.mvpexample.presenter.SampleContract;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SampleContract.View{
    //@BindView(R.id.recycler_view)
    private RecyclerView recyclerView;

    private ImageAdapter imageAdapter;
    private MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.setSampleImageData(SampleImageData.getInstance());

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        imageAdapter = new ImageAdapter(this);
        recyclerView.setAdapter(imageAdapter);

        mainPresenter.loadItem(this, false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Replace your own Action", Snackbar.LENGTH_LONG ).setAction("Action",null).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void addItems(ArrayList<ImageItem> items, boolean isClear) {
        if(isClear) {
            items.clear();
        }
        imageAdapter.setImageItems(items);
    }

    @Override
    public void notifyAdapter() {
        imageAdapter.notifyDataSetChanged();
    }
}
