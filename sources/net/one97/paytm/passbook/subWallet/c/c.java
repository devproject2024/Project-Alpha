package net.one97.paytm.passbook.subWallet.c;

import android.app.Activity;
import android.content.Context;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.passbook.beans.CJRLedgerResponse;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.subWallet.c.b;
import net.one97.paytm.passbook.utility.h;
import org.json.JSONObject;

public class c extends b.a {

    /* renamed from: b  reason: collision with root package name */
    public Activity f58885b;

    /* renamed from: c  reason: collision with root package name */
    public int f58886c;

    /* renamed from: d  reason: collision with root package name */
    public int f58887d = 0;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<h> f58888e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private int f58889f;

    /* renamed from: g  reason: collision with root package name */
    private CJRSubWallet f58890g;

    public c(b.C1135b bVar, Activity activity, int i2, CJRSubWallet cJRSubWallet) {
        super(bVar);
        this.f58885b = activity;
        this.f58889f = i2;
        this.f58890g = cJRSubWallet;
    }

    public final void a(String str, JSONObject jSONObject, String str2) {
        String b2 = com.paytm.utility.b.b((Context) this.f58885b, str);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", str2);
        hashMap.put("Accept-Encoding", "gzip");
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        "----> URL ::".concat(String.valueOf(b2));
        com.paytm.utility.b.j();
        "----> JSON ::".concat(String.valueOf(jSONObject2));
        com.paytm.utility.b.j();
        if (URLUtil.isValidUrl(b2)) {
            if (com.paytm.utility.b.c((Context) this.f58885b)) {
                ((b.C1135b) this.f57072a).j();
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(new net.one97.paytm.passbook.mapping.a.b(b2, new i.a<IJRDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        ((b.C1135b) c.this.f57072a).a((IJRDataModel) obj);
                    }
                }, new g() {
                    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        ((b.C1135b) c.this.f57072a).h();
                        ((b.C1135b) c.this.f57072a).m();
                        ((b.C1135b) c.this.f57072a).k();
                        ((b.C1135b) c.this.f57072a).a((Throwable) networkCustomError);
                    }
                }, new CJRLedgerResponse(), hashMap, jSONObject2, a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, c.class.getName()));
                return;
            }
            ((b.C1135b) this.f57072a).h();
            ((b.C1135b) this.f57072a).a(b2, jSONObject, str2);
        }
    }
}
