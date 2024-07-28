package net.one97.paytm.upi.mandate.p2p;

import net.one97.paytm.upi.mandate.data.a;
import net.one97.paytm.upi.mandate.utils.p;

public final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f67279a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f67280b;

    static {
        int[] iArr = new int[a.b.values().length];
        f67279a = iArr;
        iArr[a.b.SUCCESS.ordinal()] = 1;
        f67279a[a.b.ERROR.ordinal()] = 2;
        f67279a[a.b.LOADING.ordinal()] = 3;
        int[] iArr2 = new int[p.values().length];
        f67280b = iArr2;
        iArr2[p.WEEKLY.ordinal()] = 1;
        f67280b[p.FORTNIGHTLY.ordinal()] = 2;
    }
}
