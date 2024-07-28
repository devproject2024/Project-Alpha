package net.one97.paytm.upgradeKyc.aotp.b;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.upgradeKyc.EkycDataResponse;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharGenOTP;
import net.one97.paytm.common.entity.upgradeKyc.KycCheckDoc;

public final class b extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    final y<String> f65551a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public String f65552b;

    /* renamed from: c  reason: collision with root package name */
    public final y<String> f65553c;

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharGenOTP>> f65554d;

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharEkycDetails>> f65555e;

    /* renamed from: f  reason: collision with root package name */
    public String f65556f;

    /* renamed from: g  reason: collision with root package name */
    final y<String> f65557g;

    /* renamed from: h  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<EkycDataResponse>> f65558h;

    /* renamed from: i  reason: collision with root package name */
    public final y<String> f65559i;
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycCheckDoc>> j;
    private final y<o<String, Integer>> k = new y<>();
    private final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> l;
    private final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> m;
    private boolean n;
    private final y<Boolean> o;
    private final Application p;
    /* access modifiers changed from: private */
    public final net.one97.paytm.upgradeKyc.kycV3.b.c q;

    static final class d<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65563a;

        d(b bVar) {
            this.f65563a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            o oVar = (o) obj;
            return this.f65563a.q.a(((Number) oVar.getSecond()).intValue(), (String) oVar.getFirst());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application, net.one97.paytm.upgradeKyc.kycV3.b.c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.p = application;
        this.q = cVar;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> b2 = ah.b(this.f65551a, new e(this));
        k.a((Object) b2, "Transformations.switchMa…a.value.toString())\n    }");
        this.l = b2;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> b3 = ah.b(this.k, new d(this));
        k.a((Object) b3, "Transformations.switchMa…,tncCode= it.first)\n    }");
        this.m = b3;
        this.o = new y<>();
        this.f65553c = new y<>();
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharGenOTP>> b4 = ah.b(this.o, new C1296b(this));
        k.a((Object) b4, "Transformations.switchMa…ry.generateOtpApi()\n    }");
        this.f65554d = b4;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharEkycDetails>> b5 = ah.b(this.f65553c, new f(this));
        k.a((Object) b5, "Transformations.switchMa…a.value.toString())\n    }");
        this.f65555e = b5;
        this.f65556f = "";
        this.f65557g = new y<>();
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<EkycDataResponse>> b6 = ah.b(this.f65557g, new c(this));
        k.a((Object) b6, "Transformations.switchMa…r.value.toString())\n    }");
        this.f65558h = b6;
        this.f65559i = new y<>();
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycCheckDoc>> b7 = ah.b(this.f65559i, new a(this));
        k.a((Object) b7, "Transformations.switchMa…dhaarNum = docCode)\n    }");
        this.j = b7;
    }

    public static /* synthetic */ void a(b bVar) {
        k.c("", "adharNum");
        bVar.n = false;
        bVar.o.setValue(Boolean.FALSE);
    }

    public final void a(String str) {
        k.c(str, "refNumber");
        this.f65557g.setValue(str);
    }

    static final class e<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65564a;

        e(b bVar) {
            this.f65564a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return net.one97.paytm.upgradeKyc.kycV3.b.c.a(this.f65564a.q, String.valueOf(this.f65564a.f65551a.getValue()), (String) null, 2);
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.aotp.b.b$b  reason: collision with other inner class name */
    static final class C1296b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65561a;

        C1296b(b bVar) {
            this.f65561a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return this.f65561a.q.a(false, "", false);
        }
    }

    static final class f<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65565a;

        f(b bVar) {
            this.f65565a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return this.f65565a.q.a(this.f65565a.f65556f, String.valueOf(this.f65565a.f65553c.getValue()));
        }
    }

    static final class c<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65562a;

        c(b bVar) {
            this.f65562a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return this.f65562a.q.b(String.valueOf(this.f65562a.f65557g.getValue()));
        }
    }

    static final class a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65560a;

        a(b bVar) {
            this.f65560a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.c b2 = this.f65560a.q;
            String str = this.f65560a.f65556f;
            String str2 = this.f65560a.f65552b;
            if (str2 == null) {
                k.a("docCode");
            }
            return b2.b(str, str2);
        }
    }
}
