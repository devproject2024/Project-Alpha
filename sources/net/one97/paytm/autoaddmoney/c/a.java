package net.one97.paytm.autoaddmoney.c;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRSubscribeAutoAdd;
import net.one97.paytm.addmoney.common.model.CJRVerifyPasscodeResponse;
import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<net.one97.paytm.autoaddmoney.b.d>> f49173a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<com.paytm.network.a>> f49174b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<net.one97.paytm.autoaddmoney.b.f>> f49175c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<Boolean>> f49176d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<Boolean>> f49177e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<Boolean>> f49178f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<String>> f49179g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<ArrayList<TncData>>> f49180h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<x>> f49181i = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<x>> j = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<CJRRechargePayment>> k = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<CJRRechargePayment>> l = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<net.one97.paytm.autoaddmoney.b.a>> m = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<String>> n = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<IJRDataModel>> o = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<x>> p = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<x>> q = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<x>> r = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<x>> s = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<ArrayList<IJRDataModel>>> t = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<net.one97.paytm.autoaddmoney.b.g>> u = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<x>> v = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<NetworkCustomError>> w = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<NetworkCustomError>> x = new y<>();
    public final net.one97.paytm.autoaddmoney.data.source.b y;

    public a(net.one97.paytm.autoaddmoney.data.source.b bVar) {
        k.c(bVar, "amRepository");
        this.y = bVar;
    }

    public static String a() {
        return net.one97.paytm.helper.a.f50546a.a().f("textForAddCard");
    }

    public final void b() {
        this.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", true)));
    }

    public static final class b implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49184a;

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
        }

        public final void a(NetworkCustomError networkCustomError) {
        }

        b(a aVar) {
            this.f49184a = aVar;
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            y a2 = this.f49184a.f49175c;
            String canonicalName = a.class.getCanonicalName();
            k.a((Object) canonicalName, "AmBottomsheetSelectCardV…:class.java.canonicalName");
            a2.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.f(canonicalName, networkCustomError)));
        }

        public final void a() {
            this.f49184a.f49179g.setValue(new net.one97.paytm.autoaddmoney.a(net.one97.paytm.helper.a.f50546a.a().a(R.string.msg_invalid_url)));
        }

        public final void a(ArrayList<TncData> arrayList) {
            k.c(arrayList, "mTncDataList");
            this.f49184a.f49180h.setValue(new net.one97.paytm.autoaddmoney.a(arrayList));
        }

        public final void a(String str) {
            k.c(str, "message");
            this.f49184a.f49179g.setValue(new net.one97.paytm.autoaddmoney.a(str));
        }
    }

    public final void c() {
        this.y.a((a.f) new b(this));
    }

    public static final class f implements a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49190a;

        public f(a aVar) {
            this.f49190a = aVar;
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f49190a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
        }

        public final void b() {
            this.f49190a.f49181i.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            this.f49190a.f49174b.setValue(new net.one97.paytm.autoaddmoney.a(aVar));
            this.f49190a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
        }

        public final void a(String str) {
            k.c(str, "message");
            this.f49190a.j.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
        }

        public final void a() {
            this.f49190a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            this.f49190a.f49179g.setValue(new net.one97.paytm.autoaddmoney.a(net.one97.paytm.helper.a.f50546a.a().a(R.string.msg_invalid_url)));
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            this.f49190a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            y a2 = this.f49190a.f49175c;
            String canonicalName = a.class.getCanonicalName();
            k.a((Object) canonicalName, "AmBottomsheetSelectCardV…:class.java.canonicalName");
            a2.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.f(canonicalName, networkCustomError)));
        }
    }

    public static final class d implements a.j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49186a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f49187b;

        d(a aVar, boolean z) {
            this.f49186a = aVar;
            this.f49187b = z;
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f49186a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            this.f49186a.x.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
        }

        public final void a() {
            this.f49186a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            this.f49186a.f49179g.setValue(new net.one97.paytm.autoaddmoney.a(net.one97.paytm.helper.a.f50546a.a().a(R.string.msg_invalid_url)));
        }

        public final void a(CJRRechargePayment cJRRechargePayment) {
            k.c(cJRRechargePayment, "cjrRechargePayment");
            if (this.f49187b) {
                this.f49186a.l.setValue(new net.one97.paytm.autoaddmoney.a(cJRRechargePayment));
            } else {
                this.f49186a.k.setValue(new net.one97.paytm.autoaddmoney.a(cJRRechargePayment));
            }
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            this.f49186a.f49174b.setValue(new net.one97.paytm.autoaddmoney.a(aVar));
            this.f49186a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            this.f49186a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            y a2 = this.f49186a.f49175c;
            String canonicalName = a.class.getCanonicalName();
            k.a((Object) canonicalName, "AmBottomsheetSelectCardV…:class.java.canonicalName");
            a2.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.f(canonicalName, networkCustomError)));
        }
    }

    public final void a(String str, boolean z) {
        b();
        this.y.a(str, (a.j) new d(this, z));
    }

    public static final class h implements a.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49192a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f49193b;

        h(a aVar, boolean z) {
            this.f49192a = aVar;
            this.f49193b = z;
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            this.f49192a.f49174b.setValue(new net.one97.paytm.autoaddmoney.a(aVar));
            this.f49192a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
        }

        public final void a(String str) {
            k.c(str, "message");
            this.f49192a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            this.f49192a.r.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
        }

        public final void a(CJROrderSummary cJROrderSummary) {
            k.c(cJROrderSummary, "CJROrderSummary");
            if (this.f49193b) {
                this.f49192a.s.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
                return;
            }
            String paymentStatus = cJROrderSummary.getPaymentStatus();
            if (p.a(paymentStatus, "SUCCESS", true)) {
                this.f49192a.q.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
            } else if (p.a(paymentStatus, "FAILED", true)) {
                this.f49192a.r.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
                this.f49192a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            } else {
                this.f49192a.n.setValue(new net.one97.paytm.autoaddmoney.a(""));
                this.f49192a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            }
        }
    }

    public final void b(String str, boolean z) {
        this.y.a(str, (a.i) new h(this, z));
    }

    public static final class e implements a.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f49189b;

        public final void a() {
        }

        public e(a aVar, ArrayList arrayList) {
            this.f49188a = aVar;
            this.f49189b = arrayList;
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f49188a.x.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            this.f49188a.f49174b.setValue(new net.one97.paytm.autoaddmoney.a(aVar));
            this.f49188a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
        }

        public final void a(ArrayList<IJRDataModel> arrayList) {
            if (arrayList != null) {
                IJRDataModel iJRDataModel = null;
                Iterator<IJRDataModel> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    IJRDataModel next = it2.next();
                    if (next instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card) {
                        if (this.f49189b.contains(((CJRAvailableInstrumentsAddMoneyCreditCard.Card) next).getSavedCardId())) {
                        }
                    } else if (next instanceof CJRAvailableInstrumentsAddMoney.Card) {
                        if (this.f49189b.contains(((CJRAvailableInstrumentsAddMoney.Card) next).getSavedCardId())) {
                        }
                    }
                    iJRDataModel = next;
                }
                if (iJRDataModel != null) {
                    this.f49188a.o.setValue(new net.one97.paytm.autoaddmoney.a(iJRDataModel));
                    this.f49188a.t.setValue(new net.one97.paytm.autoaddmoney.a(arrayList));
                    return;
                }
                this.f49188a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
                this.f49188a.f49179g.setValue(new net.one97.paytm.autoaddmoney.a(net.one97.paytm.helper.a.f50546a.a().a(R.string.auto_not_supported_card)));
            }
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            this.f49188a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            y a2 = this.f49188a.f49175c;
            String canonicalName = a.class.getCanonicalName();
            k.a((Object) canonicalName, "AmBottomsheetSelectCardV…:class.java.canonicalName");
            a2.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.f(canonicalName, networkCustomError)));
        }
    }

    public static final class c implements a.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49185a;

        public c(a aVar) {
            this.f49185a = aVar;
        }

        public final void a(HasLowSuccess hasLowSuccess, String str, String str2) {
            this.f49185a.m.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.a(hasLowSuccess, str, str2)));
        }
    }

    public final void a(IJRDataModel iJRDataModel, String str, String str2, boolean z) {
        this.y.a(iJRDataModel, str, str2, z ? "EDIT" : "ADD", new C0870a(this, iJRDataModel));
    }

    /* renamed from: net.one97.paytm.autoaddmoney.c.a$a  reason: collision with other inner class name */
    public static final class C0870a implements a.C0872a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49182a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IJRDataModel f49183b;

        C0870a(a aVar, IJRDataModel iJRDataModel) {
            this.f49182a = aVar;
            this.f49183b = iJRDataModel;
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f49182a.x.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
        }

        public final void a(CJRSubscribeAutoAdd cJRSubscribeAutoAdd) {
            this.f49182a.u.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.g(cJRSubscribeAutoAdd, this.f49183b)));
            this.f49182a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            this.f49182a.f49174b.setValue(new net.one97.paytm.autoaddmoney.a(aVar));
            this.f49182a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
        }

        public final void a() {
            this.f49182a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            this.f49182a.f49179g.setValue(new net.one97.paytm.autoaddmoney.a(net.one97.paytm.helper.a.f50546a.a().a(R.string.msg_invalid_url)));
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            this.f49182a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            y a2 = this.f49182a.f49175c;
            String canonicalName = a.class.getCanonicalName();
            k.a((Object) canonicalName, "AmBottomsheetSelectCardV…:class.java.canonicalName");
            a2.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.f(canonicalName, networkCustomError)));
        }
    }

    public final void a(net.one97.paytm.addmoney.addmoneysource.c.c.b bVar, String str, String str2) {
        if (d()) {
            b();
            if (bVar != null) {
                bVar.a(com.paytm.e.a.b.a(net.one97.paytm.helper.a.f50546a.a().e(), str), new g(this), str2);
            }
        }
    }

    public static final class g implements net.one97.paytm.addmoney.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49191a;

        g(a aVar) {
            this.f49191a = aVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRVerifyPasscodeResponse) {
                CJRVerifyPasscodeResponse cJRVerifyPasscodeResponse = (CJRVerifyPasscodeResponse) iJRPaytmDataModel;
                if (cJRVerifyPasscodeResponse.getError() != null) {
                    this.f49191a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
                    this.f49191a.f49179g.setValue(new net.one97.paytm.autoaddmoney.a(cJRVerifyPasscodeResponse.getErrorDescription()));
                } else if (cJRVerifyPasscodeResponse.getAccessToken() != null) {
                    this.f49191a.v.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
                }
            }
        }

        public final void b(NetworkCustomError networkCustomError) {
            this.f49191a.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            if (networkCustomError == null || networkCustomError.networkResponse == null || !(networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
                this.f49191a.w.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
                return;
            }
            y a2 = this.f49191a.f49175c;
            String canonicalName = a.class.getCanonicalName();
            if (canonicalName == null) {
                k.a();
            }
            a2.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.f(canonicalName, networkCustomError)));
        }
    }

    public final boolean d() {
        if (com.paytm.utility.b.c(net.one97.paytm.helper.a.f50546a.a().j())) {
            return true;
        }
        this.f49173a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
        this.f49179g.setValue(new net.one97.paytm.autoaddmoney.a(net.one97.paytm.helper.a.f50546a.a().a(R.string.no_internet)));
        return false;
    }
}
