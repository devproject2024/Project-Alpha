package net.one97.paytm.oauth.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.nebula.util.H5Utils;
import com.paytm.utility.q;
import java.util.List;
import kotlin.g.b.x;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.e.f;
import net.one97.paytm.oauth.models.a;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class SmsOtpUtils$sendDirectSMS$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x.c f56751a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f56752b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f56753c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Context f56754d;

    SmsOtpUtils$sendDirectSMS$1(x.c cVar, f fVar, List list, Context context) {
        this.f56751a = cVar;
        this.f56752b = fVar;
        this.f56753c = list;
        this.f56754d = context;
    }

    public final void onReceive(Context context, Intent intent) {
        new StringBuilder("SMS Acknowledgement:").append(this.f56751a.element + 1);
        q.b();
        int resultCode = getResultCode();
        if (resultCode == -1) {
            new StringBuilder("SMS Success:").append(this.f56751a.element + 1);
            q.b();
            this.f56752b.d();
        } else if (resultCode == 1) {
            this.f56752b.a("RESULT_ERROR_GENERIC_FAILURE");
            String stringExtra = intent != null ? intent.getStringExtra(CLConstants.FIELD_ERROR_CODE) : null;
            if (stringExtra != null) {
                OauthModule.b().logHawEyeEvent(new a("RESULT_ERROR_GENERIC_FAILURE", "/login-signup", stringExtra, (String) null, (String) null, 0, 56));
            }
        } else if (resultCode == 2) {
            this.f56752b.a("RESULT_ERROR_RADIO_OFF");
        } else if (resultCode == 3) {
            this.f56752b.a("RESULT_ERROR_NULL_PDU");
        } else if (resultCode == 4) {
            this.f56752b.a("RESULT_ERROR_NO_SERVICE");
        } else if (resultCode == 5) {
            this.f56752b.a("RESULT_ERROR_LIMIT_EXCEEDED");
        } else if (resultCode == 7) {
            this.f56752b.a("RESULT_ERROR_SHORT_CODE_NOT_ALLOWED");
        } else if (resultCode != 8) {
            this.f56752b.a(H5Utils.NETWORK_TYPE_UNKNOWN);
        } else {
            this.f56752b.a("RESULT_ERROR_SHORT_CODE_NEVER_ALLOWED");
        }
        this.f56751a.element++;
        if (this.f56751a.element >= this.f56753c.size()) {
            x xVar = x.f56805a;
            x.a(this.f56754d);
        }
    }
}
