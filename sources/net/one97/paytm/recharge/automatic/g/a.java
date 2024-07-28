package net.one97.paytm.recharge.automatic.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.e;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;

public final class a implements ai {

    /* renamed from: a  reason: collision with root package name */
    public static final C1163a f60288a = new C1163a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final int f60289g = 2;

    /* renamed from: b  reason: collision with root package name */
    private final String f60290b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f60291c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f60292d;

    /* renamed from: e  reason: collision with root package name */
    private final int f60293e;

    /* renamed from: f  reason: collision with root package name */
    private final int f60294f = 1;

    public a() {
        String simpleName = a.class.getSimpleName();
        k.a((Object) simpleName, "CJRAutomaticSubscription…er::class.java.simpleName");
        this.f60290b = simpleName;
    }

    public final void a(String str, String str2, Object obj) {
        k.c(str, "tag");
        k.c(str2, "rechargeNumber");
        c cVar = c.f62654a;
        String c2 = c.c();
        ax.a aVar = ax.f61521a;
        Context context = this.f60292d;
        if (context == null) {
            k.a("mContext");
        }
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "mContext.applicationContext");
        com.paytm.b.a.a a2 = ax.a.a(applicationContext);
        String str3 = e.aQ;
        k.a((Object) str3, "CJRParamConstants.CUSTOMER_ID_SMS");
        String b2 = a2.b(str3, "", true);
        Context context2 = this.f60292d;
        if (context2 == null) {
            k.a("mContext");
        }
        if (z.a(context2) && !TextUtils.isEmpty(b2)) {
            Uri.Builder buildUpon = Uri.parse(c2).buildUpon();
            k.a((Object) buildUpon, "Uri.parse(url)\n                .buildUpon()");
            String uri = b.a(b.a(buildUpon, "cust_id", b2), "rech_num", str2).build().toString();
            if (URLUtil.isValidUrl(uri)) {
                HashMap hashMap = new HashMap();
                Context context3 = this.f60292d;
                if (context3 == null) {
                    k.a("mContext");
                }
                HashMap<String, String> a3 = b.a((HashMap<String, String>) hashMap, context3);
                k.a((Object) a3, "CJRAppCommonUtility.addS…Header(headers, mContext)");
                if (this.f60292d == null) {
                    k.a("mContext");
                }
                d.a();
                d.b(new net.one97.paytm.recharge.common.f.b(str, uri, this, new CJRAutomaticSubscriptionCheckModel(), a3, obj));
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.automatic.g.a$a  reason: collision with other inner class name */
    public static final class C1163a {
        private C1163a() {
        }

        public /* synthetic */ C1163a(byte b2) {
            this();
        }

        public static a a(Context context, c cVar) {
            k.c(context, "context");
            k.c(cVar, "listener");
            a aVar = new a();
            aVar.f60291c = cVar;
            aVar.f60292d = context;
            return aVar;
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        q.d("automatic subscription network call success");
        if (!(iJRPaytmDataModel instanceof CJRAutomaticSubscriptionCheckModel)) {
            c cVar = this.f60291c;
            if (cVar == null) {
                k.a("mListener");
            }
            cVar.a();
        } else if (iJRPaytmDataModel != null) {
            CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel = (CJRAutomaticSubscriptionCheckModel) iJRPaytmDataModel;
            Integer status = cJRAutomaticSubscriptionCheckModel.getStatus();
            int i2 = this.f60293e;
            if (status != null && status.intValue() == i2) {
                c cVar2 = this.f60291c;
                if (cVar2 == null) {
                    k.a("mListener");
                }
                cVar2.a(false, cJRAutomaticSubscriptionCheckModel.getStatus());
                return;
            }
            int i3 = this.f60294f;
            if (status == null || status.intValue() != i3) {
                int i4 = f60289g;
                if (status == null || status.intValue() != i4) {
                    c cVar3 = this.f60291c;
                    if (cVar3 == null) {
                        k.a("mListener");
                    }
                    cVar3.a();
                    return;
                }
            }
            c cVar4 = this.f60291c;
            if (cVar4 == null) {
                k.a("mListener");
            }
            cJRAutomaticSubscriptionCheckModel.getMessage();
            cVar4.a(true, cJRAutomaticSubscriptionCheckModel.getStatus());
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel");
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        q.a();
        c cVar = this.f60291c;
        if (cVar == null) {
            k.a("mListener");
        }
        cVar.a();
    }
}
