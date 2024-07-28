package net.one97.paytm.upi.mandate.update;

import net.one97.paytm.upi.mandate.utils.u;
import net.one97.paytm.upi.mandate.utils.v;

public final /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f67365a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f67366b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f67367c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int[] f67368d;

    static {
        int[] iArr = new int[u.values().length];
        f67365a = iArr;
        iArr[u.LOADING.ordinal()] = 1;
        f67365a[u.SUCCESS.ordinal()] = 2;
        f67365a[u.ERROR.ordinal()] = 3;
        int[] iArr2 = new int[v.values().length];
        f67366b = iArr2;
        iArr2[v.PAUSE.ordinal()] = 1;
        f67366b[v.RESUME.ordinal()] = 2;
        f67366b[v.CANCEL.ordinal()] = 3;
        f67366b[v.UPDATE.ordinal()] = 4;
        int[] iArr3 = new int[v.values().length];
        f67367c = iArr3;
        iArr3[v.PAUSE.ordinal()] = 1;
        f67367c[v.RESUME.ordinal()] = 2;
        f67367c[v.CANCEL.ordinal()] = 3;
        f67367c[v.UPDATE.ordinal()] = 4;
        int[] iArr4 = new int[v.values().length];
        f67368d = iArr4;
        iArr4[v.PAUSE.ordinal()] = 1;
        f67368d[v.UPDATE.ordinal()] = 2;
    }
}
