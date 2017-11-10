package com.example.recyclerview.kindofrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhy.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private ArrayList datas = new ArrayList();
    private String[] nameDatas = new String[]{"智能", "红润", "日系", "自然", "艺术黑白", "甜美", "蜜粉", "清新", "夏日阳光", "唯美", "蜜粉",};
    public static int[] pics = new int[]{R.mipmap.filter_thumb_1977, R.mipmap.filter_thumb_kevin, R.mipmap.filter_thumb_antique, R.mipmap.filter_thumb_beauty,
            R.mipmap.filter_thumb_blackcat, R.mipmap.filter_thumb_brannan, R.mipmap.filter_thumb_brooklyn, R.mipmap.filter_thumb_cool
            , R.mipmap.filter_thumb_crayon, R.mipmap.filter_thumb_kevin, R.mipmap.filter_thumb_brannan, R.mipmap.filter_thumb_brooklyn, R.mipmap.filter_thumb_cool
            , R.mipmap.filter_thumb_crayon, R.mipmap.filter_thumb_brannan, R.mipmap.filter_thumb_brooklyn, R.mipmap.filter_thumb_cool
            , R.mipmap.filter_thumb_crayon,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        loadData();
    }

    private void loadData() {
        Bean bean;
        for (int i = 0; i < nameDatas.length; i++) {
            bean = new Bean();
            bean.setCover(pics[i]);
            bean.setName(nameDatas[i]);
            datas.add(bean);
        }
    }

    @OnClick({R.id.btn1,R.id.btn2,R.id.btn3})
    void onClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                intent(CommonAdapterActivity.class);
                break;
            case R.id.btn2:
                intent(ChooseCenterActivity.class);
                break;
            case R.id.btn3:
                intent(AddHeaderActivity.class);
                break;
        }
    }

    private void intent(Class cls){
        Intent intent = new Intent(this,cls);
        Bundle bundle = new Bundle();
        bundle.putSerializable("datas",datas);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
