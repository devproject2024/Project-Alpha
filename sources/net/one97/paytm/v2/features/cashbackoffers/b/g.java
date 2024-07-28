package net.one97.paytm.v2.features.cashbackoffers.b;

import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.v2.a.f;
import net.one97.paytm.vipcashback.f.h;

public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20364a;

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

    public g(Context context) {
        k.c(context, "appContext");
        this.f20364a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0069 A[SYNTHETIC, Splitter:B:15:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007b A[Catch:{ Exception -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081 A[Catch:{ Exception -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A[Catch:{ Exception -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4 A[Catch:{ Exception -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00aa A[Catch:{ Exception -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ff A[Catch:{ Exception -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x010a A[Catch:{ Exception -> 0x0112 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r8, java.lang.String r9, java.lang.String r10, java.lang.Boolean r11) {
        /*
            r7 = this;
            java.lang.String r0 = "result"
            kotlin.g.b.k.c(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0112 }
            r0.<init>()     // Catch:{ Exception -> 0x0112 }
            net.one97.paytm.vipcashback.f.f r1 = net.one97.paytm.vipcashback.f.f.a()     // Catch:{ Exception -> 0x0112 }
            java.lang.String r2 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r1 = net.one97.paytm.vipcashback.f.f.E()     // Catch:{ Exception -> 0x0112 }
            r0.append(r1)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r1 = "&redemptionTypes=COINS&statusList="
            r0.append(r1)     // Catch:{ Exception -> 0x0112 }
            net.one97.paytm.vipcashback.d.a$j$a r1 = net.one97.paytm.vipcashback.d.a.j.f20817a     // Catch:{ Exception -> 0x0112 }
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.j.f20822f     // Catch:{ Exception -> 0x0112 }
            r0.append(r1)     // Catch:{ Exception -> 0x0112 }
            r1 = 44
            r0.append(r1)     // Catch:{ Exception -> 0x0112 }
            net.one97.paytm.vipcashback.d.a$j$a r1 = net.one97.paytm.vipcashback.d.a.j.f20817a     // Catch:{ Exception -> 0x0112 }
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.j.f20823g     // Catch:{ Exception -> 0x0112 }
            r0.append(r1)     // Catch:{ Exception -> 0x0112 }
            r1 = 38
            r0.append(r1)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0112 }
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0112 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0112 }
            if (r2 != 0) goto L_0x0116
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0112 }
            r2.<init>()     // Catch:{ Exception -> 0x0112 }
            r2.append(r0)     // Catch:{ Exception -> 0x0112 }
            r0 = 1
            r3 = 0
            if (r9 == 0) goto L_0x0064
            r4 = r9
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0112 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x0112 }
            if (r4 != 0) goto L_0x005f
            r4 = 1
            goto L_0x0060
        L_0x005f:
            r4 = 0
        L_0x0060:
            if (r4 != 0) goto L_0x0064
            r4 = 1
            goto L_0x0065
        L_0x0064:
            r4 = 0
        L_0x0065:
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x007b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0112 }
            java.lang.String r6 = "excludedIds="
            r4.<init>(r6)     // Catch:{ Exception -> 0x0112 }
            r4.append(r9)     // Catch:{ Exception -> 0x0112 }
            r4.append(r1)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r9 = r4.toString()     // Catch:{ Exception -> 0x0112 }
            goto L_0x007c
        L_0x007b:
            r9 = r5
        L_0x007c:
            r2.append(r9)     // Catch:{ Exception -> 0x0112 }
            if (r10 == 0) goto L_0x0090
            r9 = r10
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0112 }
            int r9 = r9.length()     // Catch:{ Exception -> 0x0112 }
            if (r9 != 0) goto L_0x008c
            r9 = 1
            goto L_0x008d
        L_0x008c:
            r9 = 0
        L_0x008d:
            if (r9 != 0) goto L_0x0090
            r3 = 1
        L_0x0090:
            if (r3 == 0) goto L_0x00a4
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0112 }
            java.lang.String r0 = "beforeTime="
            r9.<init>(r0)     // Catch:{ Exception -> 0x0112 }
            r9.append(r10)     // Catch:{ Exception -> 0x0112 }
            r9.append(r1)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0112 }
            goto L_0x00a5
        L_0x00a4:
            r9 = r5
        L_0x00a5:
            r2.append(r9)     // Catch:{ Exception -> 0x0112 }
            if (r11 == 0) goto L_0x00b4
            java.lang.String r9 = "isAggregationRequired="
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r5 = r9.concat(r10)     // Catch:{ Exception -> 0x0112 }
        L_0x00b4:
            r2.append(r5)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r9 = r2.toString()     // Catch:{ Exception -> 0x0112 }
            net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.b r10 = net.one97.paytm.vipcashback.f.d.a.c()     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.a$a r11 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.b r10 = r10.a((com.paytm.network.a.C0715a) r11)     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.b r9 = r10.a((java.lang.String) r9)     // Catch:{ Exception -> 0x0112 }
            net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a     // Catch:{ Exception -> 0x0112 }
            java.util.HashMap r10 = net.one97.paytm.vipcashback.f.d.a.b()     // Catch:{ Exception -> 0x0112 }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.b r9 = r9.a((java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ Exception -> 0x0112 }
            net.one97.paytm.common.entity.vipcashback.CashbackAllCards r10 = new net.one97.paytm.common.entity.vipcashback.CashbackAllCards     // Catch:{ Exception -> 0x0112 }
            r10.<init>()     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.model.IJRPaytmDataModel r10 = (com.paytm.network.model.IJRPaytmDataModel) r10     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.b r9 = r9.a((com.paytm.network.model.IJRPaytmDataModel) r10)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r10 = "DealLanding"
            com.paytm.network.b r9 = r9.c(r10)     // Catch:{ Exception -> 0x0112 }
            net.one97.paytm.v2.features.cashbackoffers.b.g$a r10 = new net.one97.paytm.v2.features.cashbackoffers.b.g$a     // Catch:{ Exception -> 0x0112 }
            r10.<init>(r8)     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.listener.b r10 = (com.paytm.network.listener.b) r10     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.b r9 = r9.a((com.paytm.network.listener.b) r10)     // Catch:{ Exception -> 0x0112 }
            com.paytm.network.a r9 = r9.l()     // Catch:{ Exception -> 0x0112 }
            android.content.Context r10 = r7.f20364a     // Catch:{ Exception -> 0x0112 }
            boolean r10 = com.paytm.utility.b.c((android.content.Context) r10)     // Catch:{ Exception -> 0x0112 }
            if (r10 == 0) goto L_0x010a
            net.one97.paytm.vipcashback.f.h r10 = net.one97.paytm.vipcashback.f.h.a()     // Catch:{ Exception -> 0x0112 }
            r8.setValue(r10)     // Catch:{ Exception -> 0x0112 }
            r9.a()     // Catch:{ Exception -> 0x0112 }
            return
        L_0x010a:
            net.one97.paytm.vipcashback.f.h r9 = net.one97.paytm.vipcashback.f.h.b(r9)     // Catch:{ Exception -> 0x0112 }
            r8.setValue(r9)     // Catch:{ Exception -> 0x0112 }
            return
        L_0x0112:
            r8 = move-exception
            r8.getMessage()
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.b.g.a(androidx.lifecycle.y, java.lang.String, java.lang.String, java.lang.Boolean):void");
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20365a;

        a(y yVar) {
            this.f20365a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20365a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20365a.setValue(h.a(iJRPaytmDataModel));
        }
    }
}
