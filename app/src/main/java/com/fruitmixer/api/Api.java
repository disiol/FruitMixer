package com.fruitmixer.api;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.POST;
import rx.Observable;

public interface Api {

   @POST("sjr4gQD5")
   Observable<Response<ResponseBody>> sendRequest();
}
