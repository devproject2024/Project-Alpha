package net.one97.paytm.recharge.common.h;

import com.paytm.network.model.NetworkCustomError;

public final /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f61426a;

    static {
        int[] iArr = new int[NetworkCustomError.ErrorType.values().length];
        f61426a = iArr;
        iArr[NetworkCustomError.ErrorType.NoConnectionError.ordinal()] = 1;
        f61426a[NetworkCustomError.ErrorType.NetworkError.ordinal()] = 2;
        f61426a[NetworkCustomError.ErrorType.AuthFailureError.ordinal()] = 3;
    }
}
