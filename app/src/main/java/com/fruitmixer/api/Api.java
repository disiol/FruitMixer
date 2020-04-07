package com.fruitmixer.api;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.POST;
import rx.Observable;

public interface Api {

   @POST("VcDcp52d")
   Observable<Response<ResponseBody>> sendRequest();
}
