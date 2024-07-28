package net.one97.paytm.wallet.newdesign.independencedaypostcard;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.wallet.CJRPostcardSentData;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.independencedaypostcard.b;
import net.one97.paytm.wallet.newdesign.independencedaypostcard.c;

public class IndependancePostCardMainActivity extends PaytmActivity implements b.a, c.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f70949c = IndependancePostCardMainActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f70950a;

    /* renamed from: b  reason: collision with root package name */
    com.google.zxing.client.android.b f70951b;

    /* renamed from: d  reason: collision with root package name */
    private Fragment f70952d;

    /* renamed from: e  reason: collision with root package name */
    private c f70953e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_post_card_independance_main);
        this.f70950a = getIntent().getStringExtra("scan");
        getSupportActionBar().f();
        if (this.f70953e == null) {
            this.f70953e = new c();
        }
        if (this.f70952d == null) {
            a((Fragment) this.f70953e);
        }
    }

    private void a(Fragment fragment) {
        try {
            if (this.f70952d == null || fragment == null || fragment != this.f70952d) {
                q a2 = getSupportFragmentManager().a();
                a2.b(R.id.postcardwithoutfilterfragment, fragment, fragment.getClass().getSimpleName());
                a2.a(fragment.getClass().getSimpleName());
                a2.c();
                this.f70952d = fragment;
            }
        } catch (Exception e2) {
            com.paytm.utility.q.d(String.valueOf(e2));
        }
    }

    public void onBackPressed() {
        Fragment c2 = getSupportFragmentManager().c(c.class.getSimpleName());
        b bVar = (b) getSupportFragmentManager().c(b.class.getSimpleName());
        a aVar = (a) getSupportFragmentManager().c(a.class.getSimpleName());
        if (c2 == null || !c2.isVisible()) {
            if (bVar == null || !bVar.isVisible()) {
                if (aVar != null && aVar.isVisible()) {
                    getSupportFragmentManager().d();
                    getSupportFragmentManager().d();
                    return;
                }
            } else if (bVar.f70963a.getVisibility() == 0) {
                getSupportFragmentManager().d();
                return;
            } else {
                return;
            }
        }
        finish();
    }

    public final void a(CJRPostcardSentData cJRPostcardSentData) {
        a((Fragment) a.a(cJRPostcardSentData));
    }

    public final void a(String str) {
        this.f70951b = new com.google.zxing.client.android.b(this, R.raw.received);
        this.f70951b.b();
        a((Fragment) b.a(str, this.f70950a));
    }

    public void onDestroy() {
        super.onDestroy();
        com.google.zxing.client.android.b bVar = this.f70951b;
        if (bVar != null) {
            bVar.close();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 104 && i3 == -1) {
            Fragment c2 = getSupportFragmentManager().c(b.class.getSimpleName());
            if (c2 instanceof b) {
                b bVar = (b) c2;
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("intent_extra_wallet_order_id");
                    intent.getStringExtra("intent_extra_wallet_email");
                    intent.getStringExtra("intent_extra_wallet_phone_number");
                    intent.getStringExtra("intent_extra_wallet_payee_sso_id");
                    intent.getStringExtra("intent_extra_wallet_send_money_amount");
                    intent.getStringExtra("intent_extra_wallet_comment");
                    intent.getStringExtra("intent_extra_wallet_request_code");
                    intent.getStringExtra("intent_extra_wallet_is_to_verify");
                    intent.getStringExtra("intent_extra_wallet_is_limit_applicable");
                    if (intent.getBooleanExtra("intent_extra_wallet_is_payment_cancelled", false)) {
                        bVar.f70963a.setVisibility(0);
                        bVar.getActivity().onBackPressed();
                    } else if (bVar.f70964b != null) {
                        bVar.f70964b.b(stringExtra);
                    }
                }
            }
        }
    }
}
