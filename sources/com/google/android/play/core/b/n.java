package com.google.android.play.core.b;

import android.content.Intent;
import com.google.android.play.core.d.aa;
import com.google.android.play.core.d.as;
import com.google.android.play.core.splitcompat.a;
import java.util.Iterator;
import java.util.List;

final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f37319a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f37320b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ o f37321c;

    n(o oVar, List list, aa aaVar) {
        this.f37321c = oVar;
        this.f37319a = list;
        this.f37320b = aaVar;
    }

    public final void run() {
        boolean z;
        try {
            p pVar = this.f37321c.f37323b;
            Iterator it2 = this.f37319a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                if (!pVar.f37327a.a(((Intent) it2.next()).getStringExtra("split_id")).exists()) {
                    z = false;
                    break;
                }
            }
            if (!z) {
                o oVar = this.f37321c;
                List list = this.f37319a;
                aa aaVar = this.f37320b;
                Integer a2 = oVar.a(list);
                if (a2 == null) {
                    return;
                }
                if (a2.intValue() == 0) {
                    aaVar.b();
                } else {
                    aaVar.a(a2.intValue());
                }
            } else {
                o oVar2 = this.f37321c;
                aa aaVar2 = this.f37320b;
                try {
                    if (a.c(as.a(oVar2.f37322a))) {
                        aaVar2.a();
                    } else {
                        aaVar2.a(-12);
                    }
                } catch (Exception unused) {
                    aaVar2.a(-12);
                }
            }
        } catch (Exception unused2) {
            this.f37320b.a(-11);
        }
    }
}
