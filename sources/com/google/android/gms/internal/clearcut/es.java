package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.es;
import java.io.IOException;

public class es<M extends es<M>> extends ex {

    /* renamed from: a  reason: collision with root package name */
    protected eu f9344a;

    /* renamed from: b */
    public M clone() throws CloneNotSupportedException {
        M m = (es) super.clone();
        ew.a(this, (es) m);
        return m;
    }

    public /* synthetic */ ex c() throws CloneNotSupportedException {
        return (es) clone();
    }

    /* access modifiers changed from: protected */
    public int a() {
        if (this.f9344a != null) {
            for (int i2 = 0; i2 < this.f9344a.f9348b; i2++) {
                this.f9344a.f9347a[i2].a();
            }
        }
        return 0;
    }

    public void a(eq eqVar) throws IOException {
        if (this.f9344a != null) {
            for (int i2 = 0; i2 < this.f9344a.f9348b; i2++) {
                this.f9344a.f9347a[i2].b();
            }
        }
    }
}
