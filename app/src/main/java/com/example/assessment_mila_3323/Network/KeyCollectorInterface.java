package com.example.assessment_mila_3323.Network;

import com.example.assessment_mila_3323.Model.KeyCollector;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Millochka on 1/11/17.
 */

public interface KeyCollectorInterface {
    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<KeyCollector> listPage();
}
