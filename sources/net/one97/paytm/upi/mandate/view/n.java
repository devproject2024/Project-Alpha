package net.one97.paytm.upi.mandate.view;

import net.one97.paytm.upi.mandate.utils.u;
import net.one97.paytm.upi.mandate.utils.v;

public final /* synthetic */ class n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f67606a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f67607b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f67608c;

    static {
        int[] iArr = new int[u.values().length];
        f67606a = iArr;
        iArr[u.LOADING.ordinal()] = 1;
        f67606a[u.SUCCESS.ordinal()] = 2;
        f67606a[u.ERROR.ordinal()] = 3;
        int[] iArr2 = new int[u.values().length];
        f67607b = iArr2;
        iArr2[u.LOADING.ordinal()] = 1;
        f67607b[u.SUCCESS.ordinal()] = 2;
        f67607b[u.ERROR.ordinal()] = 3;
        int[] iArr3 = new int[v.values().length];
        f67608c = iArr3;
        iArr3[v.PAUSE.ordinal()] = 1;
        f67608c[v.RESUME.ordinal()] = 2;
        f67608c[v.CANCEL.ordinal()] = 3;
        f67608c[v.UPDATE.ordinal()] = 4;
    }
}
