package net.one97.paytm.upgradeKyc.videokyc.b;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.upgradeKyc.DocData;
import net.one97.paytm.common.entity.upgradeKyc.Form60Data;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.kycV3.b.c;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<Form60Data> f66456a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<b<CJRAadharPanSave>> f66457b;

    /* renamed from: c  reason: collision with root package name */
    private final Application f66458c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final c f66459d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application, c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.f66458c = application;
        this.f66459d = cVar;
        LiveData<b<CJRAadharPanSave>> b2 = ah.b(this.f66456a, new C1335a(this));
        k.a((Object) b2, "Transformations.switchMa… = DOC_TYPE_FORM60)\n    }");
        this.f66457b = b2;
    }

    /* renamed from: net.one97.paytm.upgradeKyc.videokyc.b.a$a  reason: collision with other inner class name */
    static final class C1335a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f66460a;

        C1335a(a aVar) {
            this.f66460a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return c.a(this.f66460a.f66459d, (DocData) null, (Form60Data) this.f66460a.f66456a.getValue(), "form60", 1);
        }
    }
}
