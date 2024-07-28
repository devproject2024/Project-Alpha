package net.one97.paytm.v2.features.offerdetail.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseNewOfferDetailV4;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseTNCModal;
import net.one97.paytm.common.entity.vipcashback.CashBackGameDetailV4;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.f;
import net.one97.paytm.vipcashback.f.h;
import org.json.JSONObject;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20444a;

    public a(Context context) {
        k.c(context, "appContext");
        this.f20444a = context;
    }

    public final void a(y<h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "gameId");
        f.a();
        String e2 = f.e();
        if (!TextUtils.isEmpty(e2)) {
            String str2 = e2 + str;
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(str2);
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CashBackGameDetailV4()).c("GameDetailCashback").a((com.paytm.network.listener.b) new c(yVar)).l();
            if (com.paytm.utility.b.c(this.f20444a)) {
                l.a();
            } else {
                yVar.setValue(h.b(l));
            }
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20447a;

        c(y yVar) {
            this.f20447a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f20447a;
            if (networkCustomError == null) {
                k.a();
            }
            yVar.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CashBackGameDetailV4) {
                CashBackGameDetailV4 cashBackGameDetailV4 = (CashBackGameDetailV4) iJRPaytmDataModel;
                if (cashBackGameDetailV4.getStatus() == 1 && cashBackGameDetailV4.getData() != null) {
                    this.f20447a.setValue(h.a(iJRPaytmDataModel));
                } else if (cashBackGameDetailV4.getErrors() != null && cashBackGameDetailV4.getErrors().size() > 0) {
                    y yVar = this.f20447a;
                    d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                    GetVIPCashBackErrorModal getVIPCashBackErrorModal = cashBackGameDetailV4.getErrors().get(0);
                    k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                    yVar.setValue(h.a(iJRPaytmDataModel, d.a.a(getVIPCashBackErrorModal)));
                }
            }
        }
    }

    public final void b(y<h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "url");
        if (!TextUtils.isEmpty(str)) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(str);
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CashBackBaseTNCModal()).c("CashBackTnC").a((com.paytm.network.listener.b) new d(yVar)).l();
            if (com.paytm.utility.b.c(this.f20444a)) {
                l.a();
            } else {
                yVar.setValue(h.b(l));
            }
        }
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20448a;

        d(y yVar) {
            this.f20448a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20448a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CashBackBaseTNCModal) {
                CashBackBaseTNCModal cashBackBaseTNCModal = (CashBackBaseTNCModal) iJRPaytmDataModel;
                if (cashBackBaseTNCModal.getStatus() == 1 && cashBackBaseTNCModal.getData() != null) {
                    this.f20448a.setValue(h.a(iJRPaytmDataModel));
                } else if (cashBackBaseTNCModal.getErrors() != null && cashBackBaseTNCModal.getErrors().size() > 0) {
                    y yVar = this.f20448a;
                    d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                    GetVIPCashBackErrorModal getVIPCashBackErrorModal = cashBackBaseTNCModal.getErrors().get(0);
                    k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                    yVar.setValue(h.a(iJRPaytmDataModel, d.a.a(getVIPCashBackErrorModal)));
                }
            }
        }
    }

    public final void c(y<h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "campaignId");
        f.a();
        String g2 = f.g();
        if (!TextUtils.isEmpty(g2)) {
            String str2 = g2 + str;
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(str2);
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CashBackBaseNewOfferDetailV4()).c("GameDetailCashback").a((com.paytm.network.listener.b) new b(yVar)).l();
            if (com.paytm.utility.b.c(this.f20444a)) {
                l.a();
            } else {
                yVar.setValue(h.b(l));
            }
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20446a;

        b(y yVar) {
            this.f20446a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20446a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CashBackBaseNewOfferDetailV4) {
                CashBackBaseNewOfferDetailV4 cashBackBaseNewOfferDetailV4 = (CashBackBaseNewOfferDetailV4) iJRPaytmDataModel;
                if (cashBackBaseNewOfferDetailV4.getStatus() == 1 && cashBackBaseNewOfferDetailV4.getData() != null) {
                    this.f20446a.setValue(h.a(iJRPaytmDataModel));
                } else if (cashBackBaseNewOfferDetailV4.getErrors() != null && cashBackBaseNewOfferDetailV4.getErrors().size() > 0) {
                    y yVar = this.f20446a;
                    d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                    GetVIPCashBackErrorModal getVIPCashBackErrorModal = cashBackBaseNewOfferDetailV4.getErrors().get(0);
                    k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                    yVar.setValue(h.a(iJRPaytmDataModel, d.a.a(getVIPCashBackErrorModal)));
                }
            }
        }
    }

    public final void a(y<h<Object>> yVar, String str, String str2, String str3) {
        String str4;
        k.c(yVar, "result");
        k.c(str, "campaignId");
        k.c(str3, "action");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", str3);
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder();
            k.a((Object) f.a(), "GTMHelper.getInstance()");
            sb.append(f.d());
            sb.append("/");
            sb.append(str2);
            str4 = sb.toString();
        } else {
            k.a((Object) f.a(), "GTMHelper.getInstance()");
            str4 = f.f();
            k.a((Object) str4, "GTMHelper.getInstance().selectOfferUrl");
        }
        if (!TextUtils.isEmpty(str4)) {
            jSONObject.put("campaignId", str.toString());
            jSONObject.put("campaign_id", str);
            jSONObject.put("action", str3);
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b b2 = d.a.c().a(a.C0715a.POST).a(str4).b(jSONObject.toString());
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.a l = b2.a((Map<String, String>) d.a.a(this.f20444a)).a((IJRPaytmDataModel) new CashBackBaseMyOfferModalV4()).c("GameActivate").a((com.paytm.network.listener.b) new C0370a(yVar)).l();
            if (com.paytm.utility.b.c(this.f20444a)) {
                yVar.setValue(h.a());
                l.a();
                return;
            }
            yVar.setValue(h.b(l));
        }
    }

    /* renamed from: net.one97.paytm.v2.features.offerdetail.b.a$a  reason: collision with other inner class name */
    public static final class C0370a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20445a;

        C0370a(y yVar) {
            this.f20445a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20445a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20445a.setValue(h.a(iJRPaytmDataModel));
        }
    }
}
