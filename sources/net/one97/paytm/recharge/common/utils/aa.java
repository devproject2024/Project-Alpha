package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.w;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.model.rechargeutility.CJRSuccessRateAlertMessage;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;

public final class aa implements ai {

    /* renamed from: a  reason: collision with root package name */
    private Context f61494a;

    /* renamed from: b  reason: collision with root package name */
    private w f61495b;

    public aa(Context context, w wVar) {
        this.f61494a = context;
        this.f61495b = wVar;
    }

    public final void a(w wVar) {
        this.f61495b = wVar;
    }

    private static String a(String str) {
        try {
            return URLEncoder.encode(str, AppConstants.UTF_8).replace("+", "%20");
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return str;
        }
    }

    public final void a(String str, String str2, long j, String str3, String str4, String str5, Object obj) {
        c cVar = c.f62654a;
        String aH = c.aH();
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(aH)) {
            StringBuilder sb = new StringBuilder(aH);
            sb.append("?operator=".concat(String.valueOf(a(str2))));
            sb.append("&product_id=".concat(String.valueOf(j)));
            sb.append("&channel=android");
            if (!TextUtils.isEmpty(str3)) {
                sb.append("&service=".concat(String.valueOf(a(str3))));
            }
            if (!TextUtils.isEmpty(str4)) {
                sb.append("&paytype=".concat(String.valueOf(a(str4))));
            }
            if (!TextUtils.isEmpty(str5)) {
                sb.append("&circle=".concat(String.valueOf(a(str5))));
            }
            String s = b.s(this.f61494a, sb.toString());
            if (b.c(this.f61494a)) {
                d.a();
                d.b(new net.one97.paytm.recharge.common.f.b(str, s, this, new CJRSuccessRateAlertMessage(), obj));
            }
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        w wVar;
        if ("success_rate_alert_message".equalsIgnoreCase(str) && (iJRPaytmDataModel instanceof CJRSuccessRateAlertMessage)) {
            CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage = (CJRSuccessRateAlertMessage) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(cJRSuccessRateAlertMessage.getMessage()) && (wVar = this.f61495b) != null) {
                wVar.a(cJRSuccessRateAlertMessage);
            }
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        if ("success_rate_alert_message".equalsIgnoreCase(str) && (obj instanceof CJRRechargeErrorModel)) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }
}
