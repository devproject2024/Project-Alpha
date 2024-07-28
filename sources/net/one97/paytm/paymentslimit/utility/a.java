package net.one97.paytm.paymentslimit.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.paymentslimit.b.b;
import net.one97.paytm.paymentslimit.b.f;
import net.one97.paytm.paymentslimit.b.h;
import net.one97.paytm.paymentslimit.bean.CJRTransitionLimitResendOTPResponse;
import net.one97.paytm.paymentslimit.bean.CJRTransitionLimitResponse;
import net.one97.paytm.paymentslimit.bean.OTPVerifyResponse;
import net.one97.paytm.wallet.R;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements f, h.a<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f59340a;

    /* renamed from: b  reason: collision with root package name */
    public C1144a f59341b;

    /* renamed from: c  reason: collision with root package name */
    private final String f59342c;

    /* renamed from: d  reason: collision with root package name */
    private final String f59343d;

    /* renamed from: net.one97.paytm.paymentslimit.utility.a$a  reason: collision with other inner class name */
    public interface C1144a {
        void a();

        void a(IJRPaytmDataModel iJRPaytmDataModel);

        void b();
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        C1144a aVar;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel instanceof OTPVerifyResponse) {
            C1144a aVar2 = this.f59341b;
            if (aVar2 != null) {
                aVar2.a(iJRPaytmDataModel);
            }
        } else if (iJRPaytmDataModel instanceof CJRTransitionLimitResponse) {
            C1144a aVar3 = this.f59341b;
            if (aVar3 != null) {
                aVar3.a(iJRPaytmDataModel);
            }
        } else if ((iJRPaytmDataModel instanceof CJRTransitionLimitResendOTPResponse) && (aVar = this.f59341b) != null) {
            aVar.a(iJRPaytmDataModel);
        }
    }

    public a(Context context, String str, String str2) {
        this.f59340a = context;
        this.f59342c = str;
        this.f59343d = str2;
    }

    public final void a(final b bVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f59340a);
        builder.setTitle(this.f59340a.getResources().getString(R.string.no_connection));
        builder.setMessage(this.f59340a.getResources().getString(R.string.no_internet));
        builder.setCancelable(false);
        builder.setPositiveButton(this.f59340a.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c(a.this.f59340a)) {
                    bVar.f59303a.a();
                } else {
                    a.this.a(bVar);
                }
            }
        });
        builder.setNegativeButton(this.f59340a.getResources().getString(R.string.network_retry_no), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (a.this.f59341b != null) {
                    a.this.f59341b.a();
                }
            }
        });
        builder.show();
    }

    public final void a(NetworkCustomError networkCustomError) {
        C1144a aVar = this.f59341b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final b a(String str) {
        String d2 = com.paytm.utility.b.d(this.f59340a, net.one97.paytm.paymentslimit.a.b.f59274a.j());
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(this.f59340a));
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("state", str);
            jSONObject.put("request", jSONObject2);
        } catch (JSONException e2) {
            q.d(String.valueOf(e2));
        }
        return new b(d2, this, this, new CJRTransitionLimitResendOTPResponse(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PAY, a.b.USER_FACING, "Otprequesthandler.java");
    }
}
