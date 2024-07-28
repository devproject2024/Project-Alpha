package net.one97.paytm.upi.mandate.c;

import net.one97.paytm.upi.mandate.data.a;
import net.one97.paytm.upi.mandate.utils.u;

public final /* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f67076a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f67077b;

    static {
        int[] iArr = new int[a.b.values().length];
        f67076a = iArr;
        iArr[a.b.SUCCESS.ordinal()] = 1;
        f67076a[a.b.ERROR.ordinal()] = 2;
        f67076a[a.b.LOADING.ordinal()] = 3;
        int[] iArr2 = new int[u.values().length];
        f67077b = iArr2;
        iArr2[u.ERROR.ordinal()] = 1;
        f67077b[u.SUCCESS.ordinal()] = 2;
        f67077b[u.LOADING.ordinal()] = 3;
    }
}
