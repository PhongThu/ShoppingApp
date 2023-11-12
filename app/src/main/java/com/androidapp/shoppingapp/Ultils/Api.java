package com.androidapp.shoppingapp.Ultils;

import android.database.Observable;

import com.androidapp.shoppingapp.Models.User_model;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    //Get data
    @POST("dangky.php")
    @FormUrlEncoded
    Observable<User_model> dangky(
            @Field("email") String email,
            @Field ("pass") String pass,
            @Field ("username") String username,
            @Field ("mobile") String mobile

    );
}
