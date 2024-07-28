package net.one97.paytm;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paytm_finance.R;

public final class MockAppsFlyerActivity extends PaytmActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m<String, Integer, Object> f51868a = new b(this);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f51869b;

    public final View a(int i2) {
        if (this.f51869b == null) {
            this.f51869b = new HashMap();
        }
        View view = (View) this.f51869b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f51869b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b extends l implements m<String, Integer, x> {
        final /* synthetic */ MockAppsFlyerActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MockAppsFlyerActivity mockAppsFlyerActivity) {
            super(2);
            this.this$0 = mockAppsFlyerActivity;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((String) obj, ((Number) obj2).intValue());
            return x.f47997a;
        }

        public final void invoke(String str, int i2) {
            k.c(str, "url");
            this.this$0.runOnUiThread(new a(this.this$0, str));
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_mock_appsflyer);
        ((Button) a(R.id.btn_link_generation)).setOnClickListener(new c(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MockAppsFlyerActivity f51872a;

        c(MockAppsFlyerActivity mockAppsFlyerActivity) {
            this.f51872a = mockAppsFlyerActivity;
        }

        public final void onClick(View view) {
            HashMap hashMap = new HashMap();
            EditText editText = (EditText) this.f51872a.a(R.id.af_schema_value);
            k.a((Object) editText, "af_schema_value");
            String obj = editText.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                hashMap.put("af_scheme", obj);
            }
            EditText editText2 = (EditText) this.f51872a.a(R.id.af_scheme_parameter_value);
            k.a((Object) editText2, "af_scheme_parameter_value");
            String obj2 = editText2.getText().toString();
            if (!TextUtils.isEmpty(obj2)) {
                hashMap.put("af_scheme_parameter", obj2);
            }
            EditText editText3 = (EditText) this.f51872a.a(R.id.af_url_value);
            k.a((Object) editText3, "af_url_value");
            String obj3 = editText3.getText().toString();
            if (!TextUtils.isEmpty(obj3)) {
                hashMap.put("af_url", obj3);
            }
            EditText editText4 = (EditText) this.f51872a.a(R.id.af_url_parameter_value);
            k.a((Object) editText4, "af_url_parameter_value");
            String obj4 = editText4.getText().toString();
            if (!TextUtils.isEmpty(obj4)) {
                hashMap.put("af_url_parameter", obj4);
            }
            EditText editText5 = (EditText) this.f51872a.a(R.id.af_dp_value);
            k.a((Object) editText5, "af_dp_value");
            String obj5 = editText5.getText().toString();
            if (!TextUtils.isEmpty(obj5)) {
                hashMap.put("af_dp", obj5);
            }
            EditText editText6 = (EditText) this.f51872a.a(R.id.af_dp_encoded_value);
            k.a((Object) editText6, "af_dp_encoded_value");
            String obj6 = editText6.getText().toString();
            if (!TextUtils.isEmpty(obj6)) {
                hashMap.put("af_dp", obj6);
            }
            EditText editText7 = (EditText) this.f51872a.a(R.id.af_paytm_deeplink_value);
            k.a((Object) editText7, "af_paytm_deeplink_value");
            String obj7 = editText7.getText().toString();
            if (!TextUtils.isEmpty(obj7)) {
                hashMap.put("af_paytm_deeplink", obj7);
            }
            hashMap.put("is_retargeting", "true");
            net.one97.paytm.utils.m mVar = net.one97.paytm.utils.m.f69757a;
            MockAppsFlyerActivity mockAppsFlyerActivity = this.f51872a;
            net.one97.paytm.utils.m.a(mockAppsFlyerActivity, "whatsapp", hashMap, mockAppsFlyerActivity.f51868a, 0);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MockAppsFlyerActivity f51870a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f51871b;

        a(MockAppsFlyerActivity mockAppsFlyerActivity, String str) {
            this.f51870a = mockAppsFlyerActivity;
            this.f51871b = str;
        }

        public final void run() {
            AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
            EditText editText = (EditText) this.f51870a.a(R.id.generated_link);
            k.a((Object) editText, "generated_link");
            editText.setText(r0.invoke(this.f51871b));
        }
    }
}
