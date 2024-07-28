package com.travel.bus.busticket.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.a.ae;
import com.travel.bus.busticket.fragment.k;
import com.travel.bus.pojo.busticket.ReferViewEarningBody;
import com.travel.bus.pojo.busticket.ReferViewEarningModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AJRReferViewEarningsActivity extends CJRActionBarBaseActivity implements b {

    /* renamed from: a  reason: collision with root package name */
    public ActionBar f21962a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f21963b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f21964c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f21965d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21966e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f21967f;

    /* renamed from: g  reason: collision with root package name */
    private k f21968g;

    /* renamed from: h  reason: collision with root package name */
    private ReferViewEarningBody f21969h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f21970i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_refer_view_earnings);
        this.f21970i = (LinearLayout) findViewById(R.id.root_layout);
        this.f21963b = (ProgressBar) findViewById(R.id.progressBarHorizontal);
        this.f21964c = (ProgressBar) findViewById(R.id.progressBar_cyclic);
        this.f21966e = (TextView) findViewById(R.id.view_earnings_balance);
        this.f21967f = (TextView) findViewById(R.id.reached_max_limit_text);
        this.f21965d = (TextView) findViewById(R.id.view_earnings_total);
        this.f21968g = new k(this);
        q a2 = getSupportFragmentManager().a();
        a2.b(R.id.view_earnings_frg_container, this.f21968g, (String) null);
        a2.b();
        this.f21962a = getSupportActionBar();
        this.f21962a.a(false);
        setBackButtonEnabled(true);
        a();
    }

    private void a() {
        if (com.paytm.utility.b.r((Context) this)) {
            this.f21964c.setVisibility(0);
            a.a();
            String uri = Uri.parse(a.b().y()).buildUpon().appendQueryParameter("screen", "ref").build().toString();
            if (!TextUtils.isEmpty(uri)) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
                hashMap.put("userid", com.paytm.utility.b.n((Context) this));
                if (com.paytm.utility.b.c((Context) this)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(500);
                    arrayList.add(401);
                    com.paytm.network.a aVar = new com.paytm.network.a(this, a.C0715a.GET, uri, hashMap, (String) null, new ReferViewEarningModel(), this);
                    aVar.f42860d = true;
                    aVar.a();
                    return;
                }
                b();
            }
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof ReferViewEarningModel) {
            ReferViewEarningModel referViewEarningModel = (ReferViewEarningModel) iJRPaytmDataModel;
            if (!(referViewEarningModel == null || referViewEarningModel.getBody() == null)) {
                this.f21969h = referViewEarningModel.getBody();
                k kVar = this.f21968g;
                ReferViewEarningBody referViewEarningBody = this.f21969h;
                if (referViewEarningBody == null || referViewEarningBody.getResultItem() == null || referViewEarningBody.getResultItem().size() <= 0) {
                    kVar.f22295e.setVisibility(8);
                    kVar.f22293c.setVisibility(0);
                } else {
                    kVar.f22296f = referViewEarningBody.getResultItem().size();
                    kVar.f22294d = new ae(kVar.f22292b, referViewEarningBody.getResultItem());
                    com.travel.bus.a.a();
                    kVar.f22291a.setLayoutManager(new LinearLayoutManager(com.travel.bus.a.b().D()));
                    kVar.f22291a.setAdapter(kVar.f22294d);
                    kVar.f22293c.setVisibility(8);
                }
            }
            this.f21964c.setVisibility(8);
            this.f21970i.setVisibility(0);
            Drawable mutate = this.f21963b.getProgressDrawable().mutate();
            mutate.setColorFilter(R.color.color_view_earnings_progressbar, PorterDuff.Mode.SRC_IN);
            this.f21963b.setProgressDrawable(mutate);
            ReferViewEarningBody referViewEarningBody2 = this.f21969h;
            if (referViewEarningBody2 != null) {
                if (referViewEarningBody2.getTotalCashBackEarned() >= 0) {
                    TextView textView = this.f21965d;
                    textView.setText(getResources().getString(R.string.rs) + " " + String.valueOf(this.f21969h.getTotalCashBackEarned()));
                }
                if (this.f21969h.getMaxCbMonthlyLimit() >= 0 && this.f21969h.getCurremtMomthCBEarned() >= 0) {
                    TextView textView2 = this.f21966e;
                    textView2.setText(getResources().getString(R.string.rs) + " " + String.valueOf(this.f21969h.getCurremtMomthCBEarned()) + " / " + String.valueOf(this.f21969h.getMaxCbMonthlyLimit()));
                    this.f21963b.setMax(this.f21969h.getMaxCbMonthlyLimit());
                    this.f21963b.setProgress(this.f21969h.getCurremtMomthCBEarned());
                    if (this.f21969h.getCurremtMomthCBEarned() == this.f21969h.getMaxCbMonthlyLimit()) {
                        this.f21967f.setText(getResources().getString(R.string.view_earnings_max_limit_text));
                    } else if (this.f21969h.getContentBody() != null) {
                        this.f21967f.setText(this.f21969h.getContentBody());
                    }
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (i2 == 401) {
            Intent intent = new Intent();
            com.travel.bus.a.a();
            com.travel.bus.a.b().a((Context) this, intent, 4);
        } else if (i2 == 500) {
            com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "travel_referral");
        hashMap.put("event_action", "back_button_clicked");
        hashMap.put("event_label", "referrer_earning_screen");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Referrer_View_Earnings");
        hashMap.put("vertical_name", "travel");
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
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
            }
        }
    }

    private void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRReferViewEarningsActivity.this.a(dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        a();
    }
}
