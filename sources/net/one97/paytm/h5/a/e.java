package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.b;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.h5.b.j;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16836a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static String f16837b = "paytmFetchAuthCode";

    /* renamed from: c  reason: collision with root package name */
    private static String f16838c = "paytmFetchOpenId";

    /* renamed from: d  reason: collision with root package name */
    private static String f16839d = "paytmAddMoney";

    /* renamed from: e  reason: collision with root package name */
    private static String f16840e = "paytmUpdateAppData";

    /* renamed from: f  reason: collision with root package name */
    private static String f16841f = "paytmGetUserData";

    /* renamed from: g  reason: collision with root package name */
    private static String f16842g = "paytmOpenScratchCard";

    /* renamed from: h  reason: collision with root package name */
    private static String f16843h = "paytmPrePaymentNotificaion";

    /* renamed from: i  reason: collision with root package name */
    private static String f16844i = "paytmFetchPartnersAppData";
    /* access modifiers changed from: private */
    public static String j = "paytmFetchSignature";
    /* access modifiers changed from: private */
    public static String k = "paytmVerifyPasscode";
    /* access modifiers changed from: private */
    public static String l = "paytmFetchWalletToken";
    /* access modifiers changed from: private */
    public static String m = "paytmFetchCustomerId";
    /* access modifiers changed from: private */
    public static String n = "paytmGetUserInfo";
    /* access modifiers changed from: private */
    public static String o = "paytmGetLoginType";
    /* access modifiers changed from: private */
    public static String p = "paytmFetchConfig";
    /* access modifiers changed from: private */
    public static String q = "paytmFetchContacts";
    /* access modifiers changed from: private */
    public static String r = "paytmFetchDeviceAccounts";
    /* access modifiers changed from: private */
    public static String s = "PaytmSetScreenshotStatus";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(com.alibaba.a.e eVar, H5BridgeContext h5BridgeContext) {
            k.c(eVar, "dataJson");
            com.alibaba.a.e eVar2 = new com.alibaba.a.e();
            eVar2.put("success", (Object) Boolean.TRUE);
            eVar2.put("data", (Object) eVar);
            if (h5BridgeContext != null) {
                h5BridgeContext.sendBridgeResult(eVar2);
            }
        }

        public static void a(Object obj, String str, H5BridgeContext h5BridgeContext) {
            k.c(obj, "error");
            k.c(str, "errorMsg");
            com.alibaba.a.e eVar = new com.alibaba.a.e();
            eVar.put("error", obj);
            eVar.put("message", (Object) str);
            eVar.put("success", (Object) Boolean.FALSE);
            if (h5BridgeContext != null) {
                h5BridgeContext.sendBridgeResult(eVar);
            }
        }

        public static boolean a(ArrayList<String> arrayList, Activity activity) {
            k.c(arrayList, "permissionsToCheck");
            k.c(activity, "activity");
            for (String a2 : arrayList) {
                if (b.a((Context) activity, a2) == 0) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ boolean a(H5BridgeContext h5BridgeContext, Activity activity, String str, int i2) {
            if ((i2 & 4) != 0) {
                str = null;
            }
            return a(h5BridgeContext, activity, str, false);
        }

        public static boolean a(H5BridgeContext h5BridgeContext, Activity activity, String str, boolean z) {
            k.c(activity, "activity");
            if (str != null) {
                new j();
                if (!j.a(((PaytmH5Activity) activity).a(), str)) {
                    a(Integer.valueOf(H5Event.Error.FORBIDDEN.ordinal()), "Not authorized", h5BridgeContext);
                    return true;
                }
            }
            if (!z) {
                CharSequence q = com.paytm.utility.a.q(activity);
                if (q == null || q.length() == 0) {
                    a(10, "user not logged in", h5BridgeContext);
                    return true;
                }
            }
            if (z || com.paytm.utility.b.c((Context) activity)) {
                return false;
            }
            a(Integer.valueOf(H5Event.Error.UNKNOWN_ERROR.ordinal()), "Unable to process your request", h5BridgeContext);
            return true;
        }
    }
}
