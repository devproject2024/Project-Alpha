package net.one97.paytm.addmoney.utils;

import net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;

public final class c {
    private static c k;

    /* renamed from: a  reason: collision with root package name */
    public CJPayMethodResponse f48958a;

    /* renamed from: b  reason: collision with root package name */
    public String f48959b;

    /* renamed from: c  reason: collision with root package name */
    public String f48960c;

    /* renamed from: d  reason: collision with root package name */
    public String f48961d;

    /* renamed from: e  reason: collision with root package name */
    public CJRRechargePayment f48962e;

    /* renamed from: f  reason: collision with root package name */
    public CustProductList f48963f;

    /* renamed from: g  reason: collision with root package name */
    public String f48964g;

    /* renamed from: h  reason: collision with root package name */
    public String f48965h;

    /* renamed from: i  reason: collision with root package name */
    public String f48966i;
    public Double j = Double.valueOf(Double.MIN_VALUE);

    private c() {
    }

    public static c a() {
        if (k == null) {
            k = new c();
        }
        return k;
    }

    public final void a(String str, String str2, String str3) {
        this.f48959b = str;
        this.f48960c = str2;
        this.f48961d = str3;
    }
}
