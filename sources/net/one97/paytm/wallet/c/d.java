package net.one97.paytm.wallet.c;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.i.f;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f69987a;

    /* renamed from: b  reason: collision with root package name */
    private b f69988b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f69989c;

    /* renamed from: d  reason: collision with root package name */
    private TabLayout f69990d;

    public enum b {
        AMEX,
        NON_AMEX,
        ALL
    }

    public static d a(b bVar) {
        d dVar = new d();
        dVar.f69988b = bVar;
        return dVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener($$Lambda$d$aF0GeGxpU_6DL4dBhtf2MdZ6eU.INSTANCE);
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f69987a = layoutInflater.inflate(R.layout.cvv_help_layout_acdmoney, viewGroup, false);
        this.f69989c = (ViewPager) this.f69987a.findViewById(R.id.vp_cvv_help);
        this.f69989c.setAdapter(new a(getChildFragmentManager(), this.f69988b, this));
        this.f69990d = (TabLayout) this.f69987a.findViewById(R.id.tab_layout);
        this.f69990d.setupWithViewPager(this.f69989c, true);
        return this.f69987a;
    }

    class a extends m implements net.one97.paytm.wallet.newdesign.addmoney.c.a {

        /* renamed from: b  reason: collision with root package name */
        private b f69993b;

        /* renamed from: c  reason: collision with root package name */
        private d f69994c;

        a(j jVar, b bVar, d dVar) {
            super(jVar);
            this.f69993b = bVar;
            this.f69994c = dVar;
        }

        public final Fragment getItem(int i2) {
            Bundle bundle = new Bundle();
            if (this.f69993b != b.ALL) {
                int i3 = AnonymousClass1.f69991a[this.f69993b.ordinal()];
                if (i3 == 1) {
                    f a2 = f.a((net.one97.paytm.wallet.newdesign.addmoney.c.a) this);
                    bundle.putBoolean(b.NON_AMEX.name(), true);
                    a2.setArguments(bundle);
                    return a2;
                } else if (i3 != 2) {
                    return null;
                } else {
                    f a3 = f.a((net.one97.paytm.wallet.newdesign.addmoney.c.a) this);
                    bundle.putBoolean(b.AMEX.name(), true);
                    a3.setArguments(bundle);
                    return a3;
                }
            } else if (i2 == 0) {
                f a4 = f.a((net.one97.paytm.wallet.newdesign.addmoney.c.a) this);
                bundle.putBoolean(b.ALL.name(), true);
                a4.setArguments(bundle);
                return a4;
            } else if (i2 != 1) {
                return null;
            } else {
                f a5 = f.a((net.one97.paytm.wallet.newdesign.addmoney.c.a) this);
                bundle.putBoolean(b.AMEX.name(), true);
                a5.setArguments(bundle);
                return a5;
            }
        }

        public final int getCount() {
            return this.f69993b == b.ALL ? 2 : 1;
        }

        public final void a() {
            d dVar = this.f69994c;
            if (dVar != null && dVar.isAdded()) {
                this.f69994c.dismiss();
            }
        }
    }

    /* renamed from: net.one97.paytm.wallet.c.d$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f69991a = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                net.one97.paytm.wallet.c.d$b[] r0 = net.one97.paytm.wallet.c.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f69991a = r0
                int[] r0 = f69991a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.wallet.c.d$b r1 = net.one97.paytm.wallet.c.d.b.NON_AMEX     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f69991a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.wallet.c.d$b r1 = net.one97.paytm.wallet.c.d.b.AMEX     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.c.d.AnonymousClass1.<clinit>():void");
        }
    }
}
