package com.example.aanchalsingh.roposo_stories_task.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Story;
import com.example.aanchalsingh.roposo_stories_task.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AANCHAL SINGH on 11/13/2016.
 */

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {

    List<Story> storyList;
    Context context;

    public StoryAdapter(List<Story> storyList, Context context)
    {
        this.storyList=storyList;
        this.context=context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_story,parent,false);
        return new MyViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Story storyData = storyList.get(position);
        holder.storyTitle.setText(storyData.getTitle());

    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txt_title)
        TextView storyTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    // refresh adapter data
    public void refreshView(List<Story> freshList)
    {
        storyList=new ArrayList<>();
        storyList.addAll(freshList);
        notifyDataSetChanged();
    }
}
