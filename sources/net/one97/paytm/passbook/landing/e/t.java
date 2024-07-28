package net.one97.paytm.passbook.landing.e;

import net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum;
import net.one97.paytm.passbook.mapping.a.j;

public final /* synthetic */ class t {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f57691a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f57692b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f57693c;

    static {
        int[] iArr = new int[CJRPPApplicationStatusEnum.values().length];
        f57691a = iArr;
        iArr[CJRPPApplicationStatusEnum.NONE.ordinal()] = 1;
        f57691a[CJRPPApplicationStatusEnum.NOT_YET_SUBMITTED.ordinal()] = 2;
        f57691a[CJRPPApplicationStatusEnum.APPLICATION_ACCEPTED.ordinal()] = 3;
        f57691a[CJRPPApplicationStatusEnum.APPLICATION_CONFIRMED.ordinal()] = 4;
        f57691a[CJRPPApplicationStatusEnum.APPLICATION_IN_PROGRESS.ordinal()] = 5;
        f57691a[CJRPPApplicationStatusEnum.APPLICATION_PENDING_APPROVAL.ordinal()] = 6;
        int[] iArr2 = new int[j.values().length];
        f57692b = iArr2;
        iArr2[j.SUCCESS.ordinal()] = 1;
        int[] iArr3 = new int[CJRPPApplicationStatusEnum.values().length];
        f57693c = iArr3;
        iArr3[CJRPPApplicationStatusEnum.NOT_YET_SUBMITTED.ordinal()] = 1;
        f57693c[CJRPPApplicationStatusEnum.KYC_SHARING_ACCEPTED.ordinal()] = 2;
        f57693c[CJRPPApplicationStatusEnum.APPLICATION_REJECTED.ordinal()] = 3;
        f57693c[CJRPPApplicationStatusEnum.APPLICATION_CONFIRMED.ordinal()] = 4;
    }
}
