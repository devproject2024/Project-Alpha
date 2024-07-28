package com.business.a;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public final class a {

    /* renamed from: com.business.a.a$a  reason: collision with other inner class name */
    public interface C0102a {
        HashMap<String, String> a();
    }

    public interface b {
        String a();

        void a(HashMap<String, String> hashMap);
    }

    public interface c {
        Context getAppContext();

        C0102a getCommonHeaderInterface();

        HashMap<String, String> getDomainPins();

        b getHawkEyeNetworkInterface();

        boolean isCache();

        boolean isDebuggable();
    }

    public static <T> T a(File file, Class<T> cls, c cVar) {
        return new Retrofit.Builder().baseUrl("https://dashboard.paytm.com").addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(b.a(file, cVar)).build().create(cls);
    }
}
