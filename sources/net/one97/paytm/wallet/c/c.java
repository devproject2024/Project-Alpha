package net.one97.paytm.wallet.c;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f69983a;

    /* renamed from: b  reason: collision with root package name */
    private a f69984b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f69985c;

    /* renamed from: d  reason: collision with root package name */
    private TabLayout f69986d;

    public enum a {
        AMEX,
        NON_AMEX,
        ALL
    }

    public static c a(a aVar) {
        c cVar = new c();
        cVar.f69984b = aVar;
        return cVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener($$Lambda$c$nLh58liPARyAPgZ9s3SOJczngxM.INSTANCE);
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f69983a = layoutInflater.inflate(R.layout.cvv_help_layout_offline, viewGroup, false);
        this.f69985c = (ViewPager) this.f69983a.findViewById(R.id.vp_cvv_help);
        this.f69985c.setAdapter(new b(getChildFragmentManager(), this.f69984b, this));
        this.f69986d = (TabLayout) this.f69983a.findViewById(R.id.tab_layout);
        this.f69986d.setupWithViewPager(this.f69985c, true);
        return this.f69983a;
    }
}
