package com.bigkoo.mvvmframeworkdemo.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sai on 16/3/4.
 */
public class HttpServiceGenerator {
    public static final String API_BASE_URL = "http://apis.baidu.com/apistore/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());


    /**
     * 返回默认的HttpService
     * @return
     */
    public static HttpService createService() {
        return createService(builder);
    }

    public static HttpService createService(Retrofit.Builder builder) {
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .method(original.method(), original.body())
                        .addHeader("apikey", "56861a1d6b7dc2a0eddf86734f608bd7");
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(HttpService.class);
    }
}
