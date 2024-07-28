package net.one97.paytm.v2.features.offerdetail.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.offerdetail.ui.a;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRCashBackBaseActivity;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.g;

public final class CashbackCompaignGameDetail extends AJRCashBackBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f20463a = "";

    /* renamed from: d  reason: collision with root package name */
    private boolean f20464d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f20465e;

    public final View a(int i2) {
        if (this.f20465e == null) {
            this.f20465e = new HashMap();
        }
        View view = (View) this.f20465e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f20465e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cashback_compaign_game_detail);
        a(true);
        if (getIntent() != null) {
            if (getIntent().hasExtra("showHomeOnBack")) {
                this.f20464d = getIntent().getBooleanExtra("showHomeOnBack", true);
            }
            if (getIntent().hasExtra("activityName")) {
                String stringExtra = getIntent().getStringExtra("activityName");
                k.a((Object) stringExtra, "intent.getStringExtra(Ca…kConstants.ACTIVITY_NAME)");
                this.f20463a = stringExtra;
            }
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            q a2 = getSupportFragmentManager().a();
            int i2 = R.id.container;
            a.C0372a aVar = a.f20485b;
            k.c(intent, "intent");
            Bundle bundle2 = new Bundle();
            if (intent.hasExtra("gameid")) {
                bundle2.putString("gameid", intent.getStringExtra("gameid"));
            }
            if (intent.hasExtra("campaignid")) {
                bundle2.putString("campaignid", intent.getStringExtra("campaignid"));
            }
            if (intent.hasExtra("campaign")) {
                bundle2.putSerializable("campaign", intent.getSerializableExtra("campaign"));
            }
            bundle2.putBoolean("isActivated", intent.getBooleanExtra("isActivated", false));
            if (intent.hasExtra("supercashGame")) {
                bundle2.putSerializable("supercashGame", intent.getSerializableExtra("supercashGame"));
            }
            a aVar2 = new a();
            aVar2.setArguments(bundle2);
            a2.b(i2, aVar2, "gameCampaignDetail").a((String) null).b();
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        if (getIntent().hasExtra("isActivated")) {
            boolean z = false;
            if (getIntent().getBooleanExtra("isActivated", false)) {
                if (this.f20463a.length() > 0) {
                    z = true;
                }
                if (!z || (!this.f20463a.equals("net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity") && !this.f20463a.equals("net.one97.paytm.v2.features.offerdetail.ui.CashBackOfferDetailActivity") && !this.f20463a.equals("net.one97.paytm.v2.features.cashbackoffers.ui.OfferListActivity"))) {
                    g gVar = g.f20891a;
                    g.a(true);
                    setResult(-1, getIntent());
                    finish();
                }
                finish();
                d.a aVar = d.f20859a;
                d.a.a(this.f20463a, (Context) this);
                return;
            }
        }
        if (this.f20464d) {
            d.a aVar2 = d.f20859a;
            d.a.a((Activity) this);
            return;
        }
        finish();
    }

    public final void a(boolean z) {
        if (z) {
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.loadMore));
        } else {
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.loadMore));
        }
    }
}
