package ch.teko.restexample.rest;

import android.content.Context;

import ch.teko.restexample.application.RestConstant;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jonathan on 28.08.17.
 */

public class RestClient {

    static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(RestConstant.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create());

    static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass){
        return createService(serviceClass, null);
    }

    public static <S> S createService(Class<S> serviceClass, Context context) {
        if(context !=null){
            // If we need a token to autheticate

        }

        return retrofit.create(serviceClass);
    }

}
