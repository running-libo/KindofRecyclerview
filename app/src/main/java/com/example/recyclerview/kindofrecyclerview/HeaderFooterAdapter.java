package com.example.recyclerview.kindofrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by apple on 17/11/10.
 */

public class HeaderFooterAdapter extends RecyclerView.Adapter<HeaderFooterAdapter.Holder>{
    private ArrayList<Bean> mDatas;
    private View headerView;
    private View footerView;
    private int typeItem = 0;
    private int typeHeader = 1;
    private int typeFooter = 2;

    public HeaderFooterAdapter(ArrayList<Bean> datas){
        mDatas = datas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(headerView != null && viewType == typeHeader) {
            return new Holder(headerView);
        }

        if(footerView != null && viewType == typeFooter){
            return new Holder(footerView);
        }

        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_headerfooter,null);
        return new Holder(viewItem);

    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        if(getItemViewType(position) == typeItem){
            holder.tvTitle.setText(mDatas.get(position - 1).getName());
        }else if(getItemViewType(position) == typeHeader){

        }else if(getItemViewType(position) == typeFooter){

        }
    }

    @Override
    public int getItemViewType(int position) {

        if(headerView == null && footerView == null){
            return typeItem;
        }

        if(position == 0){
            return typeHeader;
        }

        if(position == getItemCount() - 1){
            return typeFooter;
        }

        return typeItem;
    }

    public void addHeader(View headerView){
        this.headerView = headerView;
        notifyItemInserted(0);
    }

    public void addFooter(View footerView){
        this.footerView = footerView;
        notifyItemInserted(getItemCount()-1);
    }

    @Override
    public int getItemCount() {
        int totalCount = mDatas.size();
        if(headerView != null) totalCount+=1;
        if(footerView != null) totalCount+=1;
        return totalCount;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvTitle;

        public Holder(View itemView) {
            super(itemView);

            if(itemView == headerView){
                return;
            }

            if(itemView == footerView){
                return;
            }

            imageView = itemView.findViewById(R.id.iv_cover);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
