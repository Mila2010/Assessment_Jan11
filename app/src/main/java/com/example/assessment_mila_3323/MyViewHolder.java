package com.example.assessment_mila_3323;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assessment_mila_3323.Model.Keys;

/**
 * Created by Millochka on 1/11/17.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    View mView;
    private TextView mKeyName;



    public MyViewHolder(ViewGroup parent) {
        super(inflateView(parent));

        mView=itemView;

    }

    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.list_item, parent, false);

    }


    protected void onBind(Keys key) {
        mKeyName=(TextView) mView.findViewById(R.id.key_item);
        mKeyName.setText(key.getName());

        mKeyName.setTextColor(Color.parseColor(key.getTextColor()));




    }


    public TextView getmKeyName() {
        return mKeyName;
    }

}
