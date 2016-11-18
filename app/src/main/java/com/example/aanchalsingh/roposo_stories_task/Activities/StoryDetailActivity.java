package com.example.aanchalsingh.roposo_stories_task.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.aanchalsingh.roposo_stories_task.DatabaseModels.User;
import com.example.aanchalsingh.roposo_stories_task.R;
import com.example.aanchalsingh.roposo_stories_task.Utils.AppConstants;
import com.example.aanchalsingh.roposo_stories_task.Utils.RealmController;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class StoryDetailActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.tv_user_name)
    TextView userNameTxt;
    @BindView(R.id.tv_user_about)
    TextView aboutTxt;
    @BindView(R.id.tv_followers)
    TextView followerTxt;
    @BindView(R.id.btn_follow)
    Button followBtn;
    @BindView(R.id.iv_user_image)
    ImageView userImageIv;
    @BindView(R.id.tv_story_title)
    TextView titleTxt;
    @BindView(R.id.tv_description)
    TextView descriptionTxt;
    @BindView(R.id.tv_verb)
    TextView verbTxt;
    @BindView(R.id.iv_story_image)
    ImageView storyImageIv;

    private User user;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            }
        }
        setContentView(R.layout.activity_story_detail);
        ButterKnife.bind(this);
        Bundle b = getIntent().getExtras();
        String authorId= b.getString("storyAuthorId");
        String storyTitle=b.getString("storyTitle");
        String storyDescription = b.getString("storyDescription");
        String storyImage= b.getString("storyImage");
        String storyVerb = b.getString("storyVerb");
        user = RealmController.with(this).getUserDetails(authorId);
        userNameTxt.setText(user.getUsername());
        aboutTxt.setText(user.getAbout());
        followerTxt.setText("Followed by : "+user.getFollowers());
        if(user.getIsFollowing())
        {
            followBtn.setTextColor(ContextCompat.getColor(this,R.color.black));
            followBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.follow_selected_detail_background));
            followBtn.setText("FOLLOWING");
        }else{
            followBtn.setTextColor(ContextCompat.getColor(this,R.color.white));
            followBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.follow_unselected_detail_background));
            followBtn.setText("FOLLOW");
        }
        followBtn.setOnClickListener(this);
        titleTxt.setText(storyTitle);
        descriptionTxt.setText(storyDescription);
        verbTxt.setText(storyVerb);
        Glide.with(this).load(user.getImage())
                .asBitmap()
                .centerCrop()
                .into(new BitmapImageViewTarget(userImageIv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        userImageIv.setImageDrawable(circularBitmapDrawable);
                    }
                });

        Glide.with(this)
                .load(storyImage)
                .asBitmap()
                .fitCenter()
                .into(storyImageIv);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_follow:

                RealmController.with(this).updateIsFollowing(user.getId(),!(user.getIsFollowing()));
                if(user.getIsFollowing())
                {
                    followBtn.setTextColor(ContextCompat.getColor(this,R.color.black));
                    followBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.follow_selected_detail_background));
                    followBtn.setText("FOLLOWING");
                }else{
                    followBtn.setTextColor(ContextCompat.getColor(this,R.color.white));
                    followBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.follow_unselected_detail_background));
                    followBtn.setText("FOLLOW");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("userId",user.getId());
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}
