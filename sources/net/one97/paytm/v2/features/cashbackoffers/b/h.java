package net.one97.paytm.v2.features.cashbackoffers.b;

import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.v2.a.f;

public final class h implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20366a;

    public final void a(y<net.one97.paytm.vipcashback.f.h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "offersTag");
    }

    public final void a(y<net.one97.paytm.vipcashback.f.h<Object>> yVar, String str, int i2, int i3) {
        k.c(yVar, "result");
    }

    public final void a(y<net.one97.paytm.vipcashback.f.h<Object>> yVar, String str, String str2) {
        k.c(yVar, "result");
        k.c(str, StringSet.filter);
        k.c(str2, "pageNo");
    }

    public h(Context context) {
        k.c(context, "appContext");
        this.f20366a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0069 A[SYNTHETIC, Splitter:B:15:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007b A[Catch:{ Exception -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081 A[Catch:{ Exception -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A[Catch:{ Exception -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ee A[Catch:{ Exception -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f9 A[Catch:{ Exception -> 0x0101 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r7, java.lang.String r8, java.lang.String r9, java.lang.Boolean r10) {
        /*
            r6 = this;
            java.lang.String r10 = "result"
            kotlin.g.b.k.c(r7, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101 }
            r10.<init>()     // Catch:{ Exception -> 0x0101 }
            net.one97.paytm.vipcashback.f.f r0 = net.one97.paytm.vipcashback.f.f.a()     // Catch:{ Exception -> 0x0101 }
            java.lang.String r1 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r0 = net.one97.paytm.vipcashback.f.f.E()     // Catch:{ Exception -> 0x0101 }
            r10.append(r0)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r0 = "&statusList="
            r10.append(r0)     // Catch:{ Exception -> 0x0101 }
            net.one97.paytm.vipcashback.d.a$j$a r0 = net.one97.paytm.vipcashback.d.a.j.f20817a     // Catch:{ Exception -> 0x0101 }
            java.lang.String r0 = net.one97.paytm.vipcashback.d.a.j.f20821e     // Catch:{ Exception -> 0x0101 }
            r10.append(r0)     // Catch:{ Exception -> 0x0101 }
            r0 = 44
            r10.append(r0)     // Catch:{ Exception -> 0x0101 }
            net.one97.paytm.vipcashback.d.a$j$a r0 = net.one97.paytm.vipcashback.d.a.j.f20817a     // Catch:{ Exception -> 0x0101 }
            java.lang.String r0 = net.one97.paytm.vipcashback.d.a.j.f20824h     // Catch:{ Exception -> 0x0101 }
            r10.append(r0)     // Catch:{ Exception -> 0x0101 }
            r0 = 38
            r10.append(r0)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0101 }
            r1 = r10
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0101 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0101 }
            if (r1 != 0) goto L_0x0105
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101 }
            r1.<init>()     // Catch:{ Exception -> 0x0101 }
            r1.append(r10)     // Catch:{ Exception -> 0x0101 }
            r10 = 1
            r2 = 0
            if (r8 == 0) goto L_0x0064
            r3 = r8
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0101 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0101 }
            if (r3 != 0) goto L_0x005f
            r3 = 1
            goto L_0x0060
        L_0x005f:
            r3 = 0
        L_0x0060:
            if (r3 != 0) goto L_0x0064
            r3 = 1
            goto L_0x0065
        L_0x0064:
            r3 = 0
        L_0x0065:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x007b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101 }
            java.lang.String r5 = "excludedIds="
            r3.<init>(r5)     // Catch:{ Exception -> 0x0101 }
            r3.append(r8)     // Catch:{ Exception -> 0x0101 }
            r3.append(r0)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r8 = r3.toString()     // Catch:{ Exception -> 0x0101 }
            goto L_0x007c
        L_0x007b:
            r8 = r4
        L_0x007c:
            r1.append(r8)     // Catch:{ Exception -> 0x0101 }
            if (r9 == 0) goto L_0x0090
            r8 = r9
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0101 }
            int r8 = r8.length()     // Catch:{ Exception -> 0x0101 }
            if (r8 != 0) goto L_0x008c
            r8 = 1
            goto L_0x008d
        L_0x008c:
            r8 = 0
        L_0x008d:
            if (r8 != 0) goto L_0x0090
            r2 = 1
        L_0x0090:
            if (r2 == 0) goto L_0x00a3
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101 }
            java.lang.String r10 = "beforeTime="
            r8.<init>(r10)     // Catch:{ Exception -> 0x0101 }
            r8.append(r9)     // Catch:{ Exception -> 0x0101 }
            r8.append(r0)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x0101 }
        L_0x00a3:
            r1.append(r4)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x0101 }
            net.one97.paytm.vipcashback.f.d$a r9 = net.one97.paytm.vipcashback.f.d.f20859a     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.b r9 = net.one97.paytm.vipcashback.f.d.a.c()     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.a$a r10 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.b r9 = r9.a((com.paytm.network.a.C0715a) r10)     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.b r8 = r9.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0101 }
            net.one97.paytm.vipcashback.f.d$a r9 = net.one97.paytm.vipcashback.f.d.f20859a     // Catch:{ Exception -> 0x0101 }
            java.util.HashMap r9 = net.one97.paytm.vipcashback.f.d.a.b()     // Catch:{ Exception -> 0x0101 }
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.b r8 = r8.a((java.util.Map<java.lang.String, java.lang.String>) r9)     // Catch:{ Exception -> 0x0101 }
            net.one97.paytm.common.entity.vipcashback.CashbackAllCards r9 = new net.one97.paytm.common.entity.vipcashback.CashbackAllCards     // Catch:{ Exception -> 0x0101 }
            r9.<init>()     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.model.IJRPaytmDataModel r9 = (com.paytm.network.model.IJRPaytmDataModel) r9     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.b r8 = r8.a((com.paytm.network.model.IJRPaytmDataModel) r9)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r9 = "DealLanding"
            com.paytm.network.b r8 = r8.c(r9)     // Catch:{ Exception -> 0x0101 }
            net.one97.paytm.v2.features.cashbackoffers.b.h$a r9 = new net.one97.paytm.v2.features.cashbackoffers.b.h$a     // Catch:{ Exception -> 0x0101 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.listener.b r9 = (com.paytm.network.listener.b) r9     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.b r8 = r8.a((com.paytm.network.listener.b) r9)     // Catch:{ Exception -> 0x0101 }
            com.paytm.network.a r8 = r8.l()     // Catch:{ Exception -> 0x0101 }
            android.content.Context r9 = r6.f20366a     // Catch:{ Exception -> 0x0101 }
            boolean r9 = com.paytm.utility.b.c((android.content.Context) r9)     // Catch:{ Exception -> 0x0101 }
            if (r9 == 0) goto L_0x00f9
            net.one97.paytm.vipcashback.f.h r9 = net.one97.paytm.vipcashback.f.h.a()     // Catch:{ Exception -> 0x0101 }
            r7.setValue(r9)     // Catch:{ Exception -> 0x0101 }
            r8.a()     // Catch:{ Exception -> 0x0101 }
            return
        L_0x00f9:
            net.one97.paytm.vipcashback.f.h r8 = net.one97.paytm.vipcashback.f.h.b(r8)     // Catch:{ Exception -> 0x0101 }
            r7.setValue(r8)     // Catch:{ Exception -> 0x0101 }
            return
        L_0x0101:
            r7 = move-exception
            r7.getMessage()
        L_0x0105:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.b.h.a(androidx.lifecycle.y, java.lang.String, java.lang.String, java.lang.Boolean):void");
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20367a;

        a(y yVar) {
            this.f20367a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20367a.setValue(net.one97.paytm.vipcashback.f.h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20367a.setValue(net.one97.paytm.vipcashback.f.h.a(iJRPaytmDataModel));
        }
    }
}
