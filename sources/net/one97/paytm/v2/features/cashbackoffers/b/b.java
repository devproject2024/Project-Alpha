package net.one97.paytm.v2.features.cashbackoffers.b;

import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.v2.a.f;
import net.one97.paytm.vipcashback.f.h;

public final class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20357a;

    public final void a(y<h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "offersTag");
    }

    public final void a(y<h<Object>> yVar, String str, int i2, int i3) {
        k.c(yVar, "result");
    }

    public final void a(y<h<Object>> yVar, String str, String str2) {
        k.c(yVar, "result");
        k.c(str, StringSet.filter);
        k.c(str2, "pageNo");
    }

    public b(Context context) {
        k.c(context, "appContext");
        this.f20357a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0077 A[SYNTHETIC, Splitter:B:15:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0089 A[Catch:{ Exception -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008f A[Catch:{ Exception -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a0 A[Catch:{ Exception -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b2 A[Catch:{ Exception -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b8 A[Catch:{ Exception -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010d A[Catch:{ Exception -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0118 A[Catch:{ Exception -> 0x0120 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r8, java.lang.String r9, java.lang.String r10, java.lang.Boolean r11) {
        /*
            r7 = this;
            java.lang.String r0 = "result"
            kotlin.g.b.k.c(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0120 }
            r0.<init>()     // Catch:{ Exception -> 0x0120 }
            net.one97.paytm.vipcashback.f.f r1 = net.one97.paytm.vipcashback.f.f.a()     // Catch:{ Exception -> 0x0120 }
            java.lang.String r2 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r1 = net.one97.paytm.vipcashback.f.f.E()     // Catch:{ Exception -> 0x0120 }
            r0.append(r1)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r1 = "&redemptionTypes="
            r0.append(r1)     // Catch:{ Exception -> 0x0120 }
            net.one97.paytm.vipcashback.d.a$f$a r1 = net.one97.paytm.vipcashback.d.a.f.f20792a     // Catch:{ Exception -> 0x0120 }
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.f.f20796e     // Catch:{ Exception -> 0x0120 }
            r0.append(r1)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r1 = "&statusList="
            r0.append(r1)     // Catch:{ Exception -> 0x0120 }
            net.one97.paytm.vipcashback.d.a$j$a r1 = net.one97.paytm.vipcashback.d.a.j.f20817a     // Catch:{ Exception -> 0x0120 }
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.j.f20822f     // Catch:{ Exception -> 0x0120 }
            r0.append(r1)     // Catch:{ Exception -> 0x0120 }
            r1 = 44
            r0.append(r1)     // Catch:{ Exception -> 0x0120 }
            net.one97.paytm.vipcashback.d.a$j$a r1 = net.one97.paytm.vipcashback.d.a.j.f20817a     // Catch:{ Exception -> 0x0120 }
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.j.f20823g     // Catch:{ Exception -> 0x0120 }
            r0.append(r1)     // Catch:{ Exception -> 0x0120 }
            r1 = 38
            r0.append(r1)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0120 }
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0120 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0120 }
            if (r2 != 0) goto L_0x0124
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0120 }
            r2.<init>()     // Catch:{ Exception -> 0x0120 }
            r2.append(r0)     // Catch:{ Exception -> 0x0120 }
            r0 = 1
            r3 = 0
            if (r9 == 0) goto L_0x0072
            r4 = r9
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0120 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x0120 }
            if (r4 != 0) goto L_0x006d
            r4 = 1
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            if (r4 != 0) goto L_0x0072
            r4 = 1
            goto L_0x0073
        L_0x0072:
            r4 = 0
        L_0x0073:
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0089
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0120 }
            java.lang.String r6 = "excludedIds="
            r4.<init>(r6)     // Catch:{ Exception -> 0x0120 }
            r4.append(r9)     // Catch:{ Exception -> 0x0120 }
            r4.append(r1)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r9 = r4.toString()     // Catch:{ Exception -> 0x0120 }
            goto L_0x008a
        L_0x0089:
            r9 = r5
        L_0x008a:
            r2.append(r9)     // Catch:{ Exception -> 0x0120 }
            if (r10 == 0) goto L_0x009e
            r9 = r10
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0120 }
            int r9 = r9.length()     // Catch:{ Exception -> 0x0120 }
            if (r9 != 0) goto L_0x009a
            r9 = 1
            goto L_0x009b
        L_0x009a:
            r9 = 0
        L_0x009b:
            if (r9 != 0) goto L_0x009e
            r3 = 1
        L_0x009e:
            if (r3 == 0) goto L_0x00b2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0120 }
            java.lang.String r0 = "beforeTime="
            r9.<init>(r0)     // Catch:{ Exception -> 0x0120 }
            r9.append(r10)     // Catch:{ Exception -> 0x0120 }
            r9.append(r1)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0120 }
            goto L_0x00b3
        L_0x00b2:
            r9 = r5
        L_0x00b3:
            r2.append(r9)     // Catch:{ Exception -> 0x0120 }
            if (r11 == 0) goto L_0x00c2
            java.lang.String r9 = "isAggregationRequired="
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r5 = r9.concat(r10)     // Catch:{ Exception -> 0x0120 }
        L_0x00c2:
            r2.append(r5)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r9 = r2.toString()     // Catch:{ Exception -> 0x0120 }
            net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.b r10 = net.one97.paytm.vipcashback.f.d.a.c()     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.a$a r11 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.b r10 = r10.a((com.paytm.network.a.C0715a) r11)     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.b r9 = r10.a((java.lang.String) r9)     // Catch:{ Exception -> 0x0120 }
            net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a     // Catch:{ Exception -> 0x0120 }
            java.util.HashMap r10 = net.one97.paytm.vipcashback.f.d.a.b()     // Catch:{ Exception -> 0x0120 }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.b r9 = r9.a((java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ Exception -> 0x0120 }
            net.one97.paytm.common.entity.vipcashback.CashbackAllCards r10 = new net.one97.paytm.common.entity.vipcashback.CashbackAllCards     // Catch:{ Exception -> 0x0120 }
            r10.<init>()     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.model.IJRPaytmDataModel r10 = (com.paytm.network.model.IJRPaytmDataModel) r10     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.b r9 = r9.a((com.paytm.network.model.IJRPaytmDataModel) r10)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r10 = "DealLanding"
            com.paytm.network.b r9 = r9.c(r10)     // Catch:{ Exception -> 0x0120 }
            net.one97.paytm.v2.features.cashbackoffers.b.b$a r10 = new net.one97.paytm.v2.features.cashbackoffers.b.b$a     // Catch:{ Exception -> 0x0120 }
            r10.<init>(r8)     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.listener.b r10 = (com.paytm.network.listener.b) r10     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.b r9 = r9.a((com.paytm.network.listener.b) r10)     // Catch:{ Exception -> 0x0120 }
            com.paytm.network.a r9 = r9.l()     // Catch:{ Exception -> 0x0120 }
            android.content.Context r10 = r7.f20357a     // Catch:{ Exception -> 0x0120 }
            boolean r10 = com.paytm.utility.b.c((android.content.Context) r10)     // Catch:{ Exception -> 0x0120 }
            if (r10 == 0) goto L_0x0118
            net.one97.paytm.vipcashback.f.h r10 = net.one97.paytm.vipcashback.f.h.a()     // Catch:{ Exception -> 0x0120 }
            r8.setValue(r10)     // Catch:{ Exception -> 0x0120 }
            r9.a()     // Catch:{ Exception -> 0x0120 }
            return
        L_0x0118:
            net.one97.paytm.vipcashback.f.h r9 = net.one97.paytm.vipcashback.f.h.b(r9)     // Catch:{ Exception -> 0x0120 }
            r8.setValue(r9)     // Catch:{ Exception -> 0x0120 }
            return
        L_0x0120:
            r8 = move-exception
            r8.getMessage()
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.b.b.a(androidx.lifecycle.y, java.lang.String, java.lang.String, java.lang.Boolean):void");
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20358a;

        a(y yVar) {
            this.f20358a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20358a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20358a.setValue(h.a(iJRPaytmDataModel));
        }
    }
}
