package net.one97.paytm.autoaddmoney.c;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.autoaddmoney.b.f;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.autoaddmoney.views.AmAutomaticActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRCashWalletResponse;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeDisableAutoAdd;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeFetchStatus;

public final class b extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<net.one97.paytm.autoaddmoney.b.d>> f49194a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<x>> f49195b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<x>> f49196c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<com.paytm.network.a>> f49197d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<com.paytm.network.a>> f49198e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<com.paytm.network.a>> f49199f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<f>> f49200g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<ArrayList<IJRDataModel>>> f49201h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<x>> f49202i = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<String>> j = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<Boolean>> k = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<CJRSubscribeDisableAutoAdd>> l = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<CJRSubscribeDisableAutoAdd>> m = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<x>> n = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<CJRSubscribeFetchStatus>> o = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<CJRCashWalletResponse>> p = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<NetworkCustomError>> q = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<Boolean>> r = new y<>();
    public final net.one97.paytm.autoaddmoney.data.source.b s;
    private final y<net.one97.paytm.autoaddmoney.a<Boolean>> t = new y<>();

    public b(net.one97.paytm.autoaddmoney.data.source.b bVar) {
        k.c(bVar, "amRepository");
        this.s = bVar;
    }

    public final void a(boolean z) {
        this.r.setValue(new net.one97.paytm.autoaddmoney.a(Boolean.valueOf(z)));
    }

    public final void b(boolean z) {
        this.f49194a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", z)));
    }

    public static final class d implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49206a;

        public d(b bVar) {
            this.f49206a = bVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRCashWallet) {
                this.f49206a.p.setValue(new net.one97.paytm.autoaddmoney.a(((CJRCashWallet) iJRPaytmDataModel).getResponse()));
            }
            this.f49206a.b(false);
        }

        public final void b(NetworkCustomError networkCustomError) {
            this.f49206a.q.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
            this.f49206a.b(false);
        }
    }

    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49203a;

        public a(b bVar) {
            this.f49203a = bVar;
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f49203a.q.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
        }

        public final void a(CJRSubscribeDisableAutoAdd cJRSubscribeDisableAutoAdd) {
            if (p.a(cJRSubscribeDisableAutoAdd != null ? cJRSubscribeDisableAutoAdd.getStatusMessage() : null, "SUCCESS", true)) {
                this.f49203a.m.setValue(new net.one97.paytm.autoaddmoney.a(cJRSubscribeDisableAutoAdd));
                this.f49203a.f49194a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
                this.f49203a.l.setValue(new net.one97.paytm.autoaddmoney.a(cJRSubscribeDisableAutoAdd));
            }
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            this.f49203a.f49194a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            this.f49203a.f49199f.setValue(new net.one97.paytm.autoaddmoney.a(aVar));
        }

        public final void a(String str) {
            this.f49203a.f49194a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            if (str != null) {
                this.f49203a.j.setValue(new net.one97.paytm.autoaddmoney.a(str));
            }
        }

        public final void a() {
            this.f49203a.f49194a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            this.f49203a.j.setValue(new net.one97.paytm.autoaddmoney.a(net.one97.paytm.helper.a.f50546a.a().a(R.string.msg_invalid_url)));
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            this.f49203a.f49194a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
            y h2 = this.f49203a.f49200g;
            String canonicalName = a.class.getCanonicalName();
            k.a((Object) canonicalName, "AmBottomsheetSelectCardV…:class.java.canonicalName");
            h2.setValue(new net.one97.paytm.autoaddmoney.a(new f(canonicalName, networkCustomError)));
        }
    }

    /* renamed from: net.one97.paytm.autoaddmoney.c.b$b  reason: collision with other inner class name */
    public static final class C0871b implements a.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49204a;

        C0871b(b bVar) {
            this.f49204a = bVar;
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f49204a.q.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
            this.f49204a.a();
        }

        public final void a() {
            this.f49204a.a();
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            this.f49204a.a();
            this.f49204a.f49197d.setValue(new net.one97.paytm.autoaddmoney.a(aVar));
        }

        public final void a(ArrayList<IJRDataModel> arrayList) {
            this.f49204a.a();
            this.f49204a.f49201h.setValue(new net.one97.paytm.autoaddmoney.a(arrayList));
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            this.f49204a.a();
            y h2 = this.f49204a.f49200g;
            String canonicalName = b.class.getCanonicalName();
            k.a((Object) canonicalName, "EditAutomaticFragmentVie…:class.java.canonicalName");
            h2.setValue(new net.one97.paytm.autoaddmoney.a(new f(canonicalName, networkCustomError)));
        }
    }

    public final void c(boolean z) {
        b(true);
        this.s.a(z, (a.h) new C0871b(this));
    }

    public final void a() {
        this.f49194a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d("", false)));
    }

    public static final class c implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49205a;

        public c(b bVar) {
            this.f49205a = bVar;
        }

        public final void a(CJRSubscribeFetchStatus cJRSubscribeFetchStatus) {
            this.f49205a.o.setValue(new net.one97.paytm.autoaddmoney.a(cJRSubscribeFetchStatus));
        }

        public final void a(com.paytm.network.a aVar) {
            k.c(aVar, "cjrCommonNetworkCall");
            this.f49205a.f49197d.setValue(new net.one97.paytm.autoaddmoney.a(aVar));
            this.f49205a.a();
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f49205a.q.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
        }

        public final void a() {
            this.f49205a.a();
            this.f49205a.j.setValue(new net.one97.paytm.autoaddmoney.a(net.one97.paytm.helper.a.f50546a.a().a(R.string.msg_invalid_url)));
        }

        public final void b(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "customError");
            this.f49205a.a();
            y h2 = this.f49205a.f49200g;
            String canonicalName = AmAutomaticActivity.class.getCanonicalName();
            if (canonicalName == null) {
                canonicalName = "";
            }
            h2.setValue(new net.one97.paytm.autoaddmoney.a(new f(canonicalName, networkCustomError)));
        }
    }
}
