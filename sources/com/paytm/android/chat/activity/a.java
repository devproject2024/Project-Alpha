package com.paytm.android.chat.activity;

import com.paytm.android.chat.bean.ChatType;
import com.paytm.android.chat.bean.CtaType;
import net.one97.paytm.common.entity.moneytransfer.requestmoney.RequestMoneyError;

public final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f41754a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f41755b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f41756c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int[] f41757d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int[] f41758e;

    static {
        int[] iArr = new int[CtaType.values().length];
        f41754a = iArr;
        iArr[CtaType.DEEPLINK.ordinal()] = 1;
        f41754a[CtaType.OPENCHATBOTTOMSHEET.ordinal()] = 2;
        int[] iArr2 = new int[CtaType.values().length];
        f41755b = iArr2;
        iArr2[CtaType.UPI_PAY.ordinal()] = 1;
        f41755b[CtaType.UPI_CANCEL.ordinal()] = 2;
        f41755b[CtaType.UPI_DECLINE.ordinal()] = 3;
        f41755b[CtaType.UPI_MARK_AS_SPAM.ordinal()] = 4;
        f41755b[CtaType.UPI_EXPIRED.ordinal()] = 5;
        int[] iArr3 = new int[ChatType.values().length];
        f41756c = iArr3;
        iArr3[ChatType.P2M.ordinal()] = 1;
        f41756c[ChatType.P2P.ordinal()] = 2;
        f41756c[ChatType.P2C.ordinal()] = 3;
        int[] iArr4 = new int[CtaType.values().length];
        f41757d = iArr4;
        iArr4[CtaType.UPI_PAY.ordinal()] = 1;
        f41757d[CtaType.UPI_CANCEL.ordinal()] = 2;
        f41757d[CtaType.UPI_DECLINE.ordinal()] = 3;
        f41757d[CtaType.UPI_MARK_AS_SPAM.ordinal()] = 4;
        f41757d[CtaType.UPI_EXPIRED.ordinal()] = 5;
        int[] iArr5 = new int[RequestMoneyError.values().length];
        f41758e = iArr5;
        iArr5[RequestMoneyError.ERROR_401.ordinal()] = 1;
        f41758e[RequestMoneyError.OTHER.ordinal()] = 2;
        f41758e[RequestMoneyError.NO_UPI_COMBINATION.ordinal()] = 3;
        f41758e[RequestMoneyError.USER_NOT_ONBOARDED.ordinal()] = 4;
    }
}
