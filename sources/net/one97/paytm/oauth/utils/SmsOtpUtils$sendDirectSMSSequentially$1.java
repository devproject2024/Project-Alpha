package net.one97.paytm.oauth.utils;

import android.app.PendingIntent;
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

public final class SmsOtpUtils$sendDirectSMSSequentially$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x.c f56755a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f56756b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f56757c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ int f56758d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f56759e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PendingIntent f56760f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ int f56761g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ Context f56762h;

    SmsOtpUtils$sendDirectSMSSequentially$1(x.c cVar, f fVar, List list, int i2, String str, PendingIntent pendingIntent, int i3, Context context) {
        this.f56755a = cVar;
        this.f56756b = fVar;
        this.f56757c = list;
        this.f56758d = i2;
        this.f56759e = str;
        this.f56760f = pendingIntent;
        this.f56761g = i3;
        this.f56762h = context;
    }

    public final void onReceive(Context context, Intent intent) {
        new StringBuilder("SMS Acknowledgement:").append(this.f56755a.element);
        q.b();
        int resultCode = getResultCode();
        if (resultCode == -1) {
            new StringBuilder("SMS Success:").append(this.f56755a.element);
            q.b();
            this.f56756b.d();
        } else if (resultCode == 1) {
            this.f56756b.a("RESULT_ERROR_GENERIC_FAILURE");
            String stringExtra = intent != null ? intent.getStringExtra(CLConstants.FIELD_ERROR_CODE) : null;
            if (stringExtra != null) {
                OauthModule.b().logHawEyeEvent(new a("RESULT_ERROR_GENERIC_FAILURE", "/login-signup", stringExtra, (String) null, (String) null, 0, 56));
            }
        } else if (resultCode == 2) {
            this.f56756b.a("RESULT_ERROR_RADIO_OFF");
        } else if (resultCode == 3) {
            this.f56756b.a("RESULT_ERROR_NULL_PDU");
        } else if (resultCode == 4) {
            this.f56756b.a("RESULT_ERROR_NO_SERVICE");
        } else if (resultCode == 5) {
            this.f56756b.a("RESULT_ERROR_LIMIT_EXCEEDED");
        } else if (resultCode == 7) {
            this.f56756b.a("RESULT_ERROR_SHORT_CODE_NOT_ALLOWED");
        } else if (resultCode != 8) {
            this.f56756b.a(H5Utils.NETWORK_TYPE_UNKNOWN);
        } else {
            this.f56756b.a("RESULT_ERROR_SHORT_CODE_NEVER_ALLOWED");
        }
        if (this.f56755a.element < this.f56757c.size()) {
            x xVar = x.f56805a;
            if (!x.a()) {
                x xVar2 = x.f56805a;
                x.b(this.f56758d, (String) this.f56757c.get(this.f56755a.element), this.f56759e, this.f56760f, this.f56756b, 1000 * ((long) this.f56761g));
                this.f56755a.element++;
                return;
            }
        }
        x xVar3 = x.f56805a;
        x.a(this.f56762h);
    }
}
