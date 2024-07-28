package net.one97.paytm.wallet.c;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import net.one97.paytm.wallet.c.c;
import net.one97.paytm.wallet.f.a;

final class b extends m implements a {

    /* renamed from: a  reason: collision with root package name */
    private c.a f69980a;

    /* renamed from: b  reason: collision with root package name */
    private c f69981b;

    b(j jVar, c.a aVar, c cVar) {
        super(jVar);
        this.f69980a = aVar;
        this.f69981b = cVar;
    }

    public final Fragment getItem(int i2) {
        Bundle bundle = new Bundle();
        if (this.f69980a != c.a.ALL) {
            int i3 = AnonymousClass1.f69982a[this.f69980a.ordinal()];
            if (i3 == 1) {
                e a2 = e.a((a) this);
                bundle.putBoolean(c.a.NON_AMEX.name(), true);
                a2.setArguments(bundle);
                return a2;
            } else if (i3 != 2) {
                return null;
            } else {
                e a3 = e.a((a) this);
                bundle.putBoolean(c.a.AMEX.name(), true);
                a3.setArguments(bundle);
                return a3;
            }
        } else if (i2 == 0) {
            e a4 = e.a((a) this);
            bundle.putBoolean(c.a.ALL.name(), true);
            a4.setArguments(bundle);
            return a4;
        } else if (i2 != 1) {
            return null;
        } else {
            e a5 = e.a((a) this);
            bundle.putBoolean(c.a.AMEX.name(), true);
            a5.setArguments(bundle);
            return a5;
        }
    }

    /* renamed from: net.one97.paytm.wallet.c.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f69982a = new int[c.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                net.one97.paytm.wallet.c.c$a[] r0 = net.one97.paytm.wallet.c.c.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f69982a = r0
                int[] r0 = f69982a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.wallet.c.c$a r1 = net.one97.paytm.wallet.c.c.a.NON_AMEX     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f69982a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.wallet.c.c$a r1 = net.one97.paytm.wallet.c.c.a.AMEX     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.c.b.AnonymousClass1.<clinit>():void");
        }
    }

    public final int getCount() {
        return this.f69980a == c.a.ALL ? 2 : 1;
    }

    public final void a() {
        c cVar = this.f69981b;
        if (cVar != null && cVar.isAdded()) {
            this.f69981b.dismiss();
        }
    }
}
