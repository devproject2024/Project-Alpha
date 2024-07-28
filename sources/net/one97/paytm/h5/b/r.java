package net.one97.paytm.h5.b;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.h5paytmsdk.c.s;
import net.one97.paytm.h5paytmsdk.c.t;

public final class r implements s {

    /* renamed from: a  reason: collision with root package name */
    private final String f16936a = "whatsapp";

    static final class a extends l implements m<String, Integer, x> {
        final /* synthetic */ t $callback;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(t tVar) {
            super(2);
            this.$callback = tVar;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((String) obj, ((Number) obj2).intValue());
            return x.f47997a;
        }

        public final void invoke(String str, int i2) {
            k.c(str, "url");
            this.$callback.a(str);
        }
    }

    public final void a(Context context, HashMap<String, String> hashMap, t tVar) {
        k.c(context, "context");
        k.c(hashMap, "params");
        k.c(tVar, H5Event.TYPE_CALL_BACK);
        if (hashMap.size() > 0) {
            try {
                String str = hashMap.get("af_dp");
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("af_dp", URLDecoder.decode(str, AppConstants.UTF_8));
                }
            } catch (UnsupportedEncodingException e2) {
                getClass().getCanonicalName();
                q.b(e2.getMessage());
            }
            net.one97.paytm.utils.m mVar = net.one97.paytm.utils.m.f69757a;
            net.one97.paytm.utils.m.a(context, this.f16936a, hashMap, new a(tVar), 0);
            return;
        }
        tVar.a("");
    }
}
