package net.one97.paytm.p2mNewDesign.d;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;

public class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f51057a;

    /* renamed from: b  reason: collision with root package name */
    private a f51058b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f51059c;

    /* renamed from: d  reason: collision with root package name */
    private TabLayout f51060d;

    public enum a {
        AMEX,
        NON_AMEX,
        ALL
    }

    public static b a(a aVar) {
        b bVar = new b();
        bVar.f51058b = aVar;
        return bVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener($$Lambda$b$9LnpBwGSEKbQEAjUMe1266GBaAY.INSTANCE);
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f51057a = layoutInflater.inflate(R.layout.cvv_help_layout_offline, viewGroup, false);
        this.f51059c = (ViewPager) this.f51057a.findViewById(R.id.vp_cvv_help);
        this.f51059c.setAdapter(new a(getChildFragmentManager(), this.f51058b, this));
        this.f51060d = (TabLayout) this.f51057a.findViewById(R.id.tab_layout);
        this.f51060d.setupWithViewPager(this.f51059c, true);
        return this.f51057a;
    }
}
