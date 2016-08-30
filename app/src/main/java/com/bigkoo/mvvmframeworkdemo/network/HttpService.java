package com.bigkoo.mvvmframeworkdemo.network;

import com.bigkoo.mvvmframework.model.HttpResult;
import com.bigkoo.mvvmframeworkdemo.model.Ticket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sai on 16/3/5.
 */
public interface HttpService {
    @GET("api/list/ticket")
    Call<HttpResult<List<Ticket>>> getTicketList(@Query("page") int page, @Query("pageSize") int pageSize);
    @GET("api/detail/ticket")
    Call<HttpResult<Ticket>> getTicketDetail(@Query("id") String id);
}
