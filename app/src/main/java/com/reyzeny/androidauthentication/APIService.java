package com.reyzeny.androidauthentication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Pelumi on 12/12/2017.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("FirstApp/SignUp.php")
    Call<MSG> userSignUp(@Field("name") String name, @Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("FirstApp/login.php")
    Call<MSG> userLogIn(@Field("email") String email, @Field("password") String password);
}
