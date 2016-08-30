package com.bigkoo.mvvmframeworkdemo.network;

import android.content.Context;

import com.shanbay.mock.MockApiInterceptor;
import com.shanbay.mock.MockApiSuite;
import com.shanbay.mock.api.StandardMockApi;
import com.shanbay.mock.constant.MockHttpMethod;
import com.shanbay.mock.constant.MockState;

import java.util.Random;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sai on 16/3/4.
 */
public class HttpServiceGenerator {
    public static Context context;

    public static final String API_BASE_URL = "http://www.bigkoo.com/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static HttpService httpService;

    /**
     * 返回默认的HttpService
     * @return
     */
    public static HttpService createService() {
        if(httpService==null)
            httpService = createService(builder);
        return httpService;
    }

    public static HttpService createService(Retrofit.Builder builder) {
        //这里mock数据用于测试
        MockApiSuite suite = new MockApiSuite("trip"); // mockdata.trip 表示 suite name
        StandardMockApi standardMockApiList = new StandardMockApi(MockHttpMethod.GET, "api/list/ticket");
        standardMockApiList.setSuccessDataFile("ticketlist.json");
        standardMockApiList.setRequestTime(1000);
        suite.addMockApi(standardMockApiList);


        suite.addMockApi(new StandardMockApi(MockHttpMethod.GET, "api/detail/ticket").setSuccessDataFile("ticketdetail.json"));

        MockApiInterceptor mockApiInterceptor = new MockApiInterceptor(context);
        mockApiInterceptor.addMockApiSuite(suite);
        httpClient.addInterceptor(mockApiInterceptor);   // 注入mock api interceptor

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(HttpService.class);
    }
}
