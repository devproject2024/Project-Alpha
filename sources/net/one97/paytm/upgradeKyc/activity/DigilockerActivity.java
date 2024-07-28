package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.upgradeKyc.DigilockerFetchConsent;
import net.one97.paytm.common.entity.upgradeKyc.DigilockerInfo;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.c.a;
import net.one97.paytm.upgradeKyc.d.m;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DigilockerActivity extends UpgradeKycBaseActivity implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<TncData> f65274a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<TncData> f65275b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f65276d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f65277e = false;

    /* renamed from: f  reason: collision with root package name */
    private TextView f65278f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f65279g;

    /* renamed from: h  reason: collision with root package name */
    private LottieAnimationView f65280h;

    /* renamed from: i  reason: collision with root package name */
    private View.OnClickListener f65281i = $$Lambda$DigilockerActivity$OvRHb4FTOi8npKaROEdkREtNSOM.INSTANCE;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g() {
    }

    public void onClick(View view) {
        if (view.getId() == R.id.kyc_activity_digilocker_button_proceed) {
            e();
        } else if (view.getId() == R.id.kyc_activity_digilocker_tv_tnc) {
            this.f65277e = false;
            if (this.f65274a != null) {
                f();
                return;
            }
            this.f65276d = true;
            d();
        }
    }

    private void d() {
        String str;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("DigilockerTnCFetchURL");
        } else {
            str = null;
        }
        if (URLUtil.isValidUrl(str)) {
            String e2 = b.e((Context) this, str);
            a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            Map<String, String> a2 = a.C1317a.a(this);
            a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.b a3 = a.C1317a.a();
            a3.f42877a = this;
            a3.f42879c = a.C0715a.GET;
            a3.f42882f = a2;
            a3.f42885i = new KYCFetchTnc();
            a3.f42880d = e2;
            a3.o = DigilockerActivity.class.getName();
            a3.n = a.b.SILENT;
            a3.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    DigilockerActivity.this.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    l.a();
                    l.a((Context) DigilockerActivity.this, networkCustomError);
                }
            };
            com.paytm.network.a l = a3.l();
            if (b.c((Context) this)) {
                net.one97.paytm.common.widgets.a.a(this.f65280h);
                l.a();
                return;
            }
            a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            a.C1317a.a((Context) this, l);
            return;
        }
        b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.digilocker);
        this.f65279g = (LinearLayout) findViewById(R.id.kyc_activity_digilocker_lyt_main);
        findViewById(R.id.kyc_activity_digilocker_tv_tnc).setOnClickListener(this);
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.textViewCenter);
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            roboTextView.setText(d.a("DigilockerShortDescription"));
        }
        this.f65280h = (LottieAnimationView) findViewById(R.id.kyc_loader);
        this.f65278f = (TextView) findViewById(R.id.kyc_activity_digilocker_tv_tnc_heading);
        ((Button) findViewById(R.id.kyc_activity_digilocker_button_proceed)).setOnClickListener(this);
        String str = null;
        d.a aVar3 = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar4 = d.f66026a;
            d.a.a();
            str = d.a("digilockerConsentFetch");
        }
        if (URLUtil.isValidUrl(str)) {
            String e2 = b.e((Context) this, str);
            a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            Map<String, String> a2 = a.C1317a.a(this);
            a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.b a3 = a.C1317a.a();
            a3.f42877a = this;
            a3.f42879c = a.C0715a.GET;
            a3.f42882f = a2;
            a3.f42885i = new DigilockerFetchConsent();
            a3.f42880d = e2;
            a3.o = DigilockerActivity.class.getName();
            a3.n = a.b.SILENT;
            a3.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    DigilockerActivity.this.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    l.a();
                    l.a((Context) DigilockerActivity.this, networkCustomError);
                }
            };
            com.paytm.network.a l = a3.l();
            if (b.c((Context) this)) {
                net.one97.paytm.common.widgets.a.a(this.f65280h);
                l.a();
                return;
            }
            a.C1317a aVar7 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            a.C1317a.a((Context) this, l);
            return;
        }
        b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url));
    }

    private void e() {
        if (this.f65274a == null) {
            d();
            this.f65277e = true;
            net.one97.paytm.common.widgets.a.b(this.f65280h);
            return;
        }
        this.f65277e = false;
        String str = null;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("kyc_tnc_user_url");
        }
        if (!URLUtil.isValidUrl(str)) {
            net.one97.paytm.common.widgets.a.b(this.f65280h);
            b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
            return;
        }
        String e2 = b.e((Context) this, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", "clickthrough");
            getSystemService(ContactColumn.PHONE_NUMBER);
            jSONObject.put("deviceId", b.e((Context) this));
            if (this.f65274a != null) {
                this.f65274a.addAll(this.f65275b);
                JSONArray jSONArray = new JSONArray();
                Iterator<TncData> it2 = this.f65274a.iterator();
                while (it2.hasNext()) {
                    TncData next = it2.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("code", next.getCode());
                        jSONObject2.put("version", next.getVersion());
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("tnCList", jSONArray);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        String jSONObject3 = jSONObject.toString();
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        Map<String, String> a2 = a.C1317a.a(this);
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a3 = a.C1317a.a();
        a3.f42877a = this;
        a3.f42879c = a.C0715a.PUT;
        a3.f42882f = a2;
        a3.f42885i = new KYCTncAccept();
        a3.f42880d = e2;
        a3.f42884h = jSONObject3;
        a3.o = DigilockerActivity.class.getName();
        a3.n = a.b.SILENT;
        a3.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                DigilockerActivity.this.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                l.a();
                l.a((Context) DigilockerActivity.this, networkCustomError);
            }
        };
        com.paytm.network.a l = a3.l();
        if (b.c((Context) this)) {
            net.one97.paytm.common.widgets.a.a(this.f65280h);
            l.a();
            return;
        }
        net.one97.paytm.common.widgets.a.b(this.f65280h);
        a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        a.C1317a.a((Context) this, l);
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        TncData tncData;
        if (iJRPaytmDataModel instanceof KYCFetchTnc) {
            if (this.f65276d) {
                net.one97.paytm.common.widgets.a.b(this.f65280h);
            }
            KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) iJRPaytmDataModel;
            if (kYCFetchTnc.getStatus() == null || !kYCFetchTnc.getStatus().equalsIgnoreCase("error")) {
                if (kYCFetchTnc.getStatus() != null && kYCFetchTnc.getStatus().equalsIgnoreCase("success") && kYCFetchTnc.getTncDataList() != null) {
                    this.f65274a = kYCFetchTnc.getTncDataList();
                    if (this.f65276d) {
                        f();
                    }
                    if (this.f65277e) {
                        e();
                    }
                }
            } else if (!TextUtils.isEmpty(kYCFetchTnc.getMessage())) {
                b.b((Context) this, getString(R.string.error), kYCFetchTnc.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof DigilockerFetchConsent) {
            net.one97.paytm.common.widgets.a.b(this.f65280h);
            DigilockerFetchConsent digilockerFetchConsent = (DigilockerFetchConsent) iJRPaytmDataModel;
            if (digilockerFetchConsent.getStatus() == null || !digilockerFetchConsent.getStatus().equalsIgnoreCase("error")) {
                if (digilockerFetchConsent.getStatus() != null && digilockerFetchConsent.getStatus().equalsIgnoreCase("success") && digilockerFetchConsent.getTncDataList() != null) {
                    this.f65275b = digilockerFetchConsent.getTncDataList();
                    ArrayList<TncData> arrayList = this.f65275b;
                    if (arrayList != null && arrayList.size() > 0 && (tncData = this.f65275b.get(0)) != null && !TextUtils.isEmpty(tncData.getCode()) && tncData.getCode().equalsIgnoreCase("DigilockerConsent") && !TextUtils.isEmpty(tncData.getDescription())) {
                        this.f65278f.setText(tncData.getDescription() + StringUtility.NEW_LINE + getString(R.string.digilocker_you_have_read));
                        this.f65279g.setVisibility(0);
                    }
                }
            } else if (!TextUtils.isEmpty(digilockerFetchConsent.getMessage())) {
                b.b((Context) this, getString(R.string.error), digilockerFetchConsent.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof KYCTncAccept) {
            net.one97.paytm.common.widgets.a.b(this.f65280h);
            KYCTncAccept kYCTncAccept = (KYCTncAccept) iJRPaytmDataModel;
            if (kYCTncAccept.getStatus() == null || !kYCTncAccept.getStatus().equalsIgnoreCase("error")) {
                if (kYCTncAccept.getStatus() != null && kYCTncAccept.getStatus().equalsIgnoreCase("success") && kYCTncAccept.getResponseCode().equals("2004")) {
                    net.one97.paytm.upgradeKyc.c.b bVar = new net.one97.paytm.upgradeKyc.c.b(this, this);
                    if (!isFinishing() && !isDestroyed()) {
                        bVar.show();
                    }
                }
            } else if (!TextUtils.isEmpty(kYCTncAccept.getMessage())) {
                b.b((Context) this, getString(R.string.error), kYCTncAccept.getMessage());
            }
        }
    }

    private void f() {
        ArrayList<TncData> arrayList = this.f65274a;
        if (arrayList != null && arrayList.size() > 0) {
            m a2 = m.a(this.f65274a);
            a2.f65713a = $$Lambda$DigilockerActivity$EqFbbIXOkiszGHAfXD9MoyaDWK8.INSTANCE;
            a2.show(getSupportFragmentManager(), "KycTNCFragment");
        }
    }

    public final void a(DigilockerInfo digilockerInfo) {
        if (!TextUtils.isEmpty(digilockerInfo.getUrl())) {
            Intent intent = null;
            try {
                e.a aVar = e.f66028b;
                intent = new Intent(this, Class.forName(e.a.b().d()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            if (intent != null) {
                intent.putExtra("url", digilockerInfo.getUrl());
                intent.putExtra("title", getString(R.string.digilocker));
                intent.putExtra("url_post_data", digilockerInfo.getPostData());
                intent.putExtra("is_url_to_post", true);
                startActivity(intent);
                finish();
            }
        } else if (!TextUtils.isEmpty(digilockerInfo.getErrorErrorMessage())) {
            b.b((Context) this, getString(R.string.error), digilockerInfo.getErrorErrorMessage());
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        a.C1317a.a((Context) this, networkCustomError);
    }

    public final int a() {
        return R.layout.kyc_activity_digilocker;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }
}
