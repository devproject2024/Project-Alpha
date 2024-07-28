package net.one97.paytm.addmoney.addmoneysource.c.c.b;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import net.one97.paytm.addmoney.common.model.CJRVerifyPasscodeResponse;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.upi.util.UpiConstantServiceApi;

public final class a implements net.one97.paytm.addmoney.addmoneysource.c.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static a f48219a;

    /* renamed from: b  reason: collision with root package name */
    private Context f48220b;

    /* renamed from: c  reason: collision with root package name */
    private Fragment f48221c;

    private a(Context context, Fragment fragment) {
        this.f48220b = context;
        this.f48221c = fragment;
    }

    public static synchronized a a(Context context, Fragment fragment) {
        a aVar;
        synchronized (a.class) {
            if (f48219a == null) {
                f48219a = new a(context, fragment);
            }
            aVar = f48219a;
        }
        return aVar;
    }

    public final void a(String str, final h hVar, String str2) {
        try {
            if (b.c(this.f48220b)) {
                HashMap hashMap = new HashMap();
                hashMap.put("Authorization", b.m());
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                hashMap.put("session_token", com.paytm.utility.a.q(this.f48220b));
                String e2 = b.e(this.f48220b, net.one97.paytm.helper.a.b().f(UpiConstantServiceApi.KEY_TOKEN));
                com.paytm.b.a.a a2 = net.one97.paytm.addmoney.utils.h.a(this.f48220b.getApplicationContext());
                com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                b2.f42880d = e2;
                b2.f42882f = hashMap;
                b2.f42877a = this.f48220b;
                b2.f42884h = "grant_type=" + URLEncoder.encode("password", AppConstants.UTF_8) + "&login_id=" + URLEncoder.encode(a2.b("mobile", "", true), AppConstants.UTF_8) + "&login_secret=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&scope=" + URLEncoder.encode(BuildConfig.BANK_TXN_SCOPE, AppConstants.UTF_8) + "&login_id_type=" + URLEncoder.encode(ContactColumn.PHONE_NUMBER, AppConstants.UTF_8) + "&login_secret_type=" + URLEncoder.encode("passcode", AppConstants.UTF_8);
                b2.o = this.f48220b.getClass().getSimpleName();
                b2.f42885i = new CJRVerifyPasscodeResponse();
                b2.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        hVar.a(iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        hVar.b(networkCustomError);
                    }
                };
                b2.l().a();
                return;
            }
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setmAlertTitle("No Internet");
            networkCustomError.setAlertMessage("You are not connected to internet");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void a(h hVar, String str) {
        new net.one97.paytm.addmoney.utils.a(this.f48220b, this.f48221c).a(hVar);
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        new net.one97.paytm.addmoney.utils.a(this.f48220b, this.f48221c).a(hVar, str, str2, i2, str3);
    }

    public final void a(String str) {
        f48219a = null;
    }
}
