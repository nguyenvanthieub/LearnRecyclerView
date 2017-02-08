package com.example.learnrecyclerview;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<DataShop> arrayList = new ArrayList<>();
        arrayList.add(new DataShop(R.drawable.dungluong, "Dung Luong"));
        arrayList.add(new DataShop(R.drawable.manhinh, "Man Hinh"));
        arrayList.add(new DataShop(R.drawable.playunity, "Play Unity"));
        arrayList.add(new DataShop(R.drawable.tiendo, "Tien Do"));
        arrayList.add(new DataShop(R.drawable.ungdung, "Ung Dung"));
        ShopAdapter shopAdapter = new ShopAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(shopAdapter);
    }

}
