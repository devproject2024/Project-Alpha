package net.one97.paytm.games.fragment.a;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.t;
import kotlin.u;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.j;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.PFGWalletBalancesResponse;
import net.one97.paytm.games.model.core.CJRSignupUser;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class a extends androidx.lifecycle.a {

    /* renamed from: g  reason: collision with root package name */
    public static final C0596a f35628g = new C0596a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public y<o<Integer, GpCommonBaseResponse>> f35629a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f35630b;

    /* renamed from: c  reason: collision with root package name */
    public y<o<Integer, PFGWalletBalancesResponse>> f35631c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<Integer> f35632d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<o<Integer, Object>> f35633e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f35634f = new AtomicInteger(1);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public com.paytm.network.a f35635h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a() {
        if (!com.paytm.utility.a.p(getApplication())) {
            this.f35632d.setValue(1);
        } else if (net.one97.paytm.games.b.a.a() == null) {
            this.f35632d.setValue(2);
        } else {
            this.f35632d.setValue(3);
        }
    }

    public final void a(int i2) {
        this.f35632d.setValue(Integer.valueOf(i2));
        if (i2 == 3) {
            this.f35634f = new AtomicInteger(1);
        }
    }

    public final void a(String str, String str2) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (this.f35633e.getValue() != null) {
            o<Integer, Object> value = this.f35633e.getValue();
            if (value == null) {
                k.a();
            }
            if (((Number) value.getFirst()).intValue() == 4) {
                return;
            }
        }
        this.f35633e.setValue(t.a(4, null));
        net.one97.paytm.games.e.a.a((Context) getApplication(), (com.paytm.network.listener.b) new b(this), str, a.b.USER_FACING, str2);
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35636a;

        b(a aVar) {
            this.f35636a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError == null) {
                try {
                    k.a();
                } catch (Throwable unused) {
                    this.f35636a.f35633e.setValue(t.a(5, "CS-H".concat(String.valueOf(i2))));
                    return;
                }
            }
            if (iJRPaytmDataModel != null) {
                CJRSignupUser cJRSignupUser = (CJRSignupUser) f.a(networkCustomError, (CJRSignupUser) iJRPaytmDataModel, CJRSignupUser.class);
                if (cJRSignupUser != null) {
                    this.f35636a.f35633e.setValue(t.a(6, cJRSignupUser));
                } else {
                    this.f35636a.f35633e.setValue(t.a(5, "CS-H".concat(String.valueOf(i2))));
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.games.model.core.CJRSignupUser");
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            this.f35636a.f35633e.setValue(t.a(6, (CJRSignupUser) iJRPaytmDataModel));
        }
    }

    public final void b() {
        com.paytm.network.a aVar = this.f35635h;
        if (aVar != null) {
            aVar.b();
        }
        j jVar = j.f35626a;
        this.f35635h = j.b(new c(this));
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35637a;

        c(a aVar) {
            this.f35637a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f35637a.f35631c.setValue(new o(5, null));
            this.f35637a.f35635h = null;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof PFGWalletBalancesResponse) {
                this.f35637a.f35631c.setValue(new o(6, iJRPaytmDataModel));
            } else {
                this.f35637a.f35631c.setValue(new o(5, null));
            }
            this.f35637a.f35635h = null;
        }
    }

    public final void c() {
        if (!this.f35630b) {
            Application application = getApplication();
            k.a((Object) application, "getApplication<Application>()");
            Context context = application;
            if (!f.a(context)) {
                try {
                    com.google.android.play.core.splitcompat.a.a((Context) application);
                    Toast.makeText(application, application.getString(R.string.com_gamepind_no_internet_available), 0).show();
                } catch (Exception unused) {
                    Toast.makeText(context, "No internet connection", 0).show();
                }
            } else {
                net.one97.paytm.games.e.b bVar = net.one97.paytm.games.e.b.f35599a;
                net.one97.paytm.games.e.b.a().getValue();
                j jVar = j.f35626a;
                com.paytm.network.a a2 = j.a(new d(this));
                if (a2 != null) {
                    this.f35630b = true;
                    this.f35629a.setValue(new o(0, null));
                    a2.a();
                }
            }
        }
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35638a;

        d(a aVar) {
            this.f35638a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            a.a(this.f35638a, iJRPaytmDataModel);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            a.a(this.f35638a, iJRPaytmDataModel);
        }
    }

    public void onCleared() {
        super.onCleared();
        com.paytm.network.a aVar = this.f35635h;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* renamed from: net.one97.paytm.games.fragment.a.a$a  reason: collision with other inner class name */
    public static final class C0596a {
        private C0596a() {
        }

        public /* synthetic */ C0596a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        aVar.f35630b = false;
        if (iJRPaytmDataModel instanceof GpCommonBaseResponse) {
            aVar.f35629a.setValue(new o(1, iJRPaytmDataModel));
        } else {
            aVar.f35629a.setValue(new o(1, new GpCommonBaseResponse()));
        }
    }
}
