package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.k;
import java.util.ArrayList;
import java.util.Map;

final class ah extends aq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ag f8412a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<a.f, ai> f8413b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ah(ag agVar, Map<a.f, ai> map) {
        super(agVar, (byte) 0);
        this.f8412a = agVar;
        this.f8413b = map;
    }

    public final void a() {
        k kVar = new k(this.f8412a.f8406d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a.f next : this.f8413b.keySet()) {
            if (!this.f8413b.get(next).f8414a) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        int i2 = -1;
        int i3 = 0;
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = arrayList;
            int size = arrayList3.size();
            while (i3 < size) {
                Object obj = arrayList3.get(i3);
                i3++;
                i2 = kVar.a(this.f8412a.f8405c, (a.f) obj);
                if (i2 != 0) {
                    break;
                }
            }
        } else {
            ArrayList arrayList4 = arrayList2;
            int size2 = arrayList4.size();
            while (i3 < size2) {
                Object obj2 = arrayList4.get(i3);
                i3++;
                i2 = kVar.a(this.f8412a.f8405c, (a.f) obj2);
                if (i2 == 0) {
                    break;
                }
            }
        }
        if (i2 != 0) {
            this.f8412a.f8403a.a((ax) new ak(this, this.f8412a, new ConnectionResult(i2, (PendingIntent) null)));
            return;
        }
        if (this.f8412a.f8408f && this.f8412a.f8407e != null) {
            this.f8412a.f8407e.u();
        }
        for (a.f next2 : this.f8413b.keySet()) {
            c.C0130c cVar = this.f8413b.get(next2);
            if (kVar.a(this.f8412a.f8405c, next2) != 0) {
                this.f8412a.f8403a.a((ax) new aj(this.f8412a, cVar));
            } else {
                next2.a(cVar);
            }
        }
    }
}
