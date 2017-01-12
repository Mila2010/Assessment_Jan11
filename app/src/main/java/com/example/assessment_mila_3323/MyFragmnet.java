package com.example.assessment_mila_3323;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assessment_mila_3323.Model.KeyCollector;
import com.example.assessment_mila_3323.Model.Keys;
import com.example.assessment_mila_3323.Network.KeyCollectorInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Millochka on 1/11/17.
 */
public class MyFragmnet extends Fragment {

    static Activity myActivity;

    RecyclerView recyclerView;
    Retrofit mRetrofit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        return view;


    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myActivity=getActivity();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        mRetrofit = new Retrofit.Builder().baseUrl("http://jsjrobotics.nyc/").addConverterFactory(GsonConverterFactory.create(gson)).build();
        KeyCollectorInterface keyCollector = mRetrofit.create(KeyCollectorInterface.class);
        Call<KeyCollector> call = keyCollector.listPage();
        call.enqueue(new Callback<KeyCollector>() {
            @Override
            public void onResponse(Call<KeyCollector> call, Response<KeyCollector> response) {

                KeyCollector keysResponse = response.body();

                ArrayList<Keys> keys=keysResponse.getAvailable_keys();
                initRecyclerV(view,keys,getActivity());

            }

            @Override
            public void onFailure(Call<KeyCollector> call, Throwable t) {

            }
        });

    }

        public void initRecyclerV(View view,List<Keys> keys, Activity myActivity ){

        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        recyclerView.setAdapter(new MyAdapter(keys, myActivity));}

}

