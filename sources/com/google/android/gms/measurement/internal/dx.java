package com.google.android.gms.measurement.internal;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

final class dx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f11820a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f11821b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Object f11822c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Object f11823d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Object f11824e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ dy f11825f;

    dx(dy dyVar, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.f11825f = dyVar;
        this.f11820a = i2;
        this.f11821b = str;
        this.f11822c = obj;
        this.f11823d = obj2;
        this.f11824e = obj3;
    }

    public final void run() {
        eh b2 = this.f11825f.y.b();
        if (!b2.v()) {
            this.f11825f.a(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.f11825f.f11826a == 0) {
            if (this.f11825f.H_().a()) {
                this.f11825f.f11826a = 'C';
            } else {
                this.f11825f.f11826a = 'c';
            }
        }
        if (this.f11825f.f11827b < 0) {
            this.f11825f.f11827b = 19000;
        }
        char charAt = "01VDIWEA?".charAt(this.f11820a);
        char c2 = this.f11825f.f11826a;
        long j = this.f11825f.f11827b;
        String a2 = dy.a(true, this.f11821b, this.f11822c, this.f11823d, this.f11824e);
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(c2);
        sb.append(j);
        sb.append(AppConstants.COLON);
        sb.append(a2);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.f11821b.substring(0, TarConstants.EOF_BLOCK);
        }
        b2.f11860c.a(sb2);
    }
}
