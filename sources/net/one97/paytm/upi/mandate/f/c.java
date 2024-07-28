package net.one97.paytm.upi.mandate.f;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.mandate.data.b;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.data.model.MandateListResponseModel;
import net.one97.paytm.upi.mandate.utils.f;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.s;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.utils.u;
import net.one97.paytm.upi.mandate.view.b;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class c extends androidx.lifecycle.a {

    /* renamed from: h  reason: collision with root package name */
    public static final b f67225h = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final y<r<List<Object>>> f67226a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final s<a> f67227b = new s<>();

    /* renamed from: c  reason: collision with root package name */
    public int f67228c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67229d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67230e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67231f;

    /* renamed from: g  reason: collision with root package name */
    public final Application f67232g;

    /* renamed from: i  reason: collision with root package name */
    private final net.one97.paytm.upi.mandate.data.b f67233i = g.a((Context) getApplication());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f67232g = application;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final void a() {
        this.f67228c = 0;
        b();
    }

    public final void b() {
        this.f67231f = f.a(this.f67228c);
        if (UpiAppUtils.isNetworkAvailable(this.f67232g)) {
            this.f67226a.setValue(new r(u.LOADING, (Object) null, (t) null, this.f67231f, 6));
            this.f67233i.b(this.f67228c, new C1363c(this));
            return;
        }
        this.f67226a.setValue(new r(u.ERROR, (Object) null, t.i.f67428a, this.f67231f, 2));
    }

    /* renamed from: net.one97.paytm.upi.mandate.f.c$c  reason: collision with other inner class name */
    public static final class C1363c implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67235a;

        C1363c(c cVar) {
            this.f67235a = cVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateListResponseModel) {
                MandateListResponseModel mandateListResponseModel = (MandateListResponseModel) upiBaseDataModel;
                if (p.a("FAILURE", mandateListResponseModel.getStatus(), true)) {
                    this.f67235a.f67226a.setValue(new r(u.ERROR, (Object) null, new t.a(mandateListResponseModel.getRespMessage()), this.f67235a.f67231f, 2));
                    return;
                }
                List<MandateItem> mandateItemList = mandateListResponseModel.getMandateItemList();
                List c2 = mandateItemList != null ? kotlin.a.k.c(mandateItemList) : null;
                if (c2 != null && !this.f67235a.f67231f && this.f67235a.f67230e && !c2.isEmpty()) {
                    String string = this.f67235a.f67232g.getString(R.string.upi_received_banner_msg);
                    k.a((Object) string, "app.getString(R.string.upi_received_banner_msg)");
                    c2.add(0, new b.C1372b(string));
                }
                this.f67235a.f67226a.setValue(new r(u.SUCCESS, c2, (t) null, this.f67235a.f67231f, 4));
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67235a.f67226a.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, this.f67235a.f67231f, 2));
            } else {
                this.f67235a.f67226a.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, this.f67235a.f67231f, 2));
            }
        }
    }

    public static abstract class a {

        /* renamed from: net.one97.paytm.upi.mandate.f.c$a$a  reason: collision with other inner class name */
        public static final class C1362a extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final C1362a f67234a = new C1362a();

            private C1362a() {
                super((byte) 0);
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
