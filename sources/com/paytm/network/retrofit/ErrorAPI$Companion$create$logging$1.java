package com.paytm.network.retrofit;

import com.paytm.utility.q;
import okhttp3.logging.HttpLoggingInterceptor;

final class ErrorAPI$Companion$create$logging$1 implements HttpLoggingInterceptor.Logger {
    public static final ErrorAPI$Companion$create$logging$1 INSTANCE = new ErrorAPI$Companion$create$logging$1();

    ErrorAPI$Companion$create$logging$1() {
    }

    public final void log(String str) {
        q.d(str);
    }
}
