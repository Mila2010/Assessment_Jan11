package com.example.assessment_mila_3323;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "IMAGEURL";



    String mImageUrl;
    ImageView mKeyImage;
    Boolean mPressedSecond;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        mImageUrl="http://jsjrobotics.nyc"+intent.getStringExtra(IMAGE_URL);

        mKeyImage=(ImageView) findViewById(R.id.key_image);
        mPressedSecond=false;

        Picasso.with(this)
                .load(mImageUrl)
                .into(mKeyImage);

    }

    @Override
    public void onBackPressed()
    {

        if(mPressedSecond){
            mPressedSecond=!mPressedSecond;
            finish();



        }else{
        Toast.makeText(getApplicationContext(),"Press once more to see list", Toast.LENGTH_SHORT).show();
        mPressedSecond=!mPressedSecond;}
        return;
    }
}
