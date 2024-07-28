package net.one97.paytm.v2.features.cashbackoffers.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.cashbackoffers.ui.a;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRCashBackBaseActivity;

public final class OfferListActivity extends AJRCashBackBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f20382a;

    public final View a(int i2) {
        if (this.f20382a == null) {
            this.f20382a = new HashMap();
        }
        View view = (View) this.f20382a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f20382a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_offer_list);
        q a2 = getSupportFragmentManager().a();
        k.a((Object) a2, "supportFragmentManager.beginTransaction()");
        int i2 = R.id.fragmentContainer;
        a.b bVar = a.f20401i;
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        k.c(intent, "intent");
        Bundle bundle2 = new Bundle();
        bundle2.putInt("offer_type_card", intent.getIntExtra("offer_type_card", 0));
        bundle2.putString("header_image_url", intent.getStringExtra("header_image_url"));
        bundle2.putString("activityName", intent.getStringExtra("activityName"));
        bundle2.putString("offertag", intent.getStringExtra("offertag"));
        bundle2.putString("titleName", intent.getStringExtra("titleName"));
        a aVar = new a();
        aVar.setArguments(bundle2);
        a2.b(i2, aVar);
        a2.c();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        a aVar = (a) supportFragmentManager.c(R.id.fragmentContainer);
        if (aVar != null) {
            aVar.onRefresh();
        }
    }

    public final void onBackPressed() {
        Boolean bool;
        a aVar = (a) getSupportFragmentManager().c(R.id.fragmentContainer);
        if (aVar != null) {
            if (aVar.f20407g != null) {
                net.one97.paytm.v2.features.b.b.a aVar2 = aVar.f20407g;
                if (aVar2 != null) {
                    aVar2.a();
                }
                aVar.f20407g = null;
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            if (bool != null ? bool.booleanValue() : false) {
                return;
            }
        }
        super.onBackPressed();
    }
}
