package com.travel.bus.busticket.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.pojo.busticket.ReferralGetCodeBody;
import com.travel.bus.pojo.busticket.ReferralGetCodeContentBody;
import com.travel.bus.pojo.busticket.ReferralGetPromocodeModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AJRTravelReferralHomeActivity extends CJRActionBarBaseActivity implements View.OnClickListener, b {

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f21971a;

    /* renamed from: b  reason: collision with root package name */
    private ReferralGetPromocodeModel f21972b;

    /* renamed from: c  reason: collision with root package name */
    private ReferralGetCodeBody f21973c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f21974d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21975e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f21976f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f21977g;

    /* renamed from: h  reason: collision with root package name */
    private EditText f21978h;

    /* renamed from: i  reason: collision with root package name */
    private Button f21979i;
    private ScrollView j;
    private ImageView k;
    private RelativeLayout l;
    private String m;
    private String n;
    private String o;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.referral_screen_title);
        setContentView(R.layout.pre_b_activity_travels_referral);
        this.j = (ScrollView) findViewById(R.id.header_main_layout);
        this.f21974d = (TextView) findViewById(R.id.referral_content_header);
        this.f21975e = (TextView) findViewById(R.id.inviteText);
        this.f21976f = (TextView) findViewById(R.id.bookText);
        this.f21977g = (TextView) findViewById(R.id.cashbackText);
        this.f21978h = (EditText) findViewById(R.id.referEditText);
        this.f21979i = (Button) findViewById(R.id.invite_friend_button);
        this.l = (RelativeLayout) findViewById(R.id.terms_and_condition);
        this.f21971a = (ProgressBar) findViewById(R.id.th_progress_bar_main);
        this.k = (ImageView) findViewById(R.id.view_earnings);
        this.f21971a.setVisibility(0);
        this.f21979i.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.k.setOnClickListener(this);
        setBackButtonEnabled(true);
        a();
        this.m = getIntent().getStringExtra("previousScreen");
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "travel_referral");
        hashMap.put("event_action", SDKConstants.PG_SCREEN_LOADED);
        String str = this.m;
        if (str != null) {
            hashMap.put("event_label", str);
        }
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Referrer Homepage");
        hashMap.put("vertical_name", "travel");
        a.a();
        a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    public void onClick(View view) {
        if (view == this.l) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "travel_referral");
            hashMap.put("event_action", "tnc_clicked");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/Referrer Homepage");
            hashMap.put("vertical_name", "travel");
            a.a();
            a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
            Intent intent = new Intent(this, AJRReferTermsAndConditionActivity.class);
            intent.putExtra("termsConditionText", this.n);
            startActivity(intent);
        } else if (view == this.f21979i) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_category", "travel_referral");
            hashMap2.put("event_action", "invite_friends_clicked");
            hashMap2.put("user_id", com.paytm.utility.b.n((Context) this));
            hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Referrer Homepage");
            hashMap2.put("vertical_name", "travel");
            a.a();
            a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap2, (Context) this);
            if (this.o != null) {
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("text/plain");
                String str = this.o;
                intent2.putExtra("android.intent.extra.SUBJECT", "Subject Here");
                intent2.putExtra("android.intent.extra.TEXT", str);
                HashMap hashMap3 = new HashMap();
                hashMap3.put("event_category", "travel_referral");
                hashMap3.put("event_action", "invite_popup_source_clicked");
                hashMap3.put("user_id", com.paytm.utility.b.n((Context) this));
                hashMap3.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/referrer_popup_screen");
                hashMap3.put("vertical_name", "travel");
                a.a();
                a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap3, (Context) this);
                startActivity(Intent.createChooser(intent2, "Paytm : Travel"));
            }
        } else if (view == this.k) {
            HashMap hashMap4 = new HashMap();
            hashMap4.put("event_category", "travel_referral");
            hashMap4.put("event_action", "view_earnings_clicked");
            hashMap4.put("user_id", com.paytm.utility.b.n((Context) this));
            hashMap4.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/referrer_homepage");
            hashMap4.put("vertical_name", "travel");
            a.a();
            a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap4, (Context) this);
            startActivity(new Intent(this, AJRReferViewEarningsActivity.class));
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (com.paytm.utility.b.r((Context) this)) {
            a.a();
            String uri = Uri.parse(a.b().x()).buildUpon().appendQueryParameter("screen", "ref").build().toString();
            if (!TextUtils.isEmpty(uri)) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
                hashMap.put("userid", com.paytm.utility.b.n((Context) this));
                hashMap.put("screen", "ref");
                if (com.paytm.utility.b.c((Context) this)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(500);
                    arrayList.add(401);
                    com.paytm.network.a aVar = new com.paytm.network.a(this, a.C0715a.GET, uri, hashMap, (String) null, new ReferralGetPromocodeModel(), this);
                    aVar.f42860d = true;
                    aVar.a();
                    return;
                }
                c();
                return;
            }
            return;
        }
        b();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof ReferralGetPromocodeModel) {
            this.f21971a.setVisibility(8);
            this.j.setVisibility(0);
            this.f21972b = (ReferralGetPromocodeModel) iJRPaytmDataModel;
            ReferralGetPromocodeModel referralGetPromocodeModel = this.f21972b;
            if (referralGetPromocodeModel != null && referralGetPromocodeModel.getGetCodeBody() != null) {
                this.f21973c = this.f21972b.getGetCodeBody();
                ReferralGetCodeBody referralGetCodeBody = this.f21973c;
                if (referralGetCodeBody != null) {
                    if (referralGetCodeBody.getSmsText() != null) {
                        this.o = this.f21973c.getSmsText();
                    }
                    if (!(this.f21973c.getTermsConditions() == null || this.f21973c.getTermsConditions().getTermsMessage() == null)) {
                        this.n = this.f21973c.getTermsConditions().getTermsMessage();
                    }
                    if (this.f21973c.getContentHeader() != null) {
                        this.f21974d.setText(this.f21973c.getContentHeader());
                    }
                    if (this.f21973c.getReferralCode() != null) {
                        this.f21978h.setText(this.f21973c.getReferralCode());
                    }
                    if (this.f21973c.getGetCodeContentBody() != null) {
                        ReferralGetCodeContentBody getCodeContentBody = this.f21973c.getGetCodeContentBody();
                        if (getCodeContentBody.getInvite() != null) {
                            this.f21975e.setText(getCodeContentBody.getInvite());
                        }
                        if (getCodeContentBody.getBook() != null) {
                            this.f21976f.setText(getCodeContentBody.getBook());
                        }
                        if (getCodeContentBody.getCashback() != null) {
                            this.f21977g.setText(getCodeContentBody.getCashback());
                        }
                    }
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (i2 == 401) {
            b();
        } else if (i2 == 500) {
            com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
        }
    }

    private void b() {
        Intent intent = new Intent();
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, intent, 4);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 4 && i3 == -1) {
            boolean z = true;
            if (com.travel.bus.b.a.a(getApplicationContext()).b("sso_token=", "", true).length() <= 0) {
                z = false;
            }
            if (z) {
                a();
                return;
            }
            return;
        }
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                AJRTravelReferralHomeActivity.this.a();
            }
        });
        builder.show();
    }
}
