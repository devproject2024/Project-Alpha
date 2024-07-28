package net.one97.paytm.wallet.rateMerchant;

import net.one97.paytm.wallet.rateMerchant.a.b;

public final /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f71675a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f71676b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f71677c;

    static {
        int[] iArr = new int[b.values().length];
        f71675a = iArr;
        iArr[b.SUCCESS.ordinal()] = 1;
        f71675a[b.LOADING.ordinal()] = 2;
        f71675a[b.ERROR.ordinal()] = 3;
        int[] iArr2 = new int[b.values().length];
        f71676b = iArr2;
        iArr2[b.ERROR.ordinal()] = 1;
        f71676b[b.LOADING.ordinal()] = 2;
        f71676b[b.SUCCESS.ordinal()] = 3;
        int[] iArr3 = new int[b.values().length];
        f71677c = iArr3;
        iArr3[b.SUCCESS.ordinal()] = 1;
        f71677c[b.LOADING.ordinal()] = 2;
        f71677c[b.ERROR.ordinal()] = 3;
    }
}
