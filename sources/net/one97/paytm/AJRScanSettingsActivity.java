package net.one97.paytm;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.h;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.l;

public final class AJRScanSettingsActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.r.a f51731a;

    /* renamed from: b  reason: collision with root package name */
    private Switch f51732b;

    /* renamed from: c  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f51733c;

    /* renamed from: d  reason: collision with root package name */
    private final g f51734d = h.a(a.INSTANCE);

    /* renamed from: e  reason: collision with root package name */
    private HashMap f51735e;

    private final z a() {
        return (z) this.f51734d.getValue();
    }

    static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRScanSettingsActivity f51737a;

        c(AJRScanSettingsActivity aJRScanSettingsActivity) {
            this.f51737a = aJRScanSettingsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (!((Boolean) obj).booleanValue()) {
                AJRScanSettingsActivity.a(this.f51737a, false);
                l.c(this.f51737a, false);
                return;
            }
            AJRScanSettingsActivity.a(this.f51737a, true);
            l.c(this.f51737a, true);
        }
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.a<z> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final z invoke() {
            return new z();
        }
    }

    public final void onCreate(Bundle bundle) {
        LiveData liveData;
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_remote_apps_settings);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        this.f51731a = (net.one97.paytm.r.a) am.a((FragmentActivity) this).a(net.one97.paytm.r.a.class);
        this.f51732b = (Switch) findViewById(R.id.security_toggle_button);
        Switch switchR = this.f51732b;
        if (switchR instanceof Switch) {
            if (switchR != null) {
                switchR.setChecked(l.h(this));
            } else {
                throw new u("null cannot be cast to non-null type android.widget.Switch");
            }
        }
        this.f51733c = new b(this);
        Switch switchR2 = this.f51732b;
        if (switchR2 != null) {
            switchR2.setOnCheckedChangeListener(this.f51733c);
        }
        net.one97.paytm.r.a aVar = this.f51731a;
        if (!(aVar == null || (liveData = aVar.f60169a) == null)) {
            liveData.observe(this, new c(this));
        }
        int i2 = R.id.back_image;
        if (this.f51735e == null) {
            this.f51735e = new HashMap();
        }
        View view = (View) this.f51735e.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this.f51735e.put(Integer.valueOf(i2), view);
        }
        ((ImageView) view).setOnClickListener(new d(this));
    }

    static final class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRScanSettingsActivity f51736a;

        b(AJRScanSettingsActivity aJRScanSettingsActivity) {
            this.f51736a = aJRScanSettingsActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            net.one97.paytm.j.a.a((Context) this.f51736a, "allow_remote_desktop_apps", "toggle_clicked", String.valueOf(z), "", "", "");
            if (!z) {
                net.one97.paytm.r.a aVar = this.f51736a.f51731a;
                if (aVar != null) {
                    aVar.a(false);
                    return;
                }
                return;
            }
            AJRScanSettingsActivity.a(this.f51736a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRScanSettingsActivity f51738a;

        d(AJRScanSettingsActivity aJRScanSettingsActivity) {
            this.f51738a = aJRScanSettingsActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.j.a.a((Context) this.f51738a, "allow_remote_desktop_apps", "back_clicked", "", "", "", "");
            this.f51738a.onBackPressed();
        }
    }

    public final void onBackPressed() {
        net.one97.paytm.j.a.a((Context) this, "allow_remote_desktop_apps", "back_clicked", "", "", "", "");
        super.onBackPressed();
    }

    public final void onPause() {
        if (a().isVisible()) {
            a().dismiss();
        }
        super.onPause();
    }

    public static final /* synthetic */ void a(AJRScanSettingsActivity aJRScanSettingsActivity) {
        Switch switchR = aJRScanSettingsActivity.f51732b;
        if (switchR != null) {
            switchR.setChecked(false);
        }
        aJRScanSettingsActivity.a().show(aJRScanSettingsActivity.getSupportFragmentManager().a(), z.class.getName());
    }

    public static final /* synthetic */ void a(AJRScanSettingsActivity aJRScanSettingsActivity, boolean z) {
        Switch switchR = aJRScanSettingsActivity.f51732b;
        if (switchR != null) {
            if (switchR == null) {
                k.a();
            }
            switchR.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            Switch switchR2 = aJRScanSettingsActivity.f51732b;
            if (switchR2 == null) {
                k.a();
            }
            switchR2.setChecked(z);
            Switch switchR3 = aJRScanSettingsActivity.f51732b;
            if (switchR3 == null) {
                k.a();
            }
            switchR3.setOnCheckedChangeListener(aJRScanSettingsActivity.f51733c);
        }
    }
}
