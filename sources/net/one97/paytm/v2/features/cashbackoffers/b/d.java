package net.one97.paytm.v2.features.cashbackoffers.b;

import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.h;

public final class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20361a;

    public d(Context context) {
        k.c(context, "appContext");
        this.f20361a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "result"
            kotlin.g.b.k.c(r8, r0)
            net.one97.paytm.vipcashback.f.f r0 = net.one97.paytm.vipcashback.f.f.a()
            java.lang.String r1 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = net.one97.paytm.vipcashback.f.f.F()
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0103
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "?"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r0 = 1
            r2 = 0
            if (r9 == 0) goto L_0x0048
            r3 = r9
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0043
            r3 = 1
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r3 != 0) goto L_0x0048
            r3 = 1
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            r4 = 38
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x0061
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "excludedIds="
            r3.<init>(r6)
            r3.append(r9)
            r3.append(r4)
            java.lang.String r9 = r3.toString()
            goto L_0x0062
        L_0x0061:
            r9 = r5
        L_0x0062:
            r1.append(r9)
            if (r10 == 0) goto L_0x0077
            r9 = r10
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0072
            r9 = 1
            goto L_0x0073
        L_0x0072:
            r9 = 0
        L_0x0073:
            if (r9 != 0) goto L_0x0077
            r9 = 1
            goto L_0x0078
        L_0x0077:
            r9 = 0
        L_0x0078:
            if (r9 == 0) goto L_0x008c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r3 = "beforeTime="
            r9.<init>(r3)
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            goto L_0x008d
        L_0x008c:
            r9 = r5
        L_0x008d:
            r1.append(r9)
            if (r11 == 0) goto L_0x00a1
            r9 = r11
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r9 = r9.length()
            if (r9 != 0) goto L_0x009d
            r9 = 1
            goto L_0x009e
        L_0x009d:
            r9 = 0
        L_0x009e:
            if (r9 != 0) goto L_0x00a1
            r2 = 1
        L_0x00a1:
            if (r2 == 0) goto L_0x00ad
            java.lang.String r9 = java.lang.String.valueOf(r11)
            java.lang.String r10 = "remainingTypes="
            java.lang.String r5 = r10.concat(r9)
        L_0x00ad:
            r1.append(r5)
            java.lang.String r9 = r1.toString()
            net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a
            com.paytm.network.b r10 = net.one97.paytm.vipcashback.f.d.a.c()
            com.paytm.network.a$a r11 = com.paytm.network.a.C0715a.GET
            com.paytm.network.b r10 = r10.a((com.paytm.network.a.C0715a) r11)
            com.paytm.network.b r9 = r10.a((java.lang.String) r9)
            net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a
            java.util.HashMap r10 = net.one97.paytm.vipcashback.f.d.a.b()
            java.util.Map r10 = (java.util.Map) r10
            com.paytm.network.b r9 = r9.a((java.util.Map<java.lang.String, java.lang.String>) r10)
            net.one97.paytm.common.entity.vipcashback.CashbackMergeCardBase r10 = new net.one97.paytm.common.entity.vipcashback.CashbackMergeCardBase
            r10.<init>()
            com.paytm.network.model.IJRPaytmDataModel r10 = (com.paytm.network.model.IJRPaytmDataModel) r10
            com.paytm.network.b r9 = r9.a((com.paytm.network.model.IJRPaytmDataModel) r10)
            java.lang.String r10 = "CashbackLanding"
            com.paytm.network.b r9 = r9.c(r10)
            net.one97.paytm.v2.features.cashbackoffers.b.d$a r10 = new net.one97.paytm.v2.features.cashbackoffers.b.d$a
            r10.<init>(r8)
            com.paytm.network.listener.b r10 = (com.paytm.network.listener.b) r10
            com.paytm.network.b r9 = r9.a((com.paytm.network.listener.b) r10)
            com.paytm.network.a r9 = r9.l()
            android.content.Context r10 = r7.f20361a
            boolean r10 = com.paytm.utility.b.c((android.content.Context) r10)
            if (r10 == 0) goto L_0x00fc
            r9.a()
            return
        L_0x00fc:
            net.one97.paytm.vipcashback.f.h r9 = net.one97.paytm.vipcashback.f.h.b(r9)
            r8.setValue(r9)
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.b.d.a(androidx.lifecycle.y, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20362a;

        a(y yVar) {
            this.f20362a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if ((networkCustomError != null ? networkCustomError.getErrorType() : null) == null || networkCustomError.getErrorType() != NetworkCustomError.ErrorType.NoConnectionError) {
                this.f20362a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
                return;
            }
            y yVar = this.f20362a;
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            yVar.setValue(h.b(d.a.c()));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20362a.setValue(h.a(iJRPaytmDataModel));
        }
    }
}
