package com.example.android.mrasyidridhotobing_1202150064_modul3;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private List<Air> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AirAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new AirAdapter(this, menuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);//penghubung antara adapter dan layout
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMenuData();

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

    }
    //mengambil objek array
    private void prepareMenuData() {
        String[] merk_title = getResources().getStringArray(R.array.name_src);
        String[] merk_deskripsi = getResources().getStringArray(R.array.desc_src);
        String[] details = getResources().getStringArray(R.array.info_src);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.img_src);
        menuList.clear();

        //sebagai perulangan array
        for(int i=0; i<merk_title.length; i++){
            menuList.add(new Air(sportsImageResources.getResourceId(i,0),merk_title[i], merk_deskripsi[i]
                    , details[i]));
        }

        sportsImageResources.recycle();

        mAdapter.notifyDataSetChanged();

    }

}
