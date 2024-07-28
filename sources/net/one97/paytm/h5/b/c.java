package net.one97.paytm.h5.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.h5.helper.H5LoginHelperActivity;
import net.one97.paytm.h5.helper.a;
import net.one97.paytm.h5.model.H5AppDetailsForUserModel;
import net.one97.paytm.l;
import net.one97.paytm.phoenix.util.m;
import net.one97.paytm.utils.r;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f16920a = new c();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, H5AppDetailsForUserModel> f16921b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static String f16922c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static a f16923d;

    public interface a {
        void onAppDataFetched(H5AppDetailsForUserModel h5AppDetailsForUserModel);

        void onError(String str);
    }

    public interface b {
        void a();

        void a(int i2);
    }

    static final class f implements a.C0257a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16933a;

        f(Context context) {
            this.f16933a = context;
        }

        public final /* synthetic */ void a(Boolean bool) {
            if (bool.booleanValue()) {
                c cVar = c.f16920a;
                Context context = this.f16933a;
                c cVar2 = c.f16920a;
                String c2 = c.c();
                c cVar3 = c.f16920a;
                c.c(context, c2, c.f16923d);
            }
        }
    }

    private c() {
    }

    public static final /* synthetic */ String c() {
        String str = f16922c;
        if (str == null) {
            k.a("appIdLastUsed");
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = (r1 = r1.getResponse()).getAppName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String a(java.lang.String r1) {
        /*
            java.lang.String r0 = "appId"
            kotlin.g.b.k.c(r1, r0)
            java.util.HashMap<java.lang.String, net.one97.paytm.h5.model.H5AppDetailsForUserModel> r0 = f16921b
            java.lang.Object r1 = r0.get(r1)
            net.one97.paytm.h5.model.H5AppDetailsForUserModel r1 = (net.one97.paytm.h5.model.H5AppDetailsForUserModel) r1
            if (r1 == 0) goto L_0x001b
            net.one97.paytm.h5.model.H5AppDataResponseModel r1 = r1.getResponse()
            if (r1 == 0) goto L_0x001b
            java.lang.String r1 = r1.getAppName()
            if (r1 != 0) goto L_0x001d
        L_0x001b:
            java.lang.String r1 = ""
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5.b.c.a(java.lang.String):java.lang.String");
    }

    public static final void a(Context context, String str, a aVar) {
        k.c(context, "context");
        k.c(str, "appId");
        f16922c = str;
        f16923d = aVar;
        e();
        if (f16921b.get(str) == null || f16921b.size() == 0) {
            c(context, str, aVar);
        } else {
            aVar.onAppDataFetched(f16921b.get(str));
        }
    }

    public static final class d implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16927a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f16928b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f16929c;

        d(String str, a aVar, Context context) {
            this.f16927a = str;
            this.f16928b = aVar;
            this.f16929c = context;
        }

        public final void a() {
            c cVar = c.f16920a;
            if (c.f16921b.get(this.f16927a) != null) {
                a aVar = this.f16928b;
                if (aVar != null) {
                    c cVar2 = c.f16920a;
                    aVar.onAppDataFetched((H5AppDetailsForUserModel) c.f16921b.get(this.f16927a));
                    return;
                }
                return;
            }
            a aVar2 = this.f16928b;
            if (aVar2 != null) {
                aVar2.onError("AN");
            }
        }

        public final void a(int i2) {
            if (i2 == -1) {
                a aVar = this.f16928b;
                if (aVar != null) {
                    aVar.onError("NW");
                }
            } else if (i2 == 410) {
                c cVar = c.f16920a;
                c.a(this.f16929c, 410);
            } else if (i2 == 422) {
                a aVar2 = this.f16928b;
                if (aVar2 != null) {
                    aVar2.onError("AN");
                }
            } else if (i2 == 500) {
                a aVar3 = this.f16928b;
                if (aVar3 != null) {
                    aVar3.onError("SR");
                }
            } else if (i2 != 400) {
                if (i2 != 401) {
                    a aVar4 = this.f16928b;
                    if (aVar4 != null) {
                        aVar4.onError("SR");
                        return;
                    }
                    return;
                }
                c cVar2 = c.f16920a;
                c.a(this.f16929c, 401);
            } else if (com.paytm.utility.b.r(this.f16929c)) {
                a aVar5 = this.f16928b;
                if (aVar5 != null) {
                    aVar5.onError("SR");
                }
            } else {
                c cVar3 = c.f16920a;
                c.a(this.f16929c, 400);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, a aVar) {
        com.paytm.network.a a2 = a(context, str, (b) new d(str, aVar, context));
        if (a2 != null) {
            if (!com.paytm.utility.b.c(context)) {
                new Handler(Looper.getMainLooper()).post(new C0256c(a2, context));
            } else {
                a2.a();
            }
        } else if (aVar != null) {
            aVar.onError("SW");
        }
    }

    /* renamed from: net.one97.paytm.h5.b.c$c  reason: collision with other inner class name */
    static final class C0256c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f16924a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f16925b;

        C0256c(com.paytm.network.a aVar, Context context) {
            this.f16924a = aVar;
            this.f16925b = context;
        }

        public final void run() {
            View findViewById;
            Context context = this.f16925b;
            if ((context instanceof Activity) && (findViewById = ((Activity) context).findViewById(16908290)) != null) {
                findViewById.postDelayed(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ C0256c f16926a;

                    {
                        this.f16926a = r1;
                    }

                    public final void run() {
                        if (!((Activity) this.f16926a.f16925b).isDestroyed() && !((Activity) this.f16926a.f16925b).isFinishing()) {
                            r.a(this.f16926a.f16924a, this.f16926a.f16925b, (DialogInterface.OnCancelListener) null);
                        }
                    }
                }, 100);
            }
        }
    }

    private static void e() {
        l lVar = l.f52428a;
        if (l.b()) {
            f16921b.clear();
        }
    }

    private static com.paytm.network.a a(Context context, String str, b bVar) {
        e();
        HashMap hashMap = new HashMap();
        com.paytm.utility.b.a((HashMap<String, String>) hashMap, context);
        net.one97.paytm.j.c.a();
        String e2 = net.one97.paytm.j.c.e("h5_mini_app_details_url_v2");
        CharSequence charSequence = e2;
        if (charSequence == null || charSequence.length() == 0) {
            bVar.a(500);
            return null;
        }
        String a2 = a(context, (((e2 + com.paytm.utility.c.a(context, false)) + "&os=android") + "&app_id=" + str) + "&resolution=" + com.paytm.utility.b.U(context));
        x.a aVar = new x.a();
        aVar.element = false;
        new m();
        com.paytm.network.a a3 = m.a(context, a2, new e(bVar, aVar, str), hashMap, a.C0715a.GET, new H5AppDetailsForUserModel(), a.c.H5, a.b.SILENT, str);
        if (a3 != null) {
            a3.b(false);
        }
        return a3;
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16930a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f16931b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f16932c;

        e(b bVar, x.a aVar, String str) {
            this.f16930a = bVar;
            this.f16931b = aVar;
            this.f16932c = str;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f16930a.a(i2);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof H5AppDetailsForUserModel) {
                q.d("isResponseReceived one: " + this.f16931b.element);
                q.d("onApiSuccess: " + iJRPaytmDataModel.toString());
                if (!this.f16931b.element) {
                    boolean z = true;
                    this.f16931b.element = true;
                    if (this.f16932c.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        c cVar = c.f16920a;
                        c.f16921b.put(this.f16932c, iJRPaytmDataModel);
                    }
                    this.f16930a.a();
                }
                q.d("isResponseReceived : " + this.f16931b.element);
                return;
            }
            this.f16930a.a(500);
        }
    }

    public static String a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "url");
        StringBuilder sb = new StringBuilder(p.b(str, (CharSequence) "?"));
        if (com.paytm.utility.b.r(context)) {
            if (p.c((CharSequence) sb, (CharSequence) "?")) {
                sb.append(AppConstants.AND_SIGN);
            } else {
                sb.append("?");
            }
            sb.append("customer_id=" + com.paytm.utility.b.n(context));
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "str.toString()");
        return sb2;
    }

    public static void a() {
        f16921b.clear();
    }

    public static final /* synthetic */ void a(Context context, int i2) {
        net.one97.paytm.h5.helper.a.a().a(new f(context));
        Intent intent = new Intent(context, H5LoginHelperActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(CLConstants.FIELD_ERROR_CODE, i2);
        context.startActivity(intent);
    }
}
