package com.google.android.gms.internal.location;

import android.content.ContentProviderClient;
import android.content.Context;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.d;
import com.google.android.gms.location.e;
import java.util.HashMap;
import java.util.Map;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final z<i> f10384a;

    /* renamed from: b  reason: collision with root package name */
    final Context f10385b;

    /* renamed from: c  reason: collision with root package name */
    boolean f10386c = false;

    /* renamed from: d  reason: collision with root package name */
    final Map<k.a<e>, r> f10387d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    final Map<k.a<Object>, q> f10388e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    final Map<k.a<d>, n> f10389f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private ContentProviderClient f10390g = null;

    public m(Context context, z<i> zVar) {
        this.f10385b = context;
        this.f10384a = zVar;
    }

    /* access modifiers changed from: package-private */
    public final r a(k<e> kVar) {
        r rVar;
        synchronized (this.f10387d) {
            rVar = this.f10387d.get(kVar.f8618b);
            if (rVar == null) {
                rVar = new r(kVar);
            }
            this.f10387d.put(kVar.f8618b, rVar);
        }
        return rVar;
    }

    public final n b(k<d> kVar) {
        n nVar;
        synchronized (this.f10389f) {
            nVar = this.f10389f.get(kVar.f8618b);
            if (nVar == null) {
                nVar = new n(kVar);
            }
            this.f10389f.put(kVar.f8618b, nVar);
        }
        return nVar;
    }
}
