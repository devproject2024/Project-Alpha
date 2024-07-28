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
import net.one97.paytm.upgradeKyc.kycV3.b.c;

public final class b extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<DocData> f66461a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> f66462b;

    /* renamed from: c  reason: collision with root package name */
    private final Application f66463c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final c f66464d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application, c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.f66463c = application;
        this.f66464d = cVar;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> b2 = ah.b(this.f66461a, new a(this));
        k.a((Object) b2, "Transformations.switchMa…= DOC_TYPE_DEFAULT)\n    }");
        this.f66462b = b2;
    }

    static final class a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66465a;

        a(b bVar) {
            this.f66465a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return c.a(this.f66465a.f66464d, this.f66465a.f66461a.getValue(), (Form60Data) null, "defaultDoc", 2);
        }
    }
}
