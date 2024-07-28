package net.one97.travelpass.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.google.android.play.core.splitcompat.a;
import com.travel.utils.q;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.travelpass.R;
import net.one97.travelpass.b.aa;
import net.one97.travelpass.ui.fragment.TravelPassHomeFragment;

public final class TravelPassHomeActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private aa f30573a;

    /* renamed from: b  reason: collision with root package name */
    private TravelPassHomeFragment f30574b;

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        q.a(context);
        super.attachBaseContext(context);
        Context context2 = this;
        a.a(context2);
        a.b(context2);
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        a.a(context);
        a.b(context);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f30573a = (aa) f.a(this, R.layout.tp_home_activity_view);
        this.f30574b = new TravelPassHomeFragment();
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        androidx.fragment.app.q a2 = supportFragmentManager.a();
        k.a((Object) a2, "fragmentManager.beginTransaction()");
        int i2 = R.id.fragment_container;
        TravelPassHomeFragment travelPassHomeFragment = this.f30574b;
        if (travelPassHomeFragment == null) {
            k.a();
        }
        a2.a(i2, (Fragment) travelPassHomeFragment);
        a2.b();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        TravelPassHomeFragment travelPassHomeFragment = this.f30574b;
        if (travelPassHomeFragment != null) {
            travelPassHomeFragment.onActivityResult(i2, i3, intent);
        }
        super.onActivityResult(i2, i3, intent);
    }
}
