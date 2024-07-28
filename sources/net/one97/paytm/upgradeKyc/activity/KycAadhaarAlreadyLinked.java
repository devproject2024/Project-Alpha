package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.upgradeKyc.EkycDataResponse;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upgradeKyc.utils.l;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class KycAadhaarAlreadyLinked extends UpgradeKycBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<TncData> f65313a;

    /* renamed from: b  reason: collision with root package name */
    private String f65314b;

    /* renamed from: d  reason: collision with root package name */
    private KycAadharEkycDetails.KycResponse f65315d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f65316e;

    public final View a(int i2) {
        if (this.f65316e == null) {
            this.f65316e = new HashMap();
        }
        View view = (View) this.f65316e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65316e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.kyc_aadhaar_already_linked;
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.link_aadhaar_btn) {
            d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("aadhaarDelink") : null;
            if (URLUtil.isValidUrl(a2)) {
                Context context = this;
                String e2 = com.paytm.utility.b.e(context, a2);
                a.C1317a aVar2 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                Map<String, String> a3 = a.C1317a.a(context);
                a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.a l = a.C1317a.a().a(context).a(a.C0715a.GET).a(a3).a((IJRPaytmDataModel) new KYCFetchTnc()).a(e2).c(KycAadhaarAlreadyLinked.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new a(this)).l();
                if (com.paytm.utility.b.c(context)) {
                    com.paytm.utility.b.k(context, getString(R.string.please_wait));
                    l.a();
                    return;
                }
                a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                k.a((Object) l, "ntwrkCall");
                a.C1317a.a(context, l);
                return;
            }
            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url));
        } else if (view != null && view.getId() == R.id.already_linked_cancel_tv) {
            finish();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            String l = com.paytm.utility.b.l((Context) this);
            if (getIntent().hasExtra("aadhaar") && !TextUtils.isEmpty(l) && getIntent().hasExtra("aadhaar")) {
                String stringExtra = getIntent().getStringExtra("aadhaar");
                if (TextUtils.isEmpty(stringExtra) || stringExtra.length() > 14) {
                    if (getIntent().hasExtra("previouslyLinkedNum")) {
                        TextView textView = (TextView) a(R.id.aadhaar_already_linked_tv);
                        k.a((Object) textView, "aadhaar_already_linked_tv");
                        textView.setText(getString(R.string.vid_already_linked, new Object[]{getIntent().getStringExtra("previouslyLinkedNum")}));
                    }
                    TextView textView2 = (TextView) a(R.id.proceed_tolink_tv);
                    k.a((Object) textView2, "proceed_tolink_tv");
                    textView2.setText(getString(R.string.proceed_to_link_vid_to_another_acnt, new Object[]{stringExtra, l}));
                } else {
                    if (getIntent().hasExtra("previouslyLinkedNum")) {
                        TextView textView3 = (TextView) a(R.id.aadhaar_already_linked_tv);
                        k.a((Object) textView3, "aadhaar_already_linked_tv");
                        textView3.setText(getString(R.string.aadhaar_already_linked, new Object[]{getIntent().getStringExtra("previouslyLinkedNum")}));
                    }
                    TextView textView4 = (TextView) a(R.id.proceed_tolink_tv);
                    k.a((Object) textView4, "proceed_tolink_tv");
                    textView4.setText(getString(R.string.proceed_to_link_aadhaar_to_another_acnt, new Object[]{stringExtra, l}));
                }
            }
            if (getIntent().hasExtra("reference_number")) {
                this.f65314b = getIntent().getStringExtra("reference_number");
            }
            if (getIntent().hasExtra("aadhaarData")) {
                this.f65315d = (KycAadharEkycDetails.KycResponse) getIntent().getSerializableExtra("aadhaarData");
            }
        }
        View.OnClickListener onClickListener = this;
        ((Button) a(R.id.link_aadhaar_btn)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.already_linked_cancel_tv)).setOnClickListener(onClickListener);
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycAadhaarAlreadyLinked f65317a;

        a(KycAadhaarAlreadyLinked kycAadhaarAlreadyLinked) {
            this.f65317a = kycAadhaarAlreadyLinked;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            KycAadhaarAlreadyLinked.a(this.f65317a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            l.a();
            if (!l.a((Context) this.f65317a, networkCustomError)) {
                KycAadhaarAlreadyLinked.a(this.f65317a, networkCustomError);
            }
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycAadhaarAlreadyLinked f65318a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NetworkCustomError f65319b;

        b(KycAadhaarAlreadyLinked kycAadhaarAlreadyLinked, NetworkCustomError networkCustomError) {
            this.f65318a = kycAadhaarAlreadyLinked;
            this.f65319b = networkCustomError;
        }

        public final void run() {
            com.paytm.utility.b.p();
            NetworkCustomError networkCustomError = this.f65319b;
            if (networkCustomError == null) {
                return;
            }
            if (networkCustomError.getMessage() == null || !p.a(this.f65319b.getMessage(), "parsing_error", true)) {
                KycAadhaarAlreadyLinked kycAadhaarAlreadyLinked = this.f65318a;
                com.paytm.utility.b.b((Context) kycAadhaarAlreadyLinked, kycAadhaarAlreadyLinked.getResources().getString(R.string.network_error_heading), this.f65318a.getResources().getString(R.string.network_error_message) + " " + this.f65319b.getUrl());
                return;
            }
            com.paytm.utility.b.d((Context) this.f65318a, this.f65319b.getUrl(), "");
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycAadhaarAlreadyLinked f65320a;

        c(KycAadhaarAlreadyLinked kycAadhaarAlreadyLinked) {
            this.f65320a = kycAadhaarAlreadyLinked;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            KycAadhaarAlreadyLinked.a(this.f65320a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            l.a();
            if (!l.a((Context) this.f65320a, networkCustomError)) {
                KycAadhaarAlreadyLinked.a(this.f65320a, networkCustomError);
            }
        }
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycAadhaarAlreadyLinked f65321a;

        d(KycAadhaarAlreadyLinked kycAadhaarAlreadyLinked) {
            this.f65321a = kycAadhaarAlreadyLinked;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            KycAadhaarAlreadyLinked.a(this.f65321a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            l.a();
            l.a((Context) this.f65321a, networkCustomError);
        }
    }

    public static final /* synthetic */ void a(KycAadhaarAlreadyLinked kycAadhaarAlreadyLinked, IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        Class<KycAadhaarAlreadyLinked> cls = KycAadhaarAlreadyLinked.class;
        String str2 = null;
        if (iJRPaytmDataModel instanceof KYCFetchTnc) {
            KycAadhaarAlreadyLinked kycAadhaarAlreadyLinked2 = kycAadhaarAlreadyLinked;
            KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) iJRPaytmDataModel;
            if (kYCFetchTnc.getStatus() == null || !p.a(kYCFetchTnc.getStatus(), "error", true)) {
                if (kYCFetchTnc.getStatus() != null && p.a(kYCFetchTnc.getStatus(), "success", true) && kYCFetchTnc.getTncDataList() != null) {
                    kycAadhaarAlreadyLinked2.f65313a = kYCFetchTnc.getTncDataList();
                    d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                    if (d.a.a() != null) {
                        str2 = net.one97.paytm.upgradeKyc.helper.d.a("kyc_tnc_v2_url");
                    }
                    if (!URLUtil.isValidUrl(str2)) {
                        com.paytm.utility.b.b((Context) kycAadhaarAlreadyLinked2, kycAadhaarAlreadyLinked2.getResources().getString(R.string.error), kycAadhaarAlreadyLinked2.getResources().getString(R.string.msg_invalid_url));
                        return;
                    }
                    Context context = kycAadhaarAlreadyLinked2;
                    String e2 = com.paytm.utility.b.e(context, str2);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mode", "clickthrough");
                        if (kycAadhaarAlreadyLinked2.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
                            jSONObject.put("deviceId", com.paytm.utility.b.e((Context) kycAadhaarAlreadyLinked2));
                            if (kycAadhaarAlreadyLinked2.f65313a != null) {
                                JSONArray jSONArray = new JSONArray();
                                ArrayList<TncData> arrayList = kycAadhaarAlreadyLinked2.f65313a;
                                if (arrayList == null) {
                                    k.a();
                                }
                                Iterator<TncData> it2 = arrayList.iterator();
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
                            String jSONObject3 = jSONObject.toString();
                            k.a((Object) jSONObject3, "requestBody.toString()");
                            a.C1317a aVar2 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                            Map<String, String> a2 = a.C1317a.a(context);
                            a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                            com.paytm.network.a l = a.C1317a.a().a(context).a(a.C0715a.PUT).a(a2).a((IJRPaytmDataModel) new KYCTncAccept()).a(e2).b(jSONObject3).c(cls.getName()).a(a.b.SILENT).a((com.paytm.network.listener.b) new d(kycAadhaarAlreadyLinked2)).l();
                            if (com.paytm.utility.b.c(context)) {
                                com.paytm.utility.b.k(context, kycAadhaarAlreadyLinked2.getString(R.string.please_wait));
                                l.a();
                                return;
                            }
                            com.paytm.utility.b.p();
                            a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                            k.a((Object) l, "ntwrkCall");
                            a.C1317a.a(context, l);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (!TextUtils.isEmpty(kYCFetchTnc.getMessage())) {
                com.paytm.utility.b.p();
                com.paytm.utility.b.b((Context) kycAadhaarAlreadyLinked2, kycAadhaarAlreadyLinked2.getString(R.string.error), kYCFetchTnc.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof EkycDataResponse) {
            com.paytm.utility.b.p();
            EkycDataResponse ekycDataResponse = (EkycDataResponse) iJRPaytmDataModel;
            if (ekycDataResponse.getStatusCode() == 200) {
                return;
            }
            if (!TextUtils.isEmpty(ekycDataResponse.getMessage())) {
                com.paytm.utility.b.b((Context) kycAadhaarAlreadyLinked, kycAadhaarAlreadyLinked.getResources().getString(R.string.error), ekycDataResponse.getMessage());
            } else {
                com.paytm.utility.b.b((Context) kycAadhaarAlreadyLinked, kycAadhaarAlreadyLinked.getResources().getString(R.string.error), kycAadhaarAlreadyLinked.getString(R.string.msg_invalid_url));
            }
        } else if (iJRPaytmDataModel instanceof KYCTncAccept) {
            KycAadhaarAlreadyLinked kycAadhaarAlreadyLinked3 = kycAadhaarAlreadyLinked;
            KYCTncAccept kYCTncAccept = (KYCTncAccept) iJRPaytmDataModel;
            if (kYCTncAccept.getStatus() == null || !p.a(kYCTncAccept.getStatus(), "error", true)) {
                if (kYCTncAccept.getStatus() != null && p.a(kYCTncAccept.getStatus(), "success", true) && k.a((Object) kYCTncAccept.getResponseCode(), (Object) "2004")) {
                    String h2 = j.h(kycAadhaarAlreadyLinked3.getApplicationContext());
                    if (TextUtils.isEmpty(h2) || !p.a(h2, "true", true)) {
                        d.a aVar5 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                        if (d.a.a() != null) {
                            str2 = net.one97.paytm.upgradeKyc.helper.d.a("saveEkycRefNumber");
                        }
                        if (!URLUtil.isValidUrl(str2)) {
                            com.paytm.utility.b.b((Context) kycAadhaarAlreadyLinked3, kycAadhaarAlreadyLinked3.getResources().getString(R.string.error), kycAadhaarAlreadyLinked3.getResources().getString(R.string.msg_invalid_url));
                            return;
                        }
                        Context context2 = kycAadhaarAlreadyLinked3;
                        String e4 = com.paytm.utility.b.e(context2, str2);
                        Map hashMap = new HashMap();
                        String a3 = com.paytm.utility.d.a(context2);
                        k.a((Object) a3, "CJRNetUtility.getSSOToken(this)");
                        hashMap.put("session_token", a3);
                        hashMap.put("Content-Type", "application/json");
                        JSONObject jSONObject4 = new JSONObject();
                        try {
                            if (!TextUtils.isEmpty(kycAadhaarAlreadyLinked3.f65314b)) {
                                jSONObject4.put("uuid", kycAadhaarAlreadyLinked3.f65314b);
                            }
                            str = jSONObject4.toString();
                            k.a((Object) str, "reqJsonObject.toString()");
                        } catch (JSONException unused) {
                            str = "";
                        }
                        a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                        com.paytm.network.a l2 = a.C1317a.a().a(context2).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new EkycDataResponse()).a(e4).b(str).c(cls.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c(kycAadhaarAlreadyLinked3)).l();
                        if (com.paytm.utility.b.c(context2)) {
                            com.paytm.utility.b.k(context2, kycAadhaarAlreadyLinked3.getString(R.string.please_wait));
                            l2.a();
                            return;
                        }
                        a.C1317a aVar7 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                        k.a((Object) l2, "ntwrkCall");
                        a.C1317a.a(context2, l2);
                        return;
                    }
                    Intent intent = new Intent(kycAadhaarAlreadyLinked3, KycParentConsentRequired.class);
                    KycAadharEkycDetails.KycResponse kycResponse = kycAadhaarAlreadyLinked3.f65315d;
                    if (kycResponse != null) {
                        intent.putExtra("aadhaarData", kycResponse);
                    }
                    intent.putExtra("reference_number", kycAadhaarAlreadyLinked3.f65314b);
                    kycAadhaarAlreadyLinked3.startActivity(intent);
                    kycAadhaarAlreadyLinked3.finish();
                }
            } else if (!TextUtils.isEmpty(kYCTncAccept.getMessage())) {
                com.paytm.utility.b.p();
                com.paytm.utility.b.b((Context) kycAadhaarAlreadyLinked3, kycAadhaarAlreadyLinked3.getString(R.string.error), kYCTncAccept.getMessage());
            }
        }
    }

    public static final /* synthetic */ void a(KycAadhaarAlreadyLinked kycAadhaarAlreadyLinked, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.p();
        if (networkCustomError == null) {
            return;
        }
        if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (p.a(networkCustomError.getMessage(), "410", true) || p.a(networkCustomError.getMessage(), UpiUtils.AUTHENTICATION_FAILURE_401, true))) {
            a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            a.C1317a.a((Context) kycAadhaarAlreadyLinked, networkCustomError);
        } else if (networkCustomError.getMessage() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(kycAadhaarAlreadyLinked.getResources().getString(R.string.network_error_message));
            sb.append(" ");
            sb.append(networkCustomError.getUrl());
            kycAadhaarAlreadyLinked.runOnUiThread(new b(kycAadhaarAlreadyLinked, networkCustomError));
        }
    }
}
