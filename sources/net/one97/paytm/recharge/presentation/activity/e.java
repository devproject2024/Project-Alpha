package net.one97.paytm.recharge.presentation.activity;

import net.one97.paytm.recharge.presentation.b.e;
import net.one97.paytm.recharge.presentation.g.c;

public final /* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f64715a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f64716b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f64717c;

    static {
        int[] iArr = new int[c.values().length];
        f64715a = iArr;
        iArr[c.LOADING.ordinal()] = 1;
        f64715a[c.ERROR.ordinal()] = 2;
        f64715a[c.SUCCESS.ordinal()] = 3;
        int[] iArr2 = new int[c.values().length];
        f64716b = iArr2;
        iArr2[c.SUCCESS.ordinal()] = 1;
        f64716b[c.ERROR.ordinal()] = 2;
        int[] iArr3 = new int[e.b.values().length];
        f64717c = iArr3;
        iArr3[e.b.RESUME.ordinal()] = 1;
        f64717c[e.b.PAUSE.ordinal()] = 2;
        f64717c[e.b.DELETE.ordinal()] = 3;
    }
}
