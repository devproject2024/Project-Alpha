package net.one97.paytm.h5paytmsdk.b;

import com.alipay.mobile.h5container.api.H5Event;

public final /* synthetic */ class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f16980a;

    static {
        int[] iArr = new int[H5Event.Error.values().length];
        f16980a = iArr;
        iArr[H5Event.Error.NOT_FOUND.ordinal()] = 1;
        f16980a[H5Event.Error.INVALID_PARAM.ordinal()] = 2;
        f16980a[H5Event.Error.UNKNOWN_ERROR.ordinal()] = 3;
        f16980a[H5Event.Error.FORBIDDEN.ordinal()] = 4;
    }
}
