package com.example.assessment_mila_3323;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.assessment_mila_3323.Model.Keys;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Millochka on 1/11/17.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private static final String IMAGE_URL = "IMAGEURL";
    private ArrayList<Keys> mKey= new ArrayList<>();

    Activity mActivity;

    public MyAdapter(List<Keys> key, Activity myActivity) {

        this.mKey=(ArrayList)key;



    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        ((MyViewHolder) holder).onBind(mKey.get(position));
        ((MyViewHolder) holder).getmKeyName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String imageUrl=mKey.get(position).getUrl();

                intent.putExtra(IMAGE_URL,imageUrl);

                mActivity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mKey.size();
    }
}
