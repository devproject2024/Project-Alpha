package c.a.a;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public final class f {
    private static void a(h hVar, String str, p pVar, OkHttpClient.Builder builder, a aVar) {
        if (str != null && !str.isEmpty()) {
            if (builder == null) {
                builder = j.b().f5567a.newBuilder();
            }
            new l(hVar, str, pVar, builder, aVar).a();
        }
    }

    public static void a(String str, p pVar, a aVar) {
        OkHttpClient.Builder newBuilder = j.b().f5567a.newBuilder();
        newBuilder.readTimeout(10000, TimeUnit.MILLISECONDS);
        newBuilder.connectTimeout(10000, TimeUnit.MILLISECONDS);
        newBuilder.writeTimeout(10000, TimeUnit.MILLISECONDS);
        a(h.GET, str, pVar, newBuilder, aVar);
    }

    public static void b(String str, p pVar, a aVar) {
        OkHttpClient.Builder newBuilder = j.b().f5567a.newBuilder();
        newBuilder.readTimeout(10000, TimeUnit.MILLISECONDS);
        newBuilder.connectTimeout(10000, TimeUnit.MILLISECONDS);
        newBuilder.writeTimeout(10000, TimeUnit.MILLISECONDS);
        a(h.POST, str, pVar, newBuilder, aVar);
    }
}
