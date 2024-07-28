package net.one97.paytm.wallet.newdesign.postcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.google.zxing.client.android.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.base.BaseActivity;
import net.one97.paytm.common.entity.CJRPostcardFetchRecipientList;
import net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.PostcardThemesResponseDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.utils.n;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.c;
import net.one97.paytm.wallet.newdesign.postcard.b.d;
import net.one97.paytm.wallet.newdesign.postcard.b.f;
import net.one97.paytm.wallet.newdesign.postcard.b.g;

public class PostCardMainActivity extends BaseActivity implements d.b, f.b, g.b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f71151b = PostCardMainActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    b f71152a;

    /* renamed from: c  reason: collision with root package name */
    private Fragment f71153c;

    /* renamed from: e  reason: collision with root package name */
    private d f71154e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<CJRPostcardFetchRecipientList> f71155f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(3);
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
        setContentView(R.layout.activity_post_card_main);
        getSupportActionBar().f();
        a(com.paytm.utility.b.r((Context) this));
    }

    private void a(boolean z) {
        if (z) {
            c();
        } else {
            net.one97.paytm.wallet.communicator.b.a().callLoginActivity(this);
        }
    }

    private void c() {
        if (this.f71154e == null) {
            this.f71154e = new d();
        }
        if (this.f71153c == null) {
            a((Fragment) this.f71154e);
        }
    }

    private void a(Fragment fragment) {
        try {
            if (this.f71153c == null || fragment == null || fragment != this.f71153c) {
                q a2 = getSupportFragmentManager().a();
                a2.b(R.id.postcardwithoutfilterfragment, fragment, fragment.getClass().getSimpleName());
                a2.a(fragment.getClass().getSimpleName());
                a2.c();
                this.f71153c = fragment;
            }
        } catch (Exception e2) {
            com.paytm.utility.q.d(String.valueOf(e2));
        }
    }

    public final void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel, boolean z, boolean z2) {
        a((Fragment) g.a(postcardThemesResponseDataModel, z, z2));
    }

    public final void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel, boolean z, Intent intent) {
        a((Fragment) g.a(postcardThemesResponseDataModel, z, intent.getStringExtra("postcard_beneficiary_name"), intent.getStringExtra("postcard_beneficiary_account"), intent.getStringExtra("postcard_beneficiary_amount"), intent.getIntExtra("postcard_type", n.aW)));
    }

    public final void a() {
        startActivity(new Intent(this, HowItWorksActivity.class));
    }

    public final void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel) {
        if (this.f71153c instanceof g) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_themes_data", postcardThemesResponseDataModel);
            ((g) this.f71153c).a(bundle);
        }
    }

    public void onBackPressed() {
        Fragment c2 = getSupportFragmentManager().c(g.class.getSimpleName());
        f fVar = (f) getSupportFragmentManager().c(f.class.getSimpleName());
        if (c2 != null && c2.isVisible()) {
            getSupportFragmentManager().d();
        } else if (fVar == null || !fVar.isVisible()) {
            finish();
        } else if (fVar.f71305a.getVisibility() == 0) {
            getSupportFragmentManager().d();
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, IconMetaDataModel iconMetaDataModel, boolean z) {
        this.f71152a = new b(this, R.raw.received);
        this.f71152a.b();
        a((Fragment) f.a(str, str2, str3, str4, str5, iconMetaDataModel, z));
    }

    private void d() {
        d dVar = (d) getSupportFragmentManager().c(d.class.getSimpleName());
        if (dVar != null && dVar.isVisible()) {
            dVar.f71279a.setVisibility(4);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || net.one97.paytm.wallet.communicator.b.a().isMinKycDone(getApplicationContext()) || !com.paytm.utility.b.r(getApplicationContext())) {
            if (i2 == 104) {
                if (i3 == -1) {
                    Fragment c2 = getSupportFragmentManager().c(f.class.getSimpleName());
                    if (c2 instanceof f) {
                        f fVar = (f) c2;
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
                                fVar.f71305a.setVisibility(0);
                                fVar.getActivity().onBackPressed();
                            } else if (fVar.f71306b != null) {
                                fVar.f71306b.b(stringExtra);
                            }
                        }
                    }
                } else {
                    super.onBackPressed();
                }
            } else if (i2 == 1010 && i3 == -1) {
                d dVar = (d) getSupportFragmentManager().c(d.class.getSimpleName());
                if (dVar != null) {
                    if (intent == null) {
                        dVar.b(false);
                    } else if (!com.paytm.utility.b.c((Context) dVar.getActivity())) {
                        dVar.d();
                    } else {
                        dVar.f71280b.a(dVar.f71281c, dVar.f71282e, intent);
                    }
                }
                d();
            } else if (i2 == 301) {
                if (i3 != -1 || !com.paytm.utility.b.r((Context) this)) {
                    finish();
                } else {
                    a(true);
                }
            }
            if (i2 == 1010) {
                d();
            }
            if (i2 == 131) {
                getSupportFragmentManager().d();
                return;
            }
            Fragment c3 = getSupportFragmentManager().c(f.class.getSimpleName());
            if (c3 instanceof f) {
                c3.isVisible();
                return;
            }
            return;
        }
        try {
            c a2 = net.one97.paytm.wallet.communicator.b.a();
            Context applicationContext = getApplicationContext();
            a2.checkDeepLinking(applicationContext, net.one97.paytm.wallet.communicator.b.a().deeplinkSchemaName() + "min_kyc?call_back_url=" + URLEncoder.encode("paytmmp://cash_wallet?featuretype=lifafa", AppConstants.UTF_8) + "&vertical=" + "wallet");
        } catch (UnsupportedEncodingException e2) {
            com.paytm.utility.q.d(String.valueOf(e2));
        }
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f71152a;
        if (bVar != null) {
            bVar.close();
        }
    }

    public final void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "wallet_lifafa");
        hashMap.put("event_action", str);
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "wallet/lifafa");
        hashMap.put("VERTICAL_NAME", "wallet");
        net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap);
    }

    public final void b() {
        Intent intent = new Intent(this, MyPostcardsActivity.class);
        intent.putExtra("recipientListObj", this.f71155f);
        startActivityForResult(intent, IuserActions.SCROLL_MAIN_RV);
    }
}
