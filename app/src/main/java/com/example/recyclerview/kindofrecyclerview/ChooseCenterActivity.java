package com.example.recyclerview.kindofrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ChooseCenterActivity extends AppCompatActivity {
    @Bind(R.id.rv_center)
    ChooseCenterRecyclerview rvCenter;
    private ArrayList datas;
    private CommonAdapter<Bean> adapter;
    private int curPos;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_center);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        datas = (ArrayList) getIntent().getExtras().getSerializable("datas");
        adapter = new CommonAdapter<Bean>(getApplicationContext(), R.layout.item_filter, datas) {
            @Override
            protected void convert(ViewHolder holder, Bean bean, int position) {
                ImageView imageView = holder.getView(R.id.iv_cover);
                holder.setText(R.id.tv_filter, bean.getName());
                imageView.setImageResource(bean.getCover());

                RelativeLayout rlFilter = holder.getView(R.id.rl_filter_box);

                if(curPos == position){
                    rlFilter.setBackgroundResource(R.drawable.round_stroke_shape);
                }else{
                    rlFilter.setBackgroundResource(R.color.total_transparent);
                }

            }
        };
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCenter.setLayoutManager(linearLayoutManager);
        rvCenter.setAdapter(adapter);

        rvCenter.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    if(rvCenter.getChildCount() > 0){
                        linearLayoutManager.scrollToPositionWithOffset(0,0);
                        rvCenter.getChildAt(0).requestFocus();
                    }
                }
            }
        });

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                curPos = position;
                adapter.notifyDataSetChanged();

                rvCenter.smoothToCenter(position);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }
}
