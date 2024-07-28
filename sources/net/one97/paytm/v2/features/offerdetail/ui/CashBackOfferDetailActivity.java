package net.one97.paytm.v2.features.offerdetail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.v2.features.offerdetail.ui.b;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRCashBackBaseActivity;
import net.one97.paytm.vipcashback.f.d;

public final class CashBackOfferDetailActivity extends AJRCashBackBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20461a;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f20462d;

    public final View a(int i2) {
        if (this.f20462d == null) {
            this.f20462d = new HashMap();
        }
        View view = (View) this.f20462d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f20462d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cash_back_new_category_offers);
        a(true);
        if (getIntent().hasExtra("showHomeOnBack")) {
            this.f20461a = getIntent().getBooleanExtra("showHomeOnBack", false);
        }
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        q a2 = getSupportFragmentManager().a();
        int i2 = R.id.container;
        b.a aVar = b.f20504c;
        k.c(intent, "intent");
        Bundle bundle2 = new Bundle();
        if (intent.hasExtra("campaignid")) {
            bundle2.putString("campaignid", intent.getStringExtra("campaignid"));
        }
        if (intent.hasExtra("campaign")) {
            bundle2.putSerializable("campaign", intent.getSerializableExtra("campaign"));
        }
        if (intent.hasExtra("activityName")) {
            bundle2.putString("activityName", intent.getStringExtra("activityName"));
        }
        b bVar = new b();
        bVar.setArguments(bundle2);
        a2.b(i2, bVar, "offerDetailFragment").a((String) null).c();
    }

    public final void onBackPressed() {
        if (this.f20461a) {
            d.a aVar = d.f20859a;
            d.a.a((Activity) this);
            return;
        }
        finish();
    }

    public final void a(boolean z) {
        if (z) {
            a.a((LottieAnimationView) a(R.id.loadMoreLoader));
        } else {
            a.b((LottieAnimationView) a(R.id.loadMoreLoader));
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 105) {
            setResult(-1, getIntent());
            finish();
        }
    }
}
