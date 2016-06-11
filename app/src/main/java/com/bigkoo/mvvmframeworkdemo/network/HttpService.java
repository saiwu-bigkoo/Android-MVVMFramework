package com.bigkoo.mvvmframeworkdemo.network;

import com.bigkoo.mvvmframework.model.HttpResult;
import com.bigkoo.mvvmframeworkdemo.model.MyHttpResult;
import com.bigkoo.mvvmframeworkdemo.model.Ticket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sai on 16/3/5.
 */
public interface HttpService {
    @GET("qunaerticket/querylist")
    Call<MyHttpResult<List<Ticket>>> getTicketList(@Query("pageno") int pageno, @Query("pagesize") int pagesize);
}
