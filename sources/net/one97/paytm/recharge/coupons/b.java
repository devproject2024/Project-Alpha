package net.one97.paytm.recharge.coupons;

import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRSelectedRecharge;
import net.one97.paytm.recharge.common.b.c;
import net.one97.paytm.recharge.common.e.ai;

public final class b extends c implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final a f62263c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f62264e;

    /* renamed from: d  reason: collision with root package name */
    private c f62265d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(net.one97.paytm.recharge.common.b.b.b bVar, c cVar) {
        super(bVar, cVar);
        k.c(bVar, "rechargeLocalDataSource");
        k.c(cVar, "couponRemoteDataSource");
        this.f62265d = cVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final b a(net.one97.paytm.recharge.common.b.b.b bVar, c cVar) {
            b bVar2;
            k.c(bVar, "rechargeLocalDataSource");
            k.c(cVar, "rechargeRemoteDataSource");
            b c2 = b.f62264e;
            if (c2 != null) {
                return c2;
            }
            synchronized (this) {
                bVar2 = new b(bVar, cVar);
                b.f62264e = bVar2;
            }
            return bVar2;
        }
    }

    public final void a(String str, ai aiVar, String str2, String str3, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, StringSet.operator);
        k.c(str3, "circle");
        c cVar = this.f62265d;
        if (cVar != null) {
            cVar.a(str, aiVar, str2, str3, obj);
        }
    }

    public final void a(String str, ai aiVar, String str2, int i2, String str3, ArrayList<CJRSelectedRecharge> arrayList, String str4, String str5, Object obj) {
        String str6 = str;
        k.c(str, "tag");
        ai aiVar2 = aiVar;
        k.c(aiVar, "onSuccess");
        String str7 = str2;
        k.c(str2, "url");
        k.c(str3, "rechargeNumber");
        k.c(arrayList, "selectedRechargeList");
        k.c(str4, StringSet.operator);
        k.c(str5, "circle");
        c cVar = this.f62265d;
        if (cVar != null) {
            cVar.a(str, aiVar, str2, i2, str3, arrayList, str4, str5, obj);
        }
    }

    public final void e(String str, ai aiVar, String str2, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "mUrl");
        c cVar = this.f62265d;
        if (cVar != null) {
            cVar.e(str, aiVar, str2, obj);
        }
    }

    public final void a(String str, String str2, ai aiVar, Object obj) {
        k.c(str, "tag");
        k.c(str2, "promoCode");
        k.c(aiVar, "onSuccess");
        this.f62265d.a(str, str2, aiVar, obj);
    }
}
