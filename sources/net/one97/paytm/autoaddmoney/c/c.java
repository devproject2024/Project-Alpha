package net.one97.paytm.autoaddmoney.c;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.autoaddmoney.b.d;
import net.one97.paytm.autoaddmoney.b.e;
import net.one97.paytm.autoaddmoney.b.f;
import net.one97.paytm.autoaddmoney.b.h;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.autoaddmoney.data.source.b;
import net.one97.paytm.common.entity.IJRDataModel;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<d>> f49207a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<e>> f49208b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<e>> f49209c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final y<Boolean> f49210d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public final y<Boolean> f49211e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<h>> f49212f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<x>> f49213g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<com.paytm.network.a>> f49214h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<f>> f49215i = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<ArrayList<IJRDataModel>>> j = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<e>> k = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<Boolean>> l = new y<>();
    public final b m;

    public c(b bVar) {
        k.c(bVar, "amRepository");
        this.m = bVar;
    }

    public static int a(String str) {
        k.c(str, "kycState");
        int h2 = net.one97.paytm.helper.a.f50546a.a().h("addMoneyMinBalanceMaxLimitMinKyc");
        if (k.a((Object) str, (Object) net.one97.paytm.newaddmoney.utils.d.PAYTM_PRIME_WALLET.name()) || k.a((Object) str, (Object) net.one97.paytm.newaddmoney.utils.d.PAYTM_ADHAAR_OTP_KYC.name())) {
            h2 = net.one97.paytm.helper.a.f50546a.a().h("addMoneyMinBalanceMaxLimit");
        }
        if (h2 > 0) {
            return String.valueOf(h2).length();
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086 A[Catch:{ Exception -> 0x00b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = 0
            net.one97.paytm.helper.a$a r1 = net.one97.paytm.helper.a.f50546a     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.c r1 = r1.a()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r2 = "addMoneyTopupMinLimitMinKyc"
            int r1 = r1.h((java.lang.String) r2)     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.a$a r2 = net.one97.paytm.helper.a.f50546a     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.c r2 = r2.a()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r3 = "addMoneyTopupMaxLimitMinKyc"
            int r2 = r2.h((java.lang.String) r3)     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.a$a r3 = net.one97.paytm.helper.a.f50546a     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.c r3 = r3.a()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r4 = "addMoneyMaxSumAmountMinKyc"
            int r3 = r3.h((java.lang.String) r4)     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.newaddmoney.utils.d r4 = net.one97.paytm.newaddmoney.utils.d.PAYTM_PRIME_WALLET     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x00b8 }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00b8 }
            if (r4 != 0) goto L_0x003d
            net.one97.paytm.newaddmoney.utils.d r4 = net.one97.paytm.newaddmoney.utils.d.PAYTM_ADHAAR_OTP_KYC     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x00b8 }
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00b8 }
            if (r8 == 0) goto L_0x0061
        L_0x003d:
            net.one97.paytm.helper.a$a r8 = net.one97.paytm.helper.a.f50546a     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.c r8 = r8.a()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r1 = "addMoneyTopupMinLimit"
            int r1 = r8.h((java.lang.String) r1)     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.a$a r8 = net.one97.paytm.helper.a.f50546a     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.c r8 = r8.a()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r2 = "addMoneyTopupMaxLimit"
            int r2 = r8.h((java.lang.String) r2)     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.a$a r8 = net.one97.paytm.helper.a.f50546a     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.helper.c r8 = r8.a()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r3 = "addMoneyMaxSumAmount"
            int r3 = r8.h((java.lang.String) r3)     // Catch:{ Exception -> 0x00b8 }
        L_0x0061:
            if (r1 != 0) goto L_0x0065
            r1 = 100
        L_0x0065:
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x00b8 }
            r4 = 1
            if (r8 == 0) goto L_0x0074
            int r8 = r8.length()     // Catch:{ Exception -> 0x00b8 }
            if (r8 != 0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r8 = 0
            goto L_0x0075
        L_0x0074:
            r8 = 1
        L_0x0075:
            if (r8 != 0) goto L_0x00a9
            int r8 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x00b8 }
            if (r8 < r1) goto L_0x00a9
            if (r2 <= 0) goto L_0x0086
            int r8 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x00b8 }
            if (r8 <= r2) goto L_0x0086
            goto L_0x00a9
        L_0x0086:
            java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x00b8 }
            if (r3 != 0) goto L_0x008d
            r3 = 10000(0x2710, float:1.4013E-41)
        L_0x008d:
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x00b8 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x00b8 }
            int r7 = r7 + r6
            if (r7 <= r3) goto L_0x00a8
            androidx.lifecycle.y<net.one97.paytm.autoaddmoney.a<net.one97.paytm.autoaddmoney.b.e>> r6 = r5.k     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.autoaddmoney.a r7 = new net.one97.paytm.autoaddmoney.a     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.autoaddmoney.b.e r8 = new net.one97.paytm.autoaddmoney.b.e     // Catch:{ Exception -> 0x00b8 }
            r8.<init>(r1, r3)     // Catch:{ Exception -> 0x00b8 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00b8 }
            r6.setValue(r7)     // Catch:{ Exception -> 0x00b8 }
            return r0
        L_0x00a8:
            return r4
        L_0x00a9:
            androidx.lifecycle.y<net.one97.paytm.autoaddmoney.a<net.one97.paytm.autoaddmoney.b.e>> r6 = r5.f49209c     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.autoaddmoney.a r7 = new net.one97.paytm.autoaddmoney.a     // Catch:{ Exception -> 0x00b8 }
            net.one97.paytm.autoaddmoney.b.e r8 = new net.one97.paytm.autoaddmoney.b.e     // Catch:{ Exception -> 0x00b8 }
            r8.<init>(r1, r2)     // Catch:{ Exception -> 0x00b8 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00b8 }
            r6.setValue(r7)     // Catch:{ Exception -> 0x00b8 }
        L_0x00b8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.c.c.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static final class a implements a.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f49216a;

        public final void a() {
        }

        public final void a(NetworkCustomError networkCustomError) {
        }

        public a(c cVar) {
            this.f49216a = cVar;
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            this.f49216a.a();
            this.f49216a.f49214h.setValue(new net.one97.paytm.autoaddmoney.a(aVar));
        }

        public final void a(ArrayList<IJRDataModel> arrayList) {
            this.f49216a.j.setValue(new net.one97.paytm.autoaddmoney.a(arrayList));
            this.f49216a.a();
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            this.f49216a.a();
            y c2 = this.f49216a.f49215i;
            String canonicalName = c.class.getCanonicalName();
            k.a((Object) canonicalName, "SetAutomaticFragmentView…:class.java.canonicalName");
            c2.setValue(new net.one97.paytm.autoaddmoney.a(new f(canonicalName, networkCustomError)));
        }
    }

    public final void a() {
        this.f49207a.setValue(new net.one97.paytm.autoaddmoney.a(new d("", false)));
    }
}
