package net.one97.paytm.v2.features.cashbackoffers.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.ErrorModel;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterResponse;
import net.one97.paytm.v2.a.f;
import net.one97.paytm.vipcashback.f.a;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.h;
import net.one97.paytm.vipcashback.g.d;

public final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    private Context f20359a;

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

    public final void a(y<h<Object>> yVar, String str, String str2, Boolean bool) {
        k.c(yVar, "result");
    }

    public c(Context context) {
        k.c(context, "context");
        this.f20359a = context;
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20360a;

        a(y yVar) {
            this.f20360a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f20360a.setValue(h.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkError");
            this.f20360a.setValue(h.a(new ErrorModel(i2, iJRPaytmDataModel), networkCustomError));
        }
    }

    public final void a(y<h<Object>> yVar) {
        com.paytm.network.a aVar;
        k.c(yVar, "result");
        a.C0397a aVar2 = net.one97.paytm.vipcashback.f.a.f20855a;
        b aVar3 = new a(yVar);
        k.c(aVar3, "apiListener");
        k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
        d.a aVar4 = d.f20859a;
        d.a.C0408a aVar5 = d.a.f21022a;
        String d2 = d.a.d(net.one97.paytm.vipcashback.f.f.n() + "?is_merchant=false", d.a.f21026e, "PROMO,DEAL");
        d.a aVar6 = net.one97.paytm.vipcashback.f.d.f20859a;
        d.a.C0408a aVar7 = d.a.f21022a;
        String d3 = d.a.d(d2, d.a.f21027f, "VOUCHER,DEAL");
        if (TextUtils.isEmpty(d3)) {
            aVar = null;
        } else {
            d.a aVar8 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(d3);
            d.a aVar9 = net.one97.paytm.vipcashback.f.d.f20859a;
            aVar = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new VoucherFilterResponse()).c("voucherlist").a(aVar3).l();
        }
        if (!com.paytm.utility.b.c(this.f20359a)) {
            yVar.setValue(h.b(aVar));
        } else if (aVar != null) {
            aVar.a();
        }
    }
}
