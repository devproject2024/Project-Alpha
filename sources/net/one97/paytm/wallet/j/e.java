package net.one97.paytm.wallet.j;

import net.one97.paytm.network.h;

public final /* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f70454a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f70455b;

    static {
        int[] iArr = new int[h.values().length];
        f70454a = iArr;
        iArr[h.ERROR.ordinal()] = 1;
        f70454a[h.PROGRESS.ordinal()] = 2;
        f70454a[h.SUCCESS.ordinal()] = 3;
        f70454a[h.CANCELLED.ordinal()] = 4;
        int[] iArr2 = new int[h.values().length];
        f70455b = iArr2;
        iArr2[h.SUCCESS.ordinal()] = 1;
        f70455b[h.CANCELLED.ordinal()] = 2;
        f70455b[h.ERROR.ordinal()] = 3;
        f70455b[h.PROGRESS.ordinal()] = 4;
    }
}
