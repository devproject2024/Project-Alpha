package com.alipay.imobile.network.quake.h.c;

import com.paytm.business.merchantprofile.common.utility.AppConstants;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f14888a;

    /* renamed from: b  reason: collision with root package name */
    private int f14889b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14890c;

    /* renamed from: d  reason: collision with root package name */
    private final float f14891d;

    public a() {
        this(AppConstants.START_OTP_FLOW, 0);
    }

    public a(int i2, int i3) {
        this.f14888a = i2;
        this.f14890c = i3;
        this.f14891d = 1.0f;
    }

    public final int a() {
        return this.f14888a;
    }

    public final int b() {
        return this.f14889b;
    }

    public final void a(com.alipay.mobile.b.b.a aVar) throws com.alipay.mobile.b.b.a {
        boolean z = true;
        this.f14889b++;
        int i2 = this.f14888a;
        this.f14888a = (int) (((float) i2) + (((float) i2) * this.f14891d));
        if (this.f14889b > this.f14890c) {
            z = false;
        }
        if (!z) {
            throw aVar;
        }
    }
}
