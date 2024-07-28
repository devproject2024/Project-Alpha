package paytm_first;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.a;
import com.paytm.utility.c;
import com.sendbird.android.constant.StringSet;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.dynamic.module.creditcard.CreditCardConstant;
import net.one97.paytm.h5.c;

public class PaytmFirstInitActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    Bundle f21282a = new Bundle();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, Object> f21283b = new HashMap<>();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21283b.put("h5_version", "1");
        this.f21283b.put("entryPoint", "paytmFirstLanding");
        this.f21283b.put("source", StringSet.Android);
        this.f21283b.put("deviceId", a.d(this));
        String a2 = a.a((Context) this);
        this.f21283b.put("user_id", a2);
        a.C0708a aVar = com.paytm.b.a.a.f42641a;
        Boolean valueOf = Boolean.valueOf(a.C0708a.a(getApplicationContext(), a.c.PAYTM_FIRST).b(a2 + "primeUserBanner", true, true));
        this.f21283b.put("request_parameters", c.a(getBaseContext(), false));
        this.f21283b.put("prime_user_banner", valueOf);
        HashMap<String, Object> hashMap = this.f21283b;
        net.one97.paytm.j.c.a();
        hashMap.put("prime_user_banner_title", net.one97.paytm.j.c.a("paytmfirstinvitetext", ""));
        HashMap<String, Object> hashMap2 = this.f21283b;
        net.one97.paytm.j.c.a();
        hashMap2.put("prime_user_banner_description", net.one97.paytm.j.c.a("paytmfirstinvitesubtext", ""));
        this.f21282a.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        this.f21282a.putBoolean("canPullDown", false);
        this.f21282a = this.f21282a;
        net.one97.paytm.h5.c cVar = net.one97.paytm.h5.c.f50543a;
        net.one97.paytm.h5.c.a("Paytm First", new c.b() {
            public final void provideValuesForKeys(String str, c.C0910c cVar) {
                PaytmFirstInitActivity.this.a(str, cVar);
            }
        });
        net.one97.paytm.j.c.a();
        String a3 = net.one97.paytm.j.c.a("urlPrimeReactV3", "");
        this.f21282a.putSerializable("initParams", this.f21283b);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            String string = getIntent().getExtras().getString("deeplink");
            if (!TextUtils.isEmpty(string)) {
                try {
                    a3 = a3 + "?deeplink=" + URLEncoder.encode(string, "utf-8");
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        u.a().a("Paytm First", CreditCardConstant.H5_CreditCard_Id, a3, this.f21282a, (String) null, (Context) this);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, c.C0910c cVar) {
        if (cVar != null) {
            char c2 = 65535;
            if (str.hashCode() == -1857023904 && str.equals("prime_user_banner")) {
                c2 = 0;
            }
            if (c2 != 0) {
                cVar.onResult("");
                return;
            }
            String a2 = com.paytm.utility.a.a((Context) this);
            a.C0708a aVar = com.paytm.b.a.a.f42641a;
            Boolean valueOf = Boolean.valueOf(a.C0708a.a(getApplicationContext(), a.c.PAYTM_FIRST).b(a2 + "primeUserBanner", true, true));
            if (valueOf.booleanValue()) {
                String str2 = com.paytm.utility.a.a((Context) this) + "primeUserBanner";
                a.C0708a aVar2 = com.paytm.b.a.a.f42641a;
                a.C0708a.a(getApplicationContext(), a.c.PAYTM_FIRST).a(str2, false, true);
            }
            cVar.onResult(valueOf);
        }
    }
}
