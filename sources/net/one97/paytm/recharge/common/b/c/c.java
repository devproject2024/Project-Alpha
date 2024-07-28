package net.one97.paytm.recharge.common.b.c;

import android.content.Context;
import android.webkit.URLUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.bf;
import net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListV2;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONObject;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f60930b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private final String f60931c;

    public final void a(String str, ai aiVar, String str2, String str3, long j, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str3, "rechargeNumber");
    }

    public final void a(String str, ai aiVar, String str2, String str3, String str4, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "categoryId");
        k.c(str3, "productId");
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "categoryId");
    }

    public final void b(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(jSONObject, "body");
        k.c(str2, "categoryId");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        k.c(context, "context");
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String B = net.one97.paytm.recharge.di.helper.c.B();
        this.f60931c = B == null ? "" : B;
    }

    public static final class a extends bf<c, Context> {
        private a() {
            super(AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "categoryUrl");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        if (!URLUtil.isValidUrl(this.f60931c)) {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (b.c(this.f60907a)) {
            Context context = this.f60907a;
            Context context2 = this.f60907a;
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b(str, b.b(context, b.b(context2, str2, net.one97.paytm.recharge.di.helper.c.C())), aiVar, new CJRRechargeProductListV2(), obj);
            d.a();
            d.b(bVar);
        } else {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
        }
    }
}
