package net.one97.paytm.upgradeKyc.kycV3.c;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.upgradeKyc.DocData;
import net.one97.paytm.common.entity.upgradeKyc.Form60Data;
import net.one97.paytm.upgradeKyc.helper.d;

public final class l extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f66262a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66263b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TncData> f66264c;

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> f66265d;

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> f66266e;

    /* renamed from: f  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> f66267f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final y<String> f66268g = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final y<ArrayList<TncData>> f66269h = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final y<DocData> f66270i = new y<>();
    /* access modifiers changed from: private */
    public final net.one97.paytm.upgradeKyc.kycV3.b.c j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Application application, net.one97.paytm.upgradeKyc.kycV3.b.c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.j = cVar;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> b2 = ah.b(this.f66268g, new c(this));
        k.a((Object) b2, "Transformations.switchMa…a.value.toString())\n    }");
        this.f66265d = b2;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> b3 = ah.b(this.f66270i, new a(this));
        k.a((Object) b3, "Transformations.switchMa…= DOC_TYPE_DEFAULT)\n    }");
        this.f66266e = b3;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> b4 = ah.b(this.f66269h, new b(this));
        k.a((Object) b4, "Transformations.switchMa…ceptLiveData.value)\n    }");
        this.f66267f = b4;
    }

    public final void a() {
        d.a aVar = d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        this.f66268g.setValue(d.a("kyc_tnc_v2_url"));
    }

    public final void a(DocData docData) {
        k.c(docData, "docData");
        this.f66270i.setValue(docData);
    }

    public final void b() {
        ArrayList<TncData> arrayList = this.f66264c;
        if (arrayList == null) {
            a();
            this.f66263b = true;
            return;
        }
        this.f66263b = false;
        this.f66269h.setValue(arrayList);
    }

    static final class c<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f66273a;

        c(l lVar) {
            this.f66273a = lVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return net.one97.paytm.upgradeKyc.kycV3.b.c.a(this.f66273a.j, (String) null, String.valueOf(this.f66273a.f66268g.getValue()), 1);
        }
    }

    static final class a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f66271a;

        a(l lVar) {
            this.f66271a = lVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return net.one97.paytm.upgradeKyc.kycV3.b.c.a(this.f66271a.j, (DocData) this.f66271a.f66270i.getValue(), (Form60Data) null, "defaultDoc", 2);
        }
    }

    static final class b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f66272a;

        b(l lVar) {
            this.f66272a = lVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return this.f66272a.j.a((ArrayList<TncData>) (ArrayList) this.f66272a.f66269h.getValue());
        }
    }
}
