package com.paytm.network.retrofit;

import com.google.gsonhtcfix.o;
import kotlin.g.b.k;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ErrorAPI {
    public static final Companion Companion = Companion.$$INSTANCE;

    @POST
    Call<Object> errorApiCall(@Url String str, @Body o oVar);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final ErrorAPI create() {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(ErrorAPI$Companion$create$logging$1.INSTANCE);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(ErrorAPI$Companion$create$1.INSTANCE);
            builder.addInterceptor(httpLoggingInterceptor);
            Object create = new Retrofit.Builder().baseUrl("https://travel.paytm.com").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(ErrorAPI.class);
            k.a(create, "retrofit.create(ErrorAPI::class.java)");
            return (ErrorAPI) create;
        }
    }
}
