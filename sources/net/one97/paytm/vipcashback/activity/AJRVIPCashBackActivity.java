package net.one97.paytm.vipcashback.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.v2.features.b.b.a;
import net.one97.paytm.v2.features.cashbacklanding.c.d;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2;

public final class AJRVIPCashBackActivity extends AJRCashBackBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20646a = true;

    /* renamed from: d  reason: collision with root package name */
    private FJRCashbackFragmentV2 f20647d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f20648e;

    public final View a(int i2) {
        if (this.f20648e == null) {
            this.f20648e = new HashMap();
        }
        View view = (View) this.f20648e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f20648e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        FJRCashbackFragmentV2 fJRCashbackFragmentV2 = (FJRCashbackFragmentV2) supportFragmentManager.c(R.id.container);
        if (fJRCashbackFragmentV2 != null) {
            Fragment c2 = fJRCashbackFragmentV2.getChildFragmentManager().c(fJRCashbackFragmentV2.f20904b);
            if (c2 != null) {
                ((d) c2).a();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.ui.ScratchCardHomeFragment");
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vip_cashback);
        Intent intent = getIntent();
        boolean z = intent == null || !intent.hasExtra("offertag");
        this.f20646a = getIntent().getBooleanExtra("show_home_on_back", true);
        if (bundle == null) {
            FJRCashbackFragmentV2.a aVar = FJRCashbackFragmentV2.f20902c;
            this.f20647d = FJRCashbackFragmentV2.a.a(z, getIntent().getStringExtra("screen"));
            q a2 = getSupportFragmentManager().a();
            k.a((Object) a2, "supportFragmentManager.beginTransaction()");
            int i2 = R.id.container;
            FJRCashbackFragmentV2 fJRCashbackFragmentV2 = this.f20647d;
            if (fJRCashbackFragmentV2 == null) {
                k.a();
            }
            a2.a(i2, (Fragment) fJRCashbackFragmentV2).c();
        }
        if (getWindow() != null) {
            Window window = getWindow();
            if (window == null) {
                k.a();
            }
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().clearFlags(67108864);
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().setStatusBarColor(b.c(this, net.one97.paytm.common.assets.R.color.color_002d90));
            }
        }
    }

    public final void onBackPressed() {
        Fragment c2;
        FJRCashbackFragmentV2 fJRCashbackFragmentV2 = this.f20647d;
        if (fJRCashbackFragmentV2 != null) {
            boolean z = false;
            if (!(fJRCashbackFragmentV2 == null || (c2 = fJRCashbackFragmentV2.getChildFragmentManager().c(fJRCashbackFragmentV2.f20904b)) == null || !(c2 instanceof d))) {
                d dVar = (d) c2;
                if ((dVar.getActivity() instanceof AJRVIPCashBackActivity) && dVar.f20161a != null) {
                    a aVar = dVar.f20161a;
                    if (aVar != null) {
                        aVar.a();
                    }
                    dVar.f20161a = null;
                    z = true;
                }
            }
            if (z) {
                return;
            }
        }
        if (this.f20646a) {
            net.one97.paytm.vipcashback.c.a.b().openLandingActivity(this);
        } else {
            super.onBackPressed();
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!this.f20646a || menuItem == null || menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        net.one97.paytm.vipcashback.c.a.b().openLandingActivity(this);
        return true;
    }
}
