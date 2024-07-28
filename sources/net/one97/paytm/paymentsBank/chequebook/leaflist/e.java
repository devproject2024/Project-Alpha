package net.one97.paytm.paymentsBank.chequebook.leaflist;

import net.one97.paytm.paymentsBank.chequebook.c;

public final /* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f17625a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f17626b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f17627c;

    static {
        int[] iArr = new int[c.values().length];
        f17625a = iArr;
        iArr[c.SUCCESS.ordinal()] = 1;
        f17625a[c.LOADING.ordinal()] = 2;
        f17625a[c.ERROR.ordinal()] = 3;
        int[] iArr2 = new int[c.values().length];
        f17626b = iArr2;
        iArr2[c.SUCCESS.ordinal()] = 1;
        f17626b[c.ERROR.ordinal()] = 2;
        f17626b[c.LOADING.ordinal()] = 3;
        int[] iArr3 = new int[c.values().length];
        f17627c = iArr3;
        iArr3[c.SUCCESS.ordinal()] = 1;
        f17627c[c.LOADING.ordinal()] = 2;
        f17627c[c.ERROR.ordinal()] = 3;
    }
}
