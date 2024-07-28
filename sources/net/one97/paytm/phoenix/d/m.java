package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.util.d;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.l;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;
import org.json.JSONObject;

public final class m extends a {

    /* renamed from: a  reason: collision with root package name */
    private b f19829a;

    /* renamed from: b  reason: collision with root package name */
    private String f19830b = "loggedInType";

    /* renamed from: c  reason: collision with root package name */
    private String f19831c = "deviceBinded";

    /* renamed from: d  reason: collision with root package name */
    private String f19832d = "loggedInWithPassword";

    /* renamed from: e  reason: collision with root package name */
    private String f19833e = "loggedInWithOTP";

    public m() {
        super("paytmGetLoginType");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        String bridgeName;
        String str;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        this.f19829a = bVar;
        Activity activity = h5Event.getActivity();
        if (activity != null && (bridgeName = h5Event.getBridgeName()) != null && bridgeName.hashCode() == -1001167026 && bridgeName.equals("paytmGetLoginType")) {
            d.a aVar = d.f19890a;
            String str2 = null;
            if (!d.a.a(h5Event, bVar, activity, (String) null, 24)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", true);
                String str3 = this.f19830b;
                Activity activity2 = h5Event.getActivity();
                if (activity2 != null) {
                    ag.a aVar2 = ag.f69605a;
                    Context applicationContext = activity2.getApplicationContext();
                    k.a((Object) applicationContext, "activity.applicationContext");
                    com.paytm.b.a.a a2 = ag.a.a(applicationContext);
                    if ("device_binding".equals(a2.b(WalletSharedPrefs.KEY_OAUTH_LOGIN_METHOD, "", true)) || "device_binding_otp".equals(a2.b(WalletSharedPrefs.KEY_OAUTH_LOGIN_METHOD, "", true))) {
                        str = this.f19831c;
                    } else if (l.g(activity2)) {
                        str = this.f19832d;
                    } else {
                        str = this.f19833e;
                    }
                    str2 = str;
                }
                jSONObject.put(str3, str2);
                a.a(this, h5Event, jSONObject, false, 4);
            }
        }
        return true;
    }
}
