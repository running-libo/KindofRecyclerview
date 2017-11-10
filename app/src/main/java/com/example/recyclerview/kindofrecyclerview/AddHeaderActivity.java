package com.example.recyclerview.kindofrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddHeaderActivity extends AppCompatActivity {

    @Bind(R.id.rv_addheader)
    RecyclerView rvAddheader;
    private HeaderFooterAdapter adapter;
    private ArrayList<Bean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_header);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        datas = (ArrayList) getIntent().getExtras().getSerializable("datas");
        adapter = new HeaderFooterAdapter(datas);
        rvAddheader.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvAddheader.setAdapter(adapter);

        View viewHeader = LayoutInflater.from(getApplicationContext()).inflate(R.layout.rv_header,null);
        View viewFooter = LayoutInflater.from(getApplicationContext()).inflate(R.layout.rv_footer,null);
        adapter.addHeader(viewHeader);
        adapter.addFooter(viewFooter);
    }
}
