package net.one97.paytm.upgradeKyc.aotp.b;

import android.app.Application;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.upgradeKyc.EkycDataResponse;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharGenOTP;
import net.one97.paytm.common.entity.upgradeKyc.KycCheckDoc;
import net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData;
import net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.kycV3.b.c;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<String> f65535a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<o<String, Integer>> f65536b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> f65537c;

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> f65538d;

    /* renamed from: e  reason: collision with root package name */
    public y<String> f65539e;

    /* renamed from: f  reason: collision with root package name */
    public String f65540f;

    /* renamed from: g  reason: collision with root package name */
    public String f65541g;

    /* renamed from: h  reason: collision with root package name */
    boolean f65542h;

    /* renamed from: i  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> f65543i;
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharGenOTP>> j;
    public final y<String> k;
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycSavedUserData>> l;
    public final y<String> m;
    final y<String> n;
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<EkycDataResponse>> o;
    public String p;
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycCheckDoc>> q;
    private final y<Boolean> r;
    private final Application s;
    /* access modifiers changed from: private */
    public final net.one97.paytm.upgradeKyc.kycV3.b.c t;

    static final class c<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65546a;

        c(a aVar) {
            this.f65546a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Boolean bool = (Boolean) obj;
            net.one97.paytm.upgradeKyc.kycV3.b.c a2 = this.f65546a.t;
            boolean z = this.f65546a.f65542h;
            String valueOf = String.valueOf(this.f65546a.f65539e.getValue());
            k.a((Object) bool, "it");
            return a2.a(z, valueOf, bool.booleanValue());
        }
    }

    static final class d<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65547a;

        d(a aVar) {
            this.f65547a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            net.one97.paytm.upgradeKyc.kycV3.b.c a2 = this.f65547a.t;
            String str2 = this.f65547a.f65540f;
            String str3 = this.f65547a.f65541g;
            k.a((Object) str, "it");
            return a2.a(str2, str, str3);
        }
    }

    static final class f<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65549a;

        f(a aVar) {
            this.f65549a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            o oVar = (o) obj;
            return this.f65549a.t.a(((Number) oVar.getSecond()).intValue(), (String) oVar.getFirst());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application, net.one97.paytm.upgradeKyc.kycV3.b.c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.s = application;
        this.t = cVar;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> b2 = ah.b(this.f65535a, new g(this));
        k.a((Object) b2, "Transformations.switchMa…a.value.toString())\n    }");
        this.f65537c = b2;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> b3 = ah.b(this.f65536b, new f(this));
        k.a((Object) b3, "Transformations.switchMa…,tncCode= it.first)\n    }");
        this.f65538d = b3;
        this.f65539e = new y<>();
        this.f65540f = "";
        this.f65541g = "";
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> b4 = ah.b(this.f65539e, new d(this));
        k.a((Object) b4, "Transformations.switchMa…me ,adharNum = it )\n    }");
        this.f65543i = b4;
        this.r = new y<>();
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharGenOTP>> b5 = ah.b(this.r, new c(this));
        k.a((Object) b5, "Transformations.switchMa…ue.toString() , it)\n    }");
        this.j = b5;
        this.k = new y<>();
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycSavedUserData>> b6 = ah.b(this.k, new b(this));
        k.a((Object) b6, "Transformations.switchMa…tchAppointmentApi()\n    }");
        this.l = b6;
        this.m = new y<>();
        this.n = new y<>();
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<EkycDataResponse>> b7 = ah.b(this.n, new e(this));
        k.a((Object) b7, "Transformations.switchMa…r.value.toString())\n    }");
        this.o = b7;
        this.p = "";
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycCheckDoc>> b8 = ah.b(this.m, new C1295a(this));
        k.a((Object) b8, "Transformations.switchMa…dhaarNum = docCode)\n    }");
        this.q = b8;
    }

    public final void a(boolean z, String str, boolean z2) {
        k.c(str, "adharNum");
        this.f65542h = z;
        this.r.setValue(Boolean.valueOf(z2));
    }

    public final void a(String str) {
        k.c(str, "refNumber");
        this.n.setValue(str);
    }

    static final class g<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65550a;

        g(a aVar) {
            this.f65550a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return net.one97.paytm.upgradeKyc.kycV3.b.c.a(this.f65550a.t, String.valueOf(this.f65550a.f65535a.getValue()), (String) null, 2);
        }
    }

    static final class e<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65548a;

        e(a aVar) {
            this.f65548a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return this.f65548a.t.b(String.valueOf(this.f65548a.n.getValue()));
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.aotp.b.a$a  reason: collision with other inner class name */
    static final class C1295a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65544a;

        C1295a(a aVar) {
            this.f65544a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return this.f65544a.t.b(this.f65544a.p, this.f65544a.f65540f);
        }
    }

    static final class b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65545a;

        b(a aVar) {
            this.f65545a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.c a2 = this.f65545a.t;
            y yVar = new y();
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            yVar.setValue(b.a.a());
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            String a3 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("mwGetAppointmentV3Url") : null;
            if (!URLUtil.isValidUrl(a3)) {
                b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a());
            }
            if (com.paytm.utility.d.a(a2.f66175b) == null) {
                b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.b()));
            } else {
                Map hashMap = new HashMap();
                String a4 = com.paytm.utility.d.a(a2.f66175b);
                k.a((Object) a4, "CJRNetUtility.getSSOToken(appContext)");
                hashMap.put("session_token", a4);
                hashMap.put("Content-Type", "application/json");
                hashMap.put("Accept", "application/json");
                a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.a l = a.C1317a.a().a(a2.f66175b).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new KycSavedUserData()).a(com.paytm.utility.b.e(a2.f66175b, a3) + "&userInterest=true&leadSource=App").a(false).c(EnterAadhaarDetailsActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c.f(yVar)).l();
                if (com.paytm.utility.b.c(a2.f66175b)) {
                    l.a();
                } else {
                    b.a aVar6 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                    yVar.setValue(b.a.a(a2.c()));
                }
            }
            return yVar;
        }
    }
}
