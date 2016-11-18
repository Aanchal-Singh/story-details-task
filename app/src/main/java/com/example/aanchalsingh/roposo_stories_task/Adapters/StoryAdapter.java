package com.example.aanchalsingh.roposo_stories_task.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.aanchalsingh.roposo_stories_task.Activities.StoryDetailActivity;
import com.example.aanchalsingh.roposo_stories_task.DatabaseModels.User;
import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Story;
import com.example.aanchalsingh.roposo_stories_task.R;
import com.example.aanchalsingh.roposo_stories_task.Utils.RealmController;
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Story storyData = storyList.get(position);
        final User user = RealmController.with((Activity)context).getUserDetails(storyData.getDb());
        holder.storyTitle.setText(storyData.getTitle());
        Glide.with(context).load(user.getImage())
                .asBitmap()
                .centerCrop()
                .into(new BitmapImageViewTarget(holder.userImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        holder.userImage.setImageDrawable(circularBitmapDrawable);
                    }
                });

        holder.userName.setText(user.getUsername());
        holder.userHandle.setText(user.getHandle());
        holder.followers.setText("Followed By : "+String.valueOf(user.getFollowers()));
        holder.likes.setText("Likes : " + String.valueOf(storyData.getLikesCount()));
        Glide.with(context)
                .load(storyData.getSi())
                .asBitmap()
                .fitCenter()
                .override(700,500)
                .into(new BitmapImageViewTarget(holder.storyImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(false);
                        holder.storyImage.setImageDrawable(circularBitmapDrawable);
                    }
                });

        if(user.getIsFollowing())
        {
            holder.follow.setTextColor(ContextCompat.getColor(context,R.color.white));
            holder.follow.setBackground(ContextCompat.getDrawable(context,R.drawable.follow_selected_background));
            holder.follow.setText("FOLLOWING");
        }else{
            holder.follow.setTextColor(ContextCompat.getColor(context,R.color.grey));
            holder.follow.setBackground(ContextCompat.getDrawable(context,R.drawable.follow_unselected_background));
            holder.follow.setText("FOLLOW");

        }
        holder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RealmController.with((Activity)context).updateIsFollowing(user.getId(),!(user.getIsFollowing()));
                RebindCorrespondingViews(storyData.getDb());
            }
        });

        holder.rlStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openStory = new Intent(context, StoryDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("storyTitle",storyData.getTitle());
                bundle.putString("storyDescription",storyData.getDescription());
                bundle.putString("storyImage",storyData.getSi());
                bundle.putString("storyVerb",storyData.getVerb());
                bundle.putString("storyAuthorId",storyData.getDb());
                openStory.putExtras(bundle);
                context.startActivity(openStory);
            }
        });

    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_user_image)
        ImageView userImage;
        @BindView(R.id.tv_username)
        TextView userName;
        @BindView(R.id.tv_user_handle)
        TextView userHandle;
        @BindView(R.id.tv_followers)
        TextView followers;
        @BindView(R.id.iv_story_image)
        ImageView storyImage;
        @BindView(R.id.tv_story_title)
        TextView storyTitle;
        @BindView(R.id.tv_likes)
        TextView likes;
        @BindView(R.id.follow_btn)
        Button follow;
        @BindView(R.id.story_view)
        RelativeLayout rlStory;

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

    //reflects the changes in all other views
    public void RebindCorrespondingViews(String userId)
    {
        for(int i=0;i<storyList.size();i++)
        {
            if(storyList.get(i).getDb().equalsIgnoreCase(userId))
                notifyItemChanged(i);

        }
    }

}