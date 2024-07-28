package net.one97.paytm.p2mNewDesign.d;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import net.one97.paytm.p2mNewDesign.d.b;

final class a extends m implements net.one97.paytm.wallet.f.a {

    /* renamed from: a  reason: collision with root package name */
    private b.a f51054a;

    /* renamed from: b  reason: collision with root package name */
    private b f51055b;

    a(j jVar, b.a aVar, b bVar) {
        super(jVar);
        this.f51054a = aVar;
        this.f51055b = bVar;
    }

    public final Fragment getItem(int i2) {
        Bundle bundle = new Bundle();
        if (this.f51054a != b.a.ALL) {
            int i3 = AnonymousClass1.f51056a[this.f51054a.ordinal()];
            if (i3 == 1) {
                c a2 = c.a((net.one97.paytm.wallet.f.a) this);
                bundle.putBoolean(b.a.NON_AMEX.name(), true);
                a2.setArguments(bundle);
                return a2;
            } else if (i3 != 2) {
                return null;
            } else {
                c a3 = c.a((net.one97.paytm.wallet.f.a) this);
                bundle.putBoolean(b.a.AMEX.name(), true);
                a3.setArguments(bundle);
                return a3;
            }
        } else if (i2 == 0) {
            c a4 = c.a((net.one97.paytm.wallet.f.a) this);
            bundle.putBoolean(b.a.ALL.name(), true);
            a4.setArguments(bundle);
            return a4;
        } else if (i2 != 1) {
            return null;
        } else {
            c a5 = c.a((net.one97.paytm.wallet.f.a) this);
            bundle.putBoolean(b.a.AMEX.name(), true);
            a5.setArguments(bundle);
            return a5;
        }
    }

    /* renamed from: net.one97.paytm.p2mNewDesign.d.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f51056a = new int[b.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                net.one97.paytm.p2mNewDesign.d.b$a[] r0 = net.one97.paytm.p2mNewDesign.d.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51056a = r0
                int[] r0 = f51056a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.p2mNewDesign.d.b$a r1 = net.one97.paytm.p2mNewDesign.d.b.a.NON_AMEX     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f51056a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.p2mNewDesign.d.b$a r1 = net.one97.paytm.p2mNewDesign.d.b.a.AMEX     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.a.AnonymousClass1.<clinit>():void");
        }
    }

    public final int getCount() {
        return this.f51054a == b.a.ALL ? 2 : 1;
    }

    public final void a() {
        b bVar = this.f51055b;
        if (bVar != null && bVar.isAdded()) {
            this.f51055b.dismiss();
        }
    }
}
