package net.one97.paytm.h5.consent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.h5.b.c;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.paytm_finance.R;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ConsentActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    String f16939a = "";

    /* renamed from: b  reason: collision with root package name */
    private HashMap f16940b;

    public final View a(int i2) {
        if (this.f16940b == null) {
            this.f16940b = new HashMap();
        }
        View view = (View) this.f16940b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f16940b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((int) R.layout.consent_activity_layout);
        String stringExtra = getIntent().getStringExtra("data");
        String stringExtra2 = getIntent().getStringExtra(H5Param.AID);
        Context context = this;
        k.a((Object) stringExtra2, H5Param.AID);
        net.one97.paytm.h5.b.c.a(context, stringExtra2, (c.a) new a(this, stringExtra));
        JSONObject jSONObject = new JSONObject(stringExtra);
        if (jSONObject.has("kyc")) {
            str = jSONObject.getString("kyc");
            k.a((Object) str, "jsonObject.getString(\"kyc\")");
        } else {
            str = "";
        }
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            RoboTextView roboTextView = (RoboTextView) a(net.one97.paytm.dynamic.module.R.id.id_kyc_label);
            k.a((Object) roboTextView, "id_kyc_label");
            roboTextView.setVisibility(8);
        } else {
            RoboTextView roboTextView2 = (RoboTextView) a(net.one97.paytm.dynamic.module.R.id.id_kyc_label);
            k.a((Object) roboTextView2, "id_kyc_label");
            roboTextView2.setText(charSequence);
        }
        JSONArray jSONArray = jSONObject.getJSONArray("data");
        int length = jSONArray.length() - 1;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                RoboTextView roboTextView3 = new RoboTextView(context);
                roboTextView3.setText("●  " + jSONArray.get(i2));
                com.paytm.utility.b.a((TextView) roboTextView3);
                roboTextView3.setTextSize(11.5f);
                roboTextView3.setTextColor(androidx.core.content.b.c(context, R.color.gray_permissions));
                ((LinearLayout) a(net.one97.paytm.dynamic.module.R.id.id_permissions_layout)).addView(roboTextView3);
                ViewGroup.LayoutParams layoutParams = roboTextView3.getLayoutParams();
                if (layoutParams != null) {
                    ((LinearLayout.LayoutParams) layoutParams).setMargins(0, 0, 0, com.paytm.utility.b.a(9, context));
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
            }
        }
        ((RoboTextView) a(net.one97.paytm.dynamic.module.R.id.id_grant)).setOnClickListener(new b(this));
        ((RoboTextView) a(net.one97.paytm.dynamic.module.R.id.id_reject)).setOnClickListener(new c(this));
    }

    public static final class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentActivity f16941a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16942b;

        public final void onError(String str) {
        }

        a(ConsentActivity consentActivity, String str) {
            this.f16941a = consentActivity;
            this.f16942b = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
            r1 = (r1 = r1.getMetaInfo()).getUrlMetaInfo();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onAppDataFetched(net.one97.paytm.h5.model.H5AppDetailsForUserModel r5) {
            /*
                r4 = this;
                if (r5 == 0) goto L_0x0092
                com.paytm.utility.b.b$a r0 = com.paytm.utility.b.b.f43744a
                net.one97.paytm.h5.consent.ConsentActivity r0 = r4.f16941a
                android.content.Context r0 = (android.content.Context) r0
                com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a.a(r0)
                net.one97.paytm.h5.model.H5AppDataResponseModel r1 = r5.getResponse()
                r2 = 0
                if (r1 == 0) goto L_0x0024
                net.one97.paytm.h5.model.H5AppMetaInfoModel r1 = r1.getMetaInfo()
                if (r1 == 0) goto L_0x0024
                net.one97.paytm.h5.model.H5AppUrlInfoModel r1 = r1.getUrlMetaInfo()
                if (r1 == 0) goto L_0x0024
                java.lang.String r1 = r1.getIcon()
                goto L_0x0025
            L_0x0024:
                r1 = r2
            L_0x0025:
                r0.f43753a = r1
                net.one97.paytm.h5.consent.ConsentActivity r1 = r4.f16941a
                int r3 = net.one97.paytm.dynamic.module.R.id.id_icon
                android.view.View r1 = r1.a(r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r3 = 2
                com.paytm.utility.b.b.a.C0750a.a(r0, r1, r2, r3)
                net.one97.paytm.h5.consent.ConsentActivity r0 = r4.f16941a
                net.one97.paytm.h5.model.H5AppDataResponseModel r5 = r5.getResponse()
                java.lang.String r1 = ""
                if (r5 == 0) goto L_0x0045
                java.lang.String r5 = r5.getAppName()
                if (r5 != 0) goto L_0x0046
            L_0x0045:
                r5 = r1
            L_0x0046:
                java.lang.String r2 = "<set-?>"
                kotlin.g.b.k.c(r5, r2)
                r0.f16939a = r5
                org.json.JSONObject r5 = new org.json.JSONObject
                java.lang.String r0 = r4.f16942b
                r5.<init>(r0)
                java.lang.String r0 = "header"
                java.lang.String r5 = r5.getString(r0)
                java.lang.String r0 = "jsonObject.getString(\"header\")"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
                r0 = 0
                java.lang.String r2 = "$"
                java.lang.String r5 = kotlin.m.p.a(r5, r2, r1, r0)
                java.lang.String r2 = "{"
                java.lang.String r5 = kotlin.m.p.a(r5, r2, r1, r0)
                net.one97.paytm.h5.consent.ConsentActivity r2 = r4.f16941a
                java.lang.String r2 = r2.f16939a
                java.lang.String r3 = "app"
                java.lang.String r5 = kotlin.m.p.a(r5, r3, r2, r0)
                java.lang.String r2 = "}"
                java.lang.String r5 = kotlin.m.p.a(r5, r2, r1, r0)
                net.one97.paytm.h5.consent.ConsentActivity r0 = r4.f16941a
                int r1 = net.one97.paytm.dynamic.module.R.id.id_name
                android.view.View r0 = r0.a(r1)
                com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
                java.lang.String r1 = "id_name"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r0.setText(r5)
            L_0x0092:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5.consent.ConsentActivity.a.onAppDataFetched(net.one97.paytm.h5.model.H5AppDetailsForUserModel):void");
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentActivity f16943a;

        b(ConsentActivity consentActivity) {
            this.f16943a = consentActivity;
        }

        public final void onClick(View view) {
            ConsentActivity.a(this.f16943a, true);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentActivity f16944a;

        c(ConsentActivity consentActivity) {
            this.f16944a = consentActivity;
        }

        public final void onClick(View view) {
            ConsentActivity.a(this.f16944a, false);
        }
    }

    public final void finish() {
        super.finish();
        overridePendingTransition(0, 17432577);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(e.a(context));
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public static final /* synthetic */ void a(ConsentActivity consentActivity, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("status", z);
        consentActivity.setResult(-1, intent);
        consentActivity.finish();
    }
}
