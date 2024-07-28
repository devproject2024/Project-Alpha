package com.paytm.android.chat.network.interceptors;

import com.appsflyer.internal.referrer.Payload;
import com.paytm.android.chat.utils.ToastUtil;
import com.paytm.utility.q;
import kotlin.g.b.g;
import kotlin.g.b.k;
import okhttp3.Interceptor;
import okhttp3.Response;

public final class ErrorInterceptor implements Interceptor {
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
            return ErrorInterceptor.TAG;
        }
    }

    static {
        Companion companion = new Companion((g) null);
        Companion = companion;
        String simpleName = companion.getClass().getSimpleName();
        k.a((Object) simpleName, "ErrorInterceptor.javaClass.simpleName");
        TAG = simpleName;
    }

    public final Response intercept(Interceptor.Chain chain) {
        k.c(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        String string = proceed.peekBody(1048576).string();
        if (proceed.code() == 10025) {
            String str = "catch error (" + proceed.code() + "):" + string;
            q.b(str);
            ToastUtil.showMsg(str);
        } else if (proceed.code() == 10026) {
            String str2 = "catch error (" + proceed.code() + "):" + string;
            q.b(str2);
            ToastUtil.showMsg(str2);
        }
        k.a((Object) proceed, Payload.RESPONSE);
        return proceed;
    }
}
