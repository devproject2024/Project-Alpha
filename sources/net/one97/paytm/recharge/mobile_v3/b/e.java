package net.one97.paytm.recharge.mobile_v3.b;

import net.one97.paytm.recharge.common.b.a;
import net.one97.paytm.recharge.model.v4.ErrorAction;

public final /* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f63843a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f63844b;

    static {
        int[] iArr = new int[a.b.values().length];
        f63843a = iArr;
        iArr[a.b.AMOUNT.ordinal()] = 1;
        int[] iArr2 = new int[ErrorAction.values().length];
        f63844b = iArr2;
        iArr2[ErrorAction.BROWSE_PLAN.ordinal()] = 1;
        f63844b[ErrorAction.OPERATOR_LIST.ordinal()] = 2;
        f63844b[ErrorAction.OPEN_MULTI_PRODUCT.ordinal()] = 3;
        f63844b[ErrorAction.NO_ACTION.ordinal()] = 4;
    }
}
