package net.one97.paytm.v2.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.cashback.posttxn.CashbackBaseTagOfferListModel;
import net.one97.paytm.common.entity.vipcashback.CampaignData;
import net.one97.paytm.common.entity.vipcashback.ErrorModel;
import net.one97.paytm.vipcashback.f.a;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.f;
import net.one97.paytm.vipcashback.f.h;

public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final String f20039a = "after_id";

    /* renamed from: b  reason: collision with root package name */
    private final String f20040b = "page_number";

    /* renamed from: c  reason: collision with root package name */
    private final String f20041c = "page_size";

    /* renamed from: d  reason: collision with root package name */
    private final String f20042d = "offer_tag";

    /* renamed from: e  reason: collision with root package name */
    private final String f20043e = "page_offset";

    /* renamed from: f  reason: collision with root package name */
    private int f20044f = 1;

    /* renamed from: g  reason: collision with root package name */
    private final Context f20045g;

    public final void a(y<h<Object>> yVar, String str, String str2, Boolean bool) {
        k.c(yVar, "result");
    }

    public a(Context context) {
        k.c(context, "appContext");
        this.f20045g = context;
    }

    public final void a(y<h<Object>> yVar, String str, int i2, int i3) {
        k.c(yVar, "result");
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String r = f.r();
        if (!TextUtils.isEmpty(r)) {
            String str2 = r + "?" + this.f20039a + "=" + i2 + AppConstants.AND_SIGN + this.f20040b + "=" + this.f20044f + AppConstants.AND_SIGN + this.f20041c + "=20&" + this.f20043e + "=" + i3;
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(AppConstants.AND_SIGN);
                sb.append(this.f20042d);
                sb.append("=");
                String encode = URLEncoder.encode(str, AppConstants.UTF_8);
                k.a((Object) encode, "URLEncoder.encode(offersTag, \"UTF-8\")");
                sb.append(p.a(encode, "+", "%20", false));
                str2 = sb.toString();
            }
            d.a aVar = d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(str2);
            d.a aVar2 = d.f20859a;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CampaignData()).c("CashbackLanding").a((com.paytm.network.listener.b) new C0354a(yVar)).l();
            if (com.paytm.utility.b.c(this.f20045g)) {
                l.a();
            } else {
                yVar.setValue(h.b(l));
            }
        }
    }

    /* renamed from: net.one97.paytm.v2.a.a$a  reason: collision with other inner class name */
    public static final class C0354a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20046a;

        C0354a(y yVar) {
            this.f20046a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20046a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20046a.setValue(h.a(iJRPaytmDataModel));
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20047a;

        b(y yVar) {
            this.f20047a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f20047a.setValue(h.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkError");
            this.f20047a.setValue(h.a(new ErrorModel(i2, iJRPaytmDataModel), networkCustomError));
        }
    }

    public final void a(y<h<Object>> yVar, String str, String str2) {
        k.c(yVar, "mediator");
        k.c(str, StringSet.filter);
        k.c(str2, "pageNo");
        a.C0397a aVar = net.one97.paytm.vipcashback.f.a.f20855a;
        com.paytm.network.a a2 = a.C0397a.a(new b(yVar), str, str2, false);
        if (com.paytm.utility.b.c(this.f20045g)) {
            yVar.setValue(h.a());
            if (a2 != null) {
                a2.a();
                return;
            }
            return;
        }
        yVar.setValue(h.b(a2));
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20048a;

        c(y yVar) {
            this.f20048a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f20048a.setValue(h.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkError");
            this.f20048a.setValue(h.a(new ErrorModel(i2, iJRPaytmDataModel), networkCustomError));
        }
    }

    public final void a(y<h<Object>> yVar, String str) {
        com.paytm.network.a aVar;
        k.c(yVar, "mediator");
        k.c(str, "offersTag");
        a.C0397a aVar2 = net.one97.paytm.vipcashback.f.a.f20855a;
        com.paytm.network.listener.b cVar = new c(yVar);
        k.c(str, "tag");
        k.c(cVar, "apiListener");
        StringBuilder sb = new StringBuilder();
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        sb.append(f.p());
        String encode = URLEncoder.encode(str, AppConstants.UTF_8);
        k.a((Object) encode, "URLEncoder.encode(tag, \"UTF-8\")");
        sb.append(p.a(encode, "+", "%20", false));
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            aVar = null;
        } else {
            d.a aVar3 = d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(sb2);
            d.a aVar4 = d.f20859a;
            aVar = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CashbackBaseTagOfferListModel()).c("myvoucherdetails").a(cVar).l();
        }
        if (com.paytm.utility.b.c(this.f20045g)) {
            yVar.setValue(h.a());
            if (aVar != null) {
                aVar.a();
            }
        } else if (aVar != null) {
            yVar.setValue(h.b(aVar));
        }
    }
}
