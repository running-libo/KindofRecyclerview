package com.example.recyclerview.kindofrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;

public class CommonAdapterActivity extends AppCompatActivity {
    @Bind(R.id.rv_adapter)
    RecyclerView rvAdapter;
    private ArrayList datas;
    private CommonAdapter<Bean> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_adapter);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        datas = (ArrayList) getIntent().getExtras().getSerializable("datas");
        adapter = new CommonAdapter<Bean>(getApplicationContext(), R.layout.item_adapter, datas) {
            @Override
            protected void convert(ViewHolder holder, Bean bean, int position) {
                ImageView imageView = holder.getView(R.id.iv_effectmore_cover);
                holder.setText(R.id.tv_effectmore_title, bean.getName());
                imageView.setImageResource(bean.getCover());

            }
        };
        rvAdapter.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        rvAdapter.setAdapter(adapter);

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Toast.makeText(getApplicationContext(),"点击第" + position + "个",Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                Toast.makeText(getApplicationContext(),"长按第" + position + "个",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
