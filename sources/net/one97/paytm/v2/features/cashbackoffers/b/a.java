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

public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20355a;

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

    public a(Context context) {
        k.c(context, "appContext");
        this.f20355a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0085 A[SYNTHETIC, Splitter:B:15:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0097 A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c0 A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c6 A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011b A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0126 A[Catch:{ Exception -> 0x012e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r8, java.lang.String r9, java.lang.String r10, java.lang.Boolean r11) {
        /*
            r7 = this;
            java.lang.String r0 = "result"
            kotlin.g.b.k.c(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r0.<init>()     // Catch:{ Exception -> 0x012e }
            net.one97.paytm.vipcashback.f.f r1 = net.one97.paytm.vipcashback.f.f.a()     // Catch:{ Exception -> 0x012e }
            java.lang.String r2 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = net.one97.paytm.vipcashback.f.f.E()     // Catch:{ Exception -> 0x012e }
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = "&redemptionTypes="
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            net.one97.paytm.vipcashback.d.a$f$a r1 = net.one97.paytm.vipcashback.d.a.f.f20792a     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.f.f20794c     // Catch:{ Exception -> 0x012e }
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = ",UPI,PPBL,"
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            net.one97.paytm.vipcashback.d.a$f$a r1 = net.one97.paytm.vipcashback.d.a.f.f20792a     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.f.f20793b     // Catch:{ Exception -> 0x012e }
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = ",GV_CASHBACK,PG_CASHBACK&statusList="
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            net.one97.paytm.vipcashback.d.a$j$a r1 = net.one97.paytm.vipcashback.d.a.j.f20817a     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.j.f20822f     // Catch:{ Exception -> 0x012e }
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            r1 = 44
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            net.one97.paytm.vipcashback.d.a$j$a r1 = net.one97.paytm.vipcashback.d.a.j.f20817a     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.j.f20823g     // Catch:{ Exception -> 0x012e }
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            r1 = 38
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x012e }
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x012e }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x012e }
            if (r2 != 0) goto L_0x0132
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r2.<init>()     // Catch:{ Exception -> 0x012e }
            r2.append(r0)     // Catch:{ Exception -> 0x012e }
            r0 = 1
            r3 = 0
            if (r9 == 0) goto L_0x0080
            r4 = r9
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x012e }
            int r4 = r4.length()     // Catch:{ Exception -> 0x012e }
            if (r4 != 0) goto L_0x007b
            r4 = 1
            goto L_0x007c
        L_0x007b:
            r4 = 0
        L_0x007c:
            if (r4 != 0) goto L_0x0080
            r4 = 1
            goto L_0x0081
        L_0x0080:
            r4 = 0
        L_0x0081:
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0097
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            java.lang.String r6 = "excludedIds="
            r4.<init>(r6)     // Catch:{ Exception -> 0x012e }
            r4.append(r9)     // Catch:{ Exception -> 0x012e }
            r4.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = r4.toString()     // Catch:{ Exception -> 0x012e }
            goto L_0x0098
        L_0x0097:
            r9 = r5
        L_0x0098:
            r2.append(r9)     // Catch:{ Exception -> 0x012e }
            if (r10 == 0) goto L_0x00ac
            r9 = r10
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x012e }
            int r9 = r9.length()     // Catch:{ Exception -> 0x012e }
            if (r9 != 0) goto L_0x00a8
            r9 = 1
            goto L_0x00a9
        L_0x00a8:
            r9 = 0
        L_0x00a9:
            if (r9 != 0) goto L_0x00ac
            r3 = 1
        L_0x00ac:
            if (r3 == 0) goto L_0x00c0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = "beforeTime="
            r9.<init>(r0)     // Catch:{ Exception -> 0x012e }
            r9.append(r10)     // Catch:{ Exception -> 0x012e }
            r9.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x012e }
            goto L_0x00c1
        L_0x00c0:
            r9 = r5
        L_0x00c1:
            r2.append(r9)     // Catch:{ Exception -> 0x012e }
            if (r11 == 0) goto L_0x00d0
            java.lang.String r9 = "isAggregationRequired="
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x012e }
            java.lang.String r5 = r9.concat(r10)     // Catch:{ Exception -> 0x012e }
        L_0x00d0:
            r2.append(r5)     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = r2.toString()     // Catch:{ Exception -> 0x012e }
            net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a     // Catch:{ Exception -> 0x012e }
            com.paytm.network.b r10 = net.one97.paytm.vipcashback.f.d.a.c()     // Catch:{ Exception -> 0x012e }
            com.paytm.network.a$a r11 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x012e }
            com.paytm.network.b r10 = r10.a((com.paytm.network.a.C0715a) r11)     // Catch:{ Exception -> 0x012e }
            com.paytm.network.b r9 = r10.a((java.lang.String) r9)     // Catch:{ Exception -> 0x012e }
            net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a     // Catch:{ Exception -> 0x012e }
            java.util.HashMap r10 = net.one97.paytm.vipcashback.f.d.a.b()     // Catch:{ Exception -> 0x012e }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Exception -> 0x012e }
            com.paytm.network.b r9 = r9.a((java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ Exception -> 0x012e }
            net.one97.paytm.common.entity.vipcashback.CashbackAllCards r10 = new net.one97.paytm.common.entity.vipcashback.CashbackAllCards     // Catch:{ Exception -> 0x012e }
            r10.<init>()     // Catch:{ Exception -> 0x012e }
            com.paytm.network.model.IJRPaytmDataModel r10 = (com.paytm.network.model.IJRPaytmDataModel) r10     // Catch:{ Exception -> 0x012e }
            com.paytm.network.b r9 = r9.a((com.paytm.network.model.IJRPaytmDataModel) r10)     // Catch:{ Exception -> 0x012e }
            java.lang.String r10 = "DealLanding"
            com.paytm.network.b r9 = r9.c(r10)     // Catch:{ Exception -> 0x012e }
            net.one97.paytm.v2.features.cashbackoffers.b.a$a r10 = new net.one97.paytm.v2.features.cashbackoffers.b.a$a     // Catch:{ Exception -> 0x012e }
            r10.<init>(r8)     // Catch:{ Exception -> 0x012e }
            com.paytm.network.listener.b r10 = (com.paytm.network.listener.b) r10     // Catch:{ Exception -> 0x012e }
            com.paytm.network.b r9 = r9.a((com.paytm.network.listener.b) r10)     // Catch:{ Exception -> 0x012e }
            com.paytm.network.a r9 = r9.l()     // Catch:{ Exception -> 0x012e }
            android.content.Context r10 = r7.f20355a     // Catch:{ Exception -> 0x012e }
            boolean r10 = com.paytm.utility.b.c((android.content.Context) r10)     // Catch:{ Exception -> 0x012e }
            if (r10 == 0) goto L_0x0126
            net.one97.paytm.vipcashback.f.h r10 = net.one97.paytm.vipcashback.f.h.a()     // Catch:{ Exception -> 0x012e }
            r8.setValue(r10)     // Catch:{ Exception -> 0x012e }
            r9.a()     // Catch:{ Exception -> 0x012e }
            return
        L_0x0126:
            net.one97.paytm.vipcashback.f.h r9 = net.one97.paytm.vipcashback.f.h.b(r9)     // Catch:{ Exception -> 0x012e }
            r8.setValue(r9)     // Catch:{ Exception -> 0x012e }
            return
        L_0x012e:
            r8 = move-exception
            r8.getMessage()
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.b.a.a(androidx.lifecycle.y, java.lang.String, java.lang.String, java.lang.Boolean):void");
    }

    /* renamed from: net.one97.paytm.v2.features.cashbackoffers.b.a$a  reason: collision with other inner class name */
    public static final class C0365a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20356a;

        C0365a(y yVar) {
            this.f20356a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20356a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20356a.setValue(h.a(iJRPaytmDataModel));
        }
    }
}
