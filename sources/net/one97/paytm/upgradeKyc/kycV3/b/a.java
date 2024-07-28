package net.one97.paytm.upgradeKyc.kycV3.b;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.utility.i;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C1325a f66162b = new C1325a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static a f66163e;

    /* renamed from: a  reason: collision with root package name */
    public List<IJRDataModel> f66164a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.paytm.b.a.a f66165c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f66166d;

    public a(Context context) {
        k.c(context, "appContext");
        this.f66166d = context;
    }

    /* renamed from: net.one97.paytm.upgradeKyc.kycV3.b.a$a  reason: collision with other inner class name */
    public static final class C1325a {
        private C1325a() {
        }

        public /* synthetic */ C1325a(byte b2) {
            this();
        }

        public static a a(Context context) {
            k.c(context, "appContext");
            if (a.f66163e == null) {
                a.f66163e = new a(context);
                a a2 = a.f66163e;
                if (a2 != null) {
                    i.a aVar = i.f49618a;
                    Context applicationContext = context.getApplicationContext();
                    k.a((Object) applicationContext, "appContext.applicationContext");
                    a2.f66165c = i.a.a(applicationContext, f.a.KYC_SHARED_PREF);
                }
            }
            a a3 = a.f66163e;
            if (a3 == null) {
                k.a();
            }
            return a3;
        }

        public static void a() {
            com.paytm.b.a.a b2;
            a a2 = a.f66163e;
            if (!(a2 == null || (b2 = a2.f66165c) == null)) {
                b2.a();
            }
            a.f66163e = null;
        }
    }

    public static boolean a(String str, String str2) {
        com.paytm.b.a.a aVar;
        k.c(str, "key");
        if (TextUtils.isEmpty(str) || str2 == null) {
            return false;
        }
        a aVar2 = f66163e;
        if (aVar2 == null || (aVar = aVar2.f66165c) == null) {
            return true;
        }
        aVar.a(str, str2, false);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = r0.f66165c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r3) {
        /*
            java.lang.String r0 = "key"
            kotlin.g.b.k.c(r3, r0)
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0025
            net.one97.paytm.upgradeKyc.kycV3.b.a r0 = f66163e
            if (r0 == 0) goto L_0x001e
            com.paytm.b.a.a r0 = r0.f66165c
            if (r0 == 0) goto L_0x001e
            r2 = 0
            java.lang.String r3 = r0.b((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)
            goto L_0x001f
        L_0x001e:
            r3 = 0
        L_0x001f:
            r1 = r3
            if (r1 != 0) goto L_0x0025
            kotlin.g.b.k.a()
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.b.a.a(java.lang.String):java.lang.String");
    }
}
