package com.reyzeny.androidauthentication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pelumi on 12/12/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "http://192.168.1.10/Projects/";  //your url e.g http://192.168.1.10/Projects/
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }
}
