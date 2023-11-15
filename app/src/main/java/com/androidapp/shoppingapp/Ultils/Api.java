package com.androidapp.shoppingapp.Ultils;

import android.database.Observable;

import com.androidapp.shoppingapp.Models.UserModel;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    //Get data
    @POST("signUp.php")
    @FormUrlEncoded
    Observable<UserModel> signUp(
            @Field("email") String email,
            @Field ("pass") String pass,
            @Field ("username") String username,
            @Field ("mobile") String mobile

    );

    @POST("signIn.php")
    @FormUrlEncoded
    Observable<UserModel> signIn(
            @Field("email") String email,
            @Field("pass") String pass
    );


}
