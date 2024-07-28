package com.paytm.android.chat.network.interceptors;

import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.q;
import kotlin.g.b.g;
import kotlin.g.b.k;
import okhttp3.Interceptor;
import okhttp3.Response;

public final class TokenInterceptor implements Interceptor {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final String TAG;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getTAG() {
            return TokenInterceptor.TAG;
        }
    }

    static {
        Companion companion = new Companion((g) null);
        Companion = companion;
        String simpleName = companion.getClass().getSimpleName();
        k.a((Object) simpleName, "TokenInterceptor.javaClass.simpleName");
        TAG = simpleName;
    }

    public final Response intercept(Interceptor.Chain chain) {
        k.c(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        k.a((Object) proceed, Payload.RESPONSE);
        if (isTokenExpired(proceed)) {
            q.b("Token Expired");
        }
        return proceed;
    }

    public final boolean isTokenExpired(Response response) {
        k.c(response, Payload.RESPONSE);
        return response.code() == 404 || response.code() == 403;
    }
}
