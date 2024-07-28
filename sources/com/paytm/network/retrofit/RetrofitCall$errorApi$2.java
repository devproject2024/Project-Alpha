package com.paytm.network.retrofit;

import kotlin.g.a.a;
import kotlin.g.b.l;

final class RetrofitCall$errorApi$2 extends l implements a<ErrorAPI> {
    public static final RetrofitCall$errorApi$2 INSTANCE = new RetrofitCall$errorApi$2();

    RetrofitCall$errorApi$2() {
        super(0);
    }

    public final ErrorAPI invoke() {
        return ErrorAPI.Companion.create();
    }
}
