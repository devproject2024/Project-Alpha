package net.one97.paytm.p2b.e;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import kotlin.g.b.k;
import net.one97.paytm.P2B.CJRP2bCheckTxnStatus;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRCashWalletResponse;
import net.one97.paytm.common.entity.wallet.CJRLedger;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.p2b.data.a;
import net.one97.paytm.p2b.data.a.a;

public final class c extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.p2b.data.a.b f12785a;

    /* renamed from: b  reason: collision with root package name */
    public y<SanitizedResponseModel> f12786b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<IStaticWidget> f12787c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<net.one97.paytm.p2b.data.a<Double>> f12788d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<net.one97.paytm.p2b.data.a<CJRP2BStatus>> f12789e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<net.one97.paytm.p2b.data.a<CJRP2bCheckTxnStatus>> f12790f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<net.one97.paytm.p2b.data.a<CJRLedger>> f12791g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<IJRDataModel> f12792h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public String f12793i;
    public String j;
    public String k;
    public String l;
    public Double m;
    public String n;
    public Double o;
    public CJRP2BStatus p;
    public String q;
    public String r;
    public Boolean s = Boolean.FALSE;
    public String t;
    public String u;
    public String v;
    public String w = getClass().getName();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "application");
        this.f12785a = net.one97.paytm.p2b.data.a.b.a((Context) application);
    }

    /* renamed from: net.one97.paytm.p2b.e.c$c  reason: collision with other inner class name */
    public static final class C0171c implements a.C0169a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f12796a;

        public C0171c(c cVar) {
            this.f12796a = cVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            if (iJRPaytmDataModel instanceof CJRCashWallet) {
                y a2 = this.f12796a.f12788d;
                a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
                CJRCashWalletResponse response = ((CJRCashWallet) iJRPaytmDataModel).getResponse();
                k.a((Object) response, "response.response");
                a2.setValue(a.C0168a.a((Object) Double.valueOf(response.getPaytmWalletBalance())));
                return;
            }
            y a3 = this.f12796a.f12788d;
            a.C0168a aVar2 = net.one97.paytm.p2b.data.a.f12728d;
            a3.setValue(a.C0168a.a((NetworkCustomError) null));
        }

        public final void a(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "volleyError");
            y a2 = this.f12796a.f12788d;
            a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
            a2.setValue(a.C0168a.a(networkCustomError));
        }
    }

    public static final class b implements a.C0169a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f12795a;

        public b(c cVar) {
            this.f12795a = cVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRP2BStatus) {
                y b2 = this.f12795a.f12789e;
                a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
                b2.setValue(a.C0168a.a((Object) iJRPaytmDataModel));
                return;
            }
            y b3 = this.f12795a.f12789e;
            a.C0168a aVar2 = net.one97.paytm.p2b.data.a.f12728d;
            b3.setValue(a.C0168a.a((NetworkCustomError) null));
        }

        public final void a(NetworkCustomError networkCustomError) {
            y b2 = this.f12795a.f12789e;
            a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
            b2.setValue(a.C0168a.a((NetworkCustomError) null));
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            y<net.one97.paytm.p2b.data.a<CJRLedger>> yVar = this.f12791g;
            a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
            yVar.setValue(a.C0168a.a((NetworkCustomError) null));
            return;
        }
        y<net.one97.paytm.p2b.data.a<CJRLedger>> yVar2 = this.f12791g;
        a.C0168a aVar2 = net.one97.paytm.p2b.data.a.f12728d;
        yVar2.setValue(a.C0168a.a());
        net.one97.paytm.p2b.data.a.b bVar = this.f12785a;
        if (bVar != null) {
            bVar.b(new a(this), str, this.w);
        }
    }

    public static final class a implements a.C0169a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f12794a;

        a(c cVar) {
            this.f12794a = cVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRLedger) {
                y c2 = this.f12794a.f12791g;
                a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
                c2.setValue(a.C0168a.a((Object) iJRPaytmDataModel));
                return;
            }
            y c3 = this.f12794a.f12791g;
            a.C0168a aVar2 = net.one97.paytm.p2b.data.a.f12728d;
            c3.setValue(a.C0168a.a((NetworkCustomError) null));
        }

        public final void a(NetworkCustomError networkCustomError) {
            y c2 = this.f12794a.f12791g;
            a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
            c2.setValue(a.C0168a.a(networkCustomError));
        }
    }

    public final void a() {
        net.one97.paytm.p2b.data.a.b bVar = this.f12785a;
        if (bVar != null) {
            bVar.a(this.w);
        }
    }

    public static final class e implements a.C0169a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f12798a;

        public e(c cVar) {
            this.f12798a = cVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRP2bCheckTxnStatus) {
                y d2 = this.f12798a.f12790f;
                a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
                d2.setValue(a.C0168a.a((Object) iJRPaytmDataModel));
                return;
            }
            y d3 = this.f12798a.f12790f;
            a.C0168a aVar2 = net.one97.paytm.p2b.data.a.f12728d;
            d3.setValue(a.C0168a.a((NetworkCustomError) null));
        }

        public final void a(NetworkCustomError networkCustomError) {
            y d2 = this.f12798a.f12790f;
            a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
            d2.setValue(a.C0168a.a(networkCustomError));
        }
    }

    public static final class d implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f12797a;

        public d(c cVar) {
            this.f12797a = cVar;
        }

        public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                this.f12797a.f12786b.setValue(sanitizedResponseModel);
            }
        }
    }
}
