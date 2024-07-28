package net.one97.paytm.recharge.common.f;

import com.paytm.network.model.NetworkCustomError;

public final /* synthetic */ class f {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f61108a;

    static {
        int[] iArr = new int[NetworkCustomError.ErrorType.values().length];
        f61108a = iArr;
        iArr[NetworkCustomError.ErrorType.TimeOutError.ordinal()] = 1;
        f61108a[NetworkCustomError.ErrorType.AuthFailureError.ordinal()] = 2;
        f61108a[NetworkCustomError.ErrorType.NoConnectionError.ordinal()] = 3;
        f61108a[NetworkCustomError.ErrorType.ParsingError.ordinal()] = 4;
        f61108a[NetworkCustomError.ErrorType.InvalidArgumentError.ordinal()] = 5;
    }
}
