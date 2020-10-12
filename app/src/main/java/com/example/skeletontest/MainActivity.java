package com.example.skeletontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;

public class MainActivity extends AppCompatActivity {
    private Skeleton skeleton;
    private RecyclerView recyclerView;
    private rvAdapter rvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        recyclerView = (RecyclerView)findViewById(R.id.rvTest);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        rvAdapter = new rvAdapter();
        final SkeletonScreen skeletonScreen = Skeleton.bind(recyclerView)
                .adapter(rvAdapter)
                .load(R.layout.item_class_skeleton)
                .shimmer(true)
                .duration(1200)
                .count(10)
                .show();
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                skeletonScreen.hide();
            }
        }, 5000);
    }
}