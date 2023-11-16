package com.androidapp.shoppingapp.Utils;

import io.reactivex.rxjava3.core.Observable;

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
            @Field ("password") String password,
            @Field ("phone") String phone

    );

    @POST("signIn.php")
    @FormUrlEncoded
    Observable<UserModel> signIn(
            @Field("email") String email,
            @Field("password") String password
    );


}
