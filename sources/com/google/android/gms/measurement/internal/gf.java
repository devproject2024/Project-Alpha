package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.zzv;

public final class gf {

    /* renamed from: a  reason: collision with root package name */
    final Context f12022a;

    /* renamed from: b  reason: collision with root package name */
    String f12023b;

    /* renamed from: c  reason: collision with root package name */
    String f12024c;

    /* renamed from: d  reason: collision with root package name */
    String f12025d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f12026e;

    /* renamed from: f  reason: collision with root package name */
    long f12027f;

    /* renamed from: g  reason: collision with root package name */
    zzv f12028g;

    /* renamed from: h  reason: collision with root package name */
    boolean f12029h = true;

    public gf(Context context, zzv zzv) {
        s.a(context);
        Context applicationContext = context.getApplicationContext();
        s.a(applicationContext);
        this.f12022a = applicationContext;
        if (zzv != null) {
            this.f12028g = zzv;
            this.f12023b = zzv.f10964f;
            this.f12024c = zzv.f10963e;
            this.f12025d = zzv.f10962d;
            this.f12029h = zzv.f10961c;
            this.f12027f = zzv.f10960b;
            if (zzv.f10965g != null) {
                this.f12026e = Boolean.valueOf(zzv.f10965g.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
