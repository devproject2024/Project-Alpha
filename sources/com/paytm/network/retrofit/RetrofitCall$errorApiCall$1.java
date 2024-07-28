package com.paytm.network.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class RetrofitCall$errorApiCall$1 implements Callback<Object> {
    final /* synthetic */ RetrofitCall this$0;

    RetrofitCall$errorApiCall$1(RetrofitCall retrofitCall) {
        this.this$0 = retrofitCall;
    }

    public final void onFailure(Call<Object> call, Throwable th) {
        String unused = this.this$0.TAG;
        new StringBuilder("onFailure: ").append(String.valueOf(call));
    }

    public final void onResponse(Call<Object> call, Response<Object> response) {
        String unused = this.this$0.TAG;
    }
}
