package net.one97.paytm.upi.mandate.confirmation;

import net.one97.paytm.upi.mandate.data.a;
import net.one97.paytm.upi.mandate.utils.u;

public final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f67094a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f67095b;

    static {
        int[] iArr = new int[a.b.values().length];
        f67094a = iArr;
        iArr[a.b.SUCCESS.ordinal()] = 1;
        f67094a[a.b.ERROR.ordinal()] = 2;
        f67094a[a.b.LOADING.ordinal()] = 3;
        int[] iArr2 = new int[u.values().length];
        f67095b = iArr2;
        iArr2[u.ERROR.ordinal()] = 1;
        f67095b[u.SUCCESS.ordinal()] = 2;
        f67095b[u.LOADING.ordinal()] = 3;
    }
}
