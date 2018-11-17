package com.course.frandydlacruz.logintoprofileactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        ImageView ivUserPhoto = findViewById(R.id.ivPhoto);
        TextView tvName = findViewById(R.id.tvUserName);
        TextView tvUserDescription = findViewById(R.id.tvUserDescription);
        TextView tvRepoCount = findViewById(R.id.tvRepoCount);
        TextView tvCommitsCount = findViewById(R.id.tvCommitsCount);
        TextView tvStarsCount = findViewById(R.id.tvStarsCount);
        Button btnShare = findViewById(R.id.btnShare);

        final User userData = getIntent().getParcelableExtra("USER");

        tvName.setText(userData.getName());
        ivUserPhoto.setImageResource(userData.getPhotoPath());
        tvUserDescription.setText(userData.getDescription());
        tvRepoCount.setText(String.valueOf(userData.getRepoCount()));
        tvCommitsCount.setText(String.valueOf(userData.getCommitsCount()));
        tvStarsCount.setText(String.valueOf(userData.getStarsCount()));

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareProfile(userData);
            }
        });
    }

    private void shareProfile(User user){
        Intent shareIntent = new Intent();

        String textToShare = user.getName() + "\n" + user.getDescription() + "\n" + user.getRepoCount() + "\n" + user.getCommitsCount()
                + "\n" + user.getStarsCount();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
        shareIntent.setType("text/plain");

        startActivity(shareIntent);
    }
}
