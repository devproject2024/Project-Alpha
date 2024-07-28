package net.one97.paytm.addmoney.cvvHelp.c;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.cvvHelp.model.CvvHelpModel;

final class a extends m {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.addmoney.cvvHelp.b.a f48548a;

    /* renamed from: b  reason: collision with root package name */
    private b f48549b;

    /* renamed from: c  reason: collision with root package name */
    private Context f48550c;

    a(Context context, j jVar, net.one97.paytm.addmoney.cvvHelp.b.a aVar, b bVar) {
        super(jVar);
        this.f48550c = context;
        this.f48548a = aVar;
        this.f48549b = bVar;
    }

    public final Fragment getItem(int i2) {
        if (this.f48548a != net.one97.paytm.addmoney.cvvHelp.b.a.ALL) {
            int i3 = AnonymousClass1.f48551a[this.f48548a.ordinal()];
            if (i3 == 1) {
                return c.a(new CvvHelpModel(this.f48550c.getString(R.string.uam_what_cvv), this.f48550c.getString(R.string.uam_cvv_desc), Boolean.FALSE), this.f48549b);
            }
            if (i3 != 2) {
                return null;
            }
            return c.a(new CvvHelpModel(this.f48550c.getString(R.string.uam_what_cvv), this.f48550c.getString(R.string.uam_amex_cvv_desc), Boolean.TRUE), this.f48549b);
        } else if (i2 == 0) {
            return c.a(new CvvHelpModel(this.f48550c.getString(R.string.uam_what_cvv), this.f48550c.getString(R.string.uam_cvv_desc), Boolean.FALSE), this.f48549b);
        } else {
            if (i2 != 1) {
                return null;
            }
            return c.a(new CvvHelpModel(this.f48550c.getString(R.string.uam_what_cvv), this.f48550c.getString(R.string.uam_amex_cvv_desc), Boolean.TRUE), this.f48549b);
        }
    }

    /* renamed from: net.one97.paytm.addmoney.cvvHelp.c.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f48551a = new int[net.one97.paytm.addmoney.cvvHelp.b.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                net.one97.paytm.addmoney.cvvHelp.b.a[] r0 = net.one97.paytm.addmoney.cvvHelp.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f48551a = r0
                int[] r0 = f48551a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.addmoney.cvvHelp.b.a r1 = net.one97.paytm.addmoney.cvvHelp.b.a.NON_AMEX     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f48551a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.addmoney.cvvHelp.b.a r1 = net.one97.paytm.addmoney.cvvHelp.b.a.AMEX     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.cvvHelp.c.a.AnonymousClass1.<clinit>():void");
        }
    }

    public final int getCount() {
        return this.f48548a == net.one97.paytm.addmoney.cvvHelp.b.a.ALL ? 2 : 1;
    }
}
