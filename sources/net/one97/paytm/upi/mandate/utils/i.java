package net.one97.paytm.upi.mandate.utils;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.GetCredentialsApiBuilder;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.upi.h.a f67397a;

    /* renamed from: b  reason: collision with root package name */
    String f67398b = "";

    /* renamed from: c  reason: collision with root package name */
    BankAccountDetails.BankAccount f67399c;

    /* renamed from: d  reason: collision with root package name */
    a f67400d;

    /* renamed from: e  reason: collision with root package name */
    final Context f67401e;

    /* renamed from: f  reason: collision with root package name */
    private final net.one97.paytm.upi.registration.b.a.b f67402f;

    /* renamed from: g  reason: collision with root package name */
    private a f67403g;

    public interface a {
        void a(String str);

        void a(t tVar);
    }

    public enum b {
        ACTION_CHECK_BALANCE,
        ACTION_PAYMENT
    }

    public i(Context context) {
        k.c(context, "context");
        this.f67401e = context;
        net.one97.paytm.upi.registration.b.a.b a2 = g.a(g.a((a.C1347a) null));
        k.a((Object) a2, "Injection.provideUpiRegi…ices(context, null)\n    )");
        this.f67402f = a2;
    }

    public static final /* synthetic */ a a(i iVar) {
        a aVar = iVar.f67400d;
        if (aVar == null) {
            k.a("listener");
        }
        return aVar;
    }

    public static final /* synthetic */ a b(i iVar) {
        a aVar = iVar.f67403g;
        if (aVar == null) {
            k.a("commonLibInput");
        }
        return aVar;
    }

    public final void a(a aVar) {
        k.c(aVar, "listener");
        this.f67400d = aVar;
        a();
        this.f67397a = net.one97.paytm.upi.h.a.a(this.f67401e, new f());
    }

    public static final class f implements a.C1347a {
        public final void onServiceConnected() {
        }

        public final void onServiceDisconnected() {
        }

        f() {
        }
    }

    public static final class e implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f67409a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        }

        e(i iVar) {
            this.f67409a = iVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                i iVar = this.f67409a;
                Object mobileAppData = ((BaseUpiResponse) upiBaseDataModel).getMobileAppData();
                if (mobileAppData != null) {
                    iVar.f67398b = (String) mobileAppData;
                    i.a(this.f67409a);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.String");
            }
            i.a(this.f67409a).a((t) t.d.f67423a);
        }
    }

    private final void a() {
        this.f67402f.b((a.C1389a) new e(this), "getUpiListKeys", "");
    }

    public final void a(a aVar) {
        k.c(aVar, "commonLibInput");
        this.f67403g = aVar;
        a(b.ACTION_PAYMENT);
    }

    public static final class c implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f67404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f67405b;

        c(i iVar, b bVar) {
            this.f67404a = iVar;
            this.f67405b = bVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof UpiToken) {
                UpiToken upiToken = (UpiToken) upiBaseDataModel;
                if (!TextUtils.isEmpty(upiToken.getUpiToken())) {
                    int i2 = j.f67410a[this.f67405b.ordinal()];
                    if (i2 == 1) {
                        i iVar = this.f67404a;
                        String upiToken2 = upiToken.getUpiToken();
                        k.a((Object) upiToken2, "response.upiToken");
                        String upiSequenceNo = UpiUtils.getUpiSequenceNo();
                        CLRemoteResultReceiver cLRemoteResultReceiver = new CLRemoteResultReceiver(new MandateMpinHelper$getMpinForCheckBalance$clRemoteResultReceiver$1(iVar, upiSequenceNo, new Handler()));
                        net.one97.paytm.upi.h.a aVar = iVar.f67397a;
                        if (aVar != null) {
                            aVar.a(upiSequenceNo, iVar.f67398b, upiToken2, 0, iVar.f67399c, cLRemoteResultReceiver);
                        }
                    } else if (i2 == 2) {
                        i iVar2 = this.f67404a;
                        String upiToken3 = upiToken.getUpiToken();
                        k.a((Object) upiToken3, "response.upiToken");
                        net.one97.paytm.upi.h.a.a(iVar2.f67401e, new d(iVar2, new CLRemoteResultReceiver(new MandateMpinHelper$getMpinForPayment$clRemoteResultReceiver$1(iVar2, new Handler())), upiToken3));
                    }
                } else {
                    i.a(this.f67404a).a((t) new t.f((String) null));
                }
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError == null || !k.a((Object) upiCustomVolleyError.getmErrorCode(), (Object) UpiConstants.NETWORK_ERROR_CODE)) {
                String str = null;
                if (k.a((Object) upiCustomVolleyError != null ? upiCustomVolleyError.getAlertTitle() : null, (Object) "1006")) {
                    i.a(this.f67404a).a((t) t.c.f67422a);
                    return;
                }
                a a2 = i.a(this.f67404a);
                if (upiCustomVolleyError != null) {
                    str = upiCustomVolleyError.getAlertMessage();
                }
                a2.a((t) new t.f(str));
                return;
            }
            i.a(this.f67404a).a((t) t.i.f67428a);
        }
    }

    private final void a(b bVar) {
        this.f67402f.d(new c(this, bVar), "fetchToken", "");
    }

    public static final class d implements a.C1347a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f67406a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CLRemoteResultReceiver f67407b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f67408c;

        d(i iVar, CLRemoteResultReceiver cLRemoteResultReceiver, String str) {
            this.f67406a = iVar;
            this.f67407b = cLRemoteResultReceiver;
            this.f67408c = str;
        }

        public final void onServiceConnected() {
            GetCredentialsApiBuilder.getPinFromCommonLib(this.f67406a.f67401e, i.b(this.f67406a).f67386a, i.b(this.f67406a).f67387b, i.b(this.f67406a).f67388c, i.b(this.f67406a).f67389d, i.b(this.f67406a).f67390e, i.b(this.f67406a).f67391f, this.f67407b, i.b(this.f67406a).f67392g, i.b(this.f67406a).f67393h, i.b(this.f67406a).f67394i, i.b(this.f67406a).j, this.f67408c, i.b(this.f67406a).k, i.b(this.f67406a).l);
        }

        public final void onServiceDisconnected() {
            throw new IllegalStateException("MandateMpinHelper:CL Services is null");
        }
    }
}
