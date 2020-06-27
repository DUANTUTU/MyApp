package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.bean.newsBean;

import java.util.List;

/**
 * @autor duan
 * create on 2020/6/2
 * creta at 9:53
 */
public class hotnewsAdapter  extends RecyclerView.Adapter<hotnewsAdapter.ViewHolder> {
    List<newsBean.NewslistBean> list;
    Context context;

    public hotnewsAdapter(Context context) {
        this.context = context;
    }

    public hotnewsAdapter(List<newsBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public hotnewsAdapter(List<newsBean.NewslistBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.newsTitle.setText(list.get(position).getTitle()+"");
            holder.updatetime.setText(list.get(position).getCtime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView newsTitle;
        private TextView updatetime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            updatetime =itemView. findViewById(R.id.updatetime);
        }
    }
}
